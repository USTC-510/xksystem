<template>
    <div class="welcome">
      <welcome />
    </div>
  </template>
  
  <script>
  import welcome from "../components/welcome.vue";
  
  export default {
    name: 'student',
    components: {
      welcome
    }
  }
  </script>
  
  <style>
  body {
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    background-image: url("../../public/assets/login.png");
    background-color: rgba(255, 255, 255, 0.5);
    background-size: cover;
    background-repeat: no-repeat;
  }
  </style>
  