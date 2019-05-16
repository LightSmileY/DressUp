<template>
  <div class="main">
    <div class="user" v-for="(item,index) in attentions" :key="index">
      <img :src="item.userHeadURL" class="user-header"/>
      <div class="name-time">
        <div class="name">{{item.userName}}</div>
        <div class="time">{{item.publishTime}}</div>
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
    mounted(){
      this.attentions = [
        {
          userName: "杨伟艺",
          userHeadURL: "../../static/assets/images/1.jpeg",
          publishTime: "今天22:03"
        },
        {
          userName: "胡健龙",
          userHeadURL: "../../static/assets/images/1.jpeg",
          publishTime: "今天22:03"
        },
        {
          userName: "张凤云",
          userHeadURL: "../../static/assets/images/1.jpeg",
          publishTime: "今天22:03"
        }
      ]
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
    float: left;
    margin-left: 40px;
  }
</style>