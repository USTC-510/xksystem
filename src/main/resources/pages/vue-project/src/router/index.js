import content_student from '../views/content-student.vue'
import login from '../views/login.vue'
import infor_student from '../views/infor-student.vue'
import choose_student from '../views/choose-student.vue'
import myTable_student from '../views/myTable-student.vue'
import content_teacher from '../views/content-teacher.vue'
import {createRouter, createWebHistory} from 'vue-router'
const routes = [
    { path:"/", component: login },
    { path:"/content-student", component: content_student },
    { path:"/infor-student", component: infor_student },
    { path:"/choose-student", component: choose_student },
    { path:"/myTable-student", component: myTable_student },
    { path:"/content-teacher", component: content_teacher }
]
const router = createRouter(
    {
        history:createWebHistory(),
        routes
    }
)
export default router;