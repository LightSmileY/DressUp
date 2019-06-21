<template>
	<div class="Mains">
	  <top></top>
			<div class="main">
				<asider></asider>
				<router-view></router-view>
			</div>
	</div>
</template>

<script>
		import Top from './components/Top'
		import Asider from './components/Asider'
	export default {
	  name: 'Mains',
		components:{
			Top,
			Asider
			
		}
	}
</script>

<style>
	*{
		margin: 0;
		padding: 0;
	}
	.main{
		position: fixed;
		top:50px;
		left: 0;
		right: 0;
		bottom: 0;
		display: flex;
		background: #FFFFFF;
	}
</style>
