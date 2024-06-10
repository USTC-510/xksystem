    <template>
    <div class="floating-card">
      <h2>重置密码</h2>
      <form @submit.prevent="submit">
        <div class="role-selection">
          <input type="radio" id="student" value='1' v-model="identity" checked>
          <label for="student">学生登录</label>
  
          <input type="radio" id="teacher" value='2' v-model="identity">
          <label for="teacher">老师登录</label>
  
          <input type="radio" id="admin" value='3' v-model="identity">
          <label for="admin">管理员登录</label>
        </div>
        <div class="input-text">  
          <label class="label" for="username">用户名：</label>
          <input type="text" name="username" v-model="username" required> 
        </div>
      <div class="input-text">  
          <label class="label" for="newPassword">新的密码：</label>  
          <input type="password" name="newPassword" v-model="newPassword" required>
      </div>
      <div class="input-text">  
          <label class="label" for="verification">验证码：</label>
          <input type="text" name="verification" v-model="verification" required>  
          <button :disabled="isDisabled" :class="{ 'disabled-button': isDisabled }" @click="handleClick">{{ message }}</button>
        </div>
      <button type="submit">修改</button>
      </form>
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
        message: "发送验证码",
        username: '',
        identity: '1',
        rightVerification: ''
      }
    },
    methods: {
      submit() {//需要和后端存的密码匹配
        if(this.rightVerification == this.verification){
            api.afterForgetPassword(this.username, this.newPassword, this.identity).then(() => {
              alert("修改成功");
            }).catch(error => {
              console.log(error);
              alert("修改失败，请稍后再试");
            });
          }
          else{
            alert("您输入的验证码错误");
          }
      },
      closeCard() {
        this.$emit('close');
      },
      handleClick() {
        this.isDisabled = true;
        this.startDecreasing();
        setTimeout(() => {
            this.isDisabled = false;
        }, 60000); // 60秒后重新启用按钮
        api.forgetPassword(this.username, this.identity).
        then(response => {
          this.rightVerification = response.data;
        }).
        catch(error => {
          console.log(error);
          alert("修改失败，请稍后再试");
        })
      },
      startDecreasing() {
        var data = 60;
        //使用计时器计时60秒
        this.intervalId = setInterval(() => {
            if (data > 0) {
                data -= 1;
                this.message = data + '秒';
            } 
            else {
                this.message = '发送验证码';
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
  input[type="password"], input[type="text"] {
    width: 200px;
    height: 30px;
    padding: 5px;
    border: 1px inset #ccc;
    border-radius: 5px;
    font-size: 20px;
  }
  
  .disabled-button {
  background-color: grey;
  cursor: not-allowed;
  }
  button{
    width: 80px;
  }
  .label {
    width: 100px;
    text-align: right;
    margin-right: 10px;
    font-size: 19px;
  }
  .input-text {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
    margin-right: 50px;
  }
  .role-selection {
    font-size: 17px;
  }
  </style>
  