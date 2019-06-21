<template>
	<div class="home">
		<div class="sex"> 
			<h1 >用户性别比例</h1>
			<schdule></schdule>
		</div>
	</div>
</template>

<script>
	import Schdule from '../components/Schdule.vue'
	export default{
		name:'home',
		components:{
			//注册组件
			Schdule,
		}
	}
</script>

<style scoped>
	.home{
		padding: 10px;
		width: 100%;
		float: right;
		/* height: 1000px; */
		background-color:gainsboro ;
	}
	.sex{
		margin-left: 20px;
		margin-top:30px;
		margin-right: 20px;
		width: 96%;
		height: 300px;
		background-color: #FFFFFF;
		border-radius:10px;
	}
	.sex h1{
		text-align: center;
		
	}
</style>