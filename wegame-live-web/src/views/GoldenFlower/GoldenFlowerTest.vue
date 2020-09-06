<template>
  <div class="outer">

    <div class="outer-flex outer-flex-one" >
      <!--每个人物-->
      <div class="people" >
        <!--左边框-->
        <div class="people-left" v-show="showSit[0]==false">
          <div>{{userList[0].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[0].userImg"
            fit="fill"></el-image>
          <div >{{userList[0].integral}}</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="showSit[0]==false">
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
        <div class="people-button">
          <el-button type="primary" class="people-button-style" round  @click="sitDown(1)" v-show="showSit[0]">坐下</el-button>
        </div>
      </div>
      <div class="people" >
        <!--左边框-->
        <div class="people-left" v-show="showSit[1]==false">
          <div>{{userList[1].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[1].userImg"
            fit="fill"></el-image>
          <div >{{userList[1].integral}}</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="showSit[1]==false">
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
        <div class="people-button">
          <el-button type="primary" class="people-button-style" round  @click="sitDown(1)" v-show="showSit[1]" >坐下</el-button>
        </div>
      </div>
    </div>
    <div class="outer-flex outer-flex-two">
      <!--每个人物-->
      <div class="people" >
        <!--左边框-->
        <div class="people-left" v-show="showSit[2]==false">
          <div>{{userList[0].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[0].userImg"
            fit="fill"></el-image>
          <div>{{userList[0].integral}}</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="showSit[2]==false">
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
        <div class="people-button">
          <el-button type="primary" class="people-button-style" round  @click="sitDown(1)" v-show="showSit[2]">坐下</el-button>
        </div>
      </div>
      <div class="people" >
        <!--左边框-->
        <div class="people-left" v-show="showSit[3]==false">
          <div>{{userList[1].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[1].userImg"
            fit="fill"></el-image>
          <div>{{userList[1].integral}}</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="showSit[3]==false">
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
        <div class="people-button">
          <el-button type="primary" class="people-button-style" round  @click="sitDown(1)" v-show="showSit[3]">坐下</el-button>
        </div>
      </div>
    </div>
    <div class="outer-flex outer-flex-three">
      <!--每个人物-->
      <div class="people" >
        <!--左边框-->
        <div class="people-left" v-show="showSit[4]==false">
          <div>{{userList[0].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[0].userImg"
            fit="fill"></el-image>
          <div >{{userList[0].integral}}</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="showSit[4]==false">
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
        <div class="people-button">
          <el-button type="primary" class="people-button-style" round  @click="sitDown(1)" v-show="showSit[4]">坐下</el-button>
        </div>
      </div>
      <div class="people" >
        <!--左边框-->
        <div class="people-left" v-show="showSit[5]==false">
          <div>{{userList[1].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[1].userImg"
            fit="fill"></el-image>
          <div>{{userList[1].integral}}</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="showSit[5]==false">
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
        <div class="people-button">
          <el-button type="primary" class="people-button-style" round  @click="sitDown(1)" v-show="showSit[5]">坐下</el-button>
        </div>
      </div>
    </div>
    <div class="outer-bottom">
        <div class="entire-button one-button">
          <div>
            <el-button type="danger" round class="background-button">X</el-button>
          </div>
          <div class="font-button">
            弃牌
          </div>
        </div>
        <div class="entire-button two-button">
          <div>
            <el-button type="primary" round class="background-button">1</el-button>
          </div>
          <div class="font-button">
            比牌
          </div>
        </div>
        <div class="entire-button three-button">
          <div>
            <el-button type="primary" round class="background-button">看牌</el-button>
          </div>
          <div class="font-button">
            看牌
          </div>
        </div>
        <div class="entire-button four-button">
          <div>
            <el-button type="warning" round class="background-button">+</el-button>
          </div>
          <div class="font-button">
            加注
          </div>
        </div>
        <div class="entire-button five-button">
          <div>
            <el-button type="success" round class="background-button">1</el-button>
          </div>
          <div class="font-button">
            跟注
          </div>
        </div>
        <div class="entire-button six-button">
          <div>
            <el-button type="primary" round class="background-button" @click="setOut">准备</el-button>
          </div>
          <div class="font-button">
            222
          </div>
        </div>
    </div>
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
        // styleOne: [
        //   "display:none",
        //   "display:none",
        //   "display:none",
        //   "display:none",
        //   "display:none",
        //   "display:none"
        // ],
        // styleOne: [true, true, true, true, true, true],
        imgList: [
          {id: "1", url: "/static/card_01.png"},
          {id: "2", url: "/static/card_01.png"},
          {id: "3", url: "/static/card_01.png"},
        ],
      }
    },
    computed:{
      styleOne(){
        let arrList=[];
        this.showSit.forEach((arr)=>{
          arrList.push(!arr);
        });
        console.log("arrList",arrList)
        return arrList;
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
            // this.user
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
          roomId: 1,
          userId:123,
          seatId: 3
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
            roomId: 1,
            userId: 123,
            seatId: number,
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
        userList.forEach(ar=>{
            switch (ar.seatSerial) {
              case 1:
                this.showSit[0] = false;
                this.$forceUpdate()
                break;
              case 2:
                this.showSit[1] = false;
                this.$forceUpdate()
                break;
              default:
                break;
            }
        });
        // for (let i = 0; i < userList.length; i++) {
        //   switch (userList[i].seatSerial) {
        //     case 1:
        //       this.showSit[0] = false;
        //       this.$forceUpdate()
        //       break;
        //     case 2:
        //       this.showSit[1] = false;
        //       this.$forceUpdate()
        //       break;
        //     default:
        //       break;
        //   }
        // }
      },
      //类型1 用户进入房间
      userInToRoom(param) {

      },
      //类型3 用户坐下
      userSitDown(param) {
        let subscript = param.seatSerial-1
        this.showSit[subscript] = false;
        // this.styleOne[subscript] = "display:inline";
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
  .outer-flex-two{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  .outer-flex-three{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
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
    margin-top: 50px;

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
    justify-content: center;
  }
  .people-right-status{
    height: 30px;
    margin-left: 10px;
  }
  .people-button{
    position: absolute;
    margin-left: 130px;
    margin-top: 50px;
  }
  .people-button-style{
    width: 100px;
  }
  .people-board-imageList{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    height: 76px;
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
  .chip-image{
    width: 30px;
    height:30px;
  }
  .outer-bottom{
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    margin-bottom: 20px;
    height: 250px;
    box-sizing: border-box;
    padding-top: 200px;
  }


  .chip-font { /*筹码文字*/
    float: left;
    width: 30px;
    height: 100%;
    margin: 2px 0px 0px 2px;
    border-radius: 25px;
    line-height: 30px;
  }


  .entire-button { /*单个按钮*/
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
