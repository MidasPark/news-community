<script setup lang="ts">
import { ref } from 'vue'
import { auth } from '~/app/plugins/firebase'
import { GoogleAuthProvider, signInWithPopup } from 'firebase/auth'

const isVisible = ref(false)

const handleGoogleLogin = async () => {
  try {
    const provider = new GoogleAuthProvider()
    const result = await signInWithPopup(auth, provider)
    const credential = GoogleAuthProvider.credentialFromResult(result)
    if (credential?.accessToken) {
      localStorage.setItem('firebase_token', credential.accessToken)
    }
    closeModal()
  } catch (error) {
    console.error('로그인 에러:', error)
  }
}

const openModal = () => {
  isVisible.value = true
}

const closeModal = () => {
  isVisible.value = false
}

defineExpose({
  openModal,
  closeModal
})
</script>

<template>
  <Teleport to="body">
    <div v-if="isVisible" class="modal-overlay" @click="closeModal">
      <div class="modal-content" @click.stop>
        <button class="close-button" @click="closeModal">×</button>
        <div class="modal-body">
          <h2>로그인</h2>
          <p>포츈 매트릭스에 오신 것을 환영합니다</p>
          
          <button @click="handleGoogleLogin" class="google-login-button">
            <img src="/images/google-icon.svg" alt="Google" class="google-icon">
            Google 계정으로 로그인
          </button>
        </div>
      </div>
    </div>
  </Teleport>
</template>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-content {
  background-color: white;
  padding: 30px;
  border-radius: 12px;
  width: 90%;
  max-width: 400px;
  position: relative;
  animation: modal-fade-in 0.3s ease;
}

.close-button {
  position: absolute;
  top: 15px;
  right: 15px;
  background: none;
  border: none;
  font-size: 24px;
  cursor: pointer;
  color: #666;
}

.close-button:hover {
  color: #333;
}

.modal-body {
  text-align: center;
}

h2 {
  font-size: 24px;
  color: #333;
  margin-bottom: 10px;
}

p {
  color: #666;
  margin-bottom: 25px;
}

.google-login-button {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
  width: 100%;
  padding: 12px;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  background-color: white;
  font-size: 16px;
  cursor: pointer;
  transition: all 0.2s ease;
}

.google-login-button:hover {
  background-color: #f5f5f5;
  transform: translateY(-2px);
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.google-icon {
  width: 24px;
  height: 24px;
}

@keyframes modal-fade-in {
  from {
    opacity: 0;
    transform: translateY(-20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}
</style> 