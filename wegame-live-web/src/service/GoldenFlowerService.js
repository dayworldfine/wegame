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

/**
 * 看牌
 * @param param
 * @returns {Promise}
 */
const seeCard = (param={})=>{
  return new Promise((resolve,reject) => {
    http.post({
      url: '/friedFlowerPort/userSeeCard',
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
 * 跟注
 * @param param
 * @returns {Promise}
 */
const withChip = (param={})=>{
    return new Promise((resolve,reject) => {
      http.post({
        url: '/friedFlowerPort/userWithChip',
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
 * 加注
 * @param param
 * @returns {Promise}
 */
const AddChip = (param={})=>{
  return new Promise((resolve,reject) => {
    http.post({
      url: '/friedFlowerPort/userAddChip',
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
 * 比牌
 * @param param
 * @returns {Promise}
 */
const thanCard = (param={})=>{
  return new Promise((resolve,reject) => {
    http.post({
      url: '/friedFlowerPort/userThanCard',
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
 * 弃牌
 * @param param
 * @returns {Promise}
 */
const disCard = (param={})=>{
  return new Promise((resolve,reject) => {
    http.post({
      url: '/friedFlowerPort/userDisCard',
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
  sitDown,                    /*坐下*/
  setOut,                     /*准备*/
  seeCard,                    /*准备*/
  withChip,                   /*跟注*/
  AddChip,                    /*加注*/
  thanCard,                   /*比牌*/
  disCard,                    /*弃牌*/
}

