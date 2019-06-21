<template>
	<div class="Schdule">
		<h2>男性</h2>
		<Progress v-bind:percent="Mannumber"  status="active" />
		<!-- {{Mannumber}} -->
		<br><br><br>
		<h2>女性</h2>
		<Progress v-bind:percent="Womannumber"  status="active" stroke-color="red"/>
		<!-- {{Womannumber}} -->
		<br><br><br><br>
		<h1 >总人数:{{Allnumber}}</h1>
	</div>
</template>

<script>
	export default{
		name:"Schdule",
		data(){
			return{
				data5:[],
				Mannumber:0,
				Womannumber:0,
				Allnumber:0,
			}
		},
		beforeMount(){
		  var _this = this;
		  console.log('123');
		  _this.$axios.get('http://106.14.46.10:8081/MakeupYou/user/findAllUsers')
		  .then((response)=>{
			  _this.data5=response.data;
			  console.log(response);
			  var ManNum=0;
			  var WomanNum=0;
			  var All = _this.data5.length;
			  console.log("获取所有用户信息成功");
			  for(var item in _this.data5){
				  if(_this.data5[item].sex == 1){
				  		ManNum ++;
				  	}else{
				  		WomanNum ++;
				  	}
				  	_this.Mannumber=ManNum/All*100;
				  	_this.Womannumber=WomanNum/All*100;
				  	_this.Allnumber=All;
			  }
			
			
			 })
		.catch(function(response){
			console.log("失败了");
		})
			
			
		},
		
			}
</script>


<style >
	.Schdule{
		width: 100%;
		
		margin-top: 10px;
		margin-left: 20px;
		margin-right: 20px;
	}
	
</style>
