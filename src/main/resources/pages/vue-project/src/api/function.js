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
    ifCanCheck(id){
        return axios.get(path.baseurl + path.checkCourse, {
            params: {
                id: id
            }
        })
    },
    forgetPassword(username, newPassword ,identity){
        return axios.post(path.baseurl + path.forgetPassword, {
            username: username,
            newPassword: newPassword,
            identity: identity
        })
    }
}

export default api;