// getters 去vuex里拿出变量，存放在这，需要取用的时候，在对应的页面computed里通过mapGetters拿到变量
// getters就是vuex的计算属性。
// 这样就不需要在对应的页面computed里去写一串 “this.$store.state.question.questionName”获取questionName的值
const getters = {
    isCollapse: state => state.app.isCollapse, //state.app.isCollapse相当于this.$store.state.app.isCollapse
    permission_routes: state => state.permission.routes,
    count: state => state.permission.count,
    isHomePage: state => state.app.isHomePage,
}
export default getters