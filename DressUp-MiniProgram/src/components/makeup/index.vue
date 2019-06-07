<template>
  <div class="makeup">
    <ul class="makeup-ul">
      <navigator :url="item.path" v-for="(item,index) in arrayList" class="makeup-li" :key="index">
        <p>{{item.name}}</p>
        <div class="images">
          <img :src="image" v-for="(image,index1) in item.images" :key="index1">
        </div>
        <div class="underline"></div>
        <p>查看详情</p>
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
  .makeup-li{
    border: 1px solid #E2E2E2;
    border-radius: 5px;
    font-size: 14px;
    margin: 10px 0;
  }
  p{
    line-height: 28px;
    margin-left: 5%;
  }
  .images{
    width: 92%;
    height: 120px;
    margin: 0 auto;
  }
  img{
    width: 31.3333%;
    height: 28vw;
    margin: 1%;
    float: left;
  }
  .underline{
    width: 100%;
    height: 0;
    border-bottom: 1px solid #E2E2E2;
  }
</style>