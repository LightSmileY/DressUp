<template>
	<div class="nav">
		<ul class="nav-ul">
			<navigator :url="item.path" class="nav-li" v-for="(item,index) in arrayList" :key="index" :data-index="index">
				<div class="icon">
					<img :src="item.icon">
				</div>
				<div class="theme">{{item.theme}}</div>
				<div class="front">
					<img :src="item.front">
				</div>
			</navigator>
		</ul>
	</div>
</template>

<script>
export default {
  data () {
    return {
    	
    }
  },
  props: {
  	arrayList: Array,
  },
  methos: {
  	
  }
};
</script>

<style scoped>
	.nav-li{
		height: 30px;
		padding: 10px 0 10px 15px;
		border-bottom: 1px solid #E2E2E2;
	}
	.nav-li:first-child{
		margin-top: 10px;
		border-top: 1px solid #E2E2E2;
	}
	.icon{
		width: 30px;
		height: 30px;
		float: left;
	}
	.theme{
		width: 200px;
		height: 30px;
		margin-left: 40px;
		line-height: 30px;
		float: left;
		font-size: 15px;
	}
	.front{
		width: 30px;
		height: 30px;
		margin-right: 10px;
		float: right;
	}
	img{
		width: 100%;
		height: 100%;
	}
</style>