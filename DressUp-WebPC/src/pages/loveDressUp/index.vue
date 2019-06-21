<template>
  <div class="loveDressUp">
    <div class="banner">
      <el-carousel :interval="4000" type="card" height="250px">
        <el-carousel-item v-for="item in banners" :key="item">
          <img :src="item" alt="">
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="main">
      <div class="nav">
        <div class="elements">
          <dl>
            <dt><img src="https://i.loli.net/2019/05/29/5cee409e364c793248.png"></dt>
            <dd>化妆教程</dd>
          </dl>
          <dl>
            <dt><img src="https://i.loli.net/2019/05/29/5cee409f41c4247642.png"></dt>
            <dd>妆容分享</dd>
          </dl>
          <dl>
            <dt><img src="https://i.loli.net/2019/05/29/5cee3ff83634a14030.jpg"></dt>
            <dd>妆品推荐</dd>
          </dl>
        </div>
      </div>
      <div class="teach">
        <div class="title">化妆教程</div>
        <div class="elements">
          <div class="item" v-for="item in dressUps">
            <dl>
              <dt><img :src="item"></dt>
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
          <div class="item" v-for="item in makeUps">
            <dl>
              <dt><img :src="item"></dt>
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
          <div class="item" v-for="item in cosmamics">
            <dl>
              <dt><img :src="item"></dt>
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
        banners: [
          "https://t1.picb.cc/uploads/2019/05/30/giNfLi.md.jpg",
          "https://i.loli.net/2019/05/29/5cee3e9cd3a1a11937.jpg",
          "https://i.loli.net/2019/05/29/5cee3f031451617189.jpg",
          "https://i.loli.net/2019/05/29/5cee3f032577c34451.jpg",
          "https://i.loli.net/2019/05/29/5cee3f78e138834786.jpg",
          "https://i.loli.net/2019/05/29/5cee3f78e644247723.jpg"
        ],
        dressUps: [
          "https://i.loli.net/2019/05/29/5cee409e364c793248.png",
          "https://i.loli.net/2019/05/29/5cee409e3f41352467.png",
          "https://i.loli.net/2019/05/29/5cee409f41c4247642.png",
          "https://i.loli.net/2019/05/29/5cee40c4b385f64368.png",
        ],
        makeUps: [
          "https://i.loli.net/2019/05/29/5cee3f031451617189.jpg",
          "https://i.loli.net/2019/05/29/5cee3f032577c34451.jpg",
          "https://i.loli.net/2019/05/29/5cee3f035d83812451.jpg",
          "https://i.loli.net/2019/05/29/5cee3f036739233912.jpg",
          "https://i.loli.net/2019/05/29/5cee4060673a186547.png",
          "https://i.loli.net/2019/05/29/5cee409e364c793248.png"
        ],
        cosmamics: [
          "https://i.loli.net/2019/05/29/5cee3ff83634a14030.jpg",
          "https://i.loli.net/2019/05/29/5cee3ff842e4847526.jpg",
          "https://i.loli.net/2019/05/29/5cee412ee685d45610.png",
          "https://i.loli.net/2019/05/29/5cee412f4bc7a31616.png",
          "https://i.loli.net/2019/05/29/5cee412f4d9f189266.png",
          "https://i.loli.net/2019/05/29/5cee412f56daf84076.png"
        ]
      }
    },
    methods: {
      
    }
  };
</script>

<style lang="scss">
  @import "../../assets/scss/loveDressUp";
</style>