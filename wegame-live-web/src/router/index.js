import Vue from 'vue'
import Router from 'vue-router'
//分割线
import Login from "@/views/Login/Login";                           //登录
import Home from "@/views/Home/Home";                        //主页
import Landlords from "@/views/Landlords/Landlords";                   //斗地主
import GoldenFlower from "@/views/GoldenFlower/GoldenFlower";             //炸金花

Vue.use(Router)

const router =  new Router({
  routes: [
    {path: '/', name: '/', component: Login},
    {path: '/Login', name: 'Login', component: Login},
    {path: '/Home', name: 'Home', component: Home, children:[
        {path: 'Landlords', name: 'Landlords', component: Landlords},                         // 斗地主
        // {path: 'GoldenFlower', name: 'GoldenFlower', component: GoldenFlower}                // 炸金花
      ]},
    {path: '/GoldenFlower', name: 'GoldenFlower', component: GoldenFlower},                  // 炸金花
  ],
  mode: 'history' //去除路径后面的#

})

let flag;
router.beforeEach((to, from, next) => {
  if (to.path === '/Login') {
    next()
  } else {
    const token = sessionStorage.getItem('token')
    if (!token) {
      // Message.warning('请先登录')
      router.push({
        name: 'Login'
      })
      return
    }
    next()
  }
})
export default router
