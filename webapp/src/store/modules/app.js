import Cookies from 'js-cookie'

const state = {
    sidebar: {
        opened: Cookies.get('sidebarStatus') ? !!+Cookies.get('sidebarStatus') : true,
        withoutAnimation: false
    },
    device: 'desktop',
    size: Cookies.get('size') || 'medium',
    isCollapse: false,
    isHomePage: false
}

const mutations = {
    TOGGLE_SIDEBAR: state => {
        state.sidebar.opened = !state.sidebar.opened
        state.sidebar.withoutAnimation = false
        if (state.sidebar.opened) {
            Cookies.set('sidebarStatus', 1)
        } else {
            Cookies.set('sidebarStatus', 0)
        }
    },
    CLOSE_SIDEBAR: (state, withoutAnimation) => {
        Cookies.set('sidebarStatus', 0)
        state.sidebar.opened = false
        state.sidebar.withoutAnimation = withoutAnimation
    },
    TOGGLE_DEVICE: (state, device) => {
        state.device = device
    },
    SET_SIZE: (state, size) => {
        state.size = size
        Cookies.set('size', size)
    },
    changeSubMenu: (state) => {
        state.isCollapse = !state.isCollapse;
        console.log("点击打开，isCollapse是从store仓库里拿到的");
    },
    showBreadCrumb: (state, path) => {
        if (path !== "/dashboard") {
            state.isHomePage = true;
        } else {
            state.isHomePage = false;
        }
    }
}

const actions = {
    toggleSideBar({
        commit
    }) {
        commit('TOGGLE_SIDEBAR')
    },
    closeSideBar({
        commit
    }, {
        withoutAnimation
    }) {
        commit('CLOSE_SIDEBAR', withoutAnimation)
    },
    toggleDevice({
        commit
    }, device) {
        commit('TOGGLE_DEVICE', device)
    },
    setSize({
        commit
    }, size) {
        commit('SET_SIZE', size)
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}