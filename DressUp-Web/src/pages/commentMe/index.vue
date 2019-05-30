<template>
  <div class="main">
    <Like :arrayList="likes"></Like>
  </div>
</template>

<script>
  import Like from "@/components/like"

  export default{
    data () {
      return {
        likes: []
      }
    },
    components:{
      Like
    },
    methods: {

    },
    mounted(){
      this.likes = [
        {
          userName: "。。",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee76ea7d01d81579.jpg",
          publishTime: "今天10:23",
          content: "学到啦",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
          {
          userName: "haphap",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee76ea7043315018.png",
          publishTime: "今天21:01",
          content: "果然好用",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
          {
          userName: "往日夕",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee76e9eef3759817.jpg",
          publishTime: "今天21:03",
          content: "啦啦啦👩‍❤️‍👩",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
          {
          userName: "百事可可",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee76a17897f93356.jpg",
          publishTime: "今天22:03",
          content: "看到你的效果啦",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
        
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
</style>