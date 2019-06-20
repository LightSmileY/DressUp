<template>
  <div class="user">
    <div class="myInfo" v-for="item in 6">
      <div class="myHeader">
        <img src="@/assets/img/header.jpg">
      </div>
      <div class="myUserName">浅笑半离兮</div>
      <div class="mySignature">一切都会很美好！</div>
    </div>
  </div>
</template>

<script>
export default {

  name: 'user',
  data () {
    return {
      
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
@import "../../assets/scss/mixins";
@import "../../assets/scss/variables";

  .user{
    flex: inline-block;
    width: 300px;
    background-color: #fff;
    box-shadow: 0 0 4px #BABABA;
    border-radius: 3px;
    margin-bottom: 40px;
    float: left;

    .myInfo{
      @include flex-center(column);
      flex: 1;
      background-image: url("~@/assets/img/bg.jpg");
      background-size: 100% 100%;
      border-bottom: 1px solid #D7D7D7;

      .myHeader{
        width: 50px;
        height: 50px;
        border-radius: 50%;
        border: 1px solid #929292;

        img{
          width: 100%;
          height: 100%;
          border-radius: 50%;
        }
      }

      .myUserName{
        margin: 5px;
      }

      .mySignature{
        font-size: 12px;
      }
    }
  }
</style>
