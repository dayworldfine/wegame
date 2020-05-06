/**
 * 用户登录
 */
import http from '@/utils/http'

/**
 * 用户登录
 * @param param
 * @returns {Promise}
 */
const login = (param={})=>{
  return new Promise((resolve,reject) => {

    http.post({
      url: '/login',
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

const login1 = (param={})=>{
  return new Promise((resolve,reject) => {

    http.post({
      url: '/asdads',
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
  login,                   /*登录*/
  login1
}
