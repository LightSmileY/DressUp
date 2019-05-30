<template>
  <div class="message main">
    <div class="theme">妆容</div>
    <Makeup :arrayList = "collections"></Makeup>
  </div>
</template>

<script>
  import Makeup from "@/components/makeup"

  export default{
    data () {
      return {
        collections: []
      }
    },
    components:{
      Makeup
    },
    methods: {

    },
    mounted(){
      this.collections = [
        {
          name: "新手妆容",
          images: [
            "https://i.loli.net/2019/05/29/5cee4b315f83933845.png",
            "https://i.loli.net/2019/05/29/5cee4b31619ec62819.png",
            "https://i.loli.net/2019/05/29/5cee4b3163d8066017.png"
          ],
          path: "../dressupDetail/main"
        },
        {
          name: "好品与好妆容",
          images: [
            "https://i.loli.net/2019/05/29/5cee4c0b2794675305.png",
            "https://i.loli.net/2019/05/29/5cee4c0b313af79794.png",
            "https://i.loli.net/2019/05/29/5cee4c0b3acf735000.png"
          ],
          path: "../dressupDetail/main"
        },
        {
          name: "常规化妆品化妆效果",
          images: [
            "https://i.loli.net/2019/05/29/5cee4c3bdb23e78229.png",
            "https://i.loli.net/2019/05/29/5cee4c3c3a9cf12221.png",
            "https://i.loli.net/2019/05/29/5cee4c3c3cd5c20275.png"
          ],
          path: "../dressupDetail/main"
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
  .theme{
    font-size: 18px;
    margin-top: 10px;
    padding: 3px;
  }
</style>