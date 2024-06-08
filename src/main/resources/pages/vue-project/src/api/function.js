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
                username,
                identity
            }
        })
    },
    getInfor(username, identity){
        return axios.get(path.baseurl + path.infor, {
            params: { 
                username,
                identity
            }
        })
    },
    changePassword(username, password, identity){
        return axios.get(path.baseurl + path.changePassword, {
            params: { 
                username,
                password,
                identity
            }
        })
    }
}

export default api;