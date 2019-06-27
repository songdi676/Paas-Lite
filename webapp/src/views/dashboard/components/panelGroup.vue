<template>
  <el-row :gutter="20" class="panel-group">
    <el-col :xs="12" :sm="12" :lg="colSpan" class="card-panel-col" v-for="item in data" :key="item">
      <div class="card-panel" @click="handleSetLineChartData('newVisitis')">
        <div class="card-panel-icon-wrapper" :class="[item.parenticon]">
          <i class="card-panel-icon" :class="[item.icon]"></i>
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">{{item.name}}</div>
          <count-to :start-val="0" :end-val="item.enddata" :duration="2600" class="card-panel-num"/>
        </div>
      </div>
    </el-col>
  </el-row>
</template>

<script>
import CountTo from "vue-count-to";

export default {
  props: {
    data: {
      type: Array,
      default: "",
      required: true
    }
  },
  computed: {
    colSpan() {
      if (this.data.length % 2 == 0) {
        return 24 / this.data.length;
      }
      else{
        return parseInt(24 / this.data.length)
      }
    }
  },
  components: {
    CountTo
  },
  methods: {
    handleSetLineChartData(type) {
      this.$emit("handleSetLineChartData", type);
    }
  }
};
</script>

<style lang="scss" scoped>
.panel-group {
  .card-panel-col {
    margin-bottom: 20px;
  }
  .card-panel {
    height: 108px;
    cursor: pointer;
    font-size: 12px;
    position: relative;
    overflow: hidden;
    color: #666;
    background: #fff;
    box-shadow: 4px 4px 40px rgba(0, 0, 0, 0.05);
    border-color: rgba(0, 0, 0, 0.05);
    display: flex;
    justify-content: space-between;
    &:hover {
      .card-panel-icon-wrapper {
        color: #fff;
      }
      .icon-green {
        background: #40c9c6;
      }
      .icon-blue {
        background: #36a3f7;
      }
      .icon-red {
        background: #f4516c;
      }
      .icon-greenky {
        background: #34bfa3;
      }
    }
    .icon-green {
      color: #40c9c6;
    }
    .icon-blue {
      color: #36a3f7;
    }
    .icon-red {
      color: #f4516c;
    }
    .icon-greenky {
      color: #34bfa3;
    }
    .card-panel-icon-wrapper {
      display: flex;
      align-items: center;
      margin: 10px;
      padding: 10px;
      transition: all 0.38s ease-out;
      border-radius: 6px;
    }
    .card-panel-icon {
      font-size: 48px;
    }
    .card-panel-description {
      font-weight: bold;
      margin: 26px;
      margin-left: 0px;
      .card-panel-text {
        line-height: 18px;
        color: rgba(0, 0, 0, 0.45);
        font-size: 16px;
        margin-bottom: 12px;
      }
      .card-panel-num {
        font-size: 20px;
      }
    }
  }
}
</style>
