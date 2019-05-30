<template>
  <div>
    <div class="info-li" v-for="(item,index) in arrayList" :key="index">
      <div class="theme">{{item.theme}}</div>
      <input class="content" type="text" :value="item.content">
    </div>
    <button>提交</button>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        arrayList: []
      }
    },
    props: {

    },
    mounted() {
      this.arrayList=[
        {
          theme:"昵称",
          content:"云云张"
        },
        {
          theme:"性别",
          content:"女"
        },
        {
          theme:"生日",
          content:"1999-6-7"
        },
        {
          theme:"所在地",
          content:"云南大学呈贡校区"
        },
        {
          theme:"邮箱",
          content:"1132434343@qq.com"
        },
        {
          theme:"个性签名",
          content:"没有伞的孩子要学会奔跑！"
        }
      ]
    }
  };
</script>

<style scoped>
  .info-li{
    float: left;
    height: 45px;
    width: 100%;
    border-bottom: 1px solid #E8E8E8;
  }
  .info-li:first-child{
    border-top: 1px solid #E8E8E8;
    margin-top: 10px;
  }
  .theme{
    float: left;
    width: 20%;
    height: 100%;
    margin-left: 20px;
    font-size: 14px;
    line-height: 45px;
  }
  .content{
    float: right;
    width: 70%;
    height: 100%;
    margin-right: 10px;
    font-size: 13px;
    line-height: 35px;
  }
  button{
    position: relative;
    top: 20px;
    width: 90%;
    height: 40px;
    font-size: 15px;
    line-height: 40px;
    background-color: #FFACAC;
    color: #fff;
    margin: 0 auto;
    border: none;
    outline: none;
    border-radius: 4px;
    cursor: pointer;
    text-align:center;
  }
  button:active{
    background-color: #FF9A9A;
  }
</style>
