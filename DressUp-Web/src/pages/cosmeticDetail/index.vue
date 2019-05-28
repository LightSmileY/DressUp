<template>
  <div class="main">
    <div class="theme">{{detail.theme}}</div>
    <div class="price">&#165;&nbsp;{{detail.price}}</div>
    <dl v-for="(cosmetic, index) in detail.cosmetics" :key="index">
      <dt>
        <img :src="cosmetic.image">
      </dt>
      <dd>
        <p v-for="(content, index1) in cosmetic.contents" :key="index1">{{content}}</p>
      </dd>
    </dl>
  </div>
</template>

<script>

  export default{
    data () {
      return {
        detail: {}
      }
    },
    components:{
      
    },
    methods: {

    },
    mounted(){
      this.detail = {
        theme: "最美神奇的化妆品",
        price: "78",
        cosmetics: [
          {
            image: "../../static/assets/images/3.jpg",
            contents: [
              "嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻",
              "寻寻寻寻寻寻寻寻寻寻寻寻寻哈哈哈哈哈哈哈哈哈哈或或或或或或或或或或或或",
              "哈哈哈哈哈哈哈哈"
            ]
          },
          {
            image: "../../static/assets/images/4.jpg",
            contents: [
              "嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻",
              "寻寻寻寻寻寻寻寻寻寻寻寻寻哈哈哈哈哈哈哈哈哈哈或或或或或或或或或或或或",
              "哈哈哈哈哈哈哈哈"
            ]
          },
          {
            image: "../../static/assets/images/3.jpg",
            contents: [
              "嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻",
              "寻寻寻寻寻寻寻寻寻寻寻寻寻哈哈哈哈哈哈哈哈哈哈或或或或或或或或或或或或",
              "哈哈哈哈哈哈哈哈"
            ]
          }
        ],
      }
    }   
  };
</script>

<style scoped>
  .main {
    position: relative;
    width: 90%;
    margin: 0 auto;
  }
  .theme {
    margin: 20px 0;
    font-size: 18px;
  }
  .price {
    position: absolute;
    top: -10px;
    right: 20px;
    font-size: 35px;
    color: red;
  }
  dl dt img {
    width: 100%;
    height: 50vw;
  }
  dl dd p {
    width: 100%;
    font-size: 14px;
    margin: 10px 0;
  }
</style>