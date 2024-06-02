<template>
<div class="welcome">
    <hello />
</div>
</template>

<script>
import hello from "../components/hello.vue"
export default{
    name: student,
    components:{
        hello
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
    background-image: url("../assets/login.png");
    background-color: rgba(255, 255, 255, 0.5);
    background-size: cover;
    background-repeat: no-repeat;
}
</style>