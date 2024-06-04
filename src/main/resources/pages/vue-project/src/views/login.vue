<template>
<div class="container">
        <h1>选课系统登录</h1>  
        <form id="loginForm" class="login-form">  
            <div class="role-selection">
                <input type="radio" id="student" value=1 v-model="identity" required checked>
                <label for="student">学生登录</label>

                <input type="radio" id="teacher" value=2 v-model="identity" required>
                <label for="teacher">老师登录</label>

                <input type="radio" id="admin" value=3 v-model="identity" required>
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
            <button @click="submit">登录</button>  
        </form>  
        <p>{{ message }}</p>  
  </div>  
</template>

<script>
import api from "../api/function.js";
export default {
    name:'login',
    data(){
        return {
            identity:'',
            username:'',
            password:'',
            message:''
        }
    },
    methods: {
    submit(){
      event.preventDefault();//阻止表单默认提交行为
      this.errorMessage = '';
      api.getMatch(this.username, this.password, this.identity)
        .then(function (response) {
        switch(response.data.match){
            case 1:
                this.message = '学生登陆成功！';
                this.$router.push({path:'/content-student', query:{username:this.username}});
                break;
            case 2:
                this.message = '老师登陆成功！';
                this.$router.push({path:'/content-teacher', query:{username:this.username}});
                break;
            case 3:
                this.message = '管理员登陆成功';
                this.$router.push({path:'/content-admin', query:{username:this.username}});
                break;
            default :
                alert('用户名或密码错误，或者您所选的登陆身份有误！');
        }
        })
        .catch(function (error) {
            console.log(error);
      });
    }
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
    /* 设置背景图片，并使用cover属性使其铺满整个页面 */
    background-image: url("../../public/assets/login.png");
    background-color: rgba(255, 255, 255, 0.5);
    background-size: cover;
    background-repeat: no-repeat;
}

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
    width: 200px; /* 设置文本框的宽度 */
    height: 30px; /* 设置文本框的高度 */
    padding: 5px; /* 设置文本框内的填充 */
    border: 1px inset #ccc; /* 设置文本框的边框 */
    border-radius: 5px; /* 设置文本框的边框半径，使其看起来更圆滑 */
    font-size: 20px; /* 设置文本框内的文字大小 */
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
    margin-top: 10px;
}

button {
    width: 100px; /* 设置按钮的宽度 */
    height: 50px; /* 设置按钮的高度 */
    background-color: #008CBA; /* 设置按钮的背景颜色 */
    color: white; /* 设置按钮的文字颜色 */
    border: none; /* 移除按钮的边框 */
    cursor: pointer; /* 当鼠标悬停在按钮上时，改变鼠标的样式 */
    font-size: 16px; /* 设置按钮的文字大小 */
    border-radius: 5px; /* 设置按钮的边角圆滑 */
}

button:hover {
    background-color: #007B9A; /* 设置按钮悬停时的背景颜色为深天蓝色，这样可以给用户反馈，让他们知道他们正在悬停在按钮上 */
}

</style>