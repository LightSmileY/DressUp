<template>
  <div class="publish">
    <input type="text" class="title" placeholder="标题">
    <textarea name="" id="" cols="30" rows="5" class="messageBody" placeholder="分享"></textarea>
  </div>
</template>

<script>
export default {
  data () {
    return {
      input: '',
      textarea: ''
    }
  },
  props: {
    arrayList: Array
  },
  methods: {
    
  }
};
</script>

<style lang="scss">
  .publish{
    position: fixed;
    top: 55%;
    left: 50%;
    margin-top: -250px;
    margin-left: -250px;
    padding: 20px;
    width: 460px;
    height: 460px;
    background-color: #fff;
    box-shadow: 0 0 5px #838383;
    z-index:9999999999;

    .title{
      width: 50%;
      margin: 20px;
      height: 30px;
    }
    .messageBody{
      width: 90%;
      margin-left: 20px;
    }
  }
</style>