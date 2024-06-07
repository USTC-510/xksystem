<template>
    <div class="student-profile">
      <div class="card">
        <img :src="person.photo" alt="student photo" class="student-photo"/>
        <h2>{{ person.realName }}</h2>
        <p>身份：{{ person.identity }}</p>
        <p>年龄: {{ person.age }}</p>
        <p>性别: {{ person.gender }}</p>
        <p>学院：{{ person.faculty }}</p>
        <p>专业：{{ person.major }}</p>
        <p>班级: {{ person.class }}</p>
        <a href="../components/forgetPassword.vue" @click.prevent="showCard = true">修改密码</a>
        <forgetPassword v-if="showCard" @close="showCard = false" />
      </div>
    </div>
  </template>
  
  <script>
  import api from '../api/function.js'
  import forgetPassword from '../components/forgetPassword.vue'
  export default {
    name: 'infor_student',
    components: {
        forgetPassword
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
          photo: 'photo.jpeg',
        },
        showCard: false
      }
    },
    created() {
        api.getInfor().then(response => {
            this.person.realName = response.data.realName;
            this.person.age = response.data.age;
            this.person.gender = response.data.gender;
            this.person.faculty = response.data.faculty;
            this.person.major = response.data.major;
            this.person.class = response.data.class
        })
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
  
