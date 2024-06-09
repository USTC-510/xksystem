<template>
    <div class="floating-card">
      <h2>重置密码</h2>
      <div class="input-text">  
          <label class="label" for="verification">验证码：</label>
          <input type="text" name="verification" v-model="verification" required>  
          <button :disabled="isDisabled" :class="{ 'disabled-button': isDisabled }" @click="handleClick">{{ message }}</button>
        </div>
      <div class="input-text">  
          <label class="label" for="newPassword">新的密码：</label>  
          <input type="password" name="newPassword" v-model="newPassword" required>
      </div>
      <button type="submit">修改</button>
      <button @click="closeCard">关闭</button>
    </div>
  </template>
  
  <script>
  import api from "../api/function.js"
  export default {
    name: 'forgetPassword',
    data() {
      return{
        verification: '',
        newPassword: '',
        isDisabled: false,
        message: "发送验证码"
      }
    },
    methods: {
      submit() {//需要和后端存的密码匹配
        const username = localStorage.getItem('username');
        const identity = localStorage.getItem('identity');
        api.forgetPassword(username, this.newPassword, identity).
        then(response => {
          if(response.data == this.verification){
            alert("修改成功");
          }
          else{
            alert("您输入的验证码错误");
          }
        }).
        catch(error => {
          console.log(error);
          alert("修改失败，请稍后再试");
        })
      },
      closeCard() {
        this.$emit('close');
      },
      handleClick() {
      this.isDisabled = true;
      setTimeout(() => {
            this.isDisabled = false;
        }, 60000); // 60秒后重新启用按钮
      },
      startDecreasing() {
        var data = 60;
        //使用计时器计时60秒
        this.intervalId = setInterval(() => {
            if (data > 0) {
                data -= 1;
                message = data + '秒';
            } 
            else {
                message = '发送验证码';
                this.stopDecreasing(); // 数据减到0时停止定时器
            }
        }, 1000);
      },
      stopDecreasing() {
        clearInterval(this.intervalId);
      }
    }
}
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
  .disabled-button {
  background-color: grey;
  cursor: not-allowed;
  }
  </style>
  