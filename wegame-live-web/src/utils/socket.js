import SockJS from  'sockjs-client';
import Stomp from 'stompjs';
import {socketUrl} from "./params";
import Vue from 'vue'
Vue.prototype.$socket = new Vue()     /*新的Vue对象*/
let stompClient = null;


function connect(number) {
  let _this = this
  // let socket = new SockJS('/endpoint-websocket');
  let socket = new SockJS(socketUrl);
  socket.onmessage =function(e){
    console.error("e",e)
  }
  stompClient = Stomp.over(socket);
  stompClient.connect({},  (frame)=> {
    console.log('Connected: ' + frame);

    //订阅群聊消息
    console.log("stompClient",stompClient)
    stompClient.subscribe('/friedFlowerServer/'+number,  (result)=> {
      // showContent(JSON.parse(result.body));
      console.log("订阅群聊消息",result)
      // console.log("订阅群聊消息",JSON.parse(result.body) )
      // console.log("订阅群聊消息",JSON.parse(result.body).content)

      Vue.prototype.$socket.$emit("socket",JSON.parse(result.body))
    });
    _this.userInToRoom('1','1','123','touxiang','wbh','111')
    //订阅私人消息
    stompClient.subscribe('/topic/'+sessionStorage.getItem('token'), function (result) {
      // showOnlieUser(JSON.parse(result.body));
      console.log("订阅在线用户消息",result)
    });


  });

}


//断开连接
function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  console.log("Disconnected");
}

//发送聊天记录
function sendContent() {
  // stompClient.send("/app/v6/chat", {}, JSON.stringify({'content': "测试发送消息"}));
  // stompClient.send("/app/sendMessage", {}, JSON.stringify({'id':"123","userName":"用户名",'type':'12','message': "测试发送消息"}));
  stompClient.send("/friedFlowerClient/sendMessage", {}, JSON.stringify({'fromId':"123","toId":"用户名",'content':'12','time': "测试发送消息"}));

}

/**
 * 用户进入直播
 * @param type
 * @param roomSerial
 * @param userId
 * @param userImg
 * @param userNickName
 * @param integral
 */
function userInToRoom(type,roomSerial,userId,userImg,userNickName,integral) {
  stompClient.send("/friedFlowerClient/userInToRoom", {}, JSON.stringify({
    'type':type,
    'roomSerial':roomSerial,
    "userId":userId,
    'userImg':userImg,
    'userNickName': userNickName,
    'integral':integral}));
}

/**
 * 用户退出直播
 * @param type
 * @param userId
 */
function userOutRoom(type,userId) {
  stompClient.send("/friedFlowerClient/userOutRoom", {}, JSON.stringify({
    'type':type,
    "userId":userId}));
}

/**
 * 用户坐下
 * @param type
 * @param userId
 * @param seat
 */
function userSitDown(type,userId,seat) {
  stompClient.send("/friedFlowerClient/userSitDown", {}, JSON.stringify({
    'type':type,
    "userId":userId,
    'seat':seat}));
}

/**
 * 用户站起来
 * @param type
 * @param userId
 * @param seat
 */
function userStandUp(type,userId,seat) {
  stompClient.send("/app/userStandUp", {}, JSON.stringify({
    'type':type,
    "userId":userId,
    'seat':seat}));
}

/**
 * 用户准备
 * @param type
 * @param userId
 * @param seat
 */
function userSetOut(type,userId,seat) {
  stompClient.send("/app/userPrepare", {}, JSON.stringify({
    'type':type,
    "userId":userId,
    'seat':seat}));
}

/**
 * 用户看牌
 * @param type
 * @param userId
 * @param seat
 * @param board
 */
function userSeeCard(type,userId,seat,board) {
  stompClient.send("/app/userSeeCard", {}, JSON.stringify({
    'type':type,
    "userId":userId,
    'seat':seat,
    'board':board}));
}

/**
 * 用户跟注
 * @param type
 * @param userId
 * @param seat
 * @param money
 */
function userFollowChip(type,userId,seat,money) {
  stompClient.send("/app/userFollowChip", {}, JSON.stringify({
    'type':type,
    "userId":userId,
    'seat':seat,
    'money':money}));
}

/**
 * 用户加注
 * @param type
 * @param userId
 * @param seat
 * @param money
 */
function userAddChip(type,userId,seat,money) {
  stompClient.send("/app/userAddChip", {}, JSON.stringify({
    'type':type,
    "userId":userId,
    'seat':seat,
    'money':money}));
}

/**
 * 用户比牌
 * @param type
 * @param userId
 * @param seat
 * @param beUserId
 * @param beSeat
 */
function userThanCard(type,userId,seat,beUserId,beSeat) {
  stompClient.send("/app/userThanCard", {}, JSON.stringify({
    'type':type,
    "userId":userId,
    'seat':seat,
    'beUserId':beUserId,
    'beSeat':beSeat}));
}

/**
 * 用户弃牌
 * @param type
 * @param userId
 * @param seat
 */
function userDisCard(type,userId,seat) {
  stompClient.send("/app/userThanCard", {}, JSON.stringify({
    'type':type,
    "userId":userId,
    'seat':seat}));
}

export default {
  connect,                      /*连接*/
  disconnect,                   /*断开连接*/
  sendContent,                  /*发送消息*/
  userInToRoom,                 /*用户进入直播*/
  userOutRoom,                  /*用户退出直播*/
  userSitDown,                  /*用户坐下*/
  userStandUp,                  /*用户站起来*/
  userSetOut,                  /*用户准备*/
  userSeeCard,                  /*用户看牌*/
  userFollowChip,               /*用户跟注*/
  userAddChip,                  /*用户加注*/
  userThanCard,                 /*用户比牌*/
  userDisCard,                  /*用户弃牌*/
}
