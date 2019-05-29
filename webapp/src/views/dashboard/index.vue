<template>
  <section>
    <panelGroup :data="data"></panelGroup>
  </section>
</template>

<script>
import panelGroup from "./components/panelGroup";
export default {
  components: {
    panelGroup
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

<style>
</style>
