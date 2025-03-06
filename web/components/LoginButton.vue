<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { auth } from '@plugins/firebase'
import { onAuthStateChanged } from 'firebase/auth'

const isLoggedIn = ref(false)
const loginModal = ref(null)

onMounted(() => {
  onAuthStateChanged(auth, (user) => {
    isLoggedIn.value = !!user
  })
})

const handleLoginClick = () => {
  loginModal.value?.openModal()
}
</script>

<template>
  <div class="login-button-container">
    <button v-if="!isLoggedIn" 
            @click="handleLoginClick" 
            class="login-button">
      <img src="/images/login-icon.svg" alt="로그인" class="login-icon">
      <span>로그인</span>
    </button>
    <div v-else class="user-profile">
      <img :src="auth.currentUser?.photoURL || '/images/default-avatar.png'" 
           alt="프로필" 
           class="profile-image">
    </div>
    <LoginModal ref="loginModal" />
  </div>
</template>

<style scoped>
.login-button-container {
  position: fixed;
  top: 20px;
  right: 20px;
  z-index: 1000;
}

.login-button {
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 8px 16px;
  background-color: #fff;
  border: 1px solid #e0e0e0;
  border-radius: 20px;
  cursor: pointer;
  transition: all 0.2s ease;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.login-button:hover {
  background-color: #f5f5f5;
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0,0,0,0.1);
}

.login-icon {
  width: 20px;
  height: 20px;
}

.user-profile {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  overflow: hidden;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.profile-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style> 