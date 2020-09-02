<template>
  <div class="sidebar">
    <el-menu
      default-active="Home"
      router
      class="el-menu-vertical-demo"
      background-color="rgb(31, 45, 61)"
      unique-opened
      text-color="#fff"
      active-text-color="#ffd04b"
      @select="handleSelect"
    >
      <NavMenu :navMenus="menus" />
    </el-menu>
  </div>
</template>

<script>
// import bus from '@/utils/bus';
import NavMenu from "@/views/Home/HomeModules/NayMenu.vue";
export default {
  name: "Home",
  components: {
    NavMenu,
  },
  data() {
    return {
      /*PublishGoods*/
      collapse: false,
      menus: [
        {'name': '首页', 'icon': 'el-icon-star-off', 'index': '/Home'},
        {'name': '斗地主', 'icon': 'el-icon-star-off', 'index': '/Home/Landlords'},
        // {'name': '炸金花', 'icon': 'el-icon-star-off', 'index': '/Home/GoldenFlower'},
        {'name': '炸金花', 'icon': 'el-icon-star-off', 'index': '/GoldenFlower'},
        {'name': '炸金花', 'icon': 'el-icon-star-off', 'index': '/GoldenFlowerTest'},
      ],
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      //        console.log(key, keyPath)
    },
    disposeMenu(menuList) {
      menuList.forEach((item) => {
        let menu = {
          name: item.name,
          index: item.url,
          icon: "el-icon-star-off",
        };
        if (item.children) {
          menu.child = [];
          item.children.forEach((res) => {
            menu.child.push({
              name: res.name,
              icon: "el-icon-star-off",
              index: res.url,
            });
            if (res.children) {
              return this.disposeMenu(res.children);
            }
          });
        }
        this.menus.push(menu);
      });
    },
  },
  computed: {},
  created() {
    // console.log(JSON.parse(sessionStorage.getItem("menuList")), "获取的菜单栏");
    // let menuList = JSON.parse(sessionStorage.getItem("menuList"));
    // this.disposeMenu(menuList);
  },
};
</script>

<style scoped>
.sidebar {
  display: block;
  position: absolute;
  left: 0;
  top: 70px;
  bottom: 0;
  overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
  width: 0;
}

.sidebar > ul {
  height: 100%;
}
</style>
