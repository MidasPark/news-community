<!-- <script setup lang="ts">
import { GoogleAuthProvider, signInWithPopup } from 'firebase/auth'
import { useRouter } from 'vue-router'

const nuxtApp = useNuxtApp()
const { $auth } = nuxtApp

const router = useRouter()

const handleGoogleLogin = async () => {
  try {
    const provider = new GoogleAuthProvider()
    const result = await signInWithPopup($auth, provider)
    const credential = GoogleAuthProvider.credentialFromResult(result)
    if (credential?.accessToken) {
      // 토큰을 로컬 스토리지에 저장
      localStorage.setItem('firebase_token', credential.accessToken)
    }
    // 로그인 성공 후 메인 페이지로 이동
    router.push('/')
  } catch (error) {
    console.error('로그인 에러:', error)
  }
}
</script>

<template>
  <div class="login-page">
    <div class="login-container">
      <h1>로그인</h1>
      <p>포츈 매트릭스에 오신 것을 환영합니다</p>
      
      <button @click="handleGoogleLogin" class="google-login-button">
        <img src="/images/google-icon.svg" alt="Google" class="google-icon">
        Google 계정으로 로그인
      </button>
    </div>
  </div>
</template>

<style scoped>
.login-page {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f5f5f5;
}

.login-container {
  background-color: white;
  padding: 40px;
  border-radius: 12px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  text-align: center;
  max-width: 400px;
  width: 90%;
}

h1 {
  color: #333;
  margin-bottom: 10px;
  font-size: 24px;
}

p {
  color: #666;
  margin-bottom: 30px;
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
</style>  -->