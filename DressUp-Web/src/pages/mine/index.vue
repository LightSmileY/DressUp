<template>
  <div class="mine">
    <div class="myInfo">
      <div class="user">
        <div class="image">
          <img :src="myInfo.image">
        </div>
        <div class="userName">{{myInfo.name}}</div>
        <div class="signature">{{myInfo.signature}}</div>
      </div>
      <div class="entry">
        <div v-for="(item,index) in entries" :key="index" @click="itemClick(item)">
          <div class="count">{{item.count}}</div>
          <div class="theme">{{item.theme}}</div>
        </div>
      </div>
    </div>
    <Navi :arrayList="navis"></Navi>   <!-- 我的资料，我的收藏 -->
  </div>
</template>

<script>
  import Navi from "@/components/nav"

  export default{
    data () {
      return {
        navis: [],
        myInfo: {},
        entries: []
      }
    },
    components:{
      Navi
    },
    methods: {
      itemClick(e) {
        wx.navigateTo({url: e.path})
      }
    },
    mounted(){
      this.myInfo = {
          image: "../../static/assets/images/1.jpeg",
          name: "浅笑半离兮",
          signature: "哈哈哈哈哈哈哈哈哈哈或或或或或或或或或或或哈哈哈哈哈哈哈哈哈哈或或或或或或"
      };
      this.entries = [
        {
          count: 24,
          path: "../myPosts/main",
          theme: "帖子"
        },
        {
          count: 9,
          path: "../myFocus/main",
          theme: "关注"
        },
        {
          count: 32,
          path: "../myFans/main",
          theme: "粉丝"
        }
      ];
      this.navis = [
        {
          icon: "../../static/icon/info.png",
          path: "../userInfo/main",
          theme: "我的资料",
          front: "../../static/icon/front.png"
        },
        {
          icon: "../../static/icon/cllection.png",
          theme: "我的收藏",
          path: "../myCollection/main",
          front: "../../static/icon/front.png"
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
  .myInfo{
    height: 145px;
    margin-bottom: 20px;
    border-bottom: 1px solid #E2E2E2;
  }
  .user{
    height: 85px;
  }
  .image{
    width: 55px;
    height: 55px;
    margin: 15px;
    float: left;
  }
  img{
    width: 100%;
    height: 100%;
    border-radius: 50%;
    border: 1px solid #D7D7D7;
  }
  .userName{
    font-size: 16px;
    margin-top: 15px;
    float: left;
  }
  .signature{
    width: 250px;
    height: 30px;
    font-size: 10px;
    margin-top: 8px;
    float: left;
  }
  .entry{
    height: 60px;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
    color: #646464;
  }
  .entry > div{
    flex-grow: 1;
  }
  .count{
    font-size: 14px;
    margin-bottom: 4px;
  }
  .theme{
    font-size: 16px;
  }
</style>