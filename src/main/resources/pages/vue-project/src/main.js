import { createApp } from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import axios from "axios"
import VueAxios from 'vue-axios'
import router from './router'

const app = createApp(App)
app.config.globalProperties.$axios = axios
app.use(router)
app.use(VueAxios,axios)
app.mount('#app')
