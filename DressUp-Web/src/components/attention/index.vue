<template>
	<div>
		<div class="myattention" v-for="(item,index) in arrayList" :key="index">
			<!-- 头像 -->
			<div class="picture_div">
				<img class="picture" :src="item.image">
			</div>
			<!-- 用户名 -->
			<div class="name">
				<h1>{{item.name}}</h1>
			</div>
			<div class="attention" v-if="show" @click="toAttent(index)">
				{{item.atten}}
			</div>
		</div>
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
		  show: Boolean,
		  
	  },
	  methods: {
	  	toAttent(i){
	  		if(this.arrayList[i].atten == "关注"){
	  			this.arrayList[i].atten = "已关注";
	  		}
	  		else{
	  			this.arrayList[i].atten = "关注"
	  		}
	  	}
	  }
	};
</script>

<style scoped>
	.myattention{
		width: 90%;
		margin: 8px auto 0;
		border: 1px solid #CBCBCB;
		border-radius: 8px;
		padding: 3px;
		height: 50px;
		font-size: 16px;
	}
	.picture_div{
		float:left;
		width:50px;
		height:50px;
		margin-left: 10px;
	}
	.picture{
		width:50px;
		height:50px;
		border-radius: 50%;
	}
	.name{
		float:left;
		width:100px;
		height:50px;
		line-height: 50px;
		margin-left: 20px;
	}
	.attention{
		float: right;
		line-height: 50px;
		margin-right: 15px;
		color: 
	}
</style>
