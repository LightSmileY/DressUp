<template>
  <div class="message">
    <!-- 各种消息列表 -->
    <Navi :arrayList="navis"></Navi>
  </div>
</template>

<script>
  import Navi from "@/components/nav"

  export default{
    data () {
      return {
        navis: []
      }
    },
    components:{
      Navi
    },
    methods: {
    },
    mounted(){
      this.navis = [
        {
          icon: "../../static/icon/like.png",
          theme: "赞我的",
          path: "../likeMe/main",
          front: "../../static/icon/front.png"
        },
        {
          icon: "../../static/icon/collection.png",
          theme: "收藏我的",
          path: "../collectMe/main",
          front: "../../static/icon/front.png"
        },
        {
          icon: "../../static/icon/share.png",
          theme: "转发我的",
          path: "../forwardMe/main",
          front: "../../static/icon/front.png"
        },
        {
          icon: "../../static/icon/evaluation.png",
          theme: "评论我的",
          path: "../commentMe/main",
          front: "../../static/icon/front.png"
        },
        {
          icon: "../../static/icon/attention.png",
          theme: "关注我的",
          path: "../attentMe/main",
          front: "../../static/icon/front.png"
        }
      ];
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