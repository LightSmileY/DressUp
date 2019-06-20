<template>
  <div class="g-tabbar">
    <el-row>
      <!-- logo -->
      <el-col :span="2">
        <div class="logo">
          <img src="@/assets/img/logo.png" alt="logo">
        </div>
      </el-col>
      <!-- 搜索框~导航栏 -->
      <el-col :span="19">
        <el-row class="search-nav">
          <!-- 搜索框 -->
          <el-col :span="9">
            <div class="search">
              <el-input
                placeholder="搜索您想要的内容..."
                prefix-icon="el-icon-search"
                v-model="search" 
                @keyup.enter.native="onSubmit">
              </el-input>
            </div>
          </el-col>
          <!-- 导航栏 -->
          <el-col :span="14">
            <div class="nav-bar">
              <ul>
                <router-link class="g-tabbar-item" to="/">
                  <li class="nav">社区</li>
                </router-link>
                <router-link class="g-tabbar-item item2" to="/loveDressUp">
                  <li class="nav">妆瓣</li>
                </router-link>
                <router-link class="g-tabbar-item" to="/mine">
                  <li class="nav">个人中心</li>
                </router-link>
              </ul>
            </div>
          </el-col>
        </el-row>
      </el-col>
      <!-- 登录/注册 -->
      <el-col :span="3">
        <div class="login-regist">
          <span @click="showLoginPage">登录</span>&nbsp;/&nbsp;
          <span @click="showRegisterPage">注册</span>
        </div>
      </el-col>
    </el-row>

    <div class="loginMask" v-if="isLogin">
      <div class="login">
        <input type="text" placeholder="用户名" v-model="uid">
        <input type="text" placeholder="密码"  v-model="password">
        <button @click="login">登录</button>
      </div>
    </div>

    <div class="registerMask" v-if="isRegister">
      <div class="register">
        <input type="text" placeholder="用户名" v-model="uid">
        <input type="text" placeholder="密码"  v-model="password">
        <button @click="register">注册</button>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'App',
    data(){
      return{
        search: "",
        isLogin: 0,
        isRegister: 0
      }
    },
    methods: {
      onSubmit(){
        alert("hhhh");
      },
      showLoginPage(){
        this.isLogin = !this.isLogin;
      },
      showRegisterPage(){
        this.isRegister = !this.isRegister;
      },
      register(){
        let _this = this;
        _this.$axios.post('http://106.14.46.10:8081/MakeupYou/user/register',
          _this.$qs.stringify({
            uid: _this.userinfo.openid,
            name: _this.userName,
            password: "123456",
            birthday: "",
            sex: 0,
            age: 0,
            register_date: _this.$store.state.getTime(),
            avatarID: _this.$store.state.myWxInfo.avatarUrl,
            description: "",
            mailbox: "",
            last_login_time: _this.$store.state.getTime()     
          })
        )
        .then(response => {
          console.log(response);
        })
        .catch(error => {
          console.log(error);
        });
      },
      login(){
        let _this = this;
        _this.$axios.post('http://106.14.46.10:8081/MakeupYou/user/login',
          _this.$qs.stringify({
            uid: _this.userinfo.openid,
            name: _this.userName,
            password: "123456",
            birthday: "",
            sex: 0,
            age: 0,
            register_date: _this.$store.state.getTime(),
            avatarID: _this.$store.state.myWxInfo.avatarUrl,
            description: "",
            mailbox: "",
            last_login_time: _this.$store.state.getTime()     
          })
        )
        .then(response => {
          console.log(response);
          console.log("登录成功");
          // 从服务器获取用户资料
          _this.$axios.get('http://106.14.46.10:8081/MakeupYou/user/findUserByID/',_this.$qs.stringify({
              userID: _this.userinfo.openid
            })
          )
          .then(function (response) {
            console.log(response.data);
            console.log("从服务器获取用户资料成功");
            
            _this.$store.state.myCosInfo = response.data;
            console.log(_this.$store.state.myCosInfo);
            console.log("将服务器返回的资料赋值给_this.$store.state.myCosInfo成功！");

            _this.getPosts();

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
    },
    components: {

    }
  };
</script>

<style lang="scss">
  @import "../../assets/scss/tabbar";
</style>