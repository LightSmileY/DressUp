<template>
  <div class="dymamic">
    <div v-for="item in 3" class="dymamicList">
      <!-- 用户信息及关注按钮 -->
      <div class="user-info">
        <img src="@/assets/img/header.jpg" alt="头像" class="header">
        <div class="name-time">
          <div class="userName">浅笑半离兮</div>
          <div class="publishTime">今天12:30</div>
        </div>
        <button class="attent">关注TA</button>
      </div>
      <!-- 帖子内容 -->
      <div class="mainDymamic">
        <span class="title">#妆容分享#</span>
        <p class="message">这是我的新妆容~分享给小伙伴们~</p>
        <div class="images">
          <img v-for="image in imageList" :src="image" @click="open($event)"/>
        </div>
      </div>
      <!-- 点赞、收藏、转发 -->
      <div class="operate">
        <div class="like">
          <img src="@/assets/icon/like.png" alt="点赞">
          <span class="count">22</span>
        </div>
        <div class="collection">
          <img src="@/assets/icon/collection.png" alt="关注">
          <span class="count">33</span>
        </div>
        <div class="share">
          <img src="@/assets/icon/share.png" alt="收藏">
          <span class="count">11</span>
        </div>
      </div>
      <!-- 评论 -->
      <div class="comments">
        <div class="comment" v-for="items in 3">
          <span class="userName">浅笑</span>:&nbsp;
          <span class="content">嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻</span>
        </div>
        <textarea name="" id="coInput" rows="3" placeholder="我也要评论···"></textarea>
        <button class="toComment">发表</button>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'App',
    data(){
      return{
        imageList: [
          "@/assets/img/test.jpg",
          "@/assets/img/test.jpg",
          "@/assets/img/test.jpg"
        ]
      }
    },
    props: {
      arrayList: Array
    },
    methods: {
      open (e) {
        fancyBox(e.target, this.imageList);
      },
      // 关注
      toAttent(i){
        if(this.dynamics[i].attent == "关注TA"){
          this.dynamics[i].attent = "已关注";
          //调用接口
        }
        else{
          this.newDynamics[i].attent = "关注TA";
        }
      },
      //点赞
      toLike(i){
        if(this.like == false){
          this.like = true;
          this.newDynamics[i].icon_like = "../../static/icon/like-active.png";
          this.newDynamics[i].like += 1;
        }
        else{
          this.like = false;
          this.newDynamics[i].icon_like = "../../static/icon/like.png";
          this.newDynamics[i].like -= 1;
        }
      },
      //收藏
      toCollection(i){
        if(this.collection == false){
          this.collection = true;
          this.newDynamics[i].icon_collection = "../../static/icon/collection-active.png";
          this.newDynamics[i].collection += 1;
        }
        else{
          this.collection = false;
          this.newDynamics[i].icon_collection = "../../static/icon/collection.png";
          this.newDynamics[i].collection -= 1;
        }
      },
      //转发
      toForward(){
        
      }
    },
    props: {
      arrayList: Array
    },
    beforeMount(){
      
    }
  };
</script>

<style lang="scss">
  @import "../../assets/scss/dymamic";
</style>