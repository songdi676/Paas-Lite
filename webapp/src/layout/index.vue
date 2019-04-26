<template>
  <div class="container">
    <header>
      <header-item></header-item>
    </header>
    <div class="main-container">
      <div class="side-content">
        <side-bar></side-bar>
      </div>
      <div
        class="main-content"
        :class="{ 'side-bar': !getChange, 'side-bar-min': getChange, 'main-max': getChange }"
      >
        <app-main></app-main>
      </div>
    </div>
  </div>
</template>

<script>
// import { HeaderItem, SideBar, AppMain } from "./components";

import { mapGetters } from "vuex";
import SideBar from "./components/Sidebar/index";
import AppMain from "./components/AppMain";
import HeaderItem from "./components/Header/index";
export default {
  components: {
    "header-item": HeaderItem,
    "side-bar": SideBar,
    "app-main": AppMain
  },
  data() {
    return {};
  },
  computed: {
    ...mapGetters(["isCollapse"]),
    getChange() {
      return this.isCollapse; //去vuex里取isCollapse状态值
    }
  }
};
</script>

<style lang="scss" scoped>
.main-content {
  height: 100%;
  -webkit-transition: margin-left 0.28s;
  transition: margin-left 0.28s;
  margin-left: 230px;
  position: relative;
  background: #f5f7fa;
  padding: 20px;
  text-align: left;
  margin-top: 80px;
  width: calc(100% - 230px);
  display: table;
}
.main-max {
  width: calc(100% - 70px);
}
.side-bar {
  margin-left: 230px;
}
.side-bar-min {
  margin-left: 70px;
}
// 为配合实现水平垂直绝对居中
.container {
  width: 100%;
  height: 100%;
  header {
    height: 80px;
    background: #2b3844;
    position: fixed;
    top: 0;
    width: 100%;
    z-index: 1000;
  }
  .main-container {
    width: 100%;
    height: 100%;
  }
  .app-main {
    height: 100%;
    width: 100%;
    display: table-cell;
    vertical-align: middle;
  }
}
</style>
