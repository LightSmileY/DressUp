<template>
  <div class="dymamicDetail">
    <div class="main">
      <DynamicList :arrayList = "myDynamics"></DynamicList>
    </div>
  </div>
</template>

<script>
  import DynamicList from "@/components/DynamicList"

  export default{
    data () {
      return {
        myDynamics: []
      }
    },
    components:{
      DynamicList
    },
    methods: {

    },
    mounted(){
      this.myDynamics = [
        {
          userHeadURL: "../../static/assets/images/1.jpeg",
          userName: "浅笑半离兮",
          publishTime: "今天12:20",
          content: "自由的本质不是放纵自己，不是无所不为，而是自律后的舒畅，是有所为，有所不为。",
          images: [
            "../../static/assets/images/2.jpg",
            "../../static/assets/images/2.jpg",
            "../../static/assets/images/2.jpg"
          ],
          like: 20,
          collection: 8,
          forward: 15,
          //评论列表
          comments: [
            {
              userName: '张凤云',
              content: '好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒'
            }
          ]
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