<template>
  <div class="myFans">
    <div class="myattention" v-for="(item,index) in fans" :key="index">
      <!-- 头像 -->
      <div class="picture_div">
        <img class="picture" :src="item.avatarID">
      </div>
      <!-- 用户名 -->
      <div class="name">
        <h1>{{item.name}}</h1>
      </div>
      <!-- <div class="attention" @click="toAttent(index)">
        atten
      </div> -->
    </div>
  </div>
</template>

<script>

  export default{
    data () {
      return {
        fans: [],
        atten: "关注TA"
      }
    },
    methods: {
      toAttent(i){
        let _this = this;
        if(this.atten == "关注TA"){
          this.arrayList[i].atten = "已关注";
        }
        else{
          this.atten = "已关注"
        }
      }
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
        _this.fans = response.data;
        console.log("获取我的粉丝成功！");
      })
      .catch(function (error) {
        console.log(error);
      });
    },
    mounted(){
      // this.attentions = [
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee7485269f927974.jpg",
      //     name: "莫名德天使",
      //     atten: "关注"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee74853f4ee44021.jpg",
      //     name: "哀悼阳光",
      //     atten: "关注"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee74854b9c265027.jpg",
      //     name: "苦尽甘来",
      //     atten: "关注"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee748565c2753329.jpg",
      //     name: "梦要自己扛",
      //     atten: "关注"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee74856a3c396539.jpg",
      //     name: "_斯文",
      //     atten: "关注"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee74859a41b10310.jpg",
      //     name: "半透明",
      //     atten: "关注"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee7485a4b3230937.jpg",
      //     name: "安生",
      //     atten: "关注"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee7486003dc40409.png",
      //     name: "难入怹",
      //     atten: "关注"
      //   },
      //     {
      //     image: "https://i.loli.net/2019/05/29/5cee7486033c023192.png",
      //     name: "你困",
      //     atten: "关注"
      //   },
      //   {
      //     image: "https://i.loli.net/2019/05/29/5cee7486003dc40409.png",
      //     name: "明月清风",
      //     atten: "关注"
      //   },
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