import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'

//分模块新建每个组件对应的store对象，并引入到此
import app from './modules/app'
import permission from './modules/permission'

Vue.use(Vuex)

//使用app.js文件下的state方法：——app.js是整个应用的状态集合
//我们应该给组件所用到的state进行归类到新的文件里，好管理
//没有分modules，使用$store.state.count
//分modules后，使用$store.state.app.count
//意味着寻找到app模块下的count状态值
//如果不划分，全局均可用到count，并改变其

const store = new Vuex.Store({
    modules: {
        app,
        permission
    },
    getters
})

export default store