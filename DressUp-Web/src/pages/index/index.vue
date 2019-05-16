<template>
  <div class="container">
    <div class="mask"></div>
    <div class="main">
      <!-- <Search></Search> -->
      <!-- <SwitchBar :arrayList = "switches"></SwitchBar> -->
      
      <!-- 顶部tag切换 -->
      
      <div class="content">
        <div class="navbar">
          <div v-for="(item,index) in tabs" :key="index" :id="index" :class="{'navbar_item_on':activeIndex == index}" class="navbar_item" @click="tabClick">
            <div class="navbar_title">{{item.name}}</div>
          </div>
          <div class="navbar_slider" :class="navbarSliderClass"></div>
        </div>
        <div>
          <!-- 每一个tag分页 -->
          <div :hidden="activeIndex != 0">
            <DynamicList :arrayList = "newDynamics"></DynamicList>
          </div>
          <div :hidden="activeIndex != 1">
            <DynamicList :arrayList = "hotDynamics"></DynamicList>
          </div>
        </div>
      </div>
      <Publish></Publish>
    </div>
  </div>
</template>

<script>
import Search from "@/components/search"
import SwitchBar from "@/components/switch"
import Publish from "@/components/publish"
import DynamicList from "@/components/DynamicList"

export default {
  data () {
    return {
      // switches: [],
      newDynamics:[],
      hotDynamics: [],
      tabs: [
          {
            name: "最新",
            type: "1",
            checked: true
          },
          {
            name: "热门",
            type: "2",
            checked: true
          }
        ],
        activeIndex: 0
    }
  },
  components:{
    // Search,
    // SwitchBar,
    Publish,
    DynamicList
  },
  computed: {
    navbarSliderClass() {
      if (this.activeIndex == 0) {
        return "navbar_slider_0";
      }
      if (this.activeIndex == 1) {
        return "navbar_slider_1";
      }
    }
  },
  methods: {
    tabClick(e) {
      this.activeIndex = e.currentTarget.id;
    }
  },
  mounted(){
    // this.switches = ["最新", "热门"];
    this.newDynamics = [
      {
        userHeadURL: "../../static/assets/images/1.jpeg",
        userName: "浅笑半离兮",
        publishTime: "今天12:20",
        content: "自由的本质不是放纵自己，不是无所不为，而是自律后的舒畅，是有所为，有所不为。",
        images: [
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg"
        ],
        like: 20,
        collection: 8,
        forward: 15,
        //评论列表
        comments: [
          {
            userName: '张凤云',
            content: '好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒'
          },
          {
            userName: '杨伟艺',
            content: '麻油麻油麻油麻油麻油麻油麻油麻油麻油麻油麻油麻油麻油麻油'
          },
          {
            userName: '胡健龙',
            content: '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈'
          }
        ]
      }
    ];
    this.hotDynamics = [
      {
        userHeadURL: "../../static/assets/images/1.jpeg",
        userName: "胡健龙",
        publishTime: "今天12:20",
        content: "活在当下",
        images: [
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg",
          "../../static/assets/images/2.jpg"
        ],
        like: 66,
        collection: 38,
        forward: 24,
        //评论列表
        comments: [
          {
            userName: '张凤云',
            content: '好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒'
          },
          {
            userName: '杨伟艺',
            content: '麻油麻油麻油麻油麻油麻油麻油麻油麻油麻油麻油麻油麻油麻油'
          },
          {
            userName: '袁乾峰',
            content: '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈'
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
    width: 90%;
    margin: 0 auto;
  }
  .content {
    box-sizing: border-box;
    margin-top: 41px;
    -webkit-overflow-scrolling: touch;
  }
  .mask{
    position: fixed;
    top: 0;
    width: 100%;
    height: 40px;
    background-color: #fff;
    z-index: 100;
  }
  .swiper-item {
    height: 100%;
    text-align: center;
  }
  .navbar {
    position: relative;
    left: 50%;
    margin-left: -80px;
    display: -webkit-box;
    display: -webkit-flex;
    display: flex;
    position: fixed;
    z-index: 500;
    top: 0;
    padding-bottom: 0;
    height: 40px;
    width: 160px;
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
    width: 40%;
    height: 4px;
    background-color: #FFAEAE;
    -webkit-transition: -webkit-transform 0.3s;
    transition: -webkit-transform 0.3s;
    transition: transform 0.3s;
    transition: transform 0.3s, -webkit-transform 0.3s;
  }

  .navbar_slider_0 {
    left: 5%;
    transform: translateX(0);
  }

  .navbar_slider_1 {
    left: 5%;
    transform: translateX(125%);
  }
</style>