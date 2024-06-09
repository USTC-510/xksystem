<template>
    <div class="course-intro">
      <h3>课程介绍: {{ courseName }}</h3>
      <p v-if="intro">{{ intro }}</p>
      <p v-else>加载中……</p>
      <button @click="$router.push('/choose-student')">返回</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'courseIntro',
    props: {
      courseName: {
        type: String,
        required: true
      }
    },
    data() {
      return{
        intro: ''
      }
    },
    methods: {
      fetchIntro() {
        api.getCourseIntro().then(response => {
            this.intro = response.data.intro;
        }).catch(error => {
            console.log(error);
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
  