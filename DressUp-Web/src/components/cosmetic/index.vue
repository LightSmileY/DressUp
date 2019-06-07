<template>
  <div class="cosmetic">
    <ul class="cosmetic-ul">
      <navigator :url="item.path" v-for="(item,index) in arrayList" class="cosmetic-li" :key="index">
        <div class="image">
          <img :src="item.imageUrl">
        </div>
        <div class="info">
          <div class="name">
            {{item.name}}
          </div>
          <div class="descri">
            <p>{{item.descri}}</p>
          </div><!-- 
          <div class="price">
            <span>{{item.price}}</span>
          </div> -->
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
    arrayList: []
  }
};
</script>

<style scoped>
  .cosmetic-li{
    height: 100px;
    border: 1px solid #E2E2E2;
    border-radius: 5px;
    font-size: 14px;
    margin: 15px 0;
    overflow: hidden;
  }
  .image{
    width: 29%;
    height: 27vw;
    float: left;
  }
  img{
    width: 80%;
    height: 80%;
    margin: 10%;

  }
  .info{
    width: 67%;
    height: 27vw;
    float: right;
    margin: 5px;
  }
  .name{
    font-size: 14px;
    width: 95%;
    height: 5vw;
    line-height: 5vw;
    margin: 8px auto 0;
  }
  .descri{
    font-size: 12px;
    width: 95%;
    height: 11vw;
    margin: 8px auto 0;
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