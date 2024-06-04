import axios from "../utils/request"
import path from "./path"
axios.defaults.headers.common['Content-Type'] = 'application/json';
const api = {
    //详情
    getMatch(username,password,identity){
        return axios.post(path.baseurl + path.dataOfSomeone, {
                username: username,
                password: password,
                identity: identity
        })
    },
    getRealName(username){
        return axios.post(path.baseurl + path.dataOfSomeone, {
                username:username
        })
    }
}

export default api;