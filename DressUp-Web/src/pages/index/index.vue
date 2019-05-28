<template>
  <div class="container">
    <div class="masker" v-if="coment" @click="remove"></div>
    <div class="mask-item"></div>
    <div class="main">
      <!-- <Search></Search> -->
      <!-- <SwitchBar :arrayList = "switches"></SwitchBar> -->
      <div class="content">
        <div class="navbar">
          <div v-for="(item,index) in tabs" :key="index" :id="index" :class="{'navbar_item_on':activeIndex == index}" class="navbar_item" @click="tabClick">
            <div class="navbar_title">{{item.name}}</div>
          </div>
          <div class="navbar_slider" :class="navbarSliderClass"></div>
        </div>
        <div>
          <!-- tag分页 -->
          <div :hidden="activeIndex != 0">
            <!-- *******************************************最新消息*************************************** -->
            <div class="dymamicList">
              <ul>
                <li v-for="(dymamic,index) in newDynamics" :key="index" wx:for-index="hello" class="dymamicList-li" >
                  <div class="user">
                    <img :src="dymamic.userHeadURL" class="user-header"/>
                    <div class="name-time">
                      <div class="name">{{dymamic.userName}}</div>
                      <div class="time">{{dymamic.publishTime}}</div>
                    </div>
                  </div>
                  <p class="content">{{dymamic.content}}</p>
                  <div class="images">
                    <img v-for="(image,index1) in dymamic.images" :key="index1" class="image" @click="previewImg(index,index1)" :src="image"/>
                  </div>
                  <div class="icons">
                    <div class="forward">
                      <img class="forward-image" :src="dymamic.icon_forward"  @click="toForward(index)">
                      <span>{{dymamic.forward}}</span>
                    </div>
                    <div class="cllection" @click="toCollection1(index)">
                      <img :src="dymamic.icon_collection">
                      <span>{{dymamic.collection}}</span>
                    </div>
                    <div class="like" @click="toLike1(index)">
                      <img :src="dymamic.icon_like">
                      <span>{{dymamic.like}}</span>
                    </div>
                  </div>
                  <div class="comment">
                    <ul class="comment-ul">
                      <li class="comment-li" v-for="(comment, index2) in dymamic.comments" :key="index2">
                        <span class="username">{{comment.userName}}</span>：
                        <span class="content">{{comment.content}}</span>
                      </li>
                    </ul>
                    <button class="toComent" @click="toComent">我也要评论</button>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div :hidden="activeIndex != 1">
            <!-- *******************************************热门消息*************************************** -->
            <div class="dymamicList">
              <ul>
                <li v-for="(dymamic,index) in hotDynamics" :key="index" class="dymamicList-li" >
                  <div class="user">
                    <img :src="dymamic.userHeadURL" class="user-header"/>
                    <div class="name-time">
                      <div class="name">{{dymamic.userName}}</div>
                      <div class="time">{{dymamic.publishTime}}</div>
                    </div>
                  </div>
                  <p class="content">{{dymamic.content}}</p>
                  <div class="images">
                    <img v-for="(image,index1) in dymamic.images" :key="index1" class="image" @click="previewImg(index,index1)" :src="image"/>
                  </div>
                  <div class="icons">
                    <div class="forward">
                      <img class="forward-image" :src="dymamic.icon_forward" @click="toForward(index)">
                      <span>{{dymamic.forward}}</span>
                    </div>
                    <div class="cllection" @click="toCollection2(index)">
                      <img :src="dymamic.icon_collection">
                      <span>{{dymamic.collection}}</span>
                    </div>
                    <div class="like" @click="toLike2(index)">
                      <img :src="dymamic.icon_like">
                      <span>{{dymamic.like}}</span>
                    </div>
                  </div>
                  <div class="comment">
                    <ul class="comment-ul">
                      <li class="comment-li" v-for="(comment, index2) in dymamic.comments" :key="index2">
                        <span class="username">{{comment.userName}}</span>：
                        <span class="content">{{comment.content}}</span>
                      </li>
                    </ul>
                    <button class="toComent" @click="toComent">我也要评论</button>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <Publish></Publish>
    </div>
    <!-- 评论框 -->
    <div class="coment" v-if="coment">
      <textarea autofocus="autofocus" rows="6"></textarea>
      <button @click="toPublish">发表</button>
    </div>
  </div>
</template>

