<template>
  <div class="like">
    <ul class="like-ul">
      <navigator :url="item.path" v-for="(item,index) in arrayList" class="like-li" :key="index">
        <div class="user">
          <img :src="item.userHeadURL" class="user-header"/>
          <div class="name-time">
            <div class="name">{{item.userName}}</div>
            <div class="time">{{item.publishTime}}</div>
          </div>
          <p>详情</p>
        </div>
        <div class="content">
          <span>{{item.content}}</span>
        </div>
        <div class="image">
          <img :src="item.imageUrl">
        </div>
        <div class="info">
            <p>{{item.descri}}</p>
        </div>
      </navigator>
    </ul>
  </div>
</template>

<script>
export default {
  data () {
    return {
      
    }
  },
  props: {
    arrayList: Array
  }
};
</script>

<style scoped>
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