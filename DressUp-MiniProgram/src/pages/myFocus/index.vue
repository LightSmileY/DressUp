<template>
  <div class="myFocus">
    <div class="myattention" v-for="(item,index) in attentions" :key="index">
      <!-- 头像 -->
      <div class="picture_div">
        <img class="picture" :src="item.avatarID">
      </div>
      <!-- 用户名 -->
      <div class="name">
        <h1>{{item.name}}</h1>
      </div>
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
    methods: {

    },
    beforeMount(){
      let _this = this;
      // 获取我的所有关注
      _this.$fly.get('http://106.14.46.10:8081/MakeupYou/relation/findFollows',_this.$qs.stringify({
          userID: _this.$store.state.openId
        })
      )
      .then(function (response) {
        console.log(response);
        _this.attentions = response.data;
        console.log("获取我的关注成功！");
      })
      .catch(function (error) {
        console.log(error);
      });
    },
    mounted(){
      // this.attentions = [
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee72eab069387734.jpg",
      //     name: "张凤云"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee72ea7697294584.jpg",
      //     name: "杨伟艺"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee72ea8b6a119175.jpg",
      //     name: "胡健龙"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee72ea7470393548.jpg",
      //     name: "袁乾峰"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee72eab904839601.jpg",
      //     name: "jijiji"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee72eae58aa15759.jpg",
      //     name: "苹果葡萄"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee72eb37c5953320.png",
      //     name: "地平线"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee72eb5b63a96036.png",
      //     name: "vjdfv"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee72eb5ddf017821.png",
      //     name: "@vdsv"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee72eb6a5f727621.png",
      //     name: "!!!需"
      //   }
      // ];
    }   
  };
</script>

<style scoped>
  .main{
    position: relative;
    width: 90%;
    margin: 0 auto;
  }
  .myattention{
    width: 90%;
    margin: 8px auto 0;
    border: 1px solid #CBCBCB;
    border-radius: 8px;
    padding: 3px;
    height: 50px;
    font-size: 16px;
  }
  .picture_div{
    float:left;
    width:50px;
    height:50px;
    margin-left: 10px;
  }
  .picture{
    width:50px;
    height:50px;
    border-radius: 50%;
  }
  .name{
    float:left;
    width:200px;
    height:50px;
    line-height: 50px;
    margin-left: 20px;
  }
  .attention{
    float: right;
    line-height: 50px;
    margin-right: 15px;
    color: 
  }
</style>