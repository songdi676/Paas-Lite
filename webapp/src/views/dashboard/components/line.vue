<template>
    <section>
        <div class="title">
            资源
        </div>
        <lineChart :chart-data="lineChartData"></lineChart>
    </section>
</template>

<script>
import lineChart from '@/components/charts/lineChart'
const lineChartData = {
  orderTotals: {
    expectedData: [211100, 231220, 425161, 321340, 131005, 561600, 331650,425161, 321340, 131005, 561600, 331650],
    actualData: [222120, 313382,255591, 651540, 1111620, 133140, 443145,313382,255591, 651540, 1111620, 133140]
  }
}
export default {
    components:{
        lineChart
    },
    data() {
        return {
            lineChartData: lineChartData.orderTotals
        }
    },
}
</script>

<style lang="scss" scoped>

</style>
