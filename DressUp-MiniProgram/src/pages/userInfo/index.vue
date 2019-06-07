<template>
  <div>
    <ul>
      <li class="info-li">
        <div class="theme">昵称</div>
        <input class="content" type="text" v-model="infos.username">
      </li>
      <li class="info-li">
        <div class="theme">性别</div>
        <input class="content" type="text" v-model="infos.sex">
      </li>
      <li class="info-li">
        <div class="theme">生日</div>
        <input class="content" type="text" v-model="infos.birthday">
      </li>
      <li class="info-li">
        <div class="theme">邮箱</div>
        <input class="content" type="text" v-model="infos.email">
      </li>
      <li class="info-li">
        <div class="theme">个性签名</div>
        <input class="content" type="text" v-model="infos.signature">
      </li>
    </ul>
    <button @click="toSubmit">提交</button>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        infos: {}
      }
    },
		methods: {
      //点击提交修改资料
			toSubmit(){
        let _this = this;
        _this.$fly.put('http://106.14.46.10:8081/MakeupYou/user/updateUser',
          _this.$qs.stringify({
            uid: _this.$store.state.openId,
            username: _this.infos.username,
            password: "123456",
            birthday: _this.infos.birthday,
            sex: _this.infos.sex,
            age: 20,
            register_date: "20190603",
            avatarID: "0000000001",
            description: _this.infos.signature,
            mailbox: _this.infos.email,
            last_login_time: "20190604"     
          })
        )
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });

				setTimeout(function(){
				  wx.showToast({
				    title:'修改成功！',
				    icon:'success',
				    duration: 1000
				  });
				  wx.navigateTo({url: "../index/main"});
				},500);
			}
		},
    beforeMount() {
      console.log(this.$store.state.openId);
      this.$fly.get('http://106.14.46.10:8081/MakeupYou/user/findOne/'+this.$store.state.openId)
      .then(function (response) {
        this.infos = response.data;
        
      })
      .catch(function (error) {
        console.log(error);
      });

      this.$store.dispatch('getMyCosInfo', this.infos);
      console.log(this.$store.state.myCosInfo);

      // let infos = this.$store.state.myCosInfo;
      // console.log(infos)
      // this.infos = {
      //   username: "云云",
      //   sex: 1,
      //   birthday: "19990607",
      //   email: "2434740987@qq.com",
      //   signature: "没有伞的孩子要学会奔跑！"
      // }
    }
  };
</script>

<style scoped>
  .info-li{
    float: left;
    height: 45px;
    width: 100%;
    border-bottom: 1px solid #E8E8E8;
  }
  .info-li:first-child{
    border-top: 1px solid #E8E8E8;
    margin-top: 10px;
  }
  .theme{
    float: left;
    width: 20%;
    height: 100%;
    margin-left: 20px;
    font-size: 14px;
    line-height: 45px;
  }
  .content{
    float: right;
    width: 70%;
    height: 100%;
    margin-right: 10px;
    font-size: 13px;
    line-height: 35px;
  }
  button{
    position: relative;
    top: 20px;
    width: 90%;
    height: 40px;
    font-size: 15px;
    line-height: 40px;
    background-color: #FFACAC;
    color: #fff;
    margin: 0 auto;
    border: none;
    outline: none;
    border-radius: 4px;
    cursor: pointer;
    text-align:center;
  }
  button:active{
    background-color: #FF9A9A;
  }
</style>
