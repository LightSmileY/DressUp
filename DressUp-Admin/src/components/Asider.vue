<template>
	<div class="asider">
		<div class="user-info">
			<div>
				<img src="../assets/image/logo.png" alt="" class="preject-logo" />
			</div>
			<div class="user-msg">
				<p>认真做项目才队</p>
				
			</div>
		</div>
		<ul class="list">
			<router-link to='/MainHome/home' active-class='active' tag='li'>首页</router-link>
			<router-link to='/MainHome/UserList' active-class='active' tag='li'>用户信息</router-link>
			<router-link to='/MainHome/AdminList' active-class='active' tag='li'>管理员信息</router-link>
			<router-link to='/MainHome/PostList' active-class='active' tag='li'>贴子信息</router-link>
			<!-- <router-link to='/Comment' active-class='active' tag='li'>评论信息</router-link> -->
			<router-link to='/MainHome/EditUser' active-class='active' tag='li'>编辑用户</router-link>
		</ul>
	</div>
</template>

<script>
	export default{
		name:"asider",
		
	}
</script>

<style>
	.asider{
		width: 16%;
		background: #00E0C7;
		/* border-radius:8px; */
		/* position: fixed; */
	}
	li.active{
		background: #009394;
		color: #FF6D00;
	}
	.list{
		list-style: none;
	}
	.list li{
		height: 60px;
		line-height: 60px;
		text-indent: 20px;
		color:#007270;
		cursor:pointer;
		font-size: 18px;
	}
	.list li.active{
		color:#fff;
	}
	.user-info{
		display:flex ;
		padding: 10px 5px 10px 20px;
		
	}
	.preject-logo{
		width: 70px;
		border-radius: 60%;
	}
	.user-msg{
		display: flex;
		flex-direction: column;
		justify-content: center;
	}
	.user-msg p{
		color: #fff;
		font-size: 16px;
		text-indent: 5px;
	}
	.circle{
		 width: 8px;
		 height: 8px;
		 border-radius:50%;
		 vertical-align: baseline;
		 display: inline-block;
		 background: chartreuse;
		 margin-right: 4px;
		 margin-left: 4px;
		 margin-top: 4px;
	}
</style>
