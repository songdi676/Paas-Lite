<template>
  <section class="head-content">
    head
  </section>
</template>

<script>
export default {
  data() {
    return {
      searchVal: ""
    };
  }
};
</script>

<style lang="scss" scoped>
.head-content {
  display: flex;
  justify-content: space-between;
  .logoBox {
    color: #fff;
    border-right: 1px solid #36424d;
    width: 230px;
    height: 80px;
    display: flex;
    align-items: center;
    .logoimg {
      width: 45px;
      height: 45px;
      overflow: hidden;
      margin: 0 10px;
      img {
        width: 100%;
      }
    }
  }
  .iconBox {
    color: #fff;
    display: flex;
    align-items: center;
    a{
      display: inline-block;
      padding: 15px;
      .el-dropdown{
        color: #fff;
      }
    }
  }
}
</style>
