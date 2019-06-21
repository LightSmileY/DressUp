<template>
  <div id="app">
	 
	<router-view></router-view>
  </div>
</template>

<script>
	import Login from './components/login'
	// import MainHome from './pages/MainHome'
	// import Top from './components/Top'
	// import Asider from './components/Asider'
export default {
  name: 'App',
	components:{
		Login,
		// MainHome
		// Top,
		// Asider
		
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
