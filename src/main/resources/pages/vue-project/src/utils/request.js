import axios from "axios"

// 错误处理函数
const errorHandle = (status,info) => {
    switch (status) {
        case 400:
            console.log("语义有误");
            break;
        case 401:
            console.log("服务器认证失败");
            break;
        case 403:
            console.log("服务器拒绝访问");
            break;
        case 404:
            console.log("地址错误");
            break;
        case 500:
            console.log("服务器遇到意外");
            break;
        case 502:
            console.log("服务器无响应");
            break;
        default:
            console.log(info);
            break;
    }
}

// 创建 Axios 实例
const instance = axios.create({
    timeout: 5000
})

 请求拦截器
instance.interceptors.request.use(
    config => {
        if (config.methods === "post") {
            config.data = querystring.stringify(config.data);
        }
        return config;
    },
    error => {
        return Promise.reject(error)
    }
)
// 响应拦截器
instance.interceptors.response.use(
    response => {
        return response.status === 200 ? Promise.resolve(response) : Promise.reject(response)
    },
    error => {
        if (error.response) {
            // 服务器返回了响应，但状态码不是 2xx
            const { status, data } = error.response;
            errorHandle(status, data);
            return Promise.reject(error.response)
        } else if (error.request) {
            // 请求已发出，但没有收到响应
            console.log("请求已发出，但没有收到响应");
            return Promise.reject(error.request)
        } else {
            // 在设置请求时发生了一些事情，触发了错误
            console.log("请求设置错误" + error.message);
            return Promise.reject(error.message)
        }
    }
)

export default instance;

