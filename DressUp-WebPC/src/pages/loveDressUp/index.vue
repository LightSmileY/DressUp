<template>
  <div class="loveDressUp">
    <div class="banner">
      <el-carousel :interval="4000" type="card" height="250px">
        <el-carousel-item v-for="item in 6" :key="item">
          <img src="@/assets/img/test.jpg" alt="404">
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="main">
      <div class="nav">
        <div class="elements">
          <dl>
            <dt><img src="@/assets/img/test.jpg"></dt>
            <dd>化妆教程</dd>
          </dl>
          <dl>
            <dt><img src="@/assets/img/test.jpg"></dt>
            <dd>妆容分享</dd>
          </dl>
          <dl>
            <dt><img src="@/assets/img/test.jpg"></dt>
            <dd>妆品推荐</dd>
          </dl>
        </div>
      </div>
      <div class="teach">
        <div class="title">化妆教程</div>
        <div class="elements">
          <div class="item" v-for="item in 4">
            <dl>
              <dt><img src="@/assets/img/teach.jpeg"></dt>
              <dd>小清新</dd>
            </dl>
          </div>
        </div>
        <div class="more">
          <span>查看更多</span>
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
      <div class="dressUp">
        <div class="title">妆容分享</div>
        <div class="elements">
          <div class="item" v-for="item in 6">
            <dl>
              <dt><img src="@/assets/img/makeup.jpg"></dt>
              <dd>妆容</dd>
            </dl>
          </div>
        </div>
        <div class="more">
          <span>查看更多</span>
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
      <div class="cosmetics">
        <div class="title">妆品推荐</div>
        <div class="elements">
          <div class="item" v-for="item in 6">
            <dl>
              <dt><img src="@/assets/img/com.jpg"></dt>
              <dd>妆品</dd>
            </dl>
          </div>
        </div>
        <div class="more">
          <span>查看更多</span>
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'App',
    data(){
      return{
        
      }
    },
    methods: {
      
    }
  };
</script>

<style lang="scss">
  @import "../../assets/scss/loveDressUp";
</style>