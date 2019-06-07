<template>
  <div class="content">
    <!-- 导航栏 -->
    <div class="navbar">
      <block v-for="(item,index) in tabs" :key="index">
        <div :id="index" :class="{'navbar_item_on':activeIndex == index}" class="navbar_item" @click="tabClick">
          <div class="navbar_title">{{item.name}}</div>
        </div>
      </block>
      <div class="navbar_slider" :class="navbarSliderClass"></div>
    </div>
    <!-- 3个可滑动的分页 -->
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
              url: "https://t1.picb.cc/uploads/2019/05/30/giNfLi.md.jpg"
            },
            {
              url: "https://i.loli.net/2019/05/29/5cee3e9cd3a1a11937.jpg"
            },
            {
              url: "https://i.loli.net/2019/05/29/5cee3e9cd5ea832876.jpg"
            },
            {
              url: "https://i.loli.net/2019/05/29/5cee3e9cd8a1c54055.jpg"
            }
          ],
          elements: [
            {
              name: "新手化妆步骤和建议",
              imageUrl: "https://i.loli.net/2019/05/29/5cee3ff83634a14030.jpg",
              path: "../teachDetail/main"
            },
            {
              name: "干货整理->新手如何入门？完整的护肤化妆步骤",
              imageUrl: "https://i.loli.net/2019/05/29/5cee3ff842e4847526.jpg",
              path: "../teachDetail/main"
            }
          ]
        },
        {
          name: "妆容分享",
          images: [
            {
              url: "https://i.loli.net/2019/05/29/5cee3f031451617189.jpg"
            },
            {
              url: "https://i.loli.net/2019/05/29/5cee3f032577c34451.jpg"
            },
            {
              url: "https://i.loli.net/2019/05/29/5cee3f035d83812451.jpg"
            },
            {
              url: "https://i.loli.net/2019/05/29/5cee3f036739233912.jpg"
            }
          ],
          elements: [
            {
              name: "毕业照妆容来啦",
              images: [
                "https://i.loli.net/2019/05/29/5cee4060673a186547.png",
                "https://i.loli.net/2019/05/29/5cee40606500a42218.png",
                "https://i.loli.net/2019/05/29/5cee40602bc6913803.png"
              ],
              path: "../dressupDetail/main"
            },
            {
              name: "法式微醺玫瑰妆容",
              images: [
                "https://i.loli.net/2019/05/29/5cee409e364c793248.png",
                "https://i.loli.net/2019/05/29/5cee409e3f41352467.png",
                "https://i.loli.net/2019/05/29/5cee409f41c4247642.png"
              ],
              path: "../dressupDetail/main"
            },
            {
              name: "A爆的丧甜-音乐节妆容",
              images: [
                "https://i.loli.net/2019/05/29/5cee40c4b385f64368.png",
                "https://i.loli.net/2019/05/29/5cee40c5298b299050.png",
                "https://i.loli.net/2019/05/29/5cee40c52c61c23852.png"
              ],
              path: "../dressupDetail/main"
            },
          ]
        },
        {
          name: "妆品推荐",
          images: [
            {
              url: "https://i.loli.net/2019/05/29/5cee3f78e138834786.jpg"
            },
            {
              url: "https://i.loli.net/2019/05/29/5cee3f78e644247723.jpg"
            },
            {
              url: "https://i.loli.net/2019/05/29/5cee3f78f2b3512871.jpg"
            },
            {
             url: "https://i.loli.net/2019/05/29/5cee3f790821b16212.jpg"
            }
          ],
          elements: [
            {
              imageUrl: "https://i.loli.net/2019/05/29/5cee412ee685d45610.png",
              name: "安耐晒小金瓶 ¥220",
              descri: "防晒首选No.1的当然是号称’晒不黑'的安耐晒小金瓶！",
              path: "../cosmeticDetail/main"
            },
            {
              imageUrl: "https://i.loli.net/2019/05/29/5cee412f56daf84076.png",
              name: "Canmake花瓣腮红 ¥77",
              descri: "立体五色花瓣浮雕特别精美，自带腮红刷，上脸颜色是淡淡的非常自然的效果，显得很有气色。新手也不担心会涂成猴子脸！",
              path: "../cosmeticDetail/main"
            },
            {
              imageUrl: "https://i.loli.net/2019/05/29/5cee412f4d9f189266.png",
              name: "Kissme眼线液笔 ¥54",
              descri: "可以不会那些复杂的眼妆，但内眼线一定要学会。眼线到底怎么画",
              path: "../cosmeticDetail/main"
            },
            {
							
              imageUrl: "https://i.loli.net/2019/05/29/5cee412f4bc7a31616.png",
              name: "CPB长管隔离价格 ¥389",
              descri: "。隔离霜是肌肤防护外部污染和伤害的重要防护层。大品牌、口碑好、使用效果好！隔离轻薄水润，上脸柔滑好推！",
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