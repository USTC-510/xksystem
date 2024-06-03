import content from '../views/content.vue'
import login from '../views/login.vue'
import {createRouter, createWebHistory} from 'vue-router'
//存储路由
const routes = [
    {
        path:"/",
        component: login
    },
    {
        path:"/content",
        component: content
    }
]

const router = createRouter(
    {
        history:createWebHistory(),
        routes
    }
)

export default router;