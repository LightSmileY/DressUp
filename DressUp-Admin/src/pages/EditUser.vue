<template>
	<div class="main-div">
		<Tooltip content="请确认编辑用户是目标用户!" placement="right-start" class="useredit">
                <Button><h1 >输入需要编辑的用户名字</h1></Button>
				
         </Tooltip>
		 <!-- 根据用户名字查找用户id -->
		 <div>
			<Input  class="inputusername"  v-model="user_name"  size="large"  clearable placeholder="Input user name..." />
			<Button type="primary" class="btninout" size="large" @click="EditUser()">搜索</Button>
		</div>
			<br><br>
			<h1 id="output">你搜索用户ID为: &nbsp &nbsp &nbsp &nbsp {{userid}}</h1>
			<br>
			<h2 id="tag">查到用户ID去才能正确编辑用户信息</h2>
			
			<br><br><br>
			<Button class="buttonedit" type="primary" @click="modal6 = true">开始编辑</Button>
				<Modal v-model="modal6" title="确保用户存在" :loading="loading" @on-ok="asyncOK">
					<Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
						<FormItem  label="姓名" prop="name"	>
							<Input v-model="formValidate.name" placeholder="Enter your name"></Input>
						</FormItem>
						<FormItem label="邮箱" prop="mailbox">
							<Input v-model="formValidate.mailbox" placeholder="Enter your e-mail"></Input>
						</FormItem>
						<FormItem label="密码" prop="password">
							<Input type="password" v-model="formValidate.password" placeholder="Enter your password"></Input>
						</FormItem>
						<FormItem label="生日" prop="birthday">
							<Row>
								<Col span="11">
									<FormItem prop="date">
										<DatePicker type="date" placeholder="Select date" v-model="formValidate.date"></DatePicker>
									</FormItem>
								</Col>
								<Col span="2" style="text-align: center">-</Col>
							</Row>
						</FormItem>
						<FormItem label="性别" prop="sex">
							<RadioGroup v-model="formValidate.sex">
								<Radio label="male">女</Radio>
								<Radio label="female">男</Radio>
							</RadioGroup>
						</FormItem>
						<FormItem label="年龄" prop="age">
							<Input type="number" v-model="formValidate.age" placeholder="Enter yourage"></Input>
						</FormItem>
						<FormItem label="个性签名" prop="description">
							<Input v-model="formValidate.desc" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="Enter something..."></Input>
						</FormItem>
						<FormItem>
							<Button type="primary" @click="handleSubmit('formValidate')">提交</Button>
							<Button @click="handleReset('formValidate')" style="margin-left: 8px">重置</Button>
						</FormItem>
						<h2 id="tag">提交后需点击确定</h2>
				</Form>
			</Modal>
	</div>
</template>

