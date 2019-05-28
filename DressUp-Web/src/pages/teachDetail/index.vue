<template>
  <div class="main">
    <div class="theme">{{detail.theme}}</div>
    <dl v-for="(teaching, index) in detail.teachings" :key="index">
      <dt>
        <img :src="teaching.image">
      </dt>
      <dd>
        <p v-for="(content, index1) in teaching.contents" :key="index1">{{content}}</p>
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
        theme: "美妆教程",
        teachings: [
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
    margin: 10px 0;
    font-size: 18px;
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