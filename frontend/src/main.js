import BootstrapVue from 'bootstrap-vue-3'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import 'bootstrap/dist/css/bootstrap.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import axios from "axios";

const app = createApp(App)

app.provide('$axios', axios)

app.use(createPinia())
app.use(router)
app.use(BootstrapVue)

app.mount('#app')
