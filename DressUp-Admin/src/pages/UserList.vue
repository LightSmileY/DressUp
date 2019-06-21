<template>
	<div class="UserList">
    <Table  class="table" border :columns="columns7" :data="data6"></Table>
	<br><br>
	<!-- <Page :total="100" show-elevator /> -->
	<!-- {{data6}} -->
	</div>
</template>
<script>
	// import EditUser from '../components/EditUser.vue'
    export default {
		name:"UserList",
			// components:{
			// 	//注册编辑用户信息的组件
			// 	EditUser
			// },
        data () {
            return {
				data6: [],
                columns7: [
                    {
                        title: 'Id',
                        key: 'uid',
                    },
                    {
                        title: '名字',
                        key: 'name'
                    },
                    {
                        title: '密码',
                        key: 'password'
                    },
					{
					    title: '生日',
					    key: 'birthday'
					},
					{
					    title: '注册时间',
					    key: 'register_date'
					},
                    {
                        title: '操作',
                        key: 'action',
                        width: 250,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '10px'
                                    },
                                    on: {
                                        click: () => {
                                            this.show(params.index)
                                        }
                                    }
                                }, '详情'),
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
									style: {
									    marginRight: '5px'
									},
                                    on: {
                                        click: () => {
                                            this.deleteuser(params.index)
                                        }
                                    }
                                }, '删除'),
								
                            ]);
                        }
                    }
                ]
                
            }
        },
		beforeMount(){
			// ----------------获得用户数据--------------
		  var _this = this;
		  console.log('123');
		  _this.$axios.get('http://106.14.46.10:8081/MakeupYou/user/findAllUsers')
		  .then((response)=>{
			  _this.data6=response.data;
			  console.log(response);
			  console.log("获取所有用户信息成功");
			 })
		.catch(function(response){
			console.log("失败了");
		})
			
			
		},
        methods: {
			// ---------------详情---------------
            show (index) {
                this.$Modal.info({
                    title: '用户信息',
                    content: `	ID：${this.data6[index].uid}<br>
								姓名：${this.data6[index].name}<br>
								密码：${this.data6[index].password}<br>
								生日：${this.data6[index].birthday}<br>
								性别：${this.data6[index].sex}<br>
								年龄：${this.data6[index].age}<br>
								注册时间：${this.data6[index].register_date}<br>
								头像：${this.data6[index].avatarID}<br>
								个性签名：${this.data6[index].description}<br>
								邮箱：${this.data6[index].mailbox}<br>
								最后一次登陆的时间：${this.data6[index].last_login_time}<br>
								`
                })
            },
            // ----------------------------------------
			
			// ---------------删除用户-------------------
			deleteuser (index) {
				var _this = this;
				var param={userID:_this.data6[index].uid};
				console.log(_this.data6[index].uid);
				this.$axios.delete('http://106.14.46.10:8081/MakeupYou/user/delete',{params:param})
			.then((response)=>{
					  console.log(_this.data6[index].uid);
					  this.$Message.error('删除用户成功');
					  console.log("删除用户成功");
				  })
				.catch(function(response){
					// console.log(_this.data6[index].uid);
					console.log("删除用户失败了");
				})
			},
			
			// ---------------编辑用户-------------------
			// edituser (index) {
			// 	var _this = this;
			// 	this.$Modal.info({
			// 	    title: '编辑用户信息',
			// 	    content: `	ID：${this.data6[index].uid}<br>
			// 					姓名：${this.data6[index].name}<br>
			// 					密码：${this.data6[index].password}<br>
			// 					生日：${this.data6[index].birthday}<br>
			// 					性别：${this.data6[index].sex}<br>
			// 					年龄：${this.data6[index].age}<br>
			// 					注册时间：${this.data6[index].register_date}<br>
			// 					头像：${this.data6[index].avatarID}<br>
			// 					个性签名：${this.data6[index].description}<br>
			// 					邮箱：${this.data6[index].mailbox}<br>
			// 					最后一次登陆的时间：${this.data6[index].last_login_time}<br>
			// 					`
			// 	})
			// },
        },
		
		created(){
			// this.getNewsList();
		},
		updated(){
			// this.getNewsList();
		},
    }
</script>
<style scoped>
	.UserList{
		/* margin-left: 200px; */
		padding: 10px;
		width: 97%;
		
		/* background-color: #007270; */
		background-color:gainsboro ;
	}
	.table{
		margin-left: 30px;
		/* background-color: #FF6D00; */
	}
</style>
