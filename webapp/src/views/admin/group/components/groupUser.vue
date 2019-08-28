<template>
  <el-form>
    <el-form label-width="80px">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="群主分配" name="first">
          <el-transfer v-model="leaders" :data="allUserData" :titles="['未选用户', '已选群主']"></el-transfer>
        </el-tab-pane>
        <el-tab-pane label="组员分配" name="second">
          <el-transfer v-model="members" :data="allUserData" :titles="['未选用户', '已选组员']"></el-transfer>
        </el-tab-pane>
      </el-tabs>
      <div style="margin-top:20px;">
        <el-button type="primary" v-if="groupManager_btn_userManager" @click="onSubmit">保存</el-button>
      </div>
    </el-form>
  </el-form>
</template>

<script>
import { page, all } from "api/admin/user/index";
import { getUsers, modifyUsers } from "api/admin/group/index";
import { mapGetters } from "vuex";
export default {
  props: {
    groupId: {
      default: "1"
    }
  },
  data() {
    return {
      lItems: [], //领导
      mItems: [], //成员
      leaders: [], //领导用户id
      members: [], //成员用户id
      allUserList: [],
      loading: false,
      groupManager_btn_userManager: false,
      allUserData: [],
      value: [],
      activeName: "first"
    };
  },
  created() {
    this.initUsers();
    this.getAllUserList();
    this.groupManager_btn_userManager = this.elements[
      "groupManager:btn_userManager"
    ];
  },
  computed: {
    ...mapGetters(["elements"])
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    generateData() {
      for (let i = 0; i < this.allUserList.length; i++) {
        this.allUserData.push({
          key: this.allUserList[i].id,
          label: this.allUserList[i].name,
          disabled: null
        });
      }
      this.value = this.mItems;
    },
    getAllUserList() {
      all().then(response => {
        this.allUserList = response;
        this.generateData();
      });
    },
    remoteMemberMethod(query) {
      if (query !== "") {
        this.loading = true;
        this.loading = false;
        page({
          name: query
        }).then(response => {
          this.mItems = response.data.rows;
          this.total = response.data.total;
          this.loading = false;
        });
      } else {
        this.mItems = [];
      }
    },
    remoteLeaderMethod(query) {
      if (query !== "") {
        this.loading = true;
        this.loading = false;
        page({
          name: query
        }).then(response => {
          this.lItems = response.data.rows;
          this.total = response.data.total;
          this.loading = false;
        });
      } else {
        this.lItems = [];
      }
    },
    onSubmit() {
      const vals = {};
      if (this.members.length > 0) vals.members = this.members.join();
      if (this.leaders.length > 0) vals.leaders = this.leaders.join();
      modifyUsers(this.groupId, vals).then(() => {
        this.$emit("closeUserDialog");
        this.$notify({
          title: "成功",
          message: "保存成功",
          type: "success",
          duration: 2000
        });
      });
    },
    initUsers() {
      getUsers(this.groupId).then(response => {
        this.lItems = response.data.leaders;
        this.mItems = response.data.members;
        const mems = [],
          leas = [];
        for (let i = 0; i < response.data.members.length; i++) {
          mems.push(response.data.members[i].id);
        }
        for (let i = 0; i < response.data.leaders.length; i++) {
          leas.push(response.data.leaders[i].id);
        }
        this.members = mems;
        this.leaders = leas;
      });
    }
  }
};
</script>
<style lang="scss" scope>
.el-form-item__content {
  margin-left: 0px !important;
}
</style>
