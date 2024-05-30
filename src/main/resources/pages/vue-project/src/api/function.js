import axios from "../utils/request"
import path from "./path"

const api = {
    //详情
    getMatch(username,password){
        return axios.get(path.baseurl + path.dataOfSomeone, {
            params: {
                username: username,
                password: password
            }
        })
    }
}

export default api;