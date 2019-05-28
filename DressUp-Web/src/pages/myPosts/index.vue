<template>
  <div class="myPosts">
    <div class="masker" v-if="coment" @click="remove"></div>
    <div class="main">
      <div class="dymamicList">
        <ul>
          <li v-for="(dymamic,index) in myDynamics" :key="index" wx:for-index="hello" class="dymamicList-li" >
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
              <div class="forward" @click="toForward">
                <img class="forward-image" :src="dymamic.icon_forward">
                <span>{{dymamic.forward}}</span>
              </div>
              <div class="cllection" @click="toCollection(index)">
                <img :src="dymamic.icon_collection">
                <span>{{dymamic.collection}}</span>
              </div>
              <div class="like" @click="toLike(index)">
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
    <!-- 评论框 -->
    <div class="coment" v-if="coment">
      <textarea autofocus="autofocus" rows="6"></textarea>
      <button @click="toPublish">发表</button>
    </div>
  </div>
</template>

<script>

  export default{
    data () {
      return {
        myDynamics: [],
        activeIndex: 0,
        icon_like: "",
        icon_collection: "",
        like: false,
        collection: false,
        coment: false
      }
    },
    components:{
      
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
      toLike(i){
        if(this.like == false){
          this.like = true;
          this.myDynamics[i].icon_like = "../../static/icon/like-active.png";
          this.myDynamics[i].like += 1;
        }
        else{
          this.like = false;
          this.myDynamics[i].icon_like = "../../static/icon/like.png";
          this.myDynamics[i].like -= 1;
        }
      },
      toCollection(i){
        if(this.collection == false){
          this.collection = true;
          this.myDynamics[i].icon_collection = "../../static/icon/collection-active.png";
          this.myDynamics[i].collection += 1;
        }
        else{
          this.collection = false;
          this.myDynamics[i].icon_collection = "../../static/icon/collection.png";
          this.myDynamics[i].collection -= 1;
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
          current: this.myDynamics[i].images[j],
          urls: this.myDynamics[i].images
        });
      }
    },
    mounted(){
      this.myDynamics = [
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
            "../../static/assets/images/2.jpg"
          ],
          like: 20,
          collection: 8,
          forward: 15,
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          //评论列表
          comments: [
            {
              userName: '张凤云',
              content: '好哒好哒好哒好哒好哒'
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
  .dymamicList-li{
    position: relative;
    top: 0;
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