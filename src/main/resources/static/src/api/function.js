import axios from "../utils/request"
import path from "./path"

const api = {
    //详情
    getMatch(username,password,identity){
        return axios.get(path.baseurl + path.dataOfSomeone, {
            params: {
                username: username,
                password: password,
                identity: identity
            }
        })
    },
    getRealName(username){
        return axios.get(path.baseurl + path.dataOfSomeone, {
            params: {
                username:username
            }
        })
    }
}

export default api;