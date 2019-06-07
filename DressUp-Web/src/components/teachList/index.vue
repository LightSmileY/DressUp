<template>
  <div class="teach">
    <ul class="teach-ul">
      <navigator :url="item.path" v-for="(item,index) in arrayList" class="teach-li" :key="index">
        <p>{{item.name}}</p>
        <img :src="item.imageUrl">
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
  .teach-li{
    border: 1px solid #E2E2E2;
    border-radius: 5px;
    font-size: 14px;
    margin: 15px 0;
  }
  p{
    line-height: 28px;
    margin-left: 5%;
  }
  img{
    display: block;
    width: 92%;
    height: 120px;
    margin: 0 auto;
    border: 1px solid #BBBBBB;
  }
  .underline{
    width: 100%;
    height: 7px;
    border-bottom: 1px solid #cacaca;
  }
</style>