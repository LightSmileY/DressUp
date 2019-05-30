<template>
  <div class="main">
    <Like :arrayList="colections"></Like>
  </div>
</template>

<script>
  import Like from "@/components/like"

  export default{
    data () {
      return {
        colections: []
      }
    },
    components:{
      Like
    },
    methods: {

    },
    mounted(){
      this.colections = [
        {
          userName: "fllll",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee439e4d56441446.jpg",
          publishTime: "今天22:13",
          content: "收藏了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
        {
          userName: "wok张",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee439ebbd9398911.jpg",
          publishTime: "今天22:13",
          content: "收藏了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
        {
          userName: "齐金",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee439ebeea957653.png",
          publishTime: "今天22:13",
          content: "收藏了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
        {
          userName: "MEta",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee439ed738a23447.png",
          publishTime: "今天22:13",
          content: "收藏了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
        {
          userName: "休斯敦",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee439ed9ef885403.png",
          publishTime: "今天22:13",
          content: "收藏了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
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
</style>