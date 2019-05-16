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
          userName: "胡健龙",
          userHeadURL: "../../static/assets/images/1.jpeg",
          publishTime: "今天22:03",
          content: "收藏了我的帖子",
          imageUrl: "../../static/assets/images/2.jpg",
          descri: "这是一盒非常非常非常非常非常非常神奇的化妆品鸭鸭！你一定要喜欢啊啊啊啊啊啊啊啊啊啊哈哈哈哈哈哈哈哈哈哈！",
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