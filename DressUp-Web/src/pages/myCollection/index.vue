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
          name: "你不知道的清新妆容",
          images: [
            "../../static/assets/images/2.jpg",
            "../../static/assets/images/2.jpg",
            "../../static/assets/images/2.jpg"
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