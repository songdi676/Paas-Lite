<template>
  <div class="navbar">
    <bread-crumb></bread-crumb>
  </div>
</template>

<script>
import BreadCrumb from "@/components/Breadcrumb/index";
export default {
  components: {
    "bread-crumb": BreadCrumb
  }
};
</script>

<style lang="scss" scoped>
.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  background: #fff;
  -webkit-box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);
  box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);
}
</style>
