<template>
    <div class="welcome">
      <p v-if="realName">欢迎，{{ realName }}！</p>
      <p v-else>加载中……</p>
      <!--如果暂时没有获取到姓名则显示加载中-->
    </div>
  </template>
  
  <script>
  import api from "../api/function.js";
  export default {
    name: 'welcome',
    data() {
      return {
        realName: null  // 初始化真实姓名为 null
      }
    },
    created() {
      this.fetchUserName();
    },
    methods: {
      fetchUserName() {
        const username = localStorage.getItem("username");
        api.getRealName(username)
          .then(response => {
            this.realName = response.data;
          })
          .catch(error => {
            console.error('获取用户信息失败:', error);
          });
      }
    }
  }
  </script>
  
  <style scoped>
  .welcome {
      color: #f5f5f5;
      font-size: 40px;
      position: absolute;
      top: 0;
      left: 0;
      transform: translate(0, 0);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 45vh;
      width: 55vw;
    }
  </style>
  