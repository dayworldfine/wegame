<template>
  <div id="app">
<!--    <img src="./assets/logo.png">-->
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  html,
  body,
  #app{
    /* 公共样式 */
    margin: 0;
    padding: 0;
    /*width: 100%;*/
    /*height: 100%;*/
    width: 1920px;
    height: 1080px;
    /*overflow: hidden;*/
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    min-width: 960px;
    min-height: 540px;
  }
  /*#app {*/
  /*  font-family: 'Avenir', Helvetica, Arial, sans-serif;*/
  /*  -webkit-font-smoothing: antialiased;*/
  /*  -moz-osx-font-smoothing: grayscale;*/
  /*  height: 100%;*/
  /*}*/
</style>
