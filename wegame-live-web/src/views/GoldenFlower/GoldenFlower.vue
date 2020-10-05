<template>
  <div class="outer">

    <div class="outer-flex outer-flex-one" >
      <!--每个人物-->
      <div class="people" @click="comPareUser(0)" :class="(userList[0].isUser==1 && userList[0].gameStatus==3 && userList[0].userId!= userMsg.userId && userMsg.compare==1)?'people-boardCompare':'' ">
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[0]==1||seatStatusList[0]==2||seatStatusList[0]==3">
          <div class="people-left-name">{{userList[0].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[0].headPortrait"
            fit="fill"></el-image>
          <div >{{userList[0].integral}}</div>
          <div class="people-setOut" v-show="seatStatusList[0]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[0]==3">
          <div class="people-right-status">{{textOne}}</div>
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
          <el-button type="primary" class="people-button-style" round  @click="sitDown(1)" v-show="seatStatusList[0]==0">坐下</el-button>
        </div>
      </div>
      <div class="people" @click="comPareUser(1)" :class="(userList[1].isUser==1 && userList[1].gameStatus==3 && userList[1].userId!= userMsg.userId && userMsg.compare==1)?'people-boardCompare':'' ">
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[1]==1||seatStatusList[1]==2||seatStatusList[1]==3">
          <div class="people-left-name">{{userList[1].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[1].headPortrait"
            fit="fill"></el-image>
          <div >{{userList[1].integral}}</div>
          <div class="people-setOut" v-show="seatStatusList[1]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[1]==3">
          <div class="people-right-status">{{textTwo}}</div>
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
          <el-button type="primary" class="people-button-style" round  @click="sitDown(2)" v-show="seatStatusList[1]==0" >坐下</el-button>
        </div>
      </div>
    </div>
    <div class="outer-flex outer-flex-two">
      <!--每个人物-->
      <div class="people" @click="comPareUser(5)" :class="(userList[5].isUser==1 && userList[5].gameStatus==3 && userList[5].userId!= userMsg.userId && userMsg.compare==1)?'people-boardCompare':'' ">
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[5]==1||seatStatusList[5]==2||seatStatusList[5]==3">
          <div class="people-left-name">{{userList[5].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[5].headPortrait"
            fit="fill"></el-image>
          <div>{{userList[5].integral}}</div>
          <div class="people-setOut" v-show="seatStatusList[5]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[5]==3">
          <div class="people-right-status">{{textSix}}</div>
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
          <el-button type="primary" class="people-button-style" round  @click="sitDown(6)" v-show="seatStatusList[5]==0">坐下</el-button>
        </div>
      </div>
      <div class="people" @click="comPareUser(2)" :class="(userList[2].isUser==1 && userList[2].gameStatus==3 && userList[2].userId!= userMsg.userId && userMsg.compare==1)?'people-boardCompare':'' ">
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[2]==1||seatStatusList[2]==2||seatStatusList[2]==3">
          <div class="people-left-name">{{userList[2].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[2].headPortrait"
            fit="fill"></el-image>
          <div>{{userList[2].integral}}</div>
          <div class="people-setOut" v-show="seatStatusList[2]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[2]==3">
          <div class="people-right-status">{{textThree}}</div>
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
          <el-button type="primary" class="people-button-style" round  @click="sitDown(3)" v-show="seatStatusList[2]==0">坐下</el-button>
        </div>
      </div>
    </div>
    <div class="outer-flex outer-flex-three">
      <!--每个人物-->
      <div class="people" @click="comPareUser(4)" :class="(userList[4].isUser==1 && userList[4].gameStatus==3 && userList[4].userId!= userMsg.userId && userMsg.compare==1)?'people-boardCompare':'' ">
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[4]==1||seatStatusList[4]==2||seatStatusList[4]==3">
          <div class="people-left-name">{{userList[4].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[4].headPortrait"
            fit="fill"></el-image>
          <div >{{userList[4].integral}}</div>
          <div class="people-setOut" v-show="seatStatusList[4]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[4]==3">
          <div class="people-right-status">{{textFive}}</div>
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
          <el-button type="primary" class="people-button-style" round  @click="sitDown(5)" v-show="seatStatusList[4]==0">坐下</el-button>
        </div>
      </div>
      <div class="people" @click="comPareUser(3)" :class="(userList[3].isUser==1 && userList[3].gameStatus==3 && userList[3].userId!= userMsg.userId && userMsg.compare==1)?'people-boardCompare':'' ">
        <!--左边框-->
        <div class="people-left" v-show="seatStatusList[3]==1||seatStatusList[3]==2||seatStatusList[3]==3">
          <div class="people-left-name">{{userList[3].userNickName}}</div>
          <el-image
            class="people-userImg"
            :src="userList[3].headPortrait"
            fit="fill"></el-image>
          <div>{{userList[3].integral}}</div>
          <<div class="people-setOut" v-show="seatStatusList[3]==2">准备</div>
        </div>
        <!--右边框-->
        <div class="people-right" v-show="seatStatusList[3]==3">
          <div class="people-right-status">{{textFour}}</div>
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
          <el-button type="primary" class="people-button-style" round  @click="sitDown(4)" v-show="seatStatusList[3]==0">坐下</el-button>
        </div>
      </div>
    </div>
    <div class="outer-bottom">
        <div class="entire-button one-button">
          <div>
            <el-button  @click="disCard()" type="danger" round class="background-button" :disabled="userMsg.gameStatus!=3 || userMsg.isTrue==0">弃牌</el-button>
          </div>
          <div class="font-button">
            弃牌
          </div>
        </div>
        <div class="entire-button two-button" >
          <div >
            <el-button @click="compareBoard()" type="primary" round class="background-button" :disabled="userMsg.round==1 || userMsg.isTrue==0">比牌</el-button>
          </div>
          <div class="font-button">
            比牌
          </div>
        </div>
        <div class="entire-button three-button"  >
          <div>
            <el-button type="primary" round class="background-button" @click="seeCard()"
                       :disabled="userMsg.seeCardStatus==1 "> 看牌</el-button>
          </div>
          <div class="font-button" >
            看牌
          </div>
        </div>
        <div class="entire-button four-button">
          <el-dropdown  @command="handleCommand">
          <div>
            <el-button type="warning" round class="background-button" :disabled="userMsg.isIntegral==1 || userMsg.isTrue==0">+</el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item :command="userMsg.integralFundus*1" :disabled="userMsg.isIntegral==1 || userMsg.isTrue==0">{{userMsg.integralFundus*1}}</el-dropdown-item>
              <el-dropdown-item :command="userMsg.integralFundus*2" :disabled="userMsg.isIntegral==1 || userMsg.isTrue==0">{{userMsg.integralFundus*2}}</el-dropdown-item>
              <el-dropdown-item :command="userMsg.integralFundus*5" :disabled="userMsg.isIntegral==1 || userMsg.isTrue==0">{{userMsg.integralFundus*5}}</el-dropdown-item>
              <el-dropdown-item :command="userMsg.integralFundus*10" :disabled="userMsg.isIntegral==1 || userMsg.isTrue==0">{{userMsg.integralFundus*10}}</el-dropdown-item>
              <el-dropdown-item :command="userMsg.integralFundus*20" :disabled="userMsg.isIntegral==1 || userMsg.isTrue==0">{{userMsg.integralFundus*20}}</el-dropdown-item>
            </el-dropdown-menu>
          </div>
          </el-dropdown>
          <div class="font-button">
            加注
          </div>
        </div>
        <div class="entire-button five-button">
          <div >
            <el-button @click="userWithChip()" type="success" round class="background-button" :disabled="userMsg.isIntegral==1 || userMsg.isTrue==0">1</el-button>
          </div>
          <div class="font-button">
            跟注
          </div>
        </div>
        <div class="entire-button six-button">
          <div>
            <el-button type="primary" round class="background-button" @click="setOut()" :disabled="userMsg.isSetout==1 ">准备</el-button>
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
        userMsg:{
          seeCardStatus:0,
          isIntegral:0,
          isSetout:0,
          gameStatus:0,
          isTrue:0,
          round:1,    //轮次
          isUserIndex:0,   //下标是多少
          roomId:1,
          seatId:1,
          gamblingId:0,
          board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}],
          integralFundus:1,
          sort:1,
          compare:0,
          userId:sessionStorage.getItem('userId'),
        },
        //用户列表
        userList:[
          {
            userNickName: '',
            headPortrait: 'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg',
            gameStatus: 0,
            integral: 0,
            userId: 0,
            board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}],
            payIntegral: "0",
            isA32:0,
            isBanker:0,
            isSpecial:0,
            seeCardStatus:0,
            boardSize:0,
            boardType:0,
            isUser:0,
          },
          {userNickName: '', headPortrait: 'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg', gameStatus: 11, integral: 0, userId: 0, board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}], payIntegral: "0", isA32:0, isBanker:0, isSpecial:0, seeCardStatus:0, boardSize:0, boardType:0,  isUser:0},
          {userNickName: '', headPortrait: 'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg', gameStatus: 11, integral: 0, userId: 0, board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}], payIntegral: "0", isA32:0, isBanker:0, isSpecial:0, seeCardStatus:0, boardSize:0, boardType:0,  isUser:0},
          {userNickName: '', headPortrait: 'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg', gameStatus: 11, integral: 0, userId: 0, board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}], payIntegral: "0", isA32:0, isBanker:0, isSpecial:0, seeCardStatus:0, boardSize:0, boardType:0,  isUser:0},
          {userNickName: '', headPortrait: 'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg', gameStatus: 11, integral: 0, userId: 0, board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}], payIntegral: "0", isA32:0, isBanker:0, isSpecial:0, seeCardStatus:0, boardSize:0, boardType:0,  isUser:0},
          {userNickName: '', headPortrait: 'https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg', gameStatus: 11, integral: 0, userId: 0, board: [{color:0,number:1}, {color:0,number:0}, {color:0,number:0}], payIntegral: "0", isA32:0, isBanker:0, isSpecial:0, seeCardStatus:0, boardSize:0, boardType:0,  isUser:0},
          ],
        //坐下按钮显示
        seatStatusList: [0, 0, 0, 0, 0, 0], // 0 空闲 1坐下未准备 2 坐下已准备 3 正在游戏中 4没人正在游戏中

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
          case 6:
            this.userSeeCardA(res);
            break;
          case 7:
            this.userWithChipA(res);
            break;
          case 8:
            this.userAddChipA(res);
          case 9:
            this.userThanCardA(res);
            break;
          case 11:
            this.gameStart(res);
            break;
          case 12:
            this.gameOver(res);
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
          userId:sessionStorage.getItem("userId"),
          seatId: Number(this.userMsg.seatId)
        }).then((res)=>{
          if(res.code===200){
            this.userMsg.isSetout=1;
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
            seatId: number,
          }
        ).then((res) => {
          console.log("res", res)
          if(res.code===200){

          }else{
            this.$message.error(res.message)
          }
        })
      },
      //点击看牌的方法
      seeCard(){
        /* 1.给所有人发送有人看牌消息
        *  2.显示自己的牌*/
        GoldenFlowerService.seeCard(
          {
            type: 6,
            roomId: this.userMsg.roomId,
            seatId: this.userMsg.seatId,
            gamblingId:this.userMsg.gamblingId,
            round:this.userMsg.round,
            sort:this.userMsg.sort,
          }
        ).then((res) => {
          console.log("res", res)
          if(res.code===200){
            let seatIndex =  (this.userMsg.seatId-1)%6;
            this.userList[seatIndex].board[0].color = this.userMsg.board[0].color;
            this.userList[seatIndex].board[0].number = this.userMsg.board[0].number;
            this.userList[seatIndex].board[1].color = this.userMsg.board[1].color;
            this.userList[seatIndex].board[1].number = this.userMsg.board[1].number;
            this.userList[seatIndex].board[2].color = this.userMsg.board[2].color;
            this.userList[seatIndex].board[2].number = this.userMsg.board[2].number;
            this.userMsg.sort+=1;
          }else{
            this.$message.error(res.message)
          }
        })
      },
      //跟注
      userWithChip(){
        GoldenFlowerService.withChip(
          {
            type: 7,
            roomId: this.userMsg.roomId,
            seatId: this.userMsg.seatId,
            gamblingId:this.userMsg.gamblingId,
            round:this.userMsg.round,
            integralFundus:this.userMsg.integralFundus,
            sort:this.userMsg.sort,
          }
        ).then((res) => {
          console.log("res", res)
          if(res.code===200){
            this.userMsg.sort=1;
          }else{
            this.$message.error(res.message)
          }
        })
      },
      //加注
      handleCommand(e){
        GoldenFlowerService.AddChip(
          {
            type:8,
            roomId: this.userMsg.roomId,
            seatId: this.userMsg.seatId,
            gamblingId:this.userMsg.gamblingId,
            round:this.userMsg.round,
            integralFundus:e,
            sort:this.userMsg.sort,
          }
        ).then((res) => {
          console.log("res", res)
          if(res.code===200){
            this.userMsg.sort=1;
          }else{
            this.$message.error(res.message)
          }
        })
      },
      compareBoard(){
        this.userMsg.compare=1;
      },
      //比较用户
      comPareUser(index){
        if (this.userList[index].gameStatus==3 && this.userList[index].isUser==1 && this.userMsg.compare==1){
          this.userMsg.compare=0;
          //发起比较牌接口
          GoldenFlowerService.thanCard(
            {
              type: 9,
              roomId: this.userMsg.roomId,
              seatId: this.userMsg.seatId,
              gamblingId:this.userMsg.gamblingId,
              round:this.userMsg.round,
              sort:this.userMsg.sort,
              beUserId: this.userList[index].userId,
            }
          ).then((res) => {
            console.log("res", res)
            if(res.code===200){
              this.userMsg.sort=1;
            }else{
              this.$message.error(res.message)
            }
          })
        }
      },
      //弃牌
      disCard(){
        GoldenFlowerService.disCard(
          {
            type: 10,
            roomId: this.userMsg.roomId,
            seatId: this.userMsg.seatId,
            gamblingId:this.userMsg.gamblingId,
            round:this.userMsg.round,
            sort:this.userMsg.sort,
          }
        ).then((res) => {
          console.log("res", res)
          if(res.code===200){
            this.userMsg.sort=1;
          }else{
            this.$message.error(res.message)
          }
        })
      },


      //类型0 系统消息
      room(param) {
        let userList = param.userList;
        userList.forEach(ar=>{
          let subscript = (ar.seatId-1)%6;
          this.seatStatusList[subscript] = Number(ar.seatStatus);
          this.userList[subscript].integral=Number(ar.integral);
          this.userList[subscript].headPortrait=ar.userImg;
          this.userList[subscript].userNickName=ar.userNickName;
        });

      },
      //类型1 用户进入房间
      userInToRoom(param) {

      },
      //类型3 用户坐下
      userSitDown(param) {
        let subscript = (param.seatId-1)%6;
        this.seatStatusList[subscript] = 1;

        this.userList[subscript].userNickName=param.userNickName,
          this.userList[subscript].headPortrait=param.userImg,
          this.userList[subscript].userId=param.userId,
          this.userList[subscript].integral=Number(param.integral);
        if(sessionStorage.getItem('userId')==param.userId){
          this.userMsg.seatId=Number(param.seatId)
        }
        this.$forceUpdate()
      },
      //类型5 用户准备
      userSetOut(param){
        this.seatStatusList[(param.seatId-1)%6]=2;
        this.$forceUpdate()
      },
      //类型6 用户看牌
      userSeeCardA(param){
        this.userList[(param.seatId-1)%6].seeCardStatus=1;
        if(sessionStorage.getItem('userId')==param.userId){
          this.userMsg.seeCardStatus=1;
        }

        this.$forceUpdate()
      },
      //类型7 用户跟注
      userWithChipA(param){
        let seatIndex =(Number(param.seatId)-1)%6;
        //更改积分
        this.userList[seatIndex].payIntegral =Number(this.userList[seatIndex].payIntegral)+ Number(param.integralFundus);
        this.userMsg.round=Number(param.round);
        this.userMsg.isTrue=0;

        //改变操作用户
        if (param.trueUserId==sessionStorage.getItem("userId")){
          this.userMsg.isTrue=1;
        }

      },
      //类型8 用户加注
      userAddChipA(param){
        let seatIndex =(Number(param.seatId)-1)%6;
        //更改积分
        this.userList[seatIndex].payIntegral =Number(this.userList[seatIndex].payIntegral)+ Number(param.integralFundus);
        this.userMsg.round=Number(param.round);
        this.userMsg.isTrue=0;

        //改变操作用户
        if (param.trueUserId==sessionStorage.getItem("userId")){
          this.userMsg.isTrue=1;
        }
      },
      //类型9 ,用户比牌
      userThanCardA(param){
        let seatIndex =(Number(param.seatId)-1)%6;
        //输的人状态
        this.userList.forEach(a=>{
          if (a.userId==param.loseUserId){
           a.gameStatus=2;
          }
        });

        this.userMsg.round=Number(param.round);
        this.userMsg.isTrue=0;

        //改变操作用户
        if (param.trueUserId==sessionStorage.getItem("userId")){
          this.userMsg.isTrue=1;
        }
      },


      //游戏开始 类型 11
      //1.关闭座位
      //2.改变有的用户的牌
      gameStart(param){
        let data =  param.userList.roomChildMsgVoList;

        //本局属性
        this.userMsg.integralFundus = param.userList.integralFundus;
        this.userMsg.roomId=param.userList.roomId;
        this.userMsg.gamblingId = param.userList.gamblingId;
        this.userMsg.round=Number(param.userList.round);
        data.forEach(a=>{
          let seatSerial = (a.seatId-1)%6;
          if (a.isUser==1){
            let userId = sessionStorage.getItem('userId');
            //根据是否是当前账号显示不同的内润  和 看牌状态控制按钮
            if (userId== a.userId && userId !='' &&  userId != null){
              //操作主体的信息
              this.userMsg.seeCardStatus = a.seeCardStatus;
              this.userMsg.isTrue=a.isTurn;
              this.userMsg.isUserIndex=seatSerial;
              this.userMsg.seatId=a.seatId;
              this.userMsg.gameStatus=a.gameStatus;

              //详细信息
              this.seatStatusList[seatSerial]=3;
              this.userList[seatSerial].userNickName = a.nickName;
              this.userList[seatSerial].headPortrait = a.headPortrait;
              this.userList[seatSerial].gameStatus = a.gameStatus;
              this.userList[seatSerial].integral = a.integral;
              this.userList[seatSerial].userId = a.userId;
              this.userList[seatSerial].payIntegral = param.userList.integralFundus;
              this.userList[seatSerial].isA32 = a.isA32;
              this.userList[seatSerial].isBanker = a.isBanker;
              this.userList[seatSerial].isSpecial = a.isSpecial;
              this.userList[seatSerial].seeCardStatus = a.seeCardStatus;
              this.userList[seatSerial].boardSize = a.boardSize;
              this.userList[seatSerial].boardType = a.boardType;
              this.userList[seatSerial].isUser = a.isUser;


              this.userList[seatSerial].board[0].color=0;
              this.userList[seatSerial].board[0].number=0;
              this.userList[seatSerial].board[1].color=0;
              this.userList[seatSerial].board[1].number=0;
              this.userList[seatSerial].board[2].color=0;
              this.userList[seatSerial].board[2].number=0;

              //给角色存储牌
              this.userMsg.board[0].color=a.firstBoardColor;
              this.userMsg.board[0].number=a.firstBoardNumber;
              this.userMsg.board[1].color=a.secondBoardColor;
              this.userMsg.board[1].number=a.secondBoardNumber;
              this.userMsg.board[2].color=a.thirdlyBoardColor;
              this.userMsg.board[2].number=a.thirdlyBoardNumber;

            }else {

              this.seatStatusList[seatSerial]=3;
              this.userList[seatSerial].userNickName = a.nickName;
              this.userList[seatSerial].headPortrait = a.headPortrait;
              this.userList[seatSerial].gameStatus = a.gameStatus;
              this.userList[seatSerial].integral = a.integral;
              this.userList[seatSerial].userId = a.userId;
              this.userList[seatSerial].payIntegral = param.userList.integralFundus;
              this.userList[seatSerial].isA32 = a.isA32;
              this.userList[seatSerial].isBanker = a.isBanker;
              this.userList[seatSerial].isSpecial = a.isSpecial;
              this.userList[seatSerial].seeCardStatus = a.seeCardStatus;
              this.userList[seatSerial].boardSize = a.boardSize;
              this.userList[seatSerial].boardType = a.boardType;
              this.userList[seatSerial].isUser = a.isUser;

              this.userList[seatSerial].board[0].color=0;
              this.userList[seatSerial].board[0].number=0;
              this.userList[seatSerial].board[1].color=0;
              this.userList[seatSerial].board[1].number=0;
              this.userList[seatSerial].board[2].color=0;
              this.userList[seatSerial].board[2].number=0;
            }
          }else {
            this.seatStatusList[seatSerial]=4;
          }
          this.$forceUpdate();
        });
      },

      //游戏结束
      gameOver(param){
        let userList = param.userList;
        this.openGameOver(param.userNickName);
        this.userMsg.seeCardStatus=0,
          this.userMsg.isIntegral=0,
          this.userMsg.isSetout=0,
          this.userMsg.gameStatus=0,
          this.userMsg.isTrue=0,
          this.userMsg.round=1,
          this.userMsg.isUserIndex=0,
          this.userMsg.gamblingId=0,
          this.userMsg.board=[{color:0,number:1}, {color:0,number:0}, {color:0,number:0}],
          this.userMsg.integralFundus=1,
          this.userMsg.seeCardStatus=0,
          this.userMsg.sort=0,
          this.userMsg.compare=0,
          this.userMsg.userId=sessionStorage.getItem('userId'),

        userList.forEach(ar=>{
          let subscript = (ar.seatId-1)%6;
          this.seatStatusList[subscript] = Number(ar.seatStatus);
          this.userList[subscript].integral=Number(ar.integral);
          this.userList[subscript].headPortrait=ar.userImg;
          this.userList[subscript].userNickName=ar.userNickName;
        });
      },
      openGameOver(userNickName) {
        this.$alert(userNickName+'胜利', '游戏结束', {
          showConfirmButton:false,
          center: true,
        });
      }


    },
    computed:{
      textOne(){
        let text ="";
        if (this.userList[0].seeCardStatus==1){
          text = "已看牌";
        }
        if(this.userList[0].gameStatus ==1){
          text = "弃牌";
        }
        if(this.userList[0].gameStatus ==2){
          text = "比牌输";
        }
        return text;
      },
      textTwo(){
        let text ="";
        if (this.userList[1].seeCardStatus==1){
          text = "已看牌";
        }
        if(this.userList[1].gameStatus ==1){
          text = "弃牌";
        }
        if(this.userList[1].gameStatus ==2){
          text = "比牌输";
        }
        return text;
      },
      textThree(){
        let text ="";
        if (this.userList[2].seeCardStatus==1){
          text = "已看牌";
        }
        if(this.userList[2].gameStatus ==1){
          text = "弃牌";
        }
        if(this.userList[2].gameStatus ==2){
          text = "比牌输";
        }
        return text;
      },
      textFour(){
        let text ="";
        if (this.userList[3].seeCardStatus==1){
          text = "已看牌";
        }
        if(this.userList[3].gameStatus ==1){
          text = "弃牌";
        }
        if(this.userList[3].gameStatus ==2){
          text = "比牌输";
        }
        return text;
      },
      textFive(){
        let text ="";
        if (this.userList[4].seeCardStatus==1){
          text = "已看牌";
        }
        if(this.userList[4].gameStatus ==1){
          text = "弃牌";
        }
        if(this.userList[4].gameStatus ==2){
          text = "比牌输";
        }
        return text;
      },
      textSix(){
        let text ="";
        if (this.userList[5].seeCardStatus==1){
          text = "已看牌";
        }
        if(this.userList[5].gameStatus ==1){
          text = "弃牌";
        }
        if(this.userList[5].gameStatus ==2){
          text = "比牌输";
        }
        return text;
      },
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

  .people-boardCompare{
    box-sizing: border-box;
    border: 10px solid #fff;
    border-color: #ff1c17 #e5e908 #156bff #3fff41;
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
