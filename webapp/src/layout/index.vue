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
        <breadCrumb v-if="!isdashboard"></breadCrumb>
        <app-main></app-main>
      </div>
    </div>
  </div>
</template>

<script>
// import { HeaderItem, SideBar, AppMain } from "./components";
import path from "path";
import { mapGetters } from "vuex";
import SideBar from "./components/Sidebar/index";
import AppMain from "./components/AppMain";
import HeaderItem from "./components/Header/index";
import BreadCrumb from "@/components/Breadcrumb/index";
export default {
  components: {
    "header-item": HeaderItem,
    "side-bar": SideBar,
    "app-main": AppMain,
    breadCrumb: BreadCrumb
  },
  data() {
    return {
      isdashboard: true
    };
  },
  computed: {
    ...mapGetters(["isCollapse"]),
    getChange() {
      return this.isCollapse;
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
  top: 55px;
  padding: 20px;
  background: #f5f7fa;
  text-align: left;
  width: calc(100% - 230px);
  //display: table;
}
.main-max {
  width: calc(100% - 60px);
}
.side-bar {
  margin-left: 230px;
}
.side-bar-min {
  margin-left: 60px;
}
// 为配合实现水平垂直绝对居中
.container {
  width: 100%;
  height: 100%;
  header {
    width: 100%;
    height: 55px;
    background: #252a2f;
    position: fixed;
    top: 0;
    z-index: 1000;
  }
  .main-container {
    width: 100%;
    height: 100%;
  }
  .app-main {
    height: 100%;
    width: 100%;
    // display: table-cell;
    // vertical-align: middle;
  }
}
</style>
