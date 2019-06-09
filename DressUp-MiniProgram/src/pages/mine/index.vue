<template>
  <div class="mine">
    <div class="myInfo">
      <!-- 用户信息 -->
      <div class="user">
        <div class="image">
          <img :src="myInfo.avatarUrl">
        </div>
        <div class="userName">{{myInfo.nickName}}</div>
        <div class="signature">{{myInfo.description}}</div>
      </div>
      <!-- 我的帖子、关注、粉丝 -->
      <div class="entry">
        <div v-for="(item,index) in entries" :key="index" @click="itemClick(item)">
          <div class="count">{{item.count}}</div>
          <div class="theme">{{item.theme}}</div>
        </div>
      </div>
    </div>
    <!-- 我的资料、收藏 -->
    <Navi :arrayList="navis"></Navi>
  </div>
</template>

<script>
  import Navi from "@/components/nav"


  const appId="wx3f1f623fc2ee0247"   //开发者appid
  const secret="ba99bfbbd14208328d7939dedadfcf96"  //开发者AppSecret(小程序密钥)

  export default{
    data () {
      return {
        navis: [],
        myInfo: {},
        entries: [],
        userName:""
      }
    },
    components:{
      Navi
    },
    methods: {
      itemClick(e) {
        wx.navigateTo({url: e.path})
      },
    },
    beforeMount(){
      this.myInfo.avatarUrl = this.$store.state.myWxInfo.avatarUrl;
      this.myInfo.nickName = this.$store.state.myWxInfo.nickName;
      this.myInfo.description = this.$store.state.myCosInfo.description;
      

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
          icon: "../../static/icon/collection.png",
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
  .ceng button{
    width: 90%;
    height: 40px;
    margin: 15px auto;
    background-color: #FFBDBD;
    border: none;
    outline: none;
    font-size: 18px;
    line-height: 40px;
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
    width: 60%;
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