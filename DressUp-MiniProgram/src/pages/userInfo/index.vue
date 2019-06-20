<template>
  <div>
    <ul>
      <li class="info-li">
        <div class="theme">昵称</div>
        <input class="content" type="text" v-model="myInfo.name">
      </li>
      <li class="info-li">
        <div class="theme">性别</div>
        <input class="content" type="text" v-model="myInfo.sex">
      </li>
      <li class="info-li">
        <div class="theme">生日</div>
        <input class="content" type="text" v-model="myInfo.birthday">
      </li>
      <li class="info-li">
        <div class="theme">邮箱</div>
        <input class="content" type="text" v-model="myInfo.mailbox">
      </li>
      <li class="info-li">
        <div class="theme">个性签名</div>
        <input class="content" type="text" v-model="myInfo.description">
      </li>
    </ul>
    <button @click="toSubmit">提交</button>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        myInfo: {}
      }
    },
		methods: {
      //修改资料
			toSubmit(){
        let _this = this;
        if(_this.myInfo.sex == "男"){
          _this.myInfo.sex1 = 1;
        }else{
          _this.myInfo.sex1 = 2;
        }
        //修改资料
        _this.$fly.put('http://106.14.46.10:8081/MakeupYou/user/update',
          _this.$qs.stringify({
            uid: _this.$store.state.openId,
            name: _this.myInfo.name,
            password: "123456",
            birthday: _this.myInfo.birthday,
            sex: _this.myInfo.sex1,
            age: 20,
            register_date: "20190603",
            avatarID: _this.$store.state.myWxInfo.avatarUrl,
            description: _this.myInfo.description,
            mailbox: _this.myInfo.mailbox,
            last_login_time: _this.$store.state.getTime()
          })
        )
        .then(function (response) {
          console.log(response);
          _this.$store.dispatch('getMyCosInfo', _this.myInfo);
          console.log("更改后的资料成功赋值给我的自定义资料");
          setTimeout(function(){
            wx.navigateBack({
              delta: 1
            })
            wx.showToast({
              title:'修改成功！',
              icon:'success',
              duration: 1000
            });
            wx.navigateTo({url: "../index/main"});
          },500);
        })
        .catch(function (error) {
          console.log(error);
          setTimeout(function(){
            wx.showToast({
              title: '修改失败！',
              icon: 'fail',
              duration: 1000
            });
            wx.navigateTo({url: "../index/main"});
          },500);
        })
			}
		},

    beforeMount() {
      let _this = this;
      //获取我的资料
      this.$fly.get('http://106.14.46.10:8081/MakeupYou/user/findUserByID/',_this.$qs.stringify({
          userID: _this.$store.state.openId
        })
      )
      .then(function (response) {
        console.log(response.data);
        console.log("获取用户资料成功");
        _this.myInfo = response.data;
        if(_this.myInfo.sex == 1){
          _this.myInfo.sex = "男";
        }else{
          _this.myInfo.sex = "女";
        }
        console.log(_this.myInfo);
        console.log("将返回的资料赋值给myInfos成功！");     
      })
      .catch(function (error) {
        console.log(error);
      });

      

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
    background-color: #FFB8B8;
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
