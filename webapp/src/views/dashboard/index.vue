<template>
  <section>
    <panelGroup :data="data"></panelGroup>
    <el-row type="flex" :gutter="20" class="rowBox">
      <el-col span="12">
        <el-card>
          <message></message>
        </el-card>
      </el-col>
      <el-col span="12">
        <el-card>
          <alarm></alarm>
        </el-card>
      </el-col>
    </el-row>
    <el-row type="flex" :gutter="20">
      <el-col span="12">
        <el-card>
        </el-card>
      </el-col>
      <el-col span="12">
        <el-card>
          
        </el-card>
      </el-col>
    </el-row>
  </section>
</template>

<script>
import panelGroup from "./components/panelGroup";
import message from "./components/message";
import alarm from "./components/alarm";
import vLine from "./components/line";
export default {
  components: {
    panelGroup,
    message,
    alarm,
    vLine
  },
  data() {
    return {
      data: [
        {
          name: "我的资源",
          enddata: "10020",
          parenticon: "icon-green",
          icon: "fa fa-user"
        },
        {
          name: "我的集群",
          enddata: "9981",
          parenticon: "icon-blue",
          icon: "fa fa-bar-chart"
        },
        {
          name: "我的资产",
          enddata: "12334",
          parenticon: "icon-red",
          icon: "fa fa-area-chart"
        },
        {
          name: "我的服务",
          enddata: "1233",
          parenticon: "icon-greenky",
          icon: "fa fa-database"
        }
      ]
    };
  }
};
</script>

<style lang="scss" scoped>
.rowBox {
  margin-bottom: 20px;
  .el-card {
    height: 400px;
    overflow: hidden;
  }
}
</style>

