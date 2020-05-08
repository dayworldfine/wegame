<template>
  <div class="navMenu">
    <label v-for="navMenu in navMenus" :key="navMenu.index">
      <el-menu-item
        v-if="navMenu.child == null"
        :data="navMenu"
        :index="navMenu.index"
        :route="navMenu.route"
        popper-class=" menu-item-height"
      >
        <!--<i :class="navMenu.icon"></i>-->
        <span slot="title">{{ navMenu.name }}</span>
      </el-menu-item>
      <el-submenu v-if="navMenu.child" :data="navMenu" :index="navMenu.index" popper-class="menu-item-height"  class="is-active">
        <template slot="title">
          <!--<i :class="navMenu.icon"></i>-->
          <span>{{ navMenu.name }}</span>
        </template>
        <NavMenu :navMenus="navMenu.child"></NavMenu>
      </el-submenu>
    </label>
  </div>
</template>

<script>
  export default {
    name: 'NavMenu',
    props: [
      'navMenus'
    ],
    data() {
      return {
        menus: null
      }
    },
    created() {
      this.getMenus()
    },
    methods: {
      handleOpen(key, keyPath) {
      },
      handleClose(key, keyPath) {
      },
      handleSelect(key, keyPath) {
        console.log(key + '-----------' + keyPath)
        switch (key) {
          case '1-1-1':
            // this.$router.push('/Page1');
            // this.breadcrumbItems  = ['导航一']
            break
        }
      },
      getMenus() {
        // this.store.saveByName("Tasks",[]);
      }
    }
  }
</script>

<style scoped>
  .el-menu-item.is-active {
    background-color: rgba(51, 51, 51, 0.5) !important;
  }

  .el-menu-vertical-demo {
    height: 100%;
  }
  .menu-item{
    border: 1px solid #f8f8f8;
  }
  .menu-item-height{
    height:50px;
  }
  .el-menu-item.is-active[data-v-2ca7c6d6]{
    background-color: #ffffff !important;
  }
  .el-submenu{
    border-bottom: 1px solid #f8f8f8;
  }
</style>
