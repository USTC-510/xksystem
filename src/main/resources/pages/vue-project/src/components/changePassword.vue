<template>
    <div class="floating-card">
      <h2>修改密码</h2>
      <form @submit.prevent="submit">
      <div class="input-text">  
          <label class="label" for="originalPassword">原密码：</label>
          <input type="password" name="originalPassword" v-model="originalPassword" required>
        </div>
      <div class="input-text">  
          <label class="label" for="newPassword">新的密码：</label>  
          <input type="password" name="newPassword" v-model="newPassword" required>
      </div>
      <button type="submit">修改</button>
      <button @click="closeCard">关闭</button>
      </form>
    </div>
  </template>
  
  <script>
  import api from "../api/function.js"
  export default {
    name: 'changePassword',
    data() {
      return{
        originalPassword: '',
        newPassword: ''
      }
    },
    methods: {
      submit() {//需要和后端存的密码匹配
        const username = localStorage.getItem('username');
        const identity = localStorage.getItem('identity');
        api.changePassword(username, this.originalPassword, this.newPassword, identity).
        then(response => {
          if(response.data == 0){console.log(response);
            alert("修改成功");
          }
          else{
            alert("您输入的原密码错误");
          }
        }).
        catch(error => {
          console.log(error);
          alert("修改失败，请稍后再试");
        })
      },
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
  