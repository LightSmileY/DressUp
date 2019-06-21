<template>
	<div class="top">
		<div class="left-logo">{{logo}}</div>
		<div class="search">
		<Input on-click="SearchUser" search enter-button="查询用户" v-model="users"  placeholder="输入用户名..." />
		</div>
	</div>
</template>

<script>
	export default{
		name:'top',
		data(){
			return{
				users:'',
				logo:'妆瓣后台管理系统'
			}
		},
		methods:{
			// 搜索用户是否存在
			SearchUser(){
				var _this = this;
				if(_this.users==''){
					this.$Message.success('输入用户名');
				}else{
				// 拿到输入框里用户的名字
				// console.log(_this.user_name);
				var param={name:_this.users};
				  this.$axios.get('http://106.14.46.10:8081/MakeupYou/user/findUserByName',{params:param})
				  .then((response)=>{
					  // console.log(response.data.uid);
					  if(response.data.uid==undefined){
						 this.$Message.success('不存在该用户');
					  }else{
					  // console.log(response);
					  this.$Message.success('该用户已注册');
					  console.log("获取该用户信息成功");
					   _this.users=response.data.name;
					  // console.log(_this.userid);
					  }
				  })
				.catch(function(response){
					console.log("失败了");
				})
				}
			}
		}
	}
</script>

<style scoped>
	.top{
		height: 200px;
		line-height: 50px;
		background: #009394;
		display: flex;
	}
	.left-logo{
		width:300px;
		backface-visibility: #2f7dab;
		text-align: center;
		color: #fff;
		font-size: 24px;
		letter-spacing: 1px;
	}
	.search{
		margin-top: 8px;
		margin-left: 55%;
		float: right;
		width: 300px;
	}
</style>
