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
        <i :class="navMenu.icon"></i>
        <span slot="title">{{ navMenu.name }}</span>
      </el-menu-item>
      <el-submenu v-if="navMenu.child" :data="navMenu" :index="navMenu.index" popper-class="menu-item-height"  class="is-active">
        <template slot="title">
          <i :class="navMenu.icon"></i>
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
//       menus: [
//         {'name': '首页', 'icon': 'el-icon-star-off', 'index': '/Index/IsHome'},
//         {'name': '应用门户', 'icon': 'el-icon-setting', 'index': '2', 'child': [
//             {'name': '专题讨论', 'icon': 'el-icon-location', 'index': '2-1','child' :[
//                 {'name': '专题发布', 'icon': 'el-icon-location', 'index': '/Index/SpecialRelease'},
//               ]},
//             {'name': '新闻头条', 'icon': 'el-icon-location', 'index': '/Index/News'},
//           ]},
//         {'name':'统战成员数据库','icon':'el-icon-setting','index':'3','child':[
//             {'name': '统战成员对象', 'icon': 'el-icon-location', 'index': '3-1', 'child': [
//                 {'name': '个人基本情况', 'icon': 'el-icon-location', 'index': '/Index/UserManage'},
//                 {'name': '个人特征标签', 'icon': 'el-icon-location', 'index': '/Index/PersonalLabel'},
//               ]},
//             {'name': '各级组织', 'icon': 'el-icon-location', 'index': '3-2', 'child': [
//                 {'name': '民主党派管理', 'icon': 'el-icon-location', 'index': '/Index/DemocraticParties'},
//                 {'name': '统战团体', 'icon': 'el-icon-location', 'index': '/Index/UnitedFrontGroups'},
//               ]},
//             {'name': '阵地管理', 'icon': 'el-icon-location', 'index': '3-3', 'child': [
// //            {'name': '阵地管理', 'icon': 'el-icon-location', 'index': '/Index/SubjectManageDemo'},
//                 {'name': '阵地地图', 'icon': 'el-icon-location', 'index': '/Index/PositionInformation'},
//                 {'name': '人员活动频率', 'icon': 'el-icon-location', 'index': '/Index/PersonnelFrequency'},
//               ]},
//           ]},
//         ]
    }
  },
  methods: {

    handleSelect(key, keyPath) {
      console.log(key + '-----------' + keyPath)
      switch (key) {
        case '1-1-1':
          // this.$router.push('/Page1');
          // this.breadcrumbItems  = ['导航一']
          break
      }
    },
  }
}
</script>

<style scoped>
.navMenu{
  width: 200px;
}
</style>
