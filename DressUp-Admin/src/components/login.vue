<template>
	<div class="login">
	    <div class="container">
	        <h1>欢迎来到妆瓣后台管理系统</h1>
	        <br><br>
			<form>
	            <input type="text" v-model="admin_user.name" placeholder="管理员名字"/>
	            <input type="password" v-model="admin_user.password" placeholder="密码"/>
	            <!-- <input type="submit" value="登陆"/> -->
				<button @click="login">登录</button>
	        </form>
	    </div>
	    <ul>
	        <li></li>
	        <li></li>
	        <li></li>
	        <li></li>
	        <li></li>
	        <li></li>
	        <li></li>
	        <li></li>
	        <li></li>
	        <li></li>
	    </ul>
	</div>
</template>

<script>
	
// import { mapMutations } from 'vuex';
	export default{
		name:"login",
		data(){
			return{
				admin_user:{
					name:'',
					password:'',
					email:'',
					last_login_tima:''
				},
				// userToken:''
			};
		},
		methods: {
    // ...mapMutations(['changeLogin']),
    login () {
      var _this = this;
	  var qs = require('qs');
	  // var params = new URLSearchParams();
      if (this.admin_user.name === '' || this.admin_user.password === '') {
      this.$Message.error('账号或密码不能为空');
      } else {
		this.$axios.post('http://106.14.46.10:8081/MakeupYou/adminUser/login',
		qs.stringify({
			name:_this.admin_user.name,
			password:_this.admin_user.password,
			email:_this.admin_user.email,
			last_login_time:_this.admin_user.last_login_time
		})
		)
		.then(res => {
			// this.$closeLoading();
			console.log("---------------------");
			_this.admin_user =res.data.AdminUser;
			console.log(_this.admin_user);
			console.log("---------------------");
			this.$Message.success('登陆成功');
		  _this.$store.dispatch('getMyLoginInfo', _this.admin_user);
		  // console.log(_this.$store.state.myLoginInfo);
		  _this.$router.push('/MainHome');
        })
		.catch(error => {
		  this.$Message.error('账号或密码错误');
          console.log(error);
        });
      }
    }
  }
			}
</script>

<style scoped>
	* {
	    box-sizing: border-box;
	}
	.login {
		margin: 0; 
		padding: 0;
		font: 16px/20px microsft yahei;
	    width: 100%;
	    height: 100%;
	    padding: 40px 0;
	    position: fixed;
	  
	    opacity: 0.8;
	    background: linear-gradient(to bottom right,#50a3a2,#53e3a6);
	    background: -webkit-linear-gradient(to bottom right,#50a3a2,#53e3a6);
	}
	.container {
	    width: 60%;
	    margin: 0 auto;
		margin-top:100px;
	}
	.container h1 {
	    text-align: center;
	    color: #FFFFFF;
	    font-weight: 500;
	}
	.container input {
	    width: 320px;
	    display: block;
	    height: 36px;
	    border: 0;
	    outline: 0;
	    padding: 6px 10px;
	    line-height: 24px;
	    margin: 32px auto;
	    -webkit-transition: all 0s ease-in 0.1ms;
	    -moz-transition: all 0s ease-in 0.1ms;
	    transition: all 0s ease-in 0.1ms;
	}
	.container button {
	    width: 320px;
	    display: block;
	    height: 36px;
	    border: 0;
	    outline: 0;
	    padding: 6px 10px;
	    line-height: 24px;
	    margin: 32px auto;
	    -webkit-transition: all 0s ease-in 0.1ms;
	    -moz-transition: all 0s ease-in 0.1ms;
	    transition: all 0s ease-in 0.1ms;
	}
	.container input[type="text"] , .container input[type="password"]  {
	    background-color: #FFFFFF;
	    font-size: 16px;
	    color: #50a3a2;
	}
	.container input:focus {
	    width: 400px;
	}
	.container button:hover {
	    background-color: #FF6D00;
	}
	 
	.login ul {
	    position: absolute;
	    top: 0;
	    left: 0;
	    width: 100%;
	    height: 100%;
	    z-index: -10;
	}
	.login ul li {
	    list-style-type: none;
	    display: block;
	    position: absolute;
	    bottom: -120px;
	    width: 15px;
	    height: 15px;
	    z-index: -8;
	    background-color:rgba(255, 255, 255, 0.15);
	    animotion: square 25s infinite;
	    -webkit-animation: square 25s infinite;
	}
	.login ul li:nth-child(1) {
	    left: 0;
	    animation-duration: 10s;
	    -moz-animation-duration: 10s;
	    -o-animation-duration: 10s;
	    -webkit-animation-duration: 10s;
	}
	.login ul li:nth-child(2) {
	    width: 40px;
	    height: 40px;
	    left: 10%;
	    animation-duration: 15s;
	    -moz-animation-duration: 15s;
	    -o-animation-duration: 15s;
	    -webkit-animation-duration: 15s;
	}
	.login ul li:nth-child(3) {
	    left: 20%;
	    width: 25px;
	    height: 25px;
	    animation-duration: 12s;
	    -moz-animation-duration: 12s;
	    -o-animation-duration: 12s;
	    -webkit-animation-duration: 12s;
	}
	.login ul li:nth-child(4) {
	    width: 50px;
	    height: 50px;
	    left: 30%;
	    -webkit-animation-delay: 3s;
	    -moz-animation-delay: 3s;
	    -o-animation-delay: 3s;
	    animation-delay: 3s;
	    animation-duration: 12s;
	    -moz-animation-duration: 12s;
	    -o-animation-duration: 12s;
	    -webkit-animation-duration: 12s;
	}
	.login ul li:nth-child(5) {
	    width: 60px;
	    height: 60px;
	    left: 40%;
	    animation-duration: 10s;
	    -moz-animation-duration: 10s;
	    -o-animation-duration: 10s;
	    -webkit-animation-duration: 10s;
	}
	.login ul li:nth-child(6) {
	    width: 75px;
	    height: 75px;
	    left: 50%;
	    -webkit-animation-delay: 7s;
	    -moz-animation-delay: 7s;
	    -o-animation-delay: 7s;
	    animation-delay: 7s;
	}
	.login ul li:nth-child(7) {
	    left: 60%;
	    animation-duration: 8s;
	    -moz-animation-duration: 8s;
	    -o-animation-duration: 8s;
	    -webkit-animation-duration: 8s;
	}
	.login ul li:nth-child(8) {
	    width: 90px;
	    height: 90px;
	    left: 70%;
	    -webkit-animation-delay: 4s;
	    -moz-animation-delay: 4s;
	    -o-animation-delay: 4s;
	    animation-delay: 4s;
	}
	.login ul li:nth-child(9) {
	    width: 100px;
	    height: 100px;
	    left: 80%;
	    animation-duration: 20s;
	    -moz-animation-duration: 20s;
	    -o-animation-duration: 20s;
	    -webkit-animation-duration: 20s;
	}
	.login ul li:nth-child(10) {
	    width: 120px;
	    height: 120px;
	    left: 90%;
	    -webkit-animation-delay: 6s;
	    -moz-animation-delay: 6s;
	    -o-animation-delay: 6s;
	    animation-delay: 6s;
	    animation-duration: 30s;
	    -moz-animation-duration: 30s;
	    -o-animation-duration: 30s;
	    -webkit-animation-duration: 30s;
	}
	 
	@keyframes square {
	    0%  {
	            -webkit-transform: translateY(0);
	            transform: translateY(0)
	        }
	    100% {
	            bottom: 400px;
	            transform: rotate(600deg);
	            -webit-transform: rotate(600deg);
	            -webkit-transform: translateY(-500);
	            transform: translateY(-500)
	    }
	}
	@-webkit-keyframes square {
	    0%  {
	        -webkit-transform: translateY(0);
	        transform: translateY(0)
	    }
	    100% {
	        bottom: 400px;
	        transform: rotate(600deg);
	        -webit-transform: rotate(600deg);
	        -webkit-transform: translateY(-500);
	        transform: translateY(-500)
	    }
	}
</style>
