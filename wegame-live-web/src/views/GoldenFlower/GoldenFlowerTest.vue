<template>
  <div class="outer">

    <div class="outer-flex outer-flex-one">
      <!--每个人物-->
      <div class="people" >
        <!--左边框-->
        <div class="people-left">
          <div>{{userList[0].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[0].userImg"
            fit="fill"></el-image>
          <div class="left-user left-three">{{userList[0].integral}}</div>
        </div>
        <!--右边框-->
        <div class="people-right">
          <div class="people-right-status">{{userList[0].status}}</div>
          <div class="people-board-imageList">
            <template v-for="item in imgList">
              <el-image
                class="people-board-image"
                :src="item.url"
                fit="fill"></el-image>
            </template>
          </div>
          <div class="people-right-bottom">
            <div class="chip-image">
              <el-image src="/static/ante_coin.png" fit="fill"></el-image>
            </div>
            <div class="chip-font">
              {{userList[0].payIntegral}}
            </div>
          </div>
        </div>
        <!--坐下按钮-->
        <div class="people-right-button">
          <el-button type="primary" class="people-right-button-style" round  @click="sitDown(1)" v-show="showSit[0]">坐下</el-button>
        </div>
      </div>
      <div class="people" >
        <!--左边框-->
        <div class="people-left">
          <div>{{userList[0].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[0].userImg"
            fit="fill"></el-image>
          <div class="left-user left-three">{{userList[0].integral}}</div>
        </div>
        <!--右边框-->
        <div class="people-right">
          <div class="people-right-status">{{userList[0].status}}</div>
          <div class="people-board-imageList">
            <template v-for="item in imgList">
              <el-image
                class="people-board-image"
                :src="item.url"
                fit="fill"></el-image>
            </template>
          </div>
          <div class="people-right-bottom">
            <div class="chip-image">
              <el-image src="/static/ante_coin.png" fit="fill"></el-image>
            </div>
            <div class="chip-font">
              {{userList[0].payIntegral}}
            </div>
          </div>
        </div>
        <!--坐下按钮-->
        <div class="people-right-button">
          <el-button type="primary" class="people-right-button-style" round  @click="sitDown(1)" >坐下</el-button>
        </div>
      </div>
    </div>
    <div>11</div>
    <div>11</div>
    <div>11</div>
  </div>

</template>

<script>
  import socket from "@/utils/socket";
  import GoldenFlowerService from "@/service/GoldenFlowerService";
  import Vue from "vue";

  export default {
    name: "GoldenFlower",
    data() {
      return {
        userList:[
          {
            userNickName: '111',
            userImg: 'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg',
            status: 11,
            integral: 2,
            userCode: 12,
            board: [0, 0, 0],
            payIntegral: 1
          },
          {
            userNickName: '111',
            userImg: 'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg',
            status: 11,
            integral: 2,
            userCode: 12,
            board: [0, 0, 0],
            payIntegral: 1
          },
          {userNickName:'',userImg:'',status: 0,integral:2,userCode:0,board:[],payIntegral: 1},
          {userNickName:'',userImg:'',status: 0,integral:2,userCode:0,board:[],payIntegral: 1},
          {userNickName:'',userImg:'',status: 0,integral:2,userCode:0,board:[],payIntegral: 1},
          {userNickName:'',userImg:'',status: 0,integral:2,userCode:0,board:[],payIntegral: 1}
          ],
        //坐下按钮显示
        showSit: [true, true, true, true, true, true],
        //用户框
        styleOne: [
          "display:none",
          "display:none",
          "display:none",
          "display:none",
          "display:none",
          "display:none"
        ],
        imgList: [
          {id: "1", url: "/static/card_01.png"},
          {id: "2", url: "/static/card_01.png"},
          {id: "3", url: "/static/card_01.png"},
        ],
      }
    },
    created() {
      socket.disconnect()
      socket.connect('one')
      Vue.prototype.$socket.$off("socket")

      Vue.prototype.$socket.$on('socket', (res) => {
        console.log("监听到的socket消息", res)

        switch (res.type) {
          case 0:
            this.room(res);
            break;
          case 1:
            this.userInToRoom(res);
            break;
          case 2:
            break;
          case 3:
            this.userSitDown(res);
            break;
          case 4:
            this.user
            break;
          case 5:
            this.userSetOut(res);
            break;
          default:
            break;
        }
      })

    },
    methods: {
      /*准备*/
      setOut(){
        GoldenFlowerService.setOut({
          type:5,
          roomSerial: 1,
          userCode:123,
          seatSerial: 3
        }).then((res)=>{
          if(res.code===200){

          }else{
            this.$message.error(res.message)
          }
        })
      },
      //点击坐下的方法
      sitDown(number) {
        GoldenFlowerService.sitDown(
          {
            type: 3,
            roomSerial: 1,
            userCode: 123,
            seatSerial: number,
            userImg: '11',
            userNickName: 'wang',
            integral: 11
          }
        ).then((res) => {
          console.log("res", res)
          if(res.code===200){

          }else{
            this.$message.error(res.message)
          }
        })
      },
      //类型0 系统消息
      room(param) {
        let userList = param.userList;
        for (let i = 0; i < userList.length; i++) {
          switch (userList[i].seatSerial) {
            case 1:
              this.showSit[0] = false;
              this.styleOne[0] = "display:inline";
              this.$forceUpdate()
              break;
            case 2:
              this.showSit[1] = false;
              this.styleOne[1] = "display:inline"
              this.$forceUpdate()
              break;
            default:
              break;
          }
        }
      },
      //类型1 用户进入房间
      userInToRoom(param) {

      },
      //类型3 用户坐下
      userSitDown(param) {
        let subscript = param.seatSerial-1
        this.showSit[subscript] = false;
        this.styleOne[subscript] = "display:inline";
        this.userList[subscript]={
          userNickName: param.userNickName,
          userImg: param.userImg,
          status: 0,
          integral: param.integral,
          userCode: param.userCode,
          board: [0, 0, 0],
          payIntegral: 0},
        this.$forceUpdate()
      },
      //类型5 用户准备
      userSetOut(param){
        this.userList[param.seatSerial-1].status=2
      }
    },

    computed: {

      // showSitSix(){
      //   if (this.styleOne[5]=="display:none"){return false}else{return true}
      // }
    },


  }
</script>

<style scoped>


  .outer { /*背景*/
    width: 100%;
    height: 100%;
    margin: 0 auto;
    background-image: url('/static/zjh-brczm.jpg');
    background-repeat: no-repeat;
    background-size: 100% 100%;
    -moz-background-size: 100% 100%;
    display: flex;
    flex-direction: column;
    box-sizing: border-box;
  }
  .outer-flex{
    height: 250px;
    width: 100%;
    box-sizing: border-box;
  }
  .outer-flex-one{
    display: flex;
    justify-content: space-around;
    flex-direction: row;
  }

  .people { /*每个人物*/
    width: 350px;
    height: 150px;
    z-index: 99;
    border: 1px solid #7e9579;
    border-radius: 25px;
    /*justify-content: space-between;*/
    box-sizing: border-box;
    display: flex;
    flex-direction: row;

  }
  .people-userImg{
    width: 105px;
    height: 76px;
    margin: auto;
  }
  .people-left{
    width: 116px;
    height: 100%;
    border-radius: 20px;
    border: 1px solid #7e9579;
    display: flex;
    flex-direction: column;
    text-align: center;
    box-sizing: border-box;
  }
  .people-right{
    width: 234px;
    height: 100%;
    border-radius: 20px;
    border: 1px solid #7e9579;
    display: flex;
    flex-direction: column;
    box-sizing: border-box;
  }
  .people-right-status{
    height: 30px;
    margin-left: 10px;
  }
  .people-right-button{
    position: absolute;
    top: 50px;
    left: 350px;
  }
  .people-right-button-style{
    width: 100px;
  }
  .people-board-imageList{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    height: 76px;
    margin-top: 10px;

  }
  .people-board-image{
    width: 69px;
    height: 100%;
  }
  .people-right-bottom{
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    margin-left: 10px;
  }

  .one {
    left: 300px;
    top: 10px;
  }

  .two {
    right: 300px;
    top: 10px;
  }

  .three {
    right: 100px;
    top: 200px;
  }

  .four {
    bottom: 200px;
    right: 300px;
  }

  .five {
    bottom: 200px;
    left: 300px;
  }

  .six {
    left: 100px;
    top: 200px;
  }

  .left-div { /*人物左边框*/
    padding: 10px 5px 10px 5px;
    text-align: center;
    line-height: 25px;
    border-radius: 20px;
    border: 1px solid #7e9579;
  }

  .left-one {
    height: 27px;
  }

  .left-two {
    height: 76px;
  }

  .left-three {
    height: 27px;
  }

  .head-image { /*头像样式*/
    width: 100%;
    height: 100%;
    overflow: hidden;
  }

  .board-image { /*牌的样式*/
    float: left;
    width: 69px;
    height: 100%;
    margin: 0px 2px 0px 2px;
  }

  .chip-image { /*筹码图片*/
    float: left;
    width: 30px;
    height: 100%;
    margin: 2px 0px 0px 2px;
    border-radius: 25px;
  }

  .chip-font { /*筹码文字*/
    float: left;
    width: 30px;
    height: 100%;
    margin: 2px 0px 0px 2px;
    border-radius: 25px;
    line-height: 30px;
  }

  .sit-down { /*坐下边框*/
    width: 350px;
    height: 150px;
    position: absolute;
    left: 0px;
    top: 0px;
    z-index: 99;
    border: 1px solid #7e9579;
    border-radius: 25px;
  }

  .sit-button { /*坐下按钮*/
    width: 100px;
    position: absolute;
    left: 125px;
    top: 50px;
  }

  .right-div { /*人物右边框*/
    padding: 5px 5px 10px 5px;
    text-align: center;
    line-height: 25px;
    border-radius: 20px;
    /*border: 1px solid red;*/
  }

  .right-one {
    height: 27px;
    width: 68px;
    border-radius: 20px;
    border: 1px solid #7e9579;
    margin: 0px 0px 5px 0px;
  }

  .right-two {
    height: 76px;
  }

  .right-three {
    height: 27px;
  }

  .all-button { /*最下排按钮*/
    position: absolute;
    height: 100px;
    width: 100%;
    bottom: 10px;
  }

  .entire-button { /*单个按钮*/
    float: left;
    width: 150px;
    height: 100px;
    text-align: center;
    /*margin-left: 50px;*/
  }

  .font-button { /*按钮整个下的文字*/
    margin-top: 5px;
    font-size: 15px;
    color: #dddddd;
  }

  .background-button { /*按钮触发事件*/
    height: 60px;
    width: 150px;
    border-radius: 150px;
    font-size: 20px;
  }

  .one-button { /*第一个按钮*/
    margin-left: 100px;
  }

  .two-button { /*第二个按钮*/
    margin-left: 300px;
  }

  .three-button { /*第三个按钮*/
    margin-left: 20px;
  }

  .four-button { /*第四个按钮*/
    margin-left: 20px;
  }

  .five-button { /*第五个按钮*/
    margin-left: 20px;
  }

  .six-button { /*第六个按钮*/
    margin-left: 20px;
  }

</style>
