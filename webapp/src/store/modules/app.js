const app = {
    state: {
        isCollapse: false
    },
    mutations: {
        changeSubMenu(state) {
            state.isCollapse = !state.isCollapse;
            console.log("点击打开，isCollapse是从store仓库里拿到的");
        }
    }
};
export default app