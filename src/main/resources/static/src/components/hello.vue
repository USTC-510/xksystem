<template>
<div class="welcome">
    <!-- <p v-if="realname">欢迎，{{ realname }}！</p> -->
    <!-- <p v-else>加载中……</p> -->
    <p>加载中……</p>
</div>
</template>

<!-- <script>
import api from "../api/function.js";
export default {
    name: hello,
    data() {
        return {
            username: '',
            realName: null  // 初始化真实姓名为 null
        }
    },
    created() {
        this.username = this.$route.query.username;
        this.fetchUserName();
    },
    methods: {
        fetchUserName() {
        api.getRealName(this.username)
        .then(response => {
          this.realName = response.data.realName;  // 假设后端返回的数据中包含 realName 字段
        })
        .catch(error => {
          console.error('获取用户信息失败:', error);
        });
        }
    }
}
</script> -->

<style scoped>
.welcome{
    width: 100px;
    height: 100px;
    background-color: red;
    position: absolute;
    top: 0;
    left: 0;
}
</style>
