<template>
  <div class="login">
    <div class="loginMask">
      <div class="login">
        <!-- <input type="text" placeholder="用户名" v-model="uid"> -->
        <!-- <input type="text" placeholder="密码"  v-model="password"> -->
        <el-input v-model="uid" placeholder="请输入用户名" class="username"></el-input>
        <el-input v-model="password" placeholder="请输入密码" class="password" show-password></el-input>
        <button @click="login">登录</button>
      </div>
    </div>

    <!-- <div class="registerMask">
      <div class="register">
        <input type="text" placeholder="用户名" v-model="uid2">
        <input type="text" placeholder="密码"  v-model="password2">
        <button @click="register">注册</button>
      </div>
    </div> -->
  </div>
</template>

<script>

export default {


  name: 'login',
  data () {
    return {
      uid: "",
      password: ""
    }
  },
  components: {
    
  },
  methods: {
    login(){
      let _this = this;
      _this.$axios.post('http://106.14.46.10:8081/MakeupYou/user/login',
        _this.$qs.stringify({
          uid: _this.uid,
          name: "~",
          password: _this.password,
          birthday: "",
          sex: 0,
          age: 0,
          register_date: "",
          avatarID: "",
          description: "",
          mailbox: "",
          last_login_time: _this.$store.state.getTime()     
        })
      )
      .then(response => {
        console.log(response);
        console.log("登录成功");
        // 从服务器获取用户资料
        _this.$axios.get('http://106.14.46.10:8081/MakeupYou/user/findUserByID/',{
            params: {
              userID: _this.uid
            }
          }
        )
        .then(function (response) {
          console.log(response.data);
          console.log("从服务器获取用户资料成功");
          
          _this.$store.state.myCosInfo = response.data;
          console.log(_this.$store.state.myCosInfo);
          console.log("将服务器返回的资料赋值给_this.$store.state.myCosInfo成功！");
          _this.$router.push({ path:'/community'});
        })
        .catch(function (error) {
          console.log(error);
        });
      })
      .catch(error => {
        console.log(error);
        console.log("登录失败");
      });
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
@import "../../assets/scss/mixins";

  .loginMask{
    position: fixed;
    width: 100vw;
    height: 100vh;
    background-image: url("~@/assets/img/bg.jpg");
    background-size: 100% 92vh;
    background-position: 0 8vh;
    background-attachment: fixed;

    .login{
      @include flex-center(column);
      position: absolute;
      top: 50%;
      left: 50%;
      margin-top: -150px;
      margin-left: -200px;
      width: 400px;
      height: 300px;
      border-radius: 10px;
      box-shadow: 0 0 10px #939393;

      .username,
      .password{
        width:80%;
        height: 50px;
      }

      button{
        position: relative;
        top: 20px;
        width: 80%;
        height: 40px;
        font-size: 15px;
        line-height: 40px;
        background-color: #FFB8B8;
        color: #fff;
        margin: 0 auto;
        border: none;
        outline: none;
        border-radius: 4px;
        cursor: pointer;
        text-align:center;
      }
      button:active{
        background-color: #FF9A9A;
      }
    }
  }
</style>
