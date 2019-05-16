<template>
	<div class="search">
        <div class="form">
            <input type="text" placeholder="搜索您想要的内容...">
            <button type="submit">搜索</button>
        </div>
    </div>
</template>

<script>
    export default {
      data () {
        return {
          
        }
      }
    };
</script>

<style scoped>
    .form {
        position: relative;
        top: 5px;
        height: 32px;
        font-size: 14px;
    }
    input, button {
        border: none;
        outline: none;
    }
    input {
        height: 30px;
        border: 1px solid #FFA79E;
        border-radius: 5px;
        padding-left: 15px;
        background: #fff;
        color: #000000;
    }
    button {
        position: absolute;
        top: 0;
        right: 0;
        height: 32px;
        width: 60px;
        background: #FFA79E;
        color: #fff;
        font-size: 13px;
        line-height: 32px;
        border-radius: 0 5px 5px 0;
        cursor: pointer;
    }
	</style>