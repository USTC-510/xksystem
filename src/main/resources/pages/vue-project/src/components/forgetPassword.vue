<template>
    <div class="floating-card">
      <h2>修改密码</h2>
      <p>这里是卡片的内容。</p>
      <button @click="closeCard">关闭</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'forgetPassword',
    methods: {
      closeCard() {
        this.$emit('close');
      }
    }
  };
  </script>
  
  <style scoped>
  .floating-card {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: white;
    padding: 20px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    z-index: 1000;
  }
  </style>
  