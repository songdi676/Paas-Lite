<template>
  <div>
    <router-link to="/dashboard">
      <el-menu-item index="1">
        <i class="fa fa-tachometer" aria-hidden="true"></i>
        <span slot="title" class="itemText">Dashboard</span>
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
