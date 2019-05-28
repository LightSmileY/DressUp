<template>
  <div class="mine">
    <div class="myInfo">
      <div class="user">
        <div class="image">
          <img v-if="!isCeng" :src="myInfo.image">
        </div>
        <div v-if="!isCeng" class="userName">{{myInfo.name}}</div>
        <div v-if="!isCeng" class="signature">{{myInfo.signature}}</div>
      </div>
      <div class="entry">
        <div v-for="(item,index) in entries" :key="index" @click="itemClick(item)">
          <div v-if="!isCeng" class="count">{{item.count}}</div>
          <div class="theme">{{item.theme}}</div>
        </div>
      </div>
    </div>
    <Navi :arrayList="navis"></Navi>
    <div class="ceng" v-if="isCeng" @touchmove.stop.prevent="touchmovehandle">    
      <button @getuserinfo="getVxUserInfo" open-type="getUserInfo" v-if="!userName" class="btn">登录</button>
    </div>
  </div>
</template>

<script>
  import Navi from "@/components/nav"


  const appId="wx3f1f623fc2ee0247"   //开发者appid
  const secret="ba99bfbbd14208328d7939dedadfcf96"  //开发者AppSecret(小程序密钥)

  export default{
    data () {
      return {
        navis: [],
        myInfo: {},
        entries: [],
        isCeng: true,
        userId: "",
        userinfo:{},
        openId: ""
      }
    },
    components:{
      Navi
    },
    methods: {
      itemClick(e) {
        wx.navigateTo({url: e.path})
      },
      getVxUserInfo(e){       
        if(e.target.userInfo){
          this.userName=e.target.userInfo.nickName;
          this.isCeng=false;
          this.isLogin()
        }else{
          this.userName="";
          this.isCeng=true;
        } 
      },    
      isLogin(){    
        var _this=this;
        wx.getSetting({
          success(res) {                   
            if (!res.authSetting['scope.userInfo']) {//未授权getUserInfo             
              wx.authorize({
                scope: 'scope.getUserInfo',
                success(res) {                  
                  // 用户已经同意小程序使用用户信息，后续调用 wx.userInfo 接口不会弹窗询问       
                  console.log(res)
                  _this.isCeng=false;
                  _this.userName=res.target.userInfo.nickName; 
                },
                fail(err){
                 console.log(err)
                }
              })
            }else{//已授权
              wx.getUserInfo({
                success(res) {  
                  _this.loginOk(res)
                },
                fail(err) {
                  console.log(err)
                }
              })
            }
          }
        })
      },
      touchmovehandle(){ //解决vue蒙层滑动穿透问题
        
      },    
      loginOk(res){  //登录成功后的信息处理
        let _this=this;
        _this.userinfo.encryptedData=res.encryptedData;
        _this.userinfo.iv=res.iv;
        _this.userinfo.rawData=res.rawData;
        _this.userinfo.signature=res.signature;
        _this.userinfo.infos=res.userInfo;
        _this.getOpenId();
        _this.myInfo.name=res.userInfo.nickName;
        _this.myInfo.image=res.userInfo.avatarUrl;
        _this.userinfo.openid=res.data.openid;
        _this.isCeng=false;
        console.log(_this.userinfo);
      },
      getOpenId(){  //获取用户的openid
        let _this=this;
        wx.login({
          success(res) {
            if (res.code) {
            // 发起网络请求
              wx.request({
                url: 'https://api.weixin.qq.com/sns/jscode2session',
                data: {
                  appid:appId,  //开发者appid
                  secret:secret, //开发者AppSecret(小程序密钥)  
                  grant_type:"authorization_code",  //默认authorization_code
                  js_code: res.code    //wx.login登录获取的code值
                },
                success(res) {
                  _this.userinfo.openid=res.data.openid;
                  _this.userinfo.session_key=res.data.session_key;  
                  console.log(_this.userinfo.openid);
                }
              })
            } else {
              console.log('登录失败！' + res.errMsg)
            }   
          }
        })
      }
    },
    mounted(){
      this.$fly.post('http://10.100.200.250:8081/MakeupYou/user/addUser', 
        this.$qs.stringify({
          uid: "qxblx",
          username: "浅笑半离兮",
          password: "111111",
          birthday: "19991111",
          sex: 1,
          age: 20,
          register_date: "20191111",
          avatarID: "111",
          description: "111",
          mailbox: "111",
          last_login_time: "20190101"     
        })
      )
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });

      this.myInfo = {
          signature: "眼里有光，目光皆是美意。内心无花，似锦繁花与荒芜无差。"
      };
      this.entries = [
        {
          count: 24,
          path: "../myPosts/main",
          theme: "帖子"
        },
        {
          count: 9,
          path: "../myFocus/main",
          theme: "关注"
        },
        {
          count: 32,
          path: "../myFans/main",
          theme: "粉丝"
        }
      ];
      this.navis = [
        {
          icon: "../../static/icon/info.png",
          path: "../userInfo/main",
          theme: "我的资料",
          front: "../../static/icon/front.png"
        },
        {
          icon: "../../static/icon/collection.png",
          theme: "我的收藏",
          path: "../myCollection/main",
          front: "../../static/icon/front.png"
        }
      ];
      
    },
    created(){
      
    }
  };
</script>

<style scoped>
  .main{
    position: relative;
    width: 90%;
    margin: 0 auto;
  }
  .ceng button{
    width: 90%;
    height: 40px;
    margin: 15px auto;
    background-color: #FFBDBD;
    border: none;
    outline: none;
    font-size: 18px;
    line-height: 40px;
  }
  .myInfo{
    height: 145px;
    margin-bottom: 20px;
    border-bottom: 1px solid #E2E2E2;
  }
  .user{
    height: 85px;
  }
  .image{
    width: 55px;
    height: 55px;
    margin: 15px;
    float: left;
  }
  img{
    width: 100%;
    height: 100%;
    border-radius: 50%;
    border: 1px solid #D7D7D7;
  }
  .userName{
    width: 60%;
    font-size: 16px;
    margin-top: 15px;
    float: left;
  }
  .signature{
    width: 250px;
    height: 30px;
    font-size: 10px;
    margin-top: 8px;
    float: left;
  }
  .entry{
    height: 60px;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
    color: #646464;
  }
  .entry > div{
    flex-grow: 1;
  }
  .count{
    font-size: 14px;
    margin-bottom: 4px;
  }
  .theme{
    font-size: 16px;
  }
</style>