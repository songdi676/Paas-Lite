import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Layout from '@/layout'

Vue.use(Router)

export const constantRouterMap = [{
        path: '',
        component: Layout,
        redirect: '/dashboard',
        children: [{
            path: 'dashboard',
            component: () =>
                import ('@/views/dashboard/index'),
            name: 'Dashboard',
            meta: {
                title: 'dashboard',
                zh: '概览',
                icon: 'dashboard',
                noCache: true,
                affix: true
            }
        }]
    },

    {
        path: '/resource',
        component: Layout,
        name: 'Resource',
        meta: {
            title: 'Resource',
            zh: '我的资源',
            icon: 'documentation'
        },
        children: [{
            path: '/resource/dashboard',
            component: () =>
                import ('@/views/resource/components/dashboard'),
            meta: {
                title: 'dashboard',
                zh: '概览',
                noCache: true,
                affix: true
            }
        }, {
            path: '/resourcelist',
            component: () =>
                import ('@/views/resource/components/resourceList'),
            meta: {
                title: 'dashboard',
                zh: '主机资源管理',
                noCache: true,
                affix: true
            }
        }]

    }

]

const createRouter = () => new Router({
    // mode: 'history', // require service support
    scrollBehavior: () => ({
        y: 0
    }),
    routes: constantRouterMap
})

const router = createRouter()

export function resetRouter() {
    const newRouter = createRouter()
    router.matcher = newRouter.matcher // reset router
}

export default router

// export default new Router({
//     // mode: 'history', //后端支持可开
//     scrollBehavior: () => ({
//         y: 0
//     }),
//     routes: constantRouterMap
// })