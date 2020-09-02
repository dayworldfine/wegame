<template>
  <div class="wrapper">
    <v-head></v-head>
    <v-sidebar></v-sidebar>
    <!--    <div class="home-home-content-box" :class="{'home-content-collapse':collapse}">-->
    <div class="home-home-content-box" >
      <!--      <v-tags></v-tags>-->
<!--      <div class="home-content">-->
        <!--        <transition name="move" mode="out-in">-->
        <!--          <keep-alive :include="tagsList">-->
        <router-view></router-view>
        <!--          </keep-alive>-->
        <!--        </transition>-->
        <!--        <el-backtop target=".home-content"></el-backtop>-->
<!--      </div>-->
    </div>
  </div>
</template>

<script>
  import vHead from '@/views/Home/HomeModules/Header.vue';
  import vSidebar from '@/views/Home/HomeModules/Sidebar.vue';
    export default {
        name: "Home",
         components: {
        vHead,
        vSidebar,
        },
      data(){
          return{

        }
      },
      created() {

      },
      watch:{

      },
      methods:{

      }
    }
</script>

<style scoped>
.home-home-content-box{
  position: absolute;
  left: 200px;
  right: 0;
  top: 70px;
  bottom: 0;
  padding-bottom: 30px;
  -webkit-transition: left .3s ease-in-out;
  transition: left .3s ease-in-out;
  /*background: #889aa4;*/
  background-color: rgb(242, 242, 242);
}
</style>
