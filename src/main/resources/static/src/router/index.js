<<<<<<< HEAD
import content from '../views/content-student.vue'
=======
import content from '../views/content.vue'
>>>>>>> parent of 7a6f14dc (S)
import login from '../views/login.vue'
import {createRouter, createWebHistory} from 'vue-router'
//存储路由
const routes = [
    {
        path:"/",
        component: login
    },
    {
<<<<<<< HEAD
        path:"/content-student",
        component: content
    },

=======
        path:"/content",
        component: content
    }
>>>>>>> parent of 7a6f14dc (S)
]

const router = createRouter(
    {
        history:createWebHistory(),
        routes
    }
)

export default router;