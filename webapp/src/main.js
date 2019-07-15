import Vue from 'vue'
import App from './App.vue'
import router from './router'

import Cookies from 'js-cookie'

import 'normalize.css/normalize.css' // a modern alternative to CSS resets

import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import 'font-awesome/css/font-awesome.css'
import './icons' // icon

import '@/styles/index.scss' // global css

import store from '@/store/index'
import echarts from 'echarts'


import { mockXHR } from '../mock'
if (process.env.NODE_ENV === 'production') {
    mockXHR()
}

Vue.use(Element, {
    size: Cookies.get('size') || 'medium' // set element-ui default size
})



Vue.config.productionTip = false
Vue.prototype.$echarts = echarts

Vue.use(Element);

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')