<template>
    <div class="container">
      <h1>选课系统登录</h1>  
      <form id="loginForm" class="login-form" @submit.prevent="submit">  
        <div class="role-selection">
          <input type="radio" id="student" value='1' v-model="identity" checked>
          <label for="student">学生登录</label>
  
          <input type="radio" id="teacher" value='2' v-model="identity">
          <label for="teacher">老师登录</label>
  
          <input type="radio" id="admin" value='3' v-model="identity">
          <label for="admin">管理员登录</label>
        </div>
        <div class="login-input-text">  
          <label class="label" for="username">用户名:</label>
          <input type="text" id="username" name="username" v-model="username" required>  
        </div>  
        <div class="login-input-text">  
          <label class="label" for="password">密码:</label>  
          <input type="password" id="password" name="password" v-model="password" required>  
        </div>
        <button type="submit">登录</button>  
      </form>  
      <p :class="{'message': ! isError, 'error': isError}">{{ message }}</p> 
    </div>  
  </template>
  
  <script>
  import api from "../api/function.js";
  export default {
    name: 'login',
    data() {
      return {
        identity: '1',
        username: '',
        password: '',
        message: '',
        isError: false
      }
    },
    methods: {
      submit() {
        this.message = '';
        localStorage.setItem(username, this.username);
        localStorage.setItem(identity, this.identity);
        api.getMatch(this.username, this.password, this.identity)
          .then(response => {
            switch(response.data.username) {
              case "student":
                this.message = '学生登陆成功！';
                this.isError = false;
                setTimeout(
                  () => {
                    this.$router.push({ path: '/content-student' }).
                    catch(
                      err => alert("跳转页面失败：" + err)
                    );
                  }, 800);
                break;
              case "teacher":
                this.message = '老师登陆成功！';
                setTimeout(
                  () => {
                    this.$router.push({ path: '/content-teacher'}).
                    catch(
                      err => alert("跳转页面失败：" + err)
                    );
                  }, 800);
                break;
              case "administrator":
                this.message = '管理员登陆成功';
                setTimeout(
                  () => {
                    this.$router.push({ path: '/content-admin'}).
                    catch(
                      err => alert("跳转页面失败：" + err)
                    );
                  }, 800);
                break;
              default:
                this.message = '用户名或密码错误，或者您所选的登陆身份有误！';
            }
          })
          .catch(error => {
            console.log(error);
            this.isError = true;
            this.message = '登陆失败，请稍后再试';
          });
      }
    }
  }
  </script>
  
  <style scoped>
  .container {
    width: 900px;
    height: 650px;
    padding: 5px;
    background-color: rgba(255, 0, 0, 0);
    border-radius: 5px;
    text-align: center;
    font-size: 30px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin-bottom: 10px;
  }
  
  input[type="password"], input[type="text"] {
    width: 200px;
    height: 30px;
    padding: 5px;
    border: 1px inset #ccc;
    border-radius: 5px;
    font-size: 20px;
  }
  
  .role-selection {
    font-size: 25px;
  }
  
  .login-input-text .label {
    display: inline-block;
    width: 100px;
    text-align: right;
  }
  
  input {
    vertical-align: middle;
  }
  
  .error {
    color: red;
    font-size: 24px;
    margin-top: 10px;
    text-align: center;
  }
  
  button {
    width: 100px;
    height: 50px;
    background-color: #008CBA;
    color: white;
    border: none;
    cursor: pointer;
    font-size: 16px;
    border-radius: 5px;
  }
  
  button:hover {
    background-color: #007B9A;
  }

  .message {
  color: green;
  font-size: 24px;
  margin-top: 10px;
  text-align: center;
}


  </style>
  