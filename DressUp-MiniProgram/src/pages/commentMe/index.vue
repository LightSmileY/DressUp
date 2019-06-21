<template>
  <div class="main">
    <ul class="like-ul">
      <navigator :url="item.path" v-for="(item,index) in comments" class="like-li" :key="index">
        <div class="user">
          <img :src="item.post.userHeadURL" class="user-header"/>
          <div class="name-time">
            <div class="name">{{item.userName}}</div>
            <div class="time">{{item.time}}</div>
          </div>
          <p>详情</p>
        </div>
        <div class="content">
          <span>评论了我:&nbsp;{{item.comment}}</span>
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
        comments: []
      }
    },
    methods: {

    },
    beforeMount(){
      let _this = this;
      // 获取点赞我的
      _this.$fly.get('http://106.14.46.10:8081/MakeupYou/appService/getCommentsMe',_this.$qs.stringify({
          userID: _this.$store.state.openId
        })
      )
      .then(function (response) {
        console.log(response);
        _this.comments = response.data.reverse();
        console.log("获取所有评论我的人成功！");
      })
      .catch(function (error) {
        console.log(error);
      });
    },
    mounted(){
      // this.comments = [
      //   {
      //     userName: "。。",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee76ea7d01d81579.jpg",
      //     publishTime: "今天21:23",
      //     content: "学到啦",
      //     imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
      //     descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
      //     path: "../dymamicDetail/main"
      //   },
      //     {
      //     userName: "haphap",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee76ea7043315018.png",
      //     publishTime: "今天20:01",
      //     content: "果然好用",
      //     imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
      //     descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
      //     path: "../dymamicDetail/main"
      //   },
      //     {
      //     userName: "往日夕",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee76e9eef3759817.jpg",
      //     publishTime: "今天19:53",
      //     content: "啦啦啦👩‍❤️‍👩",
      //     imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
      //     descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
      //     path: "../dymamicDetail/main"
      //   },
      //     {
      //     userName: "百事可可",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee76a17897f93356.jpg",
      //     publishTime: "今天19:23",
      //     content: "看到你的效果啦",
      //     imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
      //     descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
      //     path: "../dymamicDetail/main"
      //   },
        
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