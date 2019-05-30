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
          image: "https://i.loli.net/2019/05/29/5cee7485269f927974.jpg",
          name: "莫名德天使",
          atten: "关注"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee74853f4ee44021.jpg",
          name: "哀悼阳光",
          atten: "关注"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee74854b9c265027.jpg",
          name: "苦尽甘来",
          atten: "关注"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee748565c2753329.jpg",
          name: "梦要自己扛",
          atten: "关注"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee74856a3c396539.jpg",
          name: "_斯文",
          atten: "关注"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee74859a41b10310.jpg",
          name: "半透明",
          atten: "关注"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee7485a4b3230937.jpg",
          name: "安生",
          atten: "关注"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee7486003dc40409.png",
          name: "难入怹",
          atten: "关注"
        },
          {
          image: "https://i.loli.net/2019/05/29/5cee7486033c023192.png",
          name: "你困",
          atten: "关注"
        },
        {
          image: "https://i.loli.net/2019/05/29/5cee7486003dc40409.png",
          name: "明月清风",
          atten: "关注"
        },
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