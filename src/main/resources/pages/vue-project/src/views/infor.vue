<template>
    <div class="student-profile">
      <div class="card">
        <img :src="person.photo" alt="student photo" class="student-photo"/>
        <h2>{{ person.realName }}</h2>
        <p>{{ person.identity }}</p>
        <p>{{ person.age }}</p>
        <p>{{ person.gender }}</p>
        <p>{{ person.faculty }}</p>
        <p>{{ person.major }}</p>
        <p>{{ person.class }}</p>
        <a href="../components/changePassword.vue" @click.prevent="showCard = true">修改密码</a>
        <forgetPassword v-if="showCard" @close="showCard = false" />
      </div>
    </div>
  </template>
  
  <script>
  import api from '../api/function.js'
  import changePassword from '../components/changePassword.vue'
  export default {
    name: 'infor',
    components: {
        changePassword
    },
    data() {
      return {
        person: {
          realName: '',
          identity: '',
          age: 18,
          gender: '',
          faculty: '',
          major: '',
          class: '',
          photo: 'http://114.214.234.245:8080/public/assets/photo.jpeg',
        },
        showCard: false
      }
    },
    created() {
        api.getInfor().then(response => {
            this.person.realName = "姓名：" + response.data.realName;
            this.person.age = "年龄：" + response.data.age;
            this.person.gender = "性别：" + response.data.gender;
            this.person.faculty = "学院：" + response.data.faculty;
            this.person.major = "专业/研究方向：" + response.data.major;
            this.person.class = "班级：" + response.data.class;
        }).catch(error => {
    console.log(error)})
    }
  }
  </script>
  
  <style scoped>
  .student-profile {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f5f5f5;
  }
  
  .card {
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 20px;
    max-width: 400px;
    text-align: center;
  }
  
  .student-photo {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    margin-bottom: 20px;
  }
  
  h2 {
    margin: 10px 0;
    font-size: 24px;
    color: #333;
  }
  
  p {
    margin: 5px 0;
    font-size: 18px;
    color: #666;
  }
  </style>
  
