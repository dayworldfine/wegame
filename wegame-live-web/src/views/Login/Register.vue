<template>
  <div class="login-wrap">
    <el-form class="login-form" label-position="left" label-width="80px" :model="formdata">
      <h2>用户注册/找回密码</h2>
      <el-form-item label="手机号">
        <el-input v-model="formdata.account"></el-input>
      </el-form-item>
      <el-form-item label="验证码">
        <el-input v-model="formdata.code"></el-input>
      </el-form-item>
      <el-form-item label="登录名">
        <el-input v-model="formdata.userName"></el-input>
      </el-form-item>
      <el-form-item label="游戏昵称">
        <el-input v-model="formdata.nickName"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="formdata.password" type="password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getCode()"  type="primary" :disabled="getCodeStatus">获取验证码</el-button>
        <el-button @click="toRegister()"  type="primary">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import LoginService from '@/service/LoginService'
  export default {
    name: "Register",

    data(){
      return{
        formdata: {
          account: '',
          code: '',
          userName: '',
          nickName: '',
          password: ''
        },
        getCodeStatus:false,
      }
    },
    methods:{
      getCode(){
        let _this =this
        LoginService.getCode({account:_this.formdata.account}).then((res=>{
          console.log("res",res)
          if(res.code===200){
            _this.getCodeStatus=true;
            setTimeout(()=>{
              _this.getCodeStatus=false
            },60000)
          }else{
            this.$message.error(res.message);
          }
        }))
      },

      toRegister(){
        let _this =this
        LoginService.userRegister(
          {
            userName:_this.formdata.userName,
            nickName:_this.formdata.nickName,
            code:_this.formdata.code,
            pwd:_this.formdata.password,
            account:_this.formdata.account
           }
          ).then((res=>{
          console.log("res",res)
          if(res.code===200){
            _this.$message.success("注册成功 ,即将跳转")
           setTimeout(()=>{
             this.$router.push({name:'Login'})
           },2000)
          }else{
            this.$message.error(res.message);
          }
        }))
      },
    }
  }
</script>

<style scoped>
  .login-wrap {
    height: 100%;
    width: 100%;
    background-color: #324152;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
  }
  .login-form {
    width: 400px;
    background-color: #ffffff;
    border-radius: 5%;
    padding: 30px;
    /*min-width: 960px;*/
  }
</style>
