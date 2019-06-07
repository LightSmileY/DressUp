<template>
	<div class="switch-button">
		<button v-for="word in arrayList" :key="index">{{word}}</button>
	</div>
</template>

<script>
export default {
  data () {
    return {
      Array: []
    }
  },
  props: {
  	arrayList: Array
  }
};
</script>

<style scoped>
	.switch-button{
		margin-top: 10px;
		margin-bottom: 10px;
		font-size: 0;
		text-align: center;
	}
	button::after {
	    border-radius: 0;
	}
	button{
		display: inline-block;
		border: 0;
		outline: none;
		width: 100px;
		height: 30px;
		border: 1px solid #FFA79E;
		border-radius: 0;
		background-color: #fff;
		font-size: 14px;
		line-height: 30px;
	}
	button:first-child{
		border-radius: 6px 0 0 6px;
		border-right: none;
		background-color: #FFA79E;
		color: #fff;
	}
	button:last-child{
		border-radius: 0 6px 6px 0;
		border-left: none;
	}
	.active{
		background-color: #FFA79E;
		color: #fff;
	}
</style>