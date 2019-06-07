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
          userName: "袁袁袁",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee44c96734117769.jpg",
          publishTime: "今天17:21",
          content: "转发了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
        {
          userName: "nike",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee44c9a2f5d80983.jpg",
          publishTime: "今天14:03",
          content: "转发了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
        {
          userName: "hi李",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee44c9a91d338766.jpg",
          publishTime: "今天13:33",
          content: "转发了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
        {
          userName: "刘菜菜",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee44c9ab17d32805.jpg",
          publishTime: "今天12:43",
          content: "转发了我的帖子",
          imageUrl: "https://i.loli.net/2019/05/29/5cee7731a3cc637454.png",
          descri: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          path: "../dymamicDetail/main"
        },
        {
          userName: "小张",
          userHeadURL: "https://i.loli.net/2019/05/29/5cee44c9afce677451.jpg",
          publishTime: "今天11:45",
          content: "转发了我的帖子",
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