<script>
	 export default {
        data () {
            return {
				userid:'',
				user_name:'',
				modal6: false,
                loading: true,
				message:"张凤云",
                formValidate: {
                    name: '',
                    mailbox: '',
                    password: '',
                    sex: '',
                    age: '',
                    date: '',
                    time: '',
                    description: ''
                },
                ruleValidate: {
                    name: [
                        { required: true, message: '请输入名字！', trigger: 'blur' }
                    ],
                    mailbox: [
                        { required: true, message: '请输入邮箱！', trigger: 'blur' },
                        { type: 'email', message: '邮箱格式不正确', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码！', trigger: 'change' }
                    ],
                    sex: [
                        { required: true, message: '请选择性别', trigger: 'change' }
                    ],
                    
                    date: [
                        { required: true, type: 'date', message: '生日别忘了呀！', trigger: 'change' }
                    ]
                   
                }
            }
        },
        methods: {
			asyncOK () {
                setTimeout(() => {
                    this.modal6 = false;
                }, 2000);
            },
			//搜索用户编辑用户信息
			EditUser(){
				var _this = this;
				if(_this.user_name==''){
					this.$Message.success('请输入用户名');
				}else{
				// 拿到输入框里用户的名字
				// console.log(_this.user_name);
				var param={name:_this.user_name};
				  this.$axios.get('http://106.14.46.10:8081/MakeupYou/user/findUserByName',{params:param})
				  .then((response)=>{
					  // console.log(response.data.uid);
					  if(response.data.uid==undefined){
						 this.$Message.success('不存在该用户');
					  }else{
					  // console.log(response);
					  this.$Message.success('存在该用户');
					  console.log("获取该用户信息成功");
					   _this.userid=response.data.uid;
					  // console.log(_this.userid);
					  }
				  })
				.catch(function(response){
					console.log("失败了");
				})
				}
			},
			// 提交编辑后的用户信息
            handleSubmit (name) {
				var _this = this;
                this.$refs[name].validate((valid) => {
                    if (valid) 
					{
						// 临时性别变量
						var sexs;
						// 如果没有先查询用户是否存在则弹框提示
						if(_this.userid=='')
						{
							this.$Message.error('请先查询用户是否存在！！！');
						}
						// 用户已经查询过并且存在则进行用户的数据更改
						else
						{
							// 将用户的性别进行分类
							if(_this.formValidate.sex=="male")
							{
								_this.sexs=2;
							}
							else
							{
								_this.sexs=1;
							}
							// console.log("_________________");
							// console.log(_this.userid);
							
							// let datas= {
							// 	"uid": _this.userid,
							// 	"name": _this.formValidate.name,
							// 	"password": _this.formValidate.password,
							// 	"birthday": _this.formValidate.date,
							// 	"sex": _this.sexs,
							// 	"age": _this.formValidate.age,
							// 	"register_date": "20190603",
							// 	"avatarID": '',
							// 	"description": _this.formValidate.des,
							// 	"mailbox": _this.formValidate.mailbox,
							// 	"last_login_time": ''
							// };
							console.log("_________________");
							console.log(_this.userid);
							// console.log(datas);
							_this.$axios.put('http://106.14.46.10:8081/MakeupYou/user/update',
							_this.$qs.stringify({
								// datas
								uid: _this.userid,
								name: _this.formValidate.name,
								password: _this.formValidate.password,
								birthday: "2019-10-10",
								sex: _this.sexs,
								age: _this.formValidate.age,
								register_date: "2019-10-1",
								avatarID: '',
								description: _this.formValidate.des,
								mailbox: _this.formValidate.mailbox,
								last_login_time: ''
						})	
							)
							.then(res=> {
								
								console.log("________打印即将编辑的用户的id___________");
								// console.log(datas);
								// console.log(res);
								// console.log("res");
								this.$Message.success('用户信息修改成功！');
								
							})
							.catch(error=> {
								console.log("_________________");
								console.log(_this.userid);
								console.log("error");
								console.log(error);
								this.$Message.error('用户信息修改失败！');
							})
						}
					} 
					else 
					{
                        this.$Message.error('输入数据异常，提交失败！');
                    }
                
            })
			},
            handleReset (name) {
                this.$refs[name].resetFields();
            }
        }
    }
</script>

<style scoped>
.main-div{
	width:85%;
	top:100px;
	float:right;
	/* background-color:gainsboro ; */
}
.useredit{
	margin-left: 400px;
	margin-top: 40px;
}
.inputusername{
	/* margin-right: 100px; */
	margin-left: 100px;
	margin-top: 20px;
	width: 700px;
	/* height: 50px; */
	text-align: center;
	}
#output{
	margin-right: 100px;
	margin-left: 20px;
	margin-top: 20px;
	text-align: center;
	}
.buttonedit{
	float: right;
	margin-right: 80px;
	}
#tag{
	margin-right: 100px;
	margin-left: 20px;
	margin-top: 20px;
	text-align: center;
	color:crimson;
	}
.btninout{
	/* float: right; */
	margin-right: 250px;
	margin-left: 100px;
	margin-top: 20px;
	text-align: center;
}
</style>