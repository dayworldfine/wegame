<template>
  <div class="login-wrap">
    <el-form class="login-form" label-position="left" label-width="80px" :model="formdata">
      <h2>用户登录</h2>
      <el-form-item label="用户名">
        <el-input v-model="formdata.account"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="formdata.password" type="password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button  type="primary">忘记密码</el-button>
        <el-button @click.prevent="Login()"  type="primary">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
    export default {
      name: "Login",
      data(){
          return{
            formdata: {
              account: '',
              password: ''
            }
          }
      },
      methods:{
        Login(){
          this.$router.push({name:'Home'})
        }
      }
    }
</script>

<style scoped>
  .login-wrap {
    height: 100%;
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
  }
  .login-btn {
    width: 100%;
    border-radius: 5px;
  }
</style>
