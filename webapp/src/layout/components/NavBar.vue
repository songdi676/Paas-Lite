<template>
<div class="navbar">
    <trans-icon class="icon"></trans-icon>
    <bread-crumb></bread-crumb>
</div>
</template>

<script>
import BreadCrumb from '@/components/breadcrumb/index'
import TransIcon from '@/components/transIcon/index'
export default {
    components: {
        'bread-crumb': BreadCrumb,
        'trans-icon': TransIcon
    }

}
</script>

<style lang="scss" scoped>
.navbar {
    display: flex;
}

.icon {
    margin-right: 20px;
}
</style>
