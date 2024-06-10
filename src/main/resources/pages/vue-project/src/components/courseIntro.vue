<template>
  <div class="course-intro">
    <h3>课程介绍: {{ courseName }}</h3>
    <p v-if="intro">{{ intro }}</p>
    <p v-else>加载中……</p>
    <button @click="$router.push('/choose-student')">返回</button>
  </div>
</template>

<script>
import api from "../api/function.js";

export default {
  name: 'courseIntro',
  props: ['courseName'],
  data() {
    return {
      intro: ''
    };
  },
  created() {
    this.fetchIntro();
  },
  methods: {
    fetchIntro() {
      api.getCourseIntro(this.courseName)
        .then(response => {
          this.intro = response.data;
        })
        .catch(error => {
          console.error('Error fetching course intro:', error);
          this.intro = '加载失败，请稍后重试。';
        });
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
  