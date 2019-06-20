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
      getMyPosts(){
        let _this = this;
        _this.$fly.get('http://106.14.46.10:8081/MakeupYou/post/findPostByUid',_this.$qs.stringify({
            userID: _this.$store.state.openId
          })
        )
        .then(function (response) {
          console.log(response);
          _this.newDynamics = response.data.reverse();
          _this.entries[0].count = _this.newDynamics.length;
          console.log("成功获取帖子列表长度" + _this.entries[0].count);
        })
        .catch(function (error) {
          console.log(error);
        })
      },
      getMyFocus(){
        let _this = this;
        // 获取我的所有关注
        _this.$fly.get('http://106.14.46.10:8081/MakeupYou/relation/findFollows',_this.$qs.stringify({
            userID: _this.$store.state.openId
          })
        )
        .then(function (response) {
          console.log(response);
          _this.attentions = response.data;
          _this.entries[1].count = _this.attentions.length;
          console.log("获取我的粉丝列表长度为" + _this.entries[1].count);
        })
        .catch(function (error) {
          console.log(error);
        });
      },
      getMyFans(){
        let _this = this;
        // 获取我的所有关注
        _this.$fly.get('http://106.14.46.10:8081/MakeupYou/relation/findFans',_this.$qs.stringify({
            userID: _this.$store.state.openId
          })
        )
        .then(function (response) {
          console.log(response);
          _this.fans = response.data;
          _this.entries[2].count = _this.attentions.length;
          console.log("获取我的粉丝列表长度为" + _this.entries[2].count);
        })
        .catch(function (error) {
          console.log(error);
        });
      }
    },
    onShow(){
      this.myInfo.avatarUrl = this.$store.state.myWxInfo.avatarUrl;
      this.myInfo.nickName = this.$store.state.myCosInfo.name;
      this.myInfo.description = this.$store.state.myCosInfo.description;
      this.entries = [
        {
          count: 0,
          path: "../myPosts/main",
          theme: "帖子"
        },
        {
          count: 0,
          path: "../myFocus/main",
          theme: "关注"
        },
        {
          count: 0,
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
          icon: "../../static/icon/like.png",
          theme: "我的点赞",
          path: "../myLike/main",
          front: "../../static/icon/front.png"
        },
        {
          icon: "../../static/icon/collection.png",
          theme: "我的收藏",
          path: "../myCollection/main",
          front: "../../static/icon/front.png"
        }
      ]; 
      this.getMyPosts();
      this.getMyFocus();
      this.getMyFans();
    },
    beforeMount(){
      
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