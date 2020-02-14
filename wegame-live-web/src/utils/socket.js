import SockJS from  'sockjs-client';
import Stomp from 'stompjs';
import {socketUrl} from "./params";
import Vue from 'vue'
Vue.prototype.$socket = new Vue()
let stompClient = null;


function connect() {
  // let socket = new SockJS('/endpoint-websocket');
  let socket = new SockJS(socketUrl);
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);

    //订阅群聊消息
    console.log("stompClient",stompClient)
    stompClient.subscribe('/topic/chat', function (result) {
      // showContent(JSON.parse(result.body));
      console.log("订阅群聊消息",result)
      // console.log("订阅群聊消息",JSON.parse(result.body) )
      // console.log("订阅群聊消息",JSON.parse(result.body).content)

      Vue.prototype.$socket.$emit("socket",JSON.parse(result.body))
    });

    //订阅在线用户消息
    stompClient.subscribe('/topic/onlineuser', function (result) {
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
  stompClient.send("/app/sendMessage", {}, JSON.stringify({'fromId':"123","toId":"用户名",'content':'12','time': "测试发送消息"}));

}

//显示聊天记录
function showContent(body) {
  $("#record").append("<tr><td>" + body.content + "</td> <td>"+new Date(body.time).toLocaleTimeString()+"</td></tr>");
}

//显示实时在线用户
function showOnlieUser(body) {
  $("#online").html("<tr><td>" + body.content + "</td> <td>"+new Date(body.time).toLocaleTimeString()+"</td></tr>");
}

export default {
  connect,                      /*连接*/
  disconnect,                   /*断开连接*/
  sendContent,                  /*发送消息*/

}
