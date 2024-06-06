<template>
    <div class="welcome">
      <p v-if="realName">欢迎，{{ realName }}！</p>
      <p v-else>加载中……</p>
    </div>
  </template>
  
  <script>
  import api from "../api/function.js";
  export default {
    name: 'welcome',
    data() {
      return {
        username: '',
        realName: null  // 初始化真实姓名为 null
      }
    },
    created() {
      this.username = this.$route.query.username;
      this.fetchUserName();
    },
    methods: {
      fetchUserName() {
        api.getRealName()
          .then(response => {
            this.realName = response.data.realName;  // 假设后端返回的数据中包含 realName 字段
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
  