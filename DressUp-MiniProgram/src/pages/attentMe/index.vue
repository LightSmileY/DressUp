<template>
  <div class="main">
    <div class="user" v-for="(item,index) in attentions" :key="index">
      <img :src="item.avatarID" class="user-header"/>
      <div class="name-time">
        <div class="name">{{item.name}}</div>
        <div class="time">{{item.last_login_time}}</div>
      </div>
      <div class="theme">关注了我</div>
    </div>
  </div>
</template>

<script>

  export default{
    data () {
      return {
        attentions: []
      }
    },
    components:{
      
    },
    methods: {

    },
    beforeMount(){
      let _this = this;
      // 获取我的所有关注
      _this.$fly.get('http://106.14.46.10:8081/MakeupYou/relation/findFans',_this.$qs.stringify({
          userID: _this.$store.state.openId
        })
      )
      .then(function (response) {
        console.log(response);
        _this.attentions = response.data.reverse();
        console.log("获取我的粉丝成功！");
      })
      .catch(function (error) {
        console.log(error);
      });
    },
    mounted(){
      // this.attentions = [
      //   {
      //     userName: "变强er",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee76a0ae99773032.jpg",
      //     publishTime: "今天17:12"
      //   },
      //   {
      //     userName: "fukami",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee76a0dd0d687179.jpg",
      //     publishTime: "今天16:22"
      //   },
      //   {
      //     userName: "淡然",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee76a14048519661.jpg",
      //     publishTime: "今天16:13"
      //   },
      //   {
      //     userName: "follow",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee7486033c023192.png",
      //     publishTime: "今天15:33"
      //   },
      //   {
      //     userName: "达萨达",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee7485269f927974.jpg",
      //     publishTime: "今天12:03"
      //   },
      //   {
      //     userName: "fggg",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee74853f4ee44021.jpg",
      //     publishTime: "今天12:12"
      //   },
      //   {
      //     userName: "sf奋斗",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee7486003dc40409.png",
      //     publishTime: "今天11:43"
      //   },
      //   {
      //     userName: "fo的多",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee74854b9c265027.jpg",
      //     publishTime: "今天10:33"
      //   },
      //   {
      //     userName: "奋斗奋斗",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee7485a4b3230937.jpg",
      //     publishTime: "今天9:03"
      //   },
      //   {
      //     userName: "ninni",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee748565c2753329.jpg",
      //     publishTime: "今天9:00"
      //   },
      //   {
      //     userName: "fakeee",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee74859a41b10310.jpg",
      //     publishTime: "昨天19:43"
      //   },
      //   {
      //     userName: "cdcd",
      //     userHeadURL: "https://i.loli.net/2019/05/29/5cee74856a3c396539.jpg",
      //     publishTime: "昨天14:33"
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
  .user{
    width: 100%;
    height: 50px;
    margin: 10px 0;
    overflow: hidden;
    border: 1px solid #CBCBCB;
    border-radius: 8px;
  }
  .user img{
    width: 40px;
    height: 40px;
    margin: 5px 10px;
    background-color: #FFBABA;
    border-radius: 50%;
    float: left;
  }
  .name-time{
    height: 35px;
    float: left;
    margin-left: 5px;
  }
  .name-time .name{
    height: 20px;
    font-size: 14px;
    line-height: 20px;
    margin-top: 7px;
  }
  .name-time .time{
    height: 15px;
    font-size: 10px;
    margin-top: 3px;
  }
  .theme{
    width: 100px;
    height: 50px;
    line-height: 50px;
    font-size: 17px;
    float: right;
    margin-right: 50px;
  }
</style>