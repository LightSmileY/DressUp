<template>
	<div class="PostList">
    <Table  class="table" border :columns="columns7" :data="data6"></Table>
	</div>
</template>
<script>
    export default {
		name:"PostList",
        data () {
            return {
				data6: [],
                columns7: [
                    {
                        title: '帖子Id',
                        key: 'pid',
                    },
					{
                        title: '用户Id',
                        key: 'uid',
                    },
                    {
                        title: '帖子类别',
                        key: 'type'
                    },
                    {
                        title: '发表时间',
                        key: 'postTime'
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
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.deletepost(params.index)
                                        }
                                    }
                                }, '删除')
                            ]);
                        }
                    }
                ]
                
            }
        },
        methods: {
            show (index) {
                this.$Modal.info({
                    title: '用户信息',
                    content: `	帖子Id：${this.data6[index].pid}<br>
								用户Id：${this.data6[index].uid}<br>
								发表时间：${this.data6[index].postTime}<br>
								类别号：${this.data6[index].type}<br>
								标题：${this.data6[index].title}<br>
								主题内容：${this.data6[index].messagebody}<br>
								`
                })
            },
			// ----------------删除帖子数据--------------
            deletepost (index) {
            	var _this = this;
            	var param={postID:_this.data6[index].pid};
            	console.log(_this.data6[index].uid);
            	this.$axios.delete('http://106.14.46.10:8081/MakeupYou/post/deleteRecord',{params:param})
            .then((response)=>{
            		  console.log(_this.data6[index].uid);
            		  this.$Message.success('删除帖子成功');
            		  console.log("删除帖子成功");
            	  })
            	.catch(function(response){
            		// console.log(_this.data6[index].uid);
            		console.log("删除帖子失败了");
            	})
            },
			// ----------------获得帖子数据--------------
			getNewsList(){
				  this.$axios.get('http://106.14.46.10:8081/MakeupYou/post/findAllPostMessages')
				  .then((response)=>{
					  this.data6=response.data;
					  console.log("获取帖子成功");
				  })
				.catch(function(res){
					console.log("获取帖子失败了");
				})
			}
			// ------------------------------
        },
		created(){
			this.getNewsList();
		},
		updated(){
			this.getNewsList();
		},
    }
</script>
<style scoped>
	.PostList{
		padding: 10px;
		width: 97%;
		/* background-color: #007270; */
		background-color:gainsboro ;
		/* margin-left: 200px; */
	}
	.table{
		margin-left: 30px;
		/* background-color: #FF6D00; */
	}
</style>

