<template>
  <div v-if="!item.hidden">
    <template
      v-if="hasOneShowingChild(item.children,item) && (!onlyOneChild.children||onlyOneChild.noShowingChildren)&&!item.alwaysShow"
    >
      <router-link :to="resolvePath(onlyOneChild.path)">
        <el-menu-item :index="resolvePath(onlyOneChild.path)">
           <svg-icon :icon-class="onlyOneChild.meta.icon||(item.meta&&item.meta.icon)"/>
           <span slot='title' class='itemText'>{{onlyOneChild.meta.zh}}</span>
        </el-menu-item>
      </router-link>
    </template>
    <el-submenu v-else :index="resolvePath(item.path)" popper-append-to-body>
      <template slot="title">
        <div v-if="item.meta">
          <svg-icon :icon-class="item.meta && item.meta.icon"/>
          <span slot="title" class="itemText">{{item.meta.zh}}</span>
        </div>
      </template>
      <template>
        <div v-for="child in item.children" :key="child.path">
          <router-link :to="resolvePath(child.path)">
            <el-menu-item :index="resolvePath(child.path)">
              <i :class="child.meta.icon" aria-hidden="true"></i>
              <span slot="title" class="itemText">{{child.meta.zh}}</span>
            </el-menu-item>
          </router-link>
        </div>
      </template>
    </el-submenu>
  </div>
</template>

<script>
import path from "path";
export default {
  name: "SidebarItem",
  props: {
    // route object
    item: {
      type: Object,
      required: true
    },
    isNest: {
      type: Boolean,
      default: false
    },
    basePath: {
      type: String,
      default: ""
    }
  },
  data() {
    return {
      menulist: [],
      onlyOneChild: null
    };
  },
  methods: {
    hasOneShowingChild(children = [], parent) {
      const showingChildren = children.filter(item => {
        if (item.hidden) {
          return false;
        } else {
          // Temp set(will be used if only has one showing child)
          this.onlyOneChild = item;
          return true;
        }
      });

      // When there is only one child router, the child router is displayed by default
      if (showingChildren.length === 1) {
        return true;
      }

      // Show parent if there are no child router to display
      if (showingChildren.length === 0) {
        this.onlyOneChild = { ...parent, path: "", noShowingChildren: true };
        return true;
      }

      return false;
    },
    isExternal(path) {
      return /^(https?:|mailto:|tel:)/.test(path);
    },
    resolvePath(routePath) {
      if (this.isExternal(routePath)) {
        return routePath;
      }
      if (this.isExternal(this.basePath)) {
        return this.basePath;
      }
      return path.resolve(this.basePath, routePath);
    }
  }
};
</script>

<style lang="scss" scoped>
.itemText {
  margin-left: 15px;
}
</style>
