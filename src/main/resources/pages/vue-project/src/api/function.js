import axios from "../utils/request"
import path from "./path"
axios.defaults.headers.common['Content-Type'] = 'application/json';
const api = {
    //详情
    getMatch(username,password,identity){
        return axios.post(path.baseurl + path.login, {
                username: username,
                password: password,
                identity: identity
        })
    },
    getRealName(username, identity){
        return axios.get(path.baseurl + path.realName, {
            params: { 
                username: username,
                identity: identity
            }
        })
    },
    getInfor(username, identity){
        return axios.get(path.baseurl + path.infor, {
            params: { 
                username: username,
                identity: identity
            }
        })
    },
    changePassword(username, originalPassword, newPassword, identity){
        return axios.post(path.baseurl + path.changePassword, {
                username: username,
                originalPassword: originalPassword,
                newPassword: newPassword,
                identity: identity
        })
    },
    getAllCourses(){
        return axios.get(path.baseurl + path.allCourses, {
        })
    },
    getCourseIntro(course){
        return axios.get(path.baseurl + path.detailedCourse, {
            params: {
                course: course
            }
        })
    },
    ifCanCheck(id, username){
        return axios.get(path.baseurl + path.checkCourse, {
            params: {
                id: id,
                username
            }
        })
    },
    forgetPassword(username, identity){
        return axios.get(path.baseurl + path.forgetPassword, {
            params: {
                username: username,
                identity: identity
            }
        })
    },
    deleteCourses(courses){
        return axios.get(path.baseurl + path.deleteCourses, {
            params: {
                courses: courses
            }
        })
    },
    changeCourses(changes){
        return axios.post(path.baseurl + path.changeCourses, {
            params: {
                changes: changes
            }
        })
    },
    afterForgetPassword(username, newPassword, identity){
        return axios.post(path.baseurl + path.afterForgetPassword, {
            username: username,
            newPassword: newPassword,
            identity: identity
        })
    },
    getStudentCourses(username){
        return axios.get(path.baseurl + path.getStudent, {
            params: {
                username: username
            }
        })
    },
    getTeacherCourses(username){
        return axios.get(path.baseurl + path.getTeacherCourses, {
            params: {
                username: username
            }
        })
    }
}

export default api;