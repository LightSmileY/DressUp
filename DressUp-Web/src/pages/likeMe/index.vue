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
          userName: "fukami",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee439e139d882897.jpg",
          publishTime: "今天20:03",
          content: "赞了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
         {
          userName: "xiaozhang",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee439e4d56441446.jpg",
          publishTime: "今天21:34",
          content: "赞了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
         {
          userName: "luckly",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee439de2bf083812.jpg",
          publishTime: "今天22:32",
          content: "赞了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
         {
          userName: "comments",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee439e648ae25933.jpg",
          publishTime: "今天22:34",
          content: "赞了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
         {
          userName: "🈯️唧唧",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee439e922c222589.jpg",
          publishTime: "今天14:03",
          content: "赞了我的帖子",
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