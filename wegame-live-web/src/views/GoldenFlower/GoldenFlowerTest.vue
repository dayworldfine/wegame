<template>
  <div class="outer">

    <div class="outer-flex outer-flex-one" >
      <!--每个人物-->
      <div class="people">
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[0]==1||seatStatusList[0]==2||seatStatusList[0]==3">
          <div class="people-left-name">{{userList[0].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[0].userImg"
            fit="fill"></el-image>
          <div >{{userList[0].integral}}</div>
          <div class="people-setOut" v-show="seatStatusList[0]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[0]==3">
          <div class="people-right-status">{{userList[0].status}}</div>
          <div class="people-board-imageList">
            <template v-for="item in userList[0].board">
              <el-image
                class="people-board-image"
                :src="'/static/board/card_'+item.color+item.number+'.png'"
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
          <el-button type="primary" class="people-button-style" round  @click="sitDown(0)" v-show="seatStatusList[0]==0">坐下</el-button>
        </div>
      </div>
      <div class="people" >
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[1]==1||seatStatusList[1]==2||seatStatusList[1]==3">
          <div class="people-left-name">{{userList[1].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[1].userImg"
            fit="fill"></el-image>
          <div >{{userList[1].integral}}</div>
          <div class="people-setOut" v-show="seatStatusList[1]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[1]==3">
          <div class="people-right-status">{{userList[1].status}}</div>
          <div class="people-board-imageList">
            <template v-for="item in userList[1].board">
              <el-image
                class="people-board-image"
                :src="'/static/board/card_'+item.color+item.number+'.png'"
                fit="fill"></el-image>
            </template>
          </div>
          <div class="people-right-bottom">
            <div class="chip-image">
              <el-image src="/static/ante_coin.png" fit="fill"></el-image>
            </div>
            <div class="chip-font">
              {{userList[1].payIntegral}}
            </div>
          </div>
        </div>
        <!--坐下按钮-->
        <div class="people-button">
          <el-button type="primary" class="people-button-style" round  @click="sitDown(1)" v-show="seatStatusList[1]==0" >坐下</el-button>
        </div>
      </div>
    </div>
    <div class="outer-flex outer-flex-two">
      <!--每个人物-->
      <div class="people" >
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[5]==1||seatStatusList[5]==2||seatStatusList[5]==3">
          <div class="people-left-name">{{userList[5].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[5].userImg"
            fit="fill"></el-image>
          <div>{{userList[5].integral}}</div>
          <div class="people-setOut" v-show="seatStatusList[5]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[5]==3">
          <div class="people-right-status">{{userList[5].status}}</div>
          <div class="people-board-imageList">
            <template v-for="item in userList[5].board">
              <el-image
                class="people-board-image"
                :src="'/static/board/card_'+item.color+item.number+'.png'"
                fit="fill"></el-image>
            </template>
          </div>
          <div class="people-right-bottom">
            <div class="chip-image">
              <el-image src="/static/ante_coin.png" fit="fill"></el-image>
            </div>
            <div class="chip-font">
              {{userList[5].payIntegral}}
            </div>
          </div>
        </div>
        <!--坐下按钮-->
        <div class="people-button">
          <el-button type="primary" class="people-button-style" round  @click="sitDown(5)" v-show="seatStatusList[5]==0">坐下</el-button>
        </div>
      </div>
      <div class="people" >
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[2]==1||seatStatusList[2]==2||seatStatusList[2]==3">
          <div class="people-left-name">{{userList[2].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[2].userImg"
            fit="fill"></el-image>
          <div>{{userList[2].integral}}</div>
          <div class="people-setOut" v-show="seatStatusList[2]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[2]==3">
          <div class="people-right-status">{{userList[2].status}}</div>
          <div class="people-board-imageList">
            <template v-for="item in userList[2].board">
              <el-image
                class="people-board-image"
                :src="'/static/board/card_'+item.color+item.number+'.png'"
                fit="fill"></el-image>
            </template>
          </div>
          <div class="people-right-bottom">
            <div class="chip-image">
              <el-image src="/static/ante_coin.png" fit="fill"></el-image>
            </div>
            <div class="chip-font">
              {{userList[2].payIntegral}}
            </div>
          </div>
        </div>
        <!--坐下按钮-->
        <div class="people-button">
          <el-button type="primary" class="people-button-style" round  @click="sitDown(2)" v-show="seatStatusList[2]==0">坐下</el-button>
        </div>
      </div>
    </div>
    <div class="outer-flex outer-flex-three">
      <!--每个人物-->
      <div class="people" >
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[4]==1||seatStatusList[4]==2||seatStatusList[4]==3">
          <div class="people-left-name">{{userList[4].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[4].userImg"
            fit="fill"></el-image>
          <div >{{userList[4].integral}}</div>
          <div class="people-setOut" v-show="seatStatusList[4]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[4]==3">
          <div class="people-right-status">{{userList[4].status}}</div>
          <div class="people-board-imageList">
            <template v-for="item in userList[4].board">
              <el-image
                class="people-board-image"
                :src="'/static/board/card_'+item.color+item.number+'.png'"
                fit="fill"></el-image>
            </template>
          </div>
          <div class="people-right-bottom">
            <div class="chip-image">
              <el-image src="/static/ante_coin.png" fit="fill"></el-image>
            </div>
            <div class="chip-font">
              {{userList[4].payIntegral}}
            </div>
          </div>
        </div>
        <!--坐下按钮-->
        <div class="people-button">
          <el-button type="primary" class="people-button-style" round  @click="sitDown(4)" v-show="seatStatusList[4]==0">坐下</el-button>
        </div>
      </div>
      <div class="people" >
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[3]==1||seatStatusList[3]==2||seatStatusList[3]==3">
          <div class="people-left-name">{{userList[3].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[3].userImg"
            fit="fill"></el-image>
          <div>{{userList[3].integral}}</div>
          <<div class="people-setOut" v-show="seatStatusList[3]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[3]==3">
          <div class="people-right-status">{{userList[3].status}}</div>
          <div class="people-board-imageList">
            <template v-for="item in userList[3].board">
              <el-image
                class="people-board-image"
                :src="'/static/board/card_'+item.color+item.number+'.png'"
                fit="fill"></el-image>
            </template>
          </div>
          <div class="people-right-bottom">
            <div class="chip-image">
              <el-image src="/static/ante_coin.png" fit="fill"></el-image>
            </div>
            <div class="chip-font">
              {{userList[3].payIntegral}}
            </div>
          </div>
        </div>
        <!--坐下按钮-->
        <div class="people-button">
          <el-button type="primary" class="people-button-style" round  @click="sitDown(3)" v-show="seatStatusList[3]==0">坐下</el-button>
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
            <el-button type="primary" round class="background-button" @click="setOut()">准备</el-button>
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
            userNickName: '',
            userImg: 'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg',
            status: 11,
            integral: 2,
            userId: 12,
            board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}],
            payIntegral: 1,

          },
          {userNickName:'',userImg:'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg',status: 0,integral:2,userId:0,board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}],payIntegral: 1},
          {userNickName:'',userImg:'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg',status: 0,integral:2,userId:0,board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}],payIntegral: 1},
          {userNickName:'',userImg:'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg',status: 0,integral:2,userId:0,board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}],payIntegral: 1},
          {userNickName:'',userImg:'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg',status: 0,integral:2,userId:0,board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}],payIntegral: 1},
          {userNickName:'',userImg:'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg',status: 0,integral:2,userId:0,board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}],payIntegral: 1},
          ],
        //坐下按钮显示
        seatStatusList: [0, 0, 0, 0, 0, 0], // 0 空闲 1坐下未准备 2 坐下已准备 3 正在游戏中

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
          case 11:
            this.gameStart(res);
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
            switch ((ar.seatId-1)%6) {
              case 0:
                this.seatStatusList[0] = ar.seatStatus;
                this.$forceUpdate();
                break;
              case 1:
                this.seatStatusList[1] = ar.seatStatus;
                this.$forceUpdate();
                break;
              case 2:
                this.seatStatusList[2] = ar.seatStatus;
                this.$forceUpdate();
                break;
              case 3:
                this.seatStatusList[3] = ar.seatStatus;
                this.$forceUpdate();
                break;
              case 4:
                this.seatStatusList[4] = ar.seatStatus;
                this.$forceUpdate();
                break;
              case 5:
                this.seatStatusList[5] = ar.seatStatus;
                this.$forceUpdate();
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
        let subscript = (param.seatId-1)%6;
        this.seatStatusList[subscript] = 1;
        // this.styleOne[subscript] = "display:inline";
        this.userList[subscript]={
          userNickName: param.userNickName,
          userImg: param.userImg,
          status: 0,
          integral: param.integral,
          userId: param.userId,
          board: [0, 0, 0],
          payIntegral: 0},
        this.$forceUpdate()
      },
      //类型5 用户准备
      userSetOut(param){
        this.seatStatusList[(param.seatId-1)%6]=2;
        this.$forceUpdate()
      },
      //游戏开始
      //1.关闭座位
      //2.改变有的用户的牌
      gameStart(param){
        let data =  param.userList.roomChildMsgVoList;
        //先隐藏所有座位，然后把有玩家的座位显示出来
        this.seatStatusList=[99,99,99,99,99,99];
        data.forEach(a=>{
          let seatSerial = (a.seatId-1)%6;
          this.seatStatusList[seatSerial]=3;
          this.userList[seatSerial].userNickName = a.nickName;
          this.userList[seatSerial].userImg = a.headPortrait;
          this.userList[seatSerial].status = a.gameStatus;
          this.userList[seatSerial].userId = a.userId;
          this.userList[seatSerial].payIntegral = data.integralFundus;
          this.userList[seatSerial].board[0].color=a.firstBoardColor;
          this.userList[seatSerial].board[0].number=a.firstBoardNumber;
          this.userList[seatSerial].board[1].color=a.secondBoardColor;
          this.userList[seatSerial].board[1].number=a.secondBoardNumber;
          this.userList[seatSerial].board[2].color=a.thirdlyBoardColor;
          this.userList[seatSerial].board[2].number=a.thirdlyBoardNumber;
        });
      }
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
    width: 116px;
    height: 76px;
    /*margin: auto;*/
  }
  .people-setOut{
    border: 5px solid #e5e908;
    position: absolute;
    width: 116px;
    height: 76px;
    margin-top: 36px;
    text-align: center;
    font-size: 30px;
    color: #e5e908;
    line-height: 67px;
    background-color: transparent;
    box-shadow: 0 0 50px #1d4eab inset;
    box-sizing: border-box;
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
  .people-left-name{
    height: 35px;
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
