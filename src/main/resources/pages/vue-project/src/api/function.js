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
    getRealName(){
        return axios.get(path.baseurl + path.realName, {
        })
    },
    getInfor(){
        return axios.get(path.baseurl + path.infor, {
        })
    },
    changePassword(password){
        return axios.post(path.baseurl + path.changePassword, {
            password: password
        })
    }
}

export default api;