<script>

  import Search from "@/components/search"
  import SwitchBar from "@/components/switch"
  import Publish from "@/components/publish"

  const newDynamics_URL = 'http://10.100.200.250:8081/MakeupYou/post/findAllPostMessages';

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
        activeIndex: 0,
        icon_like: "",
        icon_collection: "",
        icon_forward: "",
        like1: false,
        collection1: false,
        like2: false,
        collection2: false,
        coment: false
      }
    },
    components:{
      // Search,
      // SwitchBar,
      Publish
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
      // 点击评论按钮
      toComent(){
        this.coment = !this.coment;
      },
      //点击遮罩层
      remove(){
        this.coment = !this.coment;
      },
      // 发表评论
      toPublish(){
        setTimeout(function(){
          wx.showToast({
            title:'已评论！',
            icon:'success',
            duration: 1000
          })
        },500)
        this.coment = !this.coment;
      },
      tabClick(e) {
        this.activeIndex = e.currentTarget.id;
      },
      toLike1(i){
        if(this.like1 == false){
          this.like1 = true;
          this.newDynamics[i].icon_like = "../../static/icon/like-active.png";
          this.newDynamics[i].like += 1;
        }
        else{
          this.like1 = false;
          this.newDynamics[i].icon_like = "../../static/icon/like.png";
          this.newDynamics[i].like -= 1;
        }
      },
      toCollection1(i){
        if(this.collection1 == false){
          this.collection1 = true;
          this.newDynamics[i].icon_collection = "../../static/icon/collection-active.png";
          this.newDynamics[i].collection += 1;
        }
        else{
          this.collection1 = false;
          this.newDynamics[i].icon_collection = "../../static/icon/collection.png";
          this.newDynamics[i].collection -= 1;
        }
      },
      toLike2(i){
        if(this.like2 == false){
          this.like2 = true;
          this.hotDynamics[i].icon_like = "../../static/icon/like-active.png";
          this.hotDynamics[i].like += 1;
        }
        else{
          this.like2 = false;
          this.hotDynamics[i].icon_like = "../../static/icon/like.png";
          this.hotDynamics[i].like -= 1;
        }
      },
      toCollection2(i){
        if(this.collection2 == false){
          this.collection2 = true;
          this.hotDynamics[i].icon_collection = "../../static/icon/collection-active.png";
          this.hotDynamics[i].collection += 1;
        }
        else{
          this.collection2 = false;
          this.hotDynamics[i].icon_collection = "../../static/icon/collection.png";
          this.hotDynamics[i].collection -= 1;
        }
      },
      toForward(){
        wx.showModal({
          title: '提示',
          content: '确认要转发帖子吗？',
          success: function (sm) {
            if (sm.confirm) {
              console.log('转发成功')
              setTimeout(function(){
                wx.showToast({
                  title:'转发成功！',
                  icon:'success',
                  duration: 2000
                })
              },1000)
            } else if (sm.cancel) {
              console.log('用户取消转发')
            }
          }
        })
      },
      previewImg(i,j){
        wx.previewImage({
          current: this.newDynamics[i].images[j],
          urls: this.newDynamics[i].images
        });
      }
    },
    beforeMount(){
      
      // this.$fly.get(newDynamics_URL)
      //   .then( (response) => {
      //     console.log(response);
      //     newDynamics = response.data.subjects
      //     console.log(newDynamics);
      //   })
      //   .catch( (error) => {
      //     console.log(error);
      //   });
    },
    mounted(){
      this.switches = ["最新", "热门"];
      this.newDynamics = [
        {
          userHeadURL: "../../static/assets/images/1.jpg",
          userName: "袁乾峰",
          publishTime: "今天12:20",
          content: "自由的本质不是放纵自己，不是无所不为，而是自律后的舒畅，是有所为，有所不为。",
          images: [
            "../../static/assets/images/2.jpg",
            "../../static/assets/images/2.jpg",
            "../../static/assets/images/2.jpg"
          ],
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 42,
          collection: 15,
          forward: 12,
          //评论列表
          comments: [
            {
              userName: '张凤云',
              content: '好哒好哒好哒好哒好哒好哒'
            },
            {
              userName: '杨伟艺',
              content: '麻油麻油麻油麻油麻油麻油麻油麻油麻油'
            },
            {
              userName: '胡健龙',
              content: '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈'
            }
          ]
        },
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
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 66,
          collection: 38,
          forward: 24,
          //评论列表
          comments: [
            {
              userName: '张凤云',
              content: '好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒'
            },
            {
              userName: '杨伟艺',
              content: '麻油麻油麻油麻油麻油麻油麻油麻油麻油'
            },
            {
              userName: '袁乾峰',
              content: '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈'
            }
          ]
        },
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
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 66,
          collection: 38,
          forward: 24,
          //评论列表
          comments: [
            {
              userName: '张凤云',
              content: '好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒'
            },
            {
              userName: '杨伟艺',
              content: '麻油麻油麻油麻油麻油麻油麻油麻油麻油'
            },
            {
              userName: '袁乾峰',
              content: '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈'
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
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 66,
          collection: 38,
          forward: 24,
          //评论列表
          comments: [
            {
              userName: '张凤云',
              content: '好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒'
            },
            {
              userName: '杨伟艺',
              content: '麻油麻油麻油麻油麻油麻油麻油麻油麻油'
            },
            {
              userName: '袁乾峰',
              content: '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈'
            }
          ]
        }
      ];
    }
  };
</script>

<style scoped>
  /*----------------------整个页面-----------------------  */
  .container{
    margin: 0;
    padding: 0;
    background-color: #fff;
  }
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
  /*----------------------顶部栏-----------------------  */
  .mask-item{
    position: fixed;
    top: 0;
    width: 100%;
    height: 40px;
    background-color: #fff;
    z-index: 100;
    box-shadow: 0 3px 5px #E9E9E9;
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

  .dymamicList-li{
    position: relative;
    top: 40px;
    padding: 15px 0;
    border-bottom: 1px solid #D3D3D3;
  }
  .dymamicList-li:last-child{
    border: none;
  }
  .user{
    width: 100%;
    height: 35px;
  }
  .user-header{
    width: 35px;
    height: 35px;
    margin: 0 10px 0 0;
    background-color: #FFBABA;
    border: 1px solid #DADADA;
    border-radius: 50%;
    float: left;
  }
  .name-time{
    height: 35px;
    float: left;
  }
  .name-time .name{
    height: 20px;
    font-size: 14px;
    line-height: 20px;
  }
  .name-time .time{
    height: 15px;
    font-size: 10px;
  }
  .content{
    font-size: 14px;
    margin: 5px 0;
  }
  .images{
    display: flex;
    flex-wrap: wrap;
  }
  .images .image{
    width: 31.333%;
    height: 28vw;
    margin: 1%;
    overflow: hidden;
    float: left;
  }
  .icons{
    height: 30px;
    margin-top: 5px;
    font-size: 14px;
    line-height: 25px;
    text-align: center;
  }
  .icons div{
    height: 20px;
    float: right;
    margin-right: 15px;
  }
  .icons div img{
    width: 22px;
    height: 22px;
  }
  .icons .forward .forward-image{
    width: 18px;
    height: 18px;
    margin-top: 3px;
  }
  .icons div span{
    width: 35px;
    height: 22px;
    font-size: 13px;
    line-height: 22px;
    position: relative;
    top: -5px;
    margin-left: 2px;
    overflow: hidden;
  }
  .icons .forward span{
    position: relative;
    top: -2px;
  }
  .comment{
    font-size: 13px;
  }
  .comment-li{
    line-height: 16px;
    margin: 5px;
  }
  .comment li .username{
    color: #12AADE;
  }
  .comment li .content{
    font-size: 13px
  }
  .comment .toComent{
    height: 30px;
    margin-bottom: 5px;
    margin-top: 10px;
    border: 1px solid #FFC1BB;
    border-radius: 5px;
    text-align: center;
    font-size: 14px;
    line-height: 30px;
    background-color: #fff;
  }
  .comment .toComent:active{
    background-color: #FFEDEB;
  }
  /* .mask {
    position: fixed;
    width: 100vw;
    height: 100vh;
    background-color: rgba(0, 0, 0, 0.3)
  } */
  .coment {
    position: fixed;
    top: 20vh;
    left: 50%;
    margin-left: -40vw;
    width: 80%;
    height: 180px;
    border: 1px solid #B2B2B2;
    border-radius: 10px;
    background-color: #fff;
    z-index: 9999999;
  }
  .coment textarea {
    position: relative;
    width: 68vw;
    height: 110px;
    margin: 15px 4vw 0;
    padding: 5px 2vw;
    border: 1px solid #E4E4E4;
    font-size: 15px;
    z-index: 99999999;
  }
  .coment button {
    width: 72vw;
    height: 28px;
    margin-top: 7px;
    font-size: 14px;
    line-height: 28px;
    background-color: #FFD4D4;
  }
  .coment button:active {
    background-color: #FFB5B5;
  }
  .masker{
    position: fixed;
    width: 100vw;
    height: 100vh;
    background-color: rgba(0, 0, 0, 0.2);
    z-index: 999999;
    margin: 0;
    padding: 0;
  }
</style>