<template>
  <div>
    <router-link to="/dashboard">
      <el-menu-item index="1">
        <i class="fa fa-tachometer" aria-hidden="true"></i>
        <span slot="title" class="itemText">概览</span>
      </el-menu-item>
    </router-link>
    <router-link to="/documentation">
      <el-menu-item index="2">
        <i class="fa fa-tachometer" aria-hidden="true"></i>
        <span slot="title" class="itemText">我的资源</span>
      </el-menu-item>
    </router-link>
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
