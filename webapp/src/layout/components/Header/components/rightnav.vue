<template>
  <section>
    <div class="nav">
      <div class="list">
        <a>消息</a>
      </div>
      <div class="list">
        <a>支持与服务</a>
      </div>
      <div class="list">
        <a>
          <el-badge is-dot class="item">
            <i class="fa fa-bell-o" aria-hidden="true"></i>
          </el-badge>
        </a>
      </div>
      <div class="list">
        <a>
          <el-dropdown trigger="click">
            <span class="el-dropdown-link fa fa-user-circle-o">
              <i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>Dashboard</el-dropdown-item>
              <el-dropdown-item>About Me</el-dropdown-item>
              <el-dropdown-item >
                <span style="display:block;" @click="logout">Log Out</span>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </a>
      </div>
    </div>
    <div class="subNav"></div>
  </section>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  computed: {
    ...mapGetters([
      'sidebar',
      'avatar',
      'device'
    ])
  },
   methods: {
    async logout() {
      await this.$store.dispatch('user/logout')
      this.$router.push(`/login?redirect=${this.$route.fullPath}`)
    }
  }
};
</script>

<style lang="scss" scoped>
.nav {
    .list {
      float: left;
      padding: 18px;
      &:hover {
        background: #171a1e;
      }
    }
  
}
</style>

