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
    getRealName(username){
        return axios.get(path.baseurl + path.realName, {
        })
    },
    getInfor(username){
        return axios.get(path.baseurl + path.infor, {
        })
    },
    changePassword(username, password){
        return axios.post(path.baseurl + path.changePassword, {
            password: password
        })
    }
}

export default api;