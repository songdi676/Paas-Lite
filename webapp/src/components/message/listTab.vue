<template>
  <section>
    <ul class="messageUl">
      <li v-for="item in listData" :key="item">
        【{{`${listLabel}`}}】
        <a class="listText">{{item.text}}</a>
        <span class="date">{{item.date}}</span>
      </li>
    </ul>
    <div class="more">
      <a>更多</a>
    </div>
  </section>
</template>

<script>
export default {
  props: {
    listLabel: {
      type: String,
      default: "",
      required: false
    },
    listData: {
      type: Array,
      default: [],
      required: true
    },
    createDate: {
      type: String,
      default: "",
      required: false
    }
  }
};
</script>

<style lang="scss" scoped>
.messageUl {
    height: 270px;
    overflow: auto;
    width: 101%;
  li {
    padding: 9px 0px;
    max-width: 100%;
    overflow: hidden;
    -o-text-overflow: ellipsis;
    text-overflow: ellipsis;
    white-space: nowrap;
    font-size: 14px;
    position: relative;
  }
  .listText {
    padding-left: 10px;
    &:hover{
        color: #666;
    }
    
  }
  .date{
      position: absolute;
      right: 10px;
      color: rgb(153, 153, 153);
  }
}
.more {
  margin: 15px 8px;
  a {
        color: #00b0a1;
  }
}
</style>