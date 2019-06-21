<template>
	<div class="main-div">
		<!-- <h1 class="page-header">编辑用户信息</h1> -->
		<!-- <Tooltip content="请确认编辑用户是目标用户!" placement="right-start" class="useredit">
                <Button><h1 >{{message}}用户的信息</h1></Button>
         </Tooltip> -->
			<br><br><br>
			<Button type="large" @click="modal6 = true">编辑</Button>
			<Modal v-model="modal6" title="Title" :loading="loading" @on-ok="asyncOK">
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
							<!-- <Col span="11">
								<FormItem prop="time">
									<TimePicker type="time" placeholder="Select time" v-model="formValidate.time"></TimePicker>
								</FormItem>
							</Col> -->
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
			</Form>
		</Modal>
	</div>
</template>

<script>
	 export default {
		 name:"edituser",
        data () {
            return {
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
			//发送post请求注册用户
			AddUser(){
				  this.$axios.post('http://106.14.46.10:8081/MakeupYou/user/register',NewUser)
				  .then((response)=>{
					  this.data6=response.data;
					  console.log("成功");
				  })
				.catch(function(res){
					console.log("失败了");
				})
			},
			// 弹窗
            handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$Message.success('提交成功！');
                    } else {
                        this.$Message.error('提交失败！');
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
	
}
.useredit{
	margin-left: 400px;
}
</style>