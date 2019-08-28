<template>
  <div>
    <el-form label-width="80px">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="群主分配" name="first">
          <el-transfer v-model="leaders" :data="data" :titles="['未选用户', '已选群主']"></el-transfer>
        </el-tab-pane>
        <el-tab-pane label="组员分配" name="second">
          <el-transfer v-model="members" :data="data" :titles="['未选用户', '已选组员']"></el-transfer>
        </el-tab-pane>
      </el-tabs>
      <el-form-item label="群主|领导">
        <el-select
          v-model="leaders"
          multiple
          filterable
          remote
          placeholder="请输入关键词"
          :remote-method="remoteLeaderMethod"
          :loading="loading"
        >
          <el-option v-for="item in lItems" :key="item.id" :label="item.name" :value="item.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="组员|下属">
        <el-select
          v-model="members"
          multiple
          filterable
          remote
          placeholder="请输入关键词"
          :remote-method="remoteMemberMethod"
          :loading="loading"
        >
          <el-option v-for="item in mItems" :key="item.id" :label="item.name" :value="item.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" v-if="groupManager_btn_userManager" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
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
    /**这是一个函数，不要放在data（）
     * 块里面
     */
    // const generateData = _ => {
    //     const data = [];
    //     console.log(this.list);
    //     for (let i = 0; i <= this.list.length; i++) {
    //       data.push({
    //         key: i,
    //         label: `备选项 ${ i }`,
    //         disabled: i % 4===0
    //       });
    //     }
    //     return data;
    // };
    return {
      lItems: [], //领导
      mItems: [], //成员
      leaders: [],//领导用户id
      members: [],//成员用户id
      list: [], //变量也要有意义，谁知道这是什么列表
      loading: false,
      groupManager_btn_userManager: false,
      data: [], //一样，不知道是什么数据
      value: this.members,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        name: undefined
      },
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
      
      console.log(this.list);
      for (let i = 0; i < this.list.length; i++) {
        this.data.push({
          key: this.list[i].id,
          label: this.list[i].name,
          disabled: null
        });
      }
      this.value = this.mItems;
      debugger;
    },
    /**方法名要有意义，改为getAllUserList */
    getAllUserList() {
      all().then(response => {
        this.list = response;
        this.generateData();
        console.log(this.data);
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
