/**
 * 炸金花操作
 */
import http from '@/utils/http'

/**
 * 坐下
 * @param param
 * @returns {Promise}
 */
const sitDown = (param={})=>{
  return new Promise((resolve,reject) => {
    http.post({
      url: '/friedFlowerPort/userSitDown',
      data: param
    }).then((res) => {
      console.log("resolve",res)
      resolve(res)
    },err =>{
      console.log("reject1",err)
      reject(err)
    })
  })
};

/**
 * 准备
 * @param param
 * @returns {Promise}
 */
const setOut = (param={})=>{
  return new Promise((resolve,reject) => {
    http.post({
      url: '/friedFlowerPort/userSetOut',
      data: param
    }).then((res) => {
      console.log("resolve",res)
      resolve(res)
    },err =>{
      console.log("reject1",err)
      reject(err)
    })
  })
};

export default {
  sitDown,                   /*坐下*/
  setOut,                     /*准备*/
}

