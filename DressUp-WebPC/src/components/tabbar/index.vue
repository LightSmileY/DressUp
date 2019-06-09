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
                  <li class="nav">爱妆瓣</li>
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
          <span>登录</span>&nbsp;/&nbsp;
          <span>注册</span>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>

  export default {
    name: 'App',
    data(){
      return{
        search: ""
      }
    },
    methods: {
      onSubmit(){
        alert("hhhh");
      }
    }
  };
</script>

<style lang="scss">
  @import "../../assets/scss/tabbar";
</style>