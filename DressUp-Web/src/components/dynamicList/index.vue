<template>
	<div class="dymamicList">
		<ul>
			<li v-for="(dymamic,index) in arrayList" :key="index" class="dymamicList-li" >
				<div class="user">
					<img :src="dymamic.userHeadURL" class="user-header"/>
					<div class="name-time">
						<div class="name">{{dymamic.userName}}</div>
						<div class="time">{{dymamic.publishTime}}</div>
					</div>
				</div>
				<p class="content">{{dymamic.content}}</p>
				<div class="images">
					<div v-for="(image,index1) in dymamic.images" :key="index1" class="image">
						<img :src="image"/>
					</div>
				</div>
				<div class="icons">
					<div class="forward">
						<!-- <img class="forward-image" :src="icon_forward"> -->
						<span>{{dymamic.forward}}</span>
					</div>
					<div class="cllection">
						<!-- <img :src="icon_collection"> -->
						<span>{{dymamic.collection}}</span>
					</div>
					<div class="like">
						<!-- <img :src="icon_like"> -->
						<span>{{dymamic.like}}</span>
					</div>
				</div>
				<div class="comment">
					<ul class="comment-ul">
						<li class="comment-li" v-for="(comment, index2) in dymamic.comments" :key="index2">
							<span class="username">{{comment.userName}}</span>：
							<span class="content">{{comment.content}}</span>
						</li>
					</ul>
					<button class="toComent">我也要评论</button>
				</div>
			</li>
		</ul>
	</div>
</template>

<script>
export default {
  data () {
    return {
    	icon_like: "",
    	icon_collection: "",
    	icon_forward: ""
    }
  },
  props: {
  	arrayList: Array
  },
  mounted(){
  	//说说列表
  	this.icon_like = "../../../static/icon/like.png";
  	this.icon_collection = "../../../static/icon/collection.png";
  	this.icon_forward = "../../../static/icon/forward.png";
  }
  
};
</script>

<style scoped>
	.dymamicList-li{
		position: relative;
		padding: 15px 0;
		border-bottom: 1px solid #D3D3D3;
	}
	.dymamicList-li:last-child{
		border: none;
	}
	.user{
		width: 100%;
		height: 35px;
	}
	.user-header{
		width: 35px;
		height: 35px;
		margin: 0 10px 0 0;
		background-color: #FFBABA;
		border: 1px solid #DADADA;
		border-radius: 50%;
		float: left;
	}
	.name-time{
		height: 35px;
		float: left;
	}
	.name-time .name{
		height: 20px;
		font-size: 14px;
		line-height: 20px;
	}
	.name-time .time{
		height: 15px;
		font-size: 10px;
	}
	.content{
		font-size: 14px;
		margin: 5px 0;
	}
	.images{
		display: flex;
		flex-wrap: wrap;
	}
	.images .image{
		width: 31.333%;
		height: 28vw;
		margin: 1%;
		background-color: #FCDDDD;
		overflow: hidden;
	}
	.images .image img{
		width: 100%;
		height: 100%;
		float: left;
	}
	.icons{
		height: 30px;
		margin-top: 5px;
		font-size: 14px;
		line-height: 25px;
		text-align: center;
	}
	.icons div{
		height: 20px;
		float: right;
		margin-right: 15px;
	}
	.icons div img{
		width: 22px;
		height: 22px;
	}
	.icons .forward .forward-image{
		width: 18px;
		height: 18px;
		margin-top: 3px;
	}
	.icons div span{
		width: 30px;
		height: 22px;
		font-size: 13px;
		line-height: 22px;
		position: relative;
		top: -5px;
		margin-left: 2px;
	}
	.icons .forward span{
		position: relative;
		top: -2px;
	}
	.comment{
		font-size: 13px;
	}
	.comment-li{
		line-height: 16px;
		margin: 5px;
	}
	.comment li .username{
		color: #12AADE;
	}
	.comment li .content{
		font-size: 13px
	}
	.comment .toComent{
		height: 30px;
		margin-bottom: 5px;
		margin-top: 10px;
		border: 1px solid #FFC1BB;
		border-radius: 5px;
		text-align: center;
		font-size: 14px;
		line-height: 30px;
		background-color: #fff;
	}
	.comment .toComent:active{
		background-color: #FFEDEB;
	}
</style>