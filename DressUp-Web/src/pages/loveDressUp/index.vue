<template>
  <div class="content">
    <div class="navbar">
      <block v-for="(item,index) in tabs" :key="index">
        <div :id="index" :class="{'navbar_item_on':activeIndex == index}" class="navbar_item" @click="tabClick">
          <div class="navbar_title">{{item.name}}</div>
        </div>
      </block>
      <div class="navbar_slider" :class="navbarSliderClass"></div>
    </div>
    <swiper :duration="300" :style="'height:'+contentHeight" @change="swiperChange" :current="currentTab" @animationfinish="onAnimationfinish">
        <swiper-item v-for="(item,index) in tabs" :key="index">
          <Swipering :arrayList = "item.images"></Swipering>
          <div class="main">
            <TeachList :arrayList = "item.elements" v-if="index==0"></TeachList>
            <Makeup :arrayList = "item.elements" v-if="index==1"></Makeup>
            <Cosmetic :arrayList = "item.elements" v-if="index==2"></Cosmetic>
          </div>
        </swiper-item>
      </swiper>
  </div>
</template>

<script>
  import Swipering from "@/components/swiper"
  import TeachList from "@/components/teachList"
  import Makeup from "@/components/makeup"
  import Cosmetic from "@/components/cosmetic"

  export default {
    data() {
      return {
        images:[],
        teachings: [],
        makeups: [],
        cosmetics: [],
        tabs: [],
        activeIndex: 0,
        currentTab: 0,
        winWidth: 0,
        winHeight: 0,
      };
    },
    components: {
      Swipering,
      TeachList,
      Makeup,
      Cosmetic
    },
    computed: {
      navbarSliderClass() {
        if (this.activeIndex == 0) {
          return "navbar_slider_0";
        }
        if (this.activeIndex == 1) {
          return "navbar_slider_1";
        }
        if (this.activeIndex == 2) {
          return "navbar_slider_2";
        }
      },
      contentHeight() {
        return this.winHeight + "px";
      }
    },
    methods: {
      tabClick(e) {
        this.activeIndex = e.currentTarget.id;
        this.currentTab =this.activeIndex;
      },
      swiperChange(e) {
        this.currentTab = e.mp.detail.current;
        this.activeIndex = this.currentTab;
      },
      onAnimationfinish() {
        console.log("滑动完成.....")
      }
    },
    onLoad() {
      var res = wx.getSystemInfoSync();
      this.winWidth = res.windowWidth;
      this.winHeight = res.windowHeight;
    },
    mounted() {
      this.tabs = [
        {
          name: "化妆教程",
          images: [
            {
              url: "../../static/assets/images/2.jpg"
            },
            {
              url: "../../static/assets/images/2.jpg"
            },
            {
              url: "../../static/assets/images/2.jpg"
            },
            {
              url: "../../static/assets/images/2.jpg"
            }
          ],
          elements: [
            {
              name: "你不知道的化妆技巧",
              imageUrl: "../../static/assets/images/2.jpg",
              path: "../teachDetail/main"
            },
            {
              name: "你不知道的化妆技巧",
              imageUrl: "../../static/assets/images/2.jpg",
              path: "../teachDetail/main"
            }
          ]
        },
        {
          name: "妆容分享",
          images: [
            {
              url: "../../static/assets/images/2.jpg"
            },
            {
              url: "../../static/assets/images/2.jpg"
            },
            {
              url: "../../static/assets/images/2.jpg"
            },
            {
              url: "../../static/assets/images/2.jpg"
            }
          ],
          elements: [
            {
              name: "你不知道的化妆品",
              images: [
                "../../static/assets/images/2.jpg",
                "../../static/assets/images/2.jpg",
                "../../static/assets/images/2.jpg"
              ],
              path: "../dressupDetail/main"
            }
          ]
        },
        {
          name: "妆品推荐",
          images: [
            {
              url: "../../static/assets/images/2.jpg"
            },
            {
              url: "../../static/assets/images/2.jpg"
            },
            {
              url: "../../static/assets/images/2.jpg"
            },
            {
              url: "../../static/assets/images/2.jpg"
            }
          ],
          elements: [
            {
              imageUrl: "../../static/assets/images/2.jpg",
              name: "无酒精面膜",
              descri: "这是一盒非常非常非常非常非常非常神奇的化妆品鸭鸭！你一定要喜欢啊啊啊啊啊啊啊啊啊啊哈哈哈哈哈哈哈哈哈哈！",
              path: "../cosmeticDetail/main"
            }
          ]
        }
      ];
    }
  };
</script>

<style scoped>
  .main{
    position: relative;
    width: 94%;
    margin: 0 auto;
  }
  .content {
    box-sizing: border-box;
    height: 100%;
    margin-top: 41px;
    -webkit-overflow-scrolling: touch;
  }
  .swiper-item {
    height: 100%;
    text-align: center;
  }

  .navbar {
    display: -webkit-box;
    display: -webkit-flex;
    display: flex;
    position: fixed;
    z-index: 500;
    top: 0;
    padding-bottom: 0;
    height: 40px;
    width: 100%;
    background-color: #fff;
    border-bottom: 1rpx solid #ccc;
  }

  .navbar_item {
    position: relative;
    display: block;
    -webkit-box-flex: 1;
    -webkit-flex: 1;
    flex: 1;
    padding: 9px 0;
    text-align: center;
    font-size: 0;
  }

  .navbar_item .navbar_item_on {
    color: white;
  }

  .navbar_title {
    color: #000;
    display: inline-block;
    font-size: 15px;
    max-width: 100%;
  }

  .navbar_slider {
    position: absolute;
    content: " ";
    left: 0;
    bottom: 0;
    width: 33.3333333%;
    height: 4px;
    background-color: #FFAEAE;
    -webkit-transition: -webkit-transform 0.3s;
    transition: -webkit-transform 0.3s;
    transition: transform 0.3s;
    transition: transform 0.3s, -webkit-transform 0.3s;
  }

  .navbar_slider_0 {
    left: 0;
    transform: translateX(0);
  }

  .navbar_slider_1 {
    left: 0;
    transform: translateX(100%);
  }

  .navbar_slider_2 {
    left: 0;
    transform: translateX(200%);
  }
  .controls {
    display: -webkit-box;
    display: -webkit-flex;
    display: flex;
    position: fixed;
    z-index: 8888;
    top: 80;
    height: 50px;
    width: 100%;
    background-color: #298de5;
  }
</style>