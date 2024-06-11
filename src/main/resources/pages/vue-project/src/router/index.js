import content_student from '../views/content-student.vue'
import login from '../views/login.vue'
import infor from '../views/infor.vue'
import choose_student from '../views/choose-student.vue'
import myTable_student from '../views/myTable-student.vue'
import content_teacher from '../views/content-teacher.vue'
import content_admin from '../views/content-admin.vue'
import courseIntro from '../components/courseIntro.vue'
import choose_teacher from '../views/choose-teacher.vue'
import choose_admin from '../views/choose-admin.vue'
import myTable_teacher from '../views/myTable-teacher.vue'
import {createRouter, createWebHistory} from 'vue-router'
const routes = [
    { path:"/", component: login },
    { path:"/content-student", component: content_student },
    { path:"/infor", component: infor },
    { path:"/choose-student", component: choose_student },
    { path:"/myTable-student", component: myTable_student },
    { path:"/content-teacher", component: content_teacher },
    { path:"/content-admin", component: content_admin },
    { path: '/courseIntro/:courseName', name: 'courseIntro', component: courseIntro, props: route => ({ courseName: route.params.courseName }) },
    { path:"/choose-teacher", component: choose_teacher },
    { path:"/choose-admin", component: choose_admin },
    { path:"/myTable-teacher", component: myTable_teacher }
]
const router = createRouter(
    {
        history:createWebHistory(),
        routes
    }
)
export default router;