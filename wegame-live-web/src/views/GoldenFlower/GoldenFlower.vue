<template>
  <div class="outer">
    <div class="people one">
      <!--第一-->
      <div class="sit-down">
        <div>
          <el-button type="primary" round class="sit-button" @click="sitDown(1)" v-show="showSit[0]">坐下</el-button>
        </div>
      </div>
      <el-row type="flex" :style="styleOne[0]">
        <el-col :span="8">
          <div class="grid-content bg-purple left-div">
            <div class="left-user left-one">{{userList[0].userNickName}}</div>
            <div class="left-user left-two">
              <el-image
                class="head-image"
                :src="userList[0].userImg"
                fit="fill"></el-image>
            </div>
            <div class="left-user left-three">{{userList[0].integral}}</div>
          </div>
        </el-col>
        <el-col :span="16">
          <div class="grid-content bg-purple-light right-div">
            <div class="right-user right-one">{{userList[0].status}}</div>
            <div class="right-user right-two">
              <template v-for="item in imgList">
                <el-image
                  class="board-image"
                  :src="item.url"
                  fit="fill"></el-image>
              </template>
            </div>
            <div class="right-user right-three">
              <div class="chip-image">
                <el-image src="/static/ante_coin.png" fit="fill"></el-image>
              </div>
              <div class="chip-font">
                {{userList[0].payIntegral}}
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <div class="people two">
      <!--第二张-->
      <div class="sit-down">
        <div>
          <el-button type="primary" round class="sit-button" @click="sitDown(2)" v-show="showSit[1]">坐下</el-button>
        </div>
      </div>
      <el-row type="flex" :style="styleOne[1]">
        <el-col :span="8">
          <div class="grid-content bg-purple left-div">
            <div class="left-user left-one">{{userList[1].userNickName}}</div>
            <div class="left-user left-two">
              <el-image
                class="head-image"
                :src="userList[1].userImg"
                fit="fill"></el-image>
            </div>
            <div class="left-user left-three">{{userList[1].integral}}</div>
          </div>
        </el-col>
        <el-col :span="16">
          <div class="grid-content bg-purple-light right-div">
            <div class="right-user right-one">{{userList[1].status}}</div>
            <div class="right-user right-two">
              <template v-for="item in imgList">
                <el-image
                  class="board-image"
                  :src="item.url"
                  fit="fill"></el-image>
              </template>
            </div>
            <div class="right-user right-three">
              <div class="chip-image">
                <el-image src="/static/ante_coin.png" fit="fill"></el-image>
              </div>
              <div class="chip-font">
                {{userList[1].payIntegral}}
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <div class="people three">
      <!--第三-->
      <div class="sit-down">
        <div>
          <el-button type="primary" round class="sit-button" @click="sitDown(3)" v-show="showSit[2]">坐下</el-button>
        </div>
      </div>
      <el-row type="flex" :style="styleOne[2]">
        <el-col :span="8">
          <div class="grid-content bg-purple left-div">
            <div class="left-user left-one">{{userList[2].userNickName}}</div>
            <div class="left-user left-two">
              <el-image
                class="head-image"
                :src="userList[2].userImg"
                fit="fill"></el-image>
            </div>
            <div class="left-user left-three">{{userList[2].integral}}</div>
          </div>
        </el-col>
        <el-col :span="16">
          <div class="grid-content bg-purple-light right-div">
            <div class="right-user right-one">{{userList[2].status}}</div>
            <div class="right-user right-two">
              <template v-for="item in imgList">
                <el-image
                  class="board-image"
                  :src="item.url"
                  fit="fill"></el-image>
              </template>
            </div>
            <div class="right-user right-three">
              <div class="chip-image">
                <el-image src="/static/ante_coin.png" fit="fill"></el-image>
              </div>
              <div class="chip-font">
                {{userList[2].payIntegral}}
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <div class="people four">
      <!--第四-->
      <div class="sit-down">
        <div>
          <el-button type="primary" round class="sit-button" @click="sitDown(4)" v-show="showSit[3]">坐下</el-button>
        </div>
      </div>
      <el-row type="flex" :style="styleOne[3]">
        <el-col :span="8">
          <div class="grid-content bg-purple left-div">
            <div class="left-user left-one">{{userList[3].userNickName}}</div>
            <div class="left-user left-two">
              <el-image
                class="head-image"
                :src="userList[3].userImg"
                fit="fill"></el-image>
            </div>
            <div class="left-user left-three">{{userList[3].integral}}</div>
          </div>
        </el-col>
        <el-col :span="16">
          <div class="grid-content bg-purple-light right-div">
            <div class="right-user right-one">{{userList[3].status}}</div>
            <div class="right-user right-two">
              <template v-for="item in imgList">
                <el-image
                  class="board-image"
                  :src="item.url"
                  fit="fill"></el-image>
              </template>
            </div>
            <div class="right-user right-three">
              <div class="chip-image">
                <el-image src="/static/ante_coin.png" fit="fill"></el-image>
              </div>
              <div class="chip-font">
                {{userList[3].payIntegral}}
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <div class="people five">
      <!--第五-->
      <div class="sit-down">
        <div>
          <el-button type="primary" round class="sit-button" @click="sitDown(5)" v-show="showSit[4]">坐下</el-button>
        </div>
      </div>
      <el-row type="flex" :style="styleOne[4]">
        <el-col :span="8">
          <div class="grid-content bg-purple left-div">
            <div class="left-user left-one">{{userList[4].userNickName}}</div>
            <div class="left-user left-two">
              <el-image
                class="head-image"
                :src="userList[4].userImg"
                fit="fill"></el-image>
            </div>
            <div class="left-user left-three">{{userList[4].integral}}</div>
          </div>
        </el-col>
        <el-col :span="16">
          <div class="grid-content bg-purple-light right-div">
            <div class="right-user right-one">{{userList[4].status}}</div>
            <div class="right-user right-two">
              <template v-for="item in imgList">
                <el-image
                  class="board-image"
                  :src="item.url"
                  fit="fill"></el-image>
              </template>
            </div>
            <div class="right-user right-three">
              <div class="chip-image">
                <el-image src="/static/ante_coin.png" fit="fill"></el-image>
              </div>
              <div class="chip-font">
                {{userList[4].payIntegral}}
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <div class="people six">
      <!--第六位-->
      <div class="sit-down">
        <div>
          <el-button type="primary" round class="sit-button" @click="sitDown(6)" v-show="showSit[5]">坐下</el-button>
        </div>
      </div>
      <el-row type="flex" :style="styleOne[5]">
        <el-col :span="8">
          <div class="grid-content bg-purple left-div">
            <div class="left-user left-one">{{userList[5].userNickName}}</div>
            <div class="left-user left-two">
              <el-image
                class="head-image"
                :src="userList[5].userImg"
                fit="fill"></el-image>
            </div>
            <div class="left-user left-three">{{userList[5].integral}}</div>
          </div>
        </el-col>
        <el-col :span="16">
          <div class="grid-content bg-purple-light right-div">
            <div class="right-user right-one">{{userList[5].status}}</div>
            <div class="right-user right-two">
              <template v-for="item in imgList">
                <el-image
                  class="board-image"
                  :src="item.url"
                  fit="fill"></el-image>
              </template>
            </div>
            <div class="right-user right-three">
              <div class="chip-image">
                <el-image src="/static/ante_coin.png" fit="fill"></el-image>
              </div>
              <div class="chip-font">
                {{userList[5].payIntegral}}
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <!--下排按钮-->
    <div class="all-button">
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
  .el-row--flex {
    margin: 0 auto;
    height: 100%;
    width: 100%;
  }

  .outer { /*背景*/
    width: 100%;
    height: 100%;
    margin: 0 auto;
    background-image: url('/static/zjh-brczm.jpg');
    background-repeat: no-repeat;
    background-size: 100% 100%;
    -moz-background-size: 100% 100%;
  }

  .people { /*每个人物*/
    /*border: 1px solid red;*/
    width: 350px;
    height: 150px;
    position: absolute;
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
