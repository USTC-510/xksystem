<template>
    <div class="welcome">
      <welcome />
      <div class="infor">
    <button class="img" id="inforID" @click="handleInfor"></button>
    <p class="text">个人信息</p>
  </div>
  <div class="choose">
    <button class="img" id="chooseID" @click="handleChoose"></button>
    <p class="text">学校开课</p>
  </div>
  <div class="mytable">
    <button class="img" id="myTableID" @click="handleMyTable"></button>
    <p class="text">我的任课</p>
  </div>
    </div>
  </template>
  
  <script>
  import welcome from "../components/welcome.vue";
  
  export default {
    name: 'content_teacher',
    components: {
      welcome
    },
    methods: {
      handleInfor(){
        this.$router.push({ path: '/infor' }).catch(
          err => alert("跳转页面失败：",err)
        );
      },
      handleChoose(){
        this.$router.push({ path: '/choose-teacher' }).catch(
          err => alert("跳转页面失败：",err)
        );
      },
      handleMyTable(){
        this.$router.push({ path: '/myTable-teacher' }).catch(
          err => alert("跳转页面失败：",err)
        );
      }
    }
  }
  </script>
  <style scoped>
    .img {
      background-size: cover;
      background-repeat: no-repeat;
      width: 100px;
      height: 100px;
      cursor: pointer;
      border-radius: 15px;
      border: none;
    }
    #inforID{
      background-image: url("../../public/assets/information.jpg");
    }
    #chooseID{
      background-image: url("../../public/assets/choose.jpg");
    }
    #myTableID{
      background-image: url("../../public/assets/mytable.jpg");
    }
    .text {
      font-size: 16px;
      text-align: center;
      line-height: 30px;
    }
    .infor{
      position: absolute;
      top: 300px;
      left: 650px;
    }
    .choose{
      position: absolute;
      top: 300px;
      left: 800px;
    }
    .mytable{
      position: absolute;
      top: 300px;
      left: 950px;
    }
  </style>
  