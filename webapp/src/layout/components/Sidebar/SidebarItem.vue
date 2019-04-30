<template>
  <div>
    <router-link to="/dashboard">
      <el-menu-item index="1">
        <i class="fa fa-tachometer" aria-hidden="true"></i>
        <span slot="title" class="itemText">概览</span>
      </el-menu-item>
    </router-link>
    <el-submenu index="2">
      <template slot="title">
        <i class="fa fa-tachometer"></i>
        <span slot="title" class="itemText">我的资源</span>
      </template>

      <router-link to="/resource/dashboard">
        <el-menu-item index="2-1">
          <i class="fa fa-area-chart" aria-hidden="true"></i>
          <span slot="title" class="itemText">概览</span>
        </el-menu-item>
      </router-link>
      <router-link to="/resourcelist">
        <el-menu-item index="2-2">
          <i class="fa fa-users" aria-hidden="true"></i>
          <span slot="title" class="itemText">主机资源管理</span>
        </el-menu-item>
      </router-link>
    </el-submenu>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {}
}
</script>

<style lang="scss" scoped>
.itemText {
  margin-left: 15px;
}
</style>
