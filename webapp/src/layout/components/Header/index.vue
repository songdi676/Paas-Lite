<template>
  <section class="head-content">
    <div class="pullleft">
      <div class="logoimg">
        <img src="@/assets/images/Paaslogo.png">
      </div>
      <span class="topTitle">Paas管理控制台</span>
    </div>
    <div class="pullright">
      <div class="common-search">
        <div class="searchBox">
          <input class="inputItem" type="text" placeholder="搜索">
          <div class="driver"></div>
          <div class="search-icon">
            <i class="el-icon-search"></i>
          </div>
        </div>
      </div>
      <rightNav></rightNav>
    </div>
  </section>
</template>

<script>
import rightNav from './components/rightnav'
export default {
  components:{
    rightNav
  },
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
  .pullleft {
    color: #fff;
    border-right: 1px solid #36424d;
    width: 230px;
    height: 55px;
    display: flex;
    align-items: center;
    .logoimg {
      width: 40px;
      height: 40px;
      overflow: hidden;
      margin: 0 8px;
      img {
        width: 100%;
      }
    }
    .topTitle {
      display: inline-block;
      margin-left: 20px;
    }
  }
  .pullright {
    color: #fff;
    display: flex;
    align-items: center;
    .common-search{
      margin-right: 20px;
    }
    .searchBox {
      width: 100%;
      padding: 5px;
      display: flex;
      background: #333;
      border: 1px solid hsla(0, 0%, 100%, 0.1);
      transition: all linear 0.3s;
      position: relative;
      float: right;
      &:hover {
        width: 150%;
        background: #252a2f;
        border: 1px solid #00ffea;
        cursor: pointer;
      }
      .driver {
        width: 1px;
        height: 18px;
        position: absolute;
        right: 30px;
        top: 4px;
        margin: 0 2px;
        border-right: 1px solid hsla(0, 0%, 100%, 0.1);
      }
      .search-icon {
        width: 24px;
        height: 24px;
        position: absolute;
        top: 4px;
        right: 2px;
      }
    }
    .inputItem {
      outline: none;
      border: none;
      background: transparent;
      box-sizing: border-box;
      padding-left: 5px;
      color: #fff;
      font-size: 12px;
    }

    a {
      display: inline-block;
      padding: 15px;
      .el-dropdown {
        color: #fff;
      }
    }
  }
}
</style>
