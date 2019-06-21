<template>
  <div class="main">
    <ul class="like-ul">
      <navigator :url="item.path" v-for="(item,index) in likes" class="like-li" :key="index">
        <div class="user">
          <img :src="item.post.userHeadURL" class="user-header"/>
          <div class="name-time">
            <div class="name">{{item.userName}}</div>
            <div class="time">{{item.time}}</div>
          </div>
          <p>详情</p>
        </div>
        <div class="content">
          <span>赞了我的帖子</span>
        </div>
        <div class="image">
          <img :src="item.post.images[0]">
        </div>
        <div class="info">
            <span>#{{item.post.title}}#</span>
            <p>{{item.post.content}}</p>
        </div>
      </navigator>
    </ul>
  </div>
</template>

<script>

  export default{
    data () {
      return {
        likes: []
      }
    },
    methods: {

    },
    beforeMount(){
      let _this = this;
      // 获取点赞我的
      _this.$fly.get('http://106.14.46.10:8081/MakeupYou/appService/getLikesMe',_this.$qs.stringify({
          userID: _this.$store.state.openId
        })
      )
      .then(function (response) {
        console.log(response);
        _this.likes = response.data.reverse();
        console.log("获取所有点赞我的人成功！");
      })
      .catch(function (error) {
        console.log(error);
      });
    },
    mounted(){
      // this.likes = [
      //   {
      //     userName: "fukami",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee439e139d882897.jpg",
      //     publishTime: "今天22:03",
      //     content: "赞了我的帖子",
      //     imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
      //     descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
      //     path: "../dymamicDetail/main"
      //   },
      //    {
      //     userName: "xiaozhang",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee439e4d56441446.jpg",
      //     publishTime: "今天22:00",
      //     content: "赞了我的帖子",
      //     imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
      //     descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
      //     path: "../dymamicDetail/main"
      //   },
      //    {
      //     userName: "luckly",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee439de2bf083812.jpg",
      //     publishTime: "今天21:32",
      //     content: "赞了我的帖子",
      //     imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
      //     descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
      //     path: "../dymamicDetail/main"
      //   },
      //    {
      //     userName: "comments",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee439e648ae25933.jpg",
      //     publishTime: "今天21:24",
      //     content: "赞了我的帖子",
      //     imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
      //     descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
      //     path: "../dymamicDetail/main"
      //   },
      //    {
      //     userName: "🈯️唧唧",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee439e922c222589.jpg",
      //     publishTime: "今天20:20",
      //     content: "赞了我的帖子",
      //     imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
      //     descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
      //     path: "../dymamicDetail/main"
      //   }
      // ]
    }   
  };
</script>

<style scoped>
  .main{
    position: relative;
    width: 90%;
    margin: 0 auto;
  }
  .like-li{
    width: 100%;
    border: 1px solid #CBCBCB;
    border-radius: 8px;
    margin: 15px 0;
    overflow: hidden;
  }
  .user{
    width: 100%;
    margin: 8px 0;
    overflow: hidden;
  }
  .user img{
    width: 35px;
    height: 35px;
    margin: 0 10px 0 8px;
    background-color: #FFBABA;
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
  .user p{
    color: #1B5EA0;
    font-size: 13px;
    float: right;
    margin-right: 10px;
  }
  .content{
    width: 94%;
    margin: 0 auto;
    font-size: 13px;
  }
  span:first-child{
    margin-right: 3px;
  }
  .image{
    width: 23vw;
    height: 23vw;
    float: left;
  }
  img{
    width: 80%;
    height: 80%;
    margin: 10%;
  }
  .info{
    width: 63vw;
    height: 17vw;
    float: right;
    margin: 10px 10px 10px 0;
    font-size: 12px;
  }
  .price{
    width: 95%;
    height: 9vw;
    margin: 0 auto;
  }
  .price span{
    font-size: 22px;
    line-height: 9vw;
    color: #f00;
    float: left;
  }
</style>