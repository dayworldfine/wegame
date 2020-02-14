import Vue from 'vue'
import Router from 'vue-router'
//分割线
import Login from "@/view/Login";                           //登录
import Home from "@/view/Home";                             //主页
import Landlords from "@/view/Landlords";                   //斗地主
import GoldenFlower from "@/view/GoldenFlower";             //炸金花


Vue.use(Router)

export default new Router({
  routes: [
    {path: '/', name: 'Login', component: Login},
    {path: '/Login', name: 'Login', component: Login},
    {path: '/Home', name: 'Home', component: Home, children:[
        {path: 'Landlords', name: 'Landlords', component: Landlords},                         // 斗地主
        // {path: 'GoldenFlower', name: 'GoldenFlower', component: GoldenFlower}                // 炸金花
      ]},
    {path: '/GoldenFlower', name: 'GoldenFlower', component: GoldenFlower}                // 炸金花
  ]
})
