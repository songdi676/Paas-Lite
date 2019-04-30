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
                icon: 'fa fa-dashboard',
                noCache: true,
                affix: true
            }
        }]
    },
    {
        path: '/documentation',
        component: Layout,
        children: [{
            path: 'index',
            component: () =>
                import ('@/views/documentation/index'),
            name: 'Documentation',
            meta: {
                title: 'documentation',
                icon: 'documentation',
                affix: true,
            }
        }]
    },

]
export const asyncRoutes = [{
    path: '/permission',
    component: Layout,
    redirect: '/permission/page',
    alwaysShow: true, // will always show the root menu
    name: 'Permission',
    meta: {
        title: 'permission',
        icon: 'lock',
        roles: ['admin', 'editor'] // you can set roles in root nav
    },

}]
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