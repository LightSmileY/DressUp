<template>
  <div class="post">
    <c-dymamic :arrayList="myDynamics"></c-dymamic>
  </div>
</template>

<script>
import CDymamic from '@/components/dymamic';

export default {
  name: 'post',
  data () {
    return {
      myDynamics: []
    }
  },
  components: {
    CDymamic
  },
  beforeMount(){
    this.getMyPosts();
  },
  methods: {
    getMyPosts(){
      let _this = this;
      _this.$axios.get('http://106.14.46.10:8081/MakeupYou/appService/getMainPage', {
          params: {
            userID: "oQF_-4-D3Yuy6u7Qyfq4bBp9gnBg"
          }
        }
      )
      .then(function (response) {
        console.log(response);
        _this.myDynamics = response.data.sort(_this.$store.state.createComparison(response.data[0].likes)).reverse();
        
        for(let index in _this.myDynamics){

          if (_this.myDynamics[index].isLike === false) {
            _this.myDynamics[index].isLike = "@/assets/icon/like.png";
          }else {
            _this.myDynamics[index].isLike = "@/assets/icon/like-active.png";
          }

          if (_this.myDynamics[index].isCollection === false) {
            _this.myDynamics[index].isCollection = "@/assets/icon/collection.png";
          }else {
            _this.myDynamics[index].isCollection = "@/assets/icon/collection-active.png";
          }

          if (_this.myDynamics[index].isAttent === false) {
            _this.myDynamics[index].isAttent = "关注TA";
          }else {
            _this.myDynamics[index].isAttent = "已关注";
          }
        }
        console.log(_this.myDynamics);
        console.log("成功获取数据赋值给newDynamics");
      })
      .catch(function (error) {
        console.log(error);
      });
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
  .post{
    width: 85%;
    margin: 20px auto;
  }
</style>
