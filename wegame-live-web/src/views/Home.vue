<template>
  <el-container name="Home">
    <el-header>
      <div class="headerDiv">
        <div class="headerDiv-left"></div>
        <div class="headerDiv-left">
          <div class="headerDiv-left-subhead">
            <el-image :src="logoUrl"></el-image>
          </div>
        </div>
        <div class="headerDiv-right">
          <el-dropdown>
            <span class="el-dropdown-link">
              您好，{{ userName }}，欢迎回来
              <i class="el-icon-arrow-down"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <!--<el-dropdown-item>-->
              <!--<router-link to="/index/user">修改密码</router-link>-->
              <!--</el-dropdown-item>-->
              <el-dropdown-item>
                <span @click="outLogin">退出登录</span>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </el-header>
    <el-container>
      <el-aside class="el-aside">
        <el-menu
          default-active="1"
          router
          class="el-menu-vertical-demo"
          background-color="#ffffff"
          unique-opened
          text-color="#747474"
          active-text-color="#015595"
          @select="handleSelect"
        >
          <NavMenu :navMenus="menus"/>
        </el-menu>
      </el-aside>
      <el-main style="height: 100%;background-color: #f5f5f5">
        <div style="width: 100%; height: 100%;">
          <router-view/>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import NavMenu from '@/viewComponents/Home/NavMenu.vue'
  export default {
    name: 'Home',
    components: {
      NavMenu
    },
    data() {
      return {
        userName: 'xxx',
        userRole: '',
        account:'',
        logoUrl:require('../assets/logo.png'),
        subjectId:'',
        subjectName:'',
        subjectLists:[],
        list:[
          {id:1,name:'富阳区统战部'}
        ],
        menus: [
          {'name': '首页', 'icon': 'el-icon-star-off', 'index': '/Home'},
          {'name': '斗地主', 'icon': 'el-icon-star-off', 'index': '/Home/Landlords'},
          // {'name': '炸金花', 'icon': 'el-icon-star-off', 'index': '/Home/GoldenFlower'},
          {'name': '炸金花', 'icon': 'el-icon-star-off', 'index': '/GoldenFlower'},

        ]
      }
    },
    computed: {

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
      outLogin() {
        this.$router.push('/Login');
        sessionStorage.removeItem('userInfo');
        sessionStorage.removeItem('IYunDao-AssessToken');
        this.$notify.success({title: '提示', message: '退出系统成功', duration: 5000});
      }
    }
  }
</script>

<style >
  .el-container {
    width: 100%;
    height: 100%;
  }

  .el-header {
    /*background: url("../assets/header1.png") no-repeat;*/
    background-color: #2183ce;
    background-size: 100% 100%;
    text-align: left;
    /*color: #3465fd;*/
    border-bottom: 1px solid #eee;
  }

  .el-header .headerDiv-left {
    float: left;
  }

  .el-header .headerDiv-left-title {
    font-size: 24px;
  }

  .el-header .headerDiv-left-subhead {
    padding-left: 20px;
    padding-top: 10px;
    color: #dddddd;
    font-size: 18px;
    display: flex;
    justify-content: center;
    align-content: center;
  }

  .el-header .headerDiv-right {
    padding-right: 10px;
    float: right;
    color: #ffffff;
  }

  .el-header .el-dropdown {
    margin-top: 15px;
  }

  .el-header .el-dropdown-link {
    cursor: pointer;
    color: #ffffff;
    font-size: 16px;
  }

  .el-aside {
    width: 240px !important;
    background-color: #ffffff;
    color: #333333;
    margin: 0;
    padding: 0;
    border-right: 1px solid #eee;
  }

  .el-aside .el-menu {
    border-right: none;
  }

  .el-main {
    height: 100%;
  }
  .el-dropdown{
    margin-right: 10px;
  }
</style>
