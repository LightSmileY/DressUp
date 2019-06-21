<template>
	<div class="AdminList">
    <Table  class="table" border :columns="columns7" :data="data6"></Table>
	</div>
</template>
<script>
    export default {
		name:"AdminList",
        data () {
            return {
				data6: [],
                columns7: [
                    {
                        title: '名字',
                        key: 'name'
                    },
                    {
                        title: '密码',
                        key: 'password'
                    },
					{
					    title: '邮箱',
					    key: 'email'
					},
					{
					    title: '最后一次登陆时间',
					    key: 'last_login_time'
					},
                    {
                        title: '操作',
                        key: 'action',
                        width: 150,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.show(params.index)
                                        }
                                    }
                                }, '详情'),
                                // h('Button', {
                                //     props: {
                                //         type: 'error',
                                //         size: 'small'
                                //     },
                                //     on: {
                                //         click: () => {
                                //             this.remove(params.index)
                                //         }
                                //     }
                                // }, '删除')
                            ]);
                        }
                    }
                ]
                
            }
        },
        methods: {
            show (index) {
                this.$Modal.info({
                    title: '管理员信息',
                    content: `	
								姓名：${this.data6[index].name}<br>
								密码：${this.data6[index].password}<br>
								邮箱：${this.data6[index].email}<br>
								最后一次登陆的时间：${this.data6[index].last_login_time}<br>
								`
                })
            },
            // remove (index) {
            //     this.data6.splice(index, 1);
            // },
			// ----------------获得管理员数据--------------
			getNewsList(){
				  this.$axios.get('http://106.14.46.10:8081/MakeupYou/adminUser/findAllAdmin')
				  .then((response)=>{
					  console.log(response);
					  this.data6=response.data;
					  console.log("获得管理员数据成功");
				  })
				.catch(function(res){
					console.log("获得管理员数据失败了");
				})
			}
			// ------------------------------
        },
		created(){
			this.getNewsList();
		},
		
    }
</script>
<style scoped>
	.AdminList{
		padding: 10px;
		width: 97%;
		background-color: gainsboro;
		/* margin-left: 200px; */
	}
	.table{
		margin-left: 30px;
		/* background-color: #FF6D00; */
	}
</style>

