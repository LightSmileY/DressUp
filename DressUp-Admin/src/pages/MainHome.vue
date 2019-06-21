<template>
	<div class="Mains">
	  <top></top>
			<div class="main">
				<asider></asider>
				<div class="body">
					<router-view></router-view>
				</div>
			</div>
	</div>
</template>

<script>
	import Top from '../components/Top'
	import Asider from '../components/Asider'
	export default {
	  name: 'Mains',
		components:{
			Top,
			Asider
			
		}
	}
</script>

<style scoped>
	*{
		margin: 0;
		padding: 0;
	}
	.main{
		/* position: fixed; */
		top:50px;
		left: 0;
		right: 0;
		bottom: 0;
		display: flex;
		background: #FFFFFF;
	}
	.body{
		width: 84%;
		float: right;
		background-color:gainsboro ;
	}
</style>
