<template>
<el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane :label="item.title" :name="item.name" v-for="item in listData" :key="item.title">
        <listTab :list-label="item.title" :list-data='item.content' ></listTab>
    </el-tab-pane>
    <!-- <el-tab-pane label="升级" name="second">
      <listTab :list-data='listData'></listTab>
    </el-tab-pane>
        <el-tab-pane label="工单消息" name="third">工单消息</el-tab-pane>
        <el-tab-pane label="其他" name="fourth">其他</el-tab-pane> -->
</el-tabs>
</template>

<script>
import listTab from '@/components/message/listTab';
export default {
    components: {
        listTab,
    },
    data() {
        return {
            activeName: 'first',
            listData: [{
                title: "公告",
                name:"first",
                content: [{
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                }],
            },
            {
                title: "升级",
                name:"second",
               content: [{
                  text:"升级6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                }],
            },
            {
                title: "工单消息",
                name:"third",
                content: [{
                  text:"工单消息6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                }],
            },
            {
                title: "其他",
                name:"fourth",
                content: [{
                  text:"其他6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                },
                {
                  text:"公告6月6日DDoS高防（国际）系统升级通知",
                  date:"2019-06-12"
                }],
            },
            ]
        };
    },
    methods: {
        handleClick(tab, event) {
            console.log(tab, event);
        }
    }
};
</script>

<style lang="scss" scoped>
</style>
