<template>
  <div class="myFocus">
    <Attention :arrayList="attentions" :show="show"></Attention>
  </div>
</template>

<script>
  import Attention from "@/components/attention"

  export default{
    data () {
      return {
        attentions: [],
        show: 0
      }
    },
    components:{
      Attention
    },
    methods: {

    },
    mounted(){
      this.attentions = [
        {
          image: "https://i.loli.net/2019/05/29/5cee72eab069387734.jpg",
          name: "张凤云"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee72ea7697294584.jpg",
          name: "杨伟艺"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee72ea8b6a119175.jpg",
          name: "胡健龙"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee72ea7470393548.jpg",
          name: "袁乾峰"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee72eab904839601.jpg",
          name: "jijiji"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee72eae58aa15759.jpg",
          name: "苹果葡萄"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee72eb37c5953320.png",
          name: "地平线"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee72eb5b63a96036.png",
          name: "vjdfv"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee72eb5ddf017821.png",
          name: "@vdsv"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee72eb6a5f727621.png",
          name: "!!!需"
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