<template>
  <div class="header">
    <!-- 折叠按钮 -->
    <div class="header-collapse-btn" @click="collapseChage">
      <!--      <i v-if="!collapse" class="el-icon-s-fold"></i>-->
      <!--      <i v-else class="el-icon-s-unfold"></i>-->
      <img
        src="https://wx.ywmapp.com/static/upload/images/1/2019/09/D0UxxAwcw2cFOovFReOZ6vRf5AXeU9.png"
        height="40px"
        width="40px"
      />
    </div>
    <!--    <div class="logo"></div>-->
    <div class="header-right">
      <div class="header-user-con">
        <!-- 全屏显示 -->
        <div class="header-btn-fullscreen" @click="handleFullScreen">
          <el-tooltip effect="dark" :content="fullscreen?`取消全屏`:`全屏`" placement="bottom">
            <i class="el-icon-rank"></i>
          </el-tooltip>
        </div>
        <!-- 消息中心 -->
        <!-- <div class="header-btn-bell">
          <el-tooltip effect="dark" :content="message?`有${message}条未读消息`:`消息中心`" placement="bottom">
            <router-link to="/tabs">
              <i class="el-icon-bell"></i>
            </router-link>
          </el-tooltip>
          <span class="header-btn-bell-badge" v-if="message"></span>
        </div> -->
        <!-- 用户头像 -->
        <div class="header-user-avator">
          <img :src="userhead" />
        </div>
        <!-- 用户名下拉菜单 -->
        <el-dropdown class="header-user-name" trigger="click" @command="handleCommand">
          <span class="header-el-dropdown-link">
            {{username}}
            <i class="el-icon-caret-bottom"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <!-- <a href="www.baidu.com" target="_blank">
              <el-dropdown-item>项目仓库</el-dropdown-item>
            </a> -->
            <el-dropdown-item divided command="loginout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>
<script>
// import bus from '@/utils/bus';
export default {
  data() {
    return {
      collapse: false,
      fullscreen: false,
      name: "header",
      head:
        "https://wx.ywmapp.com/static/upload/images/0/2019/12/20191225630cc2e85e53c9501210ab1a80826f5d.jpeg",
      message: 2,
    };
  },
  computed: {
    username() {
      let username = sessionStorage.getItem("name");
      return username ? username : this.name;
    },
    userhead() {
      let userhead = sessionStorage.getItem("head_img");
      return userhead ? userhead : this.head;
    },
  },
  methods: {
    // 用户名下拉菜单选择事件
    handleCommand(command) {
      if (command == "loginout") {
        localStorage.removeItem("ms_username");
        this.$router.push("/login");
      }
    },
    // 侧边栏折叠
    collapseChage() {},
    // 全屏事件
    handleFullScreen() {
      let element = document.documentElement;
      if (this.fullscreen) {
        if (document.exitFullscreen) {
          document.exitFullscreen();
        } else if (document.webkitCancelFullScreen) {
          document.webkitCancelFullScreen();
        } else if (document.mozCancelFullScreen) {
          document.mozCancelFullScreen();
        } else if (document.msExitFullscreen) {
          document.msExitFullscreen();
        }
      } else {
        if (element.requestFullscreen) {
          element.requestFullscreen();
        } else if (element.webkitRequestFullScreen) {
          element.webkitRequestFullScreen();
        } else if (element.mozRequestFullScreen) {
          element.mozRequestFullScreen();
        } else if (element.msRequestFullscreen) {
          // IE11
          element.msRequestFullscreen();
        }
      }
      this.fullscreen = !this.fullscreen;
    },
  },
  mounted() {
    if (document.body.clientWidth < 1500) {
      this.collapseChage();
    }
  },
};
</script>
<style scoped>
.header {
  position: relative;
  box-sizing: border-box;
  width: 100%;
  height: 70px;
  font-size: 22px;
  /*background-color: #f56c6c;*/
  /*background-color: #a7a7a7;*/
  background-color: rgb(31, 45, 61);
}
.header-collapse-btn {
  float: left;
  padding-top: 15px;
  padding-left: 70px;
  cursor: pointer;
  line-height: 70px;
  background-color: rgb(31, 45, 61);
  color: white;
  width: 200px;
  box-sizing: border-box;
}
.header .logo {
  float: left;
  width: 136px;
  line-height: 70px;
}
.logo {
  background-color: rgb(31, 45, 61);
  color: white;
}
.header-right {
  float: right;
  padding-right: 50px;
  color: white;
}
.header-user-con {
  display: flex;
  height: 70px;
  align-items: center;
}
.header-btn-fullscreen {
  transform: rotate(45deg);
  margin-right: 5px;
  font-size: 24px;
}
.header-btn-bell,
.header-btn-fullscreen {
  position: relative;
  width: 30px;
  height: 30px;
  text-align: center;
  border-radius: 15px;
  cursor: pointer;
}
.header-btn-bell-badge {
  position: absolute;
  right: 0;
  top: -2px;
  width: 8px;
  height: 8px;
  border-radius: 4px;
  background: #f56c6c;
  color: #fff;
}
.header-btn-bell .el-icon-bell {
  color: white;
}
.header-user-name {
  margin-left: 10px;
}
.header-user-avator {
  margin-left: 20px;
}
.header-user-avator img {
  display: block;
  width: 40px;
  height: 40px;
  border-radius: 50%;
}
.header-el-dropdown-link {
  color: white;
  cursor: pointer;
}
.header-el-dropdown-menu__item {
  text-align: center;
}
</style>
