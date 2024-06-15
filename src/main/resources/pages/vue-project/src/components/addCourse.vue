<template>
    <div class="floating-card">
      <h2>课程添加</h2>
      <form @submit.prevent="submit">
        <div class="input-text">  
          <label class="label" for="id">课程编号：</label>
          <input type="text" name="id" v-model="id" required> 
        </div>
      <div class="input-text">  
          <label class="label" for="name">课程名称：</label>  
          <input type="text" name="name" v-model="name" required>
      </div>
      <div class="input-text">  
          <label class="label" for="professor">教师：</label>
          <input type="text" name="professor" v-model="professor" required>  
        </div>
        <div class="input-text">
        <label class="label" for="credits">学分：</label>
        <input type="text" name="credits" v-model="credits" required>
        </div>
        <div class="input-text">  
          <label class="label" for="hour">学时：</label>
          <input type="text" name="hour" v-model="hour" required>
        </div>
        <div class="input-text">
                  <label class="label" for="maxPeople">最大人数：</label>
                  <input type="text" name="maxPeople" v-model="maxPeople" required>
                </div>
        <div v-for="day in days" :key="day">
        <label>
          <input type="checkbox" :value="day" v-model="selectedDays" @change="toggleTimeSlots(day)">
          {{ day }}
        </label>
        <div v-if="selectedDays.includes(day)" class="time-slots">
          <label v-for="time in timeSlots" :key="time">
            <input type="checkbox" :value="time" v-model="selectedTimeSlots[time]">
            {{ time }}
          </label>
        </div>
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
        rightVerification: '',
        days: ['周一', '周二', '周三', '周四', '周五'],
        timeSlots: Array.from({ length: 13 }, (_, i) => i + 1),
        selectedDays: [],
        selectedTimeSlots: {}
      }
    },
    methods: {
      submit() {
        for (let day of this.selectedDays) {
        if (!this.selectedTimeSlots[day] || this.selectedTimeSlots[day].length === 0) {
          alert(`${day} 至少选择一个时间段`);
          return;
        }
        }
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
      },
      toggleTimeSlots(day) {
      if (!this.selectedDays.includes(day)) {
        this.$set(this.selectedTimeSlots, day, []);
      }
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
  .label {
    width: 60px;
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
  role-selection {
    font-size: 17px;
  }
  </style>
  