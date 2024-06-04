import content from '../views/content-student.vue'
import login from '../views/login.vue'
import {createRouter, createWebHistory} from 'vue-router'
const routes = [
    {
        path:"/",
        component: login
    },
    {
        path:"/content-student",
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