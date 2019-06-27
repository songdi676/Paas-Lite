<template>
<section>
    <div class="title">
        告警
    </div>
    <lineChart :chart-data="lineChartData"></lineChart>
</section>
</template>

<script>
import lineChart from '@/components/charts/lineChart'
const lineChartData = {
    orderTotals: {
        lowData: [100, 120, 161, 134, 105, 160, 165],
        mediumData: [120, 82, 91, 154, 162, 140, 145],
        hightData: [80, 100, 121, 104, 105, 90, 100]
    }
}
export default {
    components: {
        lineChart
    },
    data() {
        return {
            lineChartData: lineChartData.orderTotals
        }
    },
}
</script>

<style>

</style>
