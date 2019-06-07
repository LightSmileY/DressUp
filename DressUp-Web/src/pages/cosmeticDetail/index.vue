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
        theme: "安耐晒小金瓶",
        price: "220",
        cosmetics: [
          {
            image: "https://i.loli.net/2019/05/29/5cee432b94f3923708.png",
            contents: [
              "口碑超好，防晒指数SPF50+ PA++++ 不仅超强防晒，还防水、防汗！质地清爽不油腻！",
           ]
          },
          {
            image: "https://i.loli.net/2019/05/29/5cee432bab6e465886.png",
            contents: [
              "长时间户外活动、军训以及海边旅游非它莫属！（普通日常防晒的话，日系碧柔防晒霜就行~）",
            ]
          },
          {
            image: "https://i.loli.net/2019/05/29/5cee432c062a634984.png",
            contents: [
               "防晒霜要出门前半小时涂，用量一个硬币大小，不能省！每隔两小时补涂一次！（如果化了妆，补涂防晒用雾状的防晒喷雾~）"
            ]
          }
        ]
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
    height: 80vw;
  }
  dl dd p {
    width: 100%;
    font-size: 14px;
    margin: 10px 0;
  }
</style>