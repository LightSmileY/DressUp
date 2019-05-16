<template>
  <div class="myFans">
    <Attention :arrayList="attentions" :show="show"></Attention>
  </div>
</template>

<script>
  import Attention from "@/components/attention"

  export default{
    data () {
      return {
        attentions: [],
        show: 1
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
          image: "../../static/assets/images/1.jpeg",
          name: "张凤云"
        },
        {
          image: "../../static/assets/images/1.jpeg",
          name: "杨伟艺"
        },
        {
          image: "../../static/assets/images/1.jpeg",
          name: "胡健龙"
        },
        {
          image: "../../static/assets/images/1.jpeg",
          name: "袁乾峰"
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