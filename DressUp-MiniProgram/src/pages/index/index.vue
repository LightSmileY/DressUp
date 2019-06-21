<template>
  <div class="container">
    <div class="masker1" v-if="isCeng" @click="disapp">
      <img :src="logoUrl">
      <div class="login" @touchmove.stop.prevent="touchmovehandle">   
        <button @getuserinfo="getVxUserInfo" open-type="getUserInfo" v-if="isCeng" class="btn">登录</button>
      </div>
    </div>
    <div class="masker2" v-if="coment" @click="remove"></div>
    <div class="mask-item"></div>
    <div class="main">
      <div class="content">
        <div class="navbar">
          <div v-for="(item,index) in tabs" :key="index" :id="index" :class="{'navbar_item_on':activeIndex == index}" class="navbar_item" @click="tabClick">
            <div class="navbar_title">{{item.name}}</div>
          </div>
          <div class="navbar_slider" :class="navbarSliderClass"></div>
        </div>
        <div>
          <!-- tag分页 -->
          <!-- *******************************************最新消息*************************************** -->
          <div :hidden="activeIndex != 0" v-if="isShow1">
            <div class="dymamicList">
              <ul>
                <li v-for="(dymamic,index) in newDynamics" :key="index" wx:for-index="hello" class="dymamicList-li" >
                  <div class="user">
                    <img :src="dymamic.userHeadURL" class="user-header"/>
                    <div class="name-time">
                      <div class="name">{{dymamic.userName}}</div>
                      <div class="time">{{dymamic.publishTime}}</div>
                    </div>
                  </div>
                  <div class="attent" @click="toAttent1(index)">{{dymamic.isAttent}}</div>
                  <p class="content">#{{dymamic.title}}#</p>
                  <p class="content">{{dymamic.content}}</p>
                  <div class="images">
                    <img v-for="(image,index1) in dymamic.images" :key="index1" class="image" @click="previewImg_new(index,index1)" :src="image"/>
                  </div>
                  <div class="icons">
                    <div class="forward">
                      <img class="forward-image" :src="dymamic.icon_forward"  @click="toForward(index)">
                      <span>{{dymamic.forward}}</span>
                    </div>
                    <div class="cllection" @click="toCollection1(index)">
                      <img :src="dymamic.isCollection">
                      <span>{{dymamic.favorites}}</span>
                    </div>
                    <div class="like" @click="toLike1(index)">
                      <img :src="dymamic.isLike">
                      <span>{{dymamic.likes}}</span>
                    </div>
                  </div>
                  <div class="comment">
                    <ul class="comment-ul">
                      <li class="comment-li" v-for="(comment, index2) in dymamic.comments" :key="index2">
                        <span class="username">{{comment.userName}}</span>：
                        <span class="content">{{comment.message}}</span>
                      </li>
                    </ul>
                    <button class="toComent" @click="toComent1(index)">我也要评论</button>
                    <!-- 评论框 -->
                    <div class="coment" v-if="coment">
                      <textarea autofocus="autofocus" rows="6" v-model="comment_content"></textarea>
                      <button @click="toPublish1()">发表</button>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <!-- *******************************************热门消息*************************************** -->
          <div :hidden="activeIndex != 1" v-if="isShow2">
            <div class="dymamicList">
              <ul>
                <li v-for="(dymamic,index) in hotDynamics" :key="index" wx:for-index="hello" class="dymamicList-li" >
                  <div class="user">
                    <img :src="dymamic.userHeadURL" class="user-header"/>
                    <div class="name-time">
                      <div class="name">{{dymamic.userName}}</div>
                      <div class="time">{{dymamic.publishTime}}</div>
                    </div>
                  </div>
                  <div class="attent" @click="toAttent1(index)">{{dymamic.isAttent}}</div>
                  <p class="content">#{{dymamic.title}}#</p>
                  <p class="content">{{dymamic.content}}</p>
                  <div class="images">
                    <img v-for="(image,index1) in dymamic.images" :key="index1" class="image" @click="previewImg_new(index,index1)" :src="image"/>
                  </div>
                  <div class="icons">
                    <div class="forward">
                      <img class="forward-image" :src="dymamic.icon_forward"  @click="toForward(index)">
                      <span>{{dymamic.forward}}</span>
                    </div>
                    <div class="cllection" @click="toCollection1(index)">
                      <img :src="dymamic.isCollection">
                      <span>{{dymamic.favorites}}</span>
                    </div>
                    <div class="like" @click="toLike1(index)">
                      <img :src="dymamic.isLike">
                      <span>{{dymamic.likes}}</span>
                    </div>
                  </div>
                  <div class="comment">
                    <ul class="comment-ul">
                      <li class="comment-li" v-for="(comment, index2) in dymamic.comments" :key="index2">
                        <span class="username">{{comment.userName}}</span>：
                        <span class="content">{{comment.message}}</span>
                      </li>
                    </ul>
                    <button class="toComent" @click="toComent2(index)">我也要评论</button>
                    <!-- 评论框 -->
                    <div class="coment" v-if="coment">
                      <textarea autofocus="autofocus" rows="6" v-model="comment_content"></textarea>
                      <button @click="toPublish2()">发表</button>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <!-- 发表按钮 -->
      <Publish></Publish>
    </div>
    
  </div>
</template>

<script>

  import Search from "@/components/search"
  import SwitchBar from "@/components/switch"
  import Publish from "@/components/publish"

  const appId="wx3f1f623fc2ee0247"   //开发者appid
  const secret="ba99bfbbd14208328d7939dedadfcf96"  //开发者AppSecret(小程序密钥)

  export default {

    data () {
      return {
        // switches: [],
        logoUrl: "../../static/icon/logo.png",
        newDynamics:[],
        hotDynamics: [],
        comment_content: "",
        // dymamicList1: [],
        // dymamicList2: [],
        tabs: [
          {
            name: "最新",
            type: "1",
            checked: true
          },
          {
            name: "热门",
            type: "2",
            checked: true
          }
        ],
        activeIndex: 0,
        icon_like: "../../static/icon/like.png",
        icon_collection: "../../static/icon/collection.png",
        icon_forward: "",
        like1: false,
        collection1: false,
        like2: false,
        collection2: false,
        coment: false,
        login: true,
        isCeng: true,
        isShow1: true,
        isShow2: false,
        userId: "",
        userinfo:{

        },
        openId: "",
        index: 0
      }
    },
    components:{
      // Search,
      // SwitchBar,
      Publish
    },
    computed: {
      navbarSliderClass() {
        let that = this;
        if (this.activeIndex == 0) {
          this.isShow1 = true;
          this.isShow2 = false;
          return "navbar_slider_0";
        }
        if (this.activeIndex == 1) {
          this.isShow1 = false;
          this.isShow2 = true;
          return "navbar_slider_1";
        }
        that.onload();
      }
    },
    methods: {
      //用户授权
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
      //判断是否已授权，授权则登录    
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
      //登录成功后的信息处理    
      loginOk(res){  
        let _this=this;
        _this.userinfo.encryptedData=res.encryptedData;
            _this.userinfo.iv=res.iv;
            _this.userinfo.rawData=res.rawData;
            _this.userinfo.signature=res.signature;
            _this.userinfo.infos=res.userInfo;
            _this.userName=res.userInfo.nickName;
            _this.getOpenId()
            _this.isCeng=false;
            _this.$store.dispatch('getMyWxInfo', _this.userinfo.infos);
            console.log(_this.$store.state.myWxInfo);
      },
      //获取用户的openid
      getOpenId(){  
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
                  _this.userinfo.session_key=res.data.session_key;
                  _this.userinfo.openid=res.data.openid;

                  _this.$store.dispatch('getOpenId', _this.userinfo.openid);
                  console.log(_this.$store.state.openId);

                  console.log(_this.userName);

                  //注册
                  _this.$fly.post('http://106.14.46.10:8081/MakeupYou/user/register',_this.$qs.stringify({
                      uid: _this.userinfo.openid,
                      name: _this.userName,
                      password: "123456",
                      birthday: "",
                      sex: null,
                      age: 0,
                      register_date: _this.$store.state.getTime(),
                      avatarID: _this.$store.state.myWxInfo.avatarUrl,
                      description: "",
                      mailbox: "",
                      last_login_time: _this.$store.state.getTime()     
                    })
                  )
                  .then(function (response) {
                    console.log(response);

                    // 登录
                    _this.$fly.post('http://106.14.46.10:8081/MakeupYou/user/login',_this.$qs.stringify({
                        uid: _this.userinfo.openid,
                        name: _this.userName,
                        password: "123456",
                        birthday: "",
                        sex: 0,
                        age: 0,
                        register_date: _this.$store.state.getTime(),
                        avatarID: _this.$store.state.myWxInfo.avatarUrl,
                        description: "",
                        mailbox: "",
                        last_login_time: _this.$store.state.getTime()     
                      })
                    )
                    .then(function (response) {
                      console.log(response);
                      console.log("登录成功");

                      // 从服务器获取用户资料
                      _this.$fly.get('http://106.14.46.10:8081/MakeupYou/user/findUserByID/',_this.$qs.stringify({
                          userID: _this.userinfo.openid
                        })
                      )
                      .then(function (response) {
                        console.log(response.data);
                        console.log("从服务器获取用户资料成功");
                        
                        _this.$store.state.myCosInfo = response.data;
                        console.log(_this.$store.state.myCosInfo);
                        console.log("将服务器返回的资料赋值给_this.$store.state.myCosInfo成功！");

                        _this.getPosts();

                      })
                      .catch(function (error) {
                        console.log(error);
                      });
                    })
                    .catch(function (error) {
                      console.log(error);
                      
                    });
                  })
                  .catch(function (error) {
                    console.log(error);
                  });
                }
              })
            } else {
              console.log('登录失败！' + res.errMsg)
            }
          }
        })
      },
      // 点击评论按钮
      toComent1(i){
        this.index = i;
        this.coment = !this.coment;
      },
      //点击遮罩层
      remove(){
        this.coment = !this.coment;
      },
      // 发表评论
      toPublish1(){
        let _this = this;
        _this.$fly.post('http://106.14.46.10:8081/MakeupYou/comments/addRecord',_this.$qs.stringify({
            userID: _this.$store.state.openId,
            postID: _this.newDynamics[_this.index].pid,
            time: _this.$store.state.getTime(),
            message: _this.comment_content
          })
        )
        .then(function (response) {
          console.log(response);
          console.log("评论成功！");
          console.log(_this.index);
          console.log(_this.newDynamics[_this.index].pid);
          console.log(_this.comment_content);
          setTimeout(function(){
            wx.showToast({
              title:'已评论！',
              icon:'success',
              duration: 1000
            })
          },500)
          _this.comment_content = "";
          _this.getPosts();
        })
        .catch(function (error) {
          console.log(error);
        });
        this.coment = !this.coment;
      },
      //tab换页
      tabClick(e) {
        this.activeIndex = e.currentTarget.id;
        this.getPosts();
      },
      // 关注
      toAttent1(i){
        let _this = this;
        if(this.newDynamics[i].isAttent == "关注TA"){
          //调用接口
          _this.$fly.post('http://106.14.46.10:8081/MakeupYou/relation/addRelation',_this.$qs.stringify({
              fansID: _this.userinfo.openid,
              followsID: _this.newDynamics[i].uid
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("关注成功！");
            _this.getPosts();
          })
          .catch(function (error) {
            console.log(error);
          });
          this.newDynamics[i].isAttent = "已关注";
        }
        else{
          _this.$fly.delete('http://106.14.46.10:8081/MakeupYou/relation/deleteRelation',_this.$qs.stringify({
              fansID: _this.userinfo.openid,
              followsID: _this.newDynamics[i].uid
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("取消关注！");
            _this.getPosts();
          })
          .catch(function (error) {
            console.log(error);
          });
          this.newDynamics[i].isAttent = "关注TA";
        }
      },
      //点赞
      toLike1(i){
        let _this = this;
        if(this.newDynamics[i].isLike == "../../static/icon/like.png"){
          // 点赞
          _this.$fly.post('http://106.14.46.10:8081/MakeupYou/likes/addRecord',_this.$qs.stringify({
              userID: _this.userinfo.openid,
              postID: _this.newDynamics[i].pid,
              time: _this.$store.state.getTime()
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("点赞成功！");
          })
          .catch(function (error) {
            console.log(error);
          });
          this.newDynamics[i].isLike = "../../static/icon/like-active.png";
          this.newDynamics[i].likes += 1;
        }
        else{
          // 取消点赞
          _this.$fly.delete('http://106.14.46.10:8081/MakeupYou/likes/deleteRecord',_this.$qs.stringify({
              userID: _this.userinfo.openid,
              postID: _this.newDynamics[i].pid,
              time: _this.$store.state.getTime()
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("取消点赞！");
          })
          .catch(function (error) {
            console.log(error);
          });
          this.newDynamics[i].isLike = "../../static/icon/like.png";
          this.newDynamics[i].likes -= 1;
        }
      },
      //收藏
      toCollection1(i){
        let _this = this;
        if(this.newDynamics[i].isCollection == "../../static/icon/collection.png"){
          // 收藏
          _this.$fly.post('http://106.14.46.10:8081/MakeupYou/favorites/addRecord',_this.$qs.stringify({
              userID: _this.userinfo.openid,
              postID: _this.newDynamics[i].pid,
              time: _this.$store.state.getTime()
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("收藏成功!");
          })
          .catch(function (error) {
            console.log(error);
          });
          this.newDynamics[i].isCollection = "../../static/icon/collection-active.png";
          this.newDynamics[i].favorites += 1;
        }
        else{
          // 取消收藏
          _this.$fly.delete('http://106.14.46.10:8081/MakeupYou/favorites/deleteRecord', _this.$qs.stringify({
              userID: _this.userinfo.openid,
              postID: _this.newDynamics[i].pid,
              time: _this.$store.state.getTime()
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("取消收藏！");
          })
          .catch(function (error) {
            console.log(error);
          });
          this.newDynamics[i].isCollection = "../../static/icon/collection.png";
          this.newDynamics[i].favorites -= 1;
        }
      },
      // 点击评论按钮
      toComent2(i){
        this.index = i;
        this.coment = !this.coment;
      },
      //点击遮罩层
      remove(){
        this.coment = !this.coment;
      },
      // 发表评论
      toPublish2(){
        let _this = this;
        _this.$fly.post('http://106.14.46.10:8081/MakeupYou/comments/addRecord',_this.$qs.stringify({
            userID: _this.$store.state.openId,
            postID: _this.hotDymamics[_this.index].pid,
            time: _this.$store.state.getTime(),
            message: _this.comment_content
          })
        )
        .then(function (response) {
          console.log(response);
          console.log("评论成功！");
          console.log(_this.index);
          console.log(_this.hotDymamics[_this.index].pid);
          console.log(_this.comment_content);
          setTimeout(function(){
            wx.showToast({
              title:'已评论！',
              icon:'success',
              duration: 1000
            })
          },500)
          _this.comment_content = "";
          _this.getPosts();
        })
        .catch(function (error) {
          console.log(error);
        });
        this.coment = !this.coment;
      },
      // 关注
      toAttent2(i){
        let _this = this;
        if(this.hotDymamics[i].isAttent == "关注TA"){
          //调用接口
          _this.$fly.post('http://106.14.46.10:8081/MakeupYou/relation/addRelation',_this.$qs.stringify({
              fansID: _this.userinfo.openid,
              followsID: _this.hotDymamics[i].uid
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("关注成功！");
            _this.getPosts();
          })
          .catch(function (error) {
            console.log(error);
          });
          this.hotDymamics[i].isAttent = "已关注";
        }
        else{
          _this.$fly.delete('http://106.14.46.10:8081/MakeupYou/relation/deleteRelation',_this.$qs.stringify({
              fansID: _this.userinfo.openid,
              followsID: _this.hotDymamics[i].uid
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("取消关注！");
            _this.getPosts();
          })
          .catch(function (error) {
            console.log(error);
          });
          this.hotDymamics[i].isAttent = "关注TA";
        }
      },
      //点赞
      toLike2(i){
        let _this = this;
        if(this.hotDymamics[i].isLike == "../../static/icon/like.png"){
          // 点赞
          _this.$fly.post('http://106.14.46.10:8081/MakeupYou/likes/addRecord',_this.$qs.stringify({
              userID: _this.userinfo.openid,
              postID: _this.hotDymamics[i].pid,
              time: _this.$store.state.getTime()
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("点赞成功！");
          })
          .catch(function (error) {
            console.log(error);
          });
          this.hotDymamics[i].isLike = "../../static/icon/like-active.png";
          this.hotDymamics[i].likes += 1;
        }
        else{
          // 取消点赞
          _this.$fly.delete('http://106.14.46.10:8081/MakeupYou/likes/deleteRecord',_this.$qs.stringify({
              userID: _this.userinfo.openid,
              postID: _this.hotDymamics[i].pid,
              time: _this.$store.state.getTime()
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("取消点赞！");
          })
          .catch(function (error) {
            console.log(error);
          });
          this.hotDymamics[i].isLike = "../../static/icon/like.png";
          this.hotDymamics[i].likes -= 1;
        }
      },
      //收藏
      toCollection2(i){
        let _this = this;
        if(this.hotDymamics[i].isCollection == "../../static/icon/collection.png"){
          // 收藏
          _this.$fly.post('http://106.14.46.10:8081/MakeupYou/favorites/addRecord',_this.$qs.stringify({
              userID: _this.userinfo.openid,
              postID: _this.hotDymamics[i].pid,
              time: _this.$store.state.getTime()
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("收藏成功!");
          })
          .catch(function (error) {
            console.log(error);
          });
          this.hotDymamics[i].isCollection = "../../static/icon/collection-active.png";
          this.hotDymamics[i].favorites += 1;
        }
        else{
          // 取消收藏
          _this.$fly.delete('http://106.14.46.10:8081/MakeupYou/favorites/deleteRecord', _this.$qs.stringify({
              userID: _this.userinfo.openid,
              postID: _this.hotDymamics[i].pid,
              time: _this.$store.state.getTime()
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("取消收藏！");
          })
          .catch(function (error) {
            console.log(error);
          });
          this.hotDymamics[i].isCollection = "../../static/icon/collection.png";
          this.hotDymamics[i].favorites -= 1;
        }
      },
      //转发
      toForward(){
        wx.showModal({
          title: '提示',
          content: '确认要转发帖子吗？',
          success: function (sm) {
            if (sm.confirm) {
              console.log('转发成功')
              setTimeout(function(){
                wx.showToast({
                  title:'转发成功！',
                  icon:'success',
                  duration: 2000
                })
              },1000)
            } else if (sm.cancel) {
              console.log('用户取消转发')
            }
          }
        })
      },
      //预览图片
      previewImg_new(i,j){
        wx.previewImage({
          current: this.newDynamics[i].images[j],
          urls: this.newDynamics[i].images
        });
      },
			previewImg_hot(i,j){
			  wx.previewImage({
			    current: this.hotDynamics[i].images[j],
			    urls: this.hotDynamics[i].images
			  });
			},
      getPosts(){
        let _this = this;
        _this.$fly.get('http://106.14.46.10:8081/MakeupYou/appService/getMainPage', _this.$qs.stringify({
            userID: _this.userinfo.openid   
          })
        )
        .then(function (response) {
          console.log(response);

          _this.newDynamics = response.data.reverse();
          _this.hotDynamics = response.data;

          // _this.newDynamics = response.data.sort(_this.$store.state.createComparison("publishTime"));
          // _this.hotDynamics = response.data.sort(_this.$store.state.createComparison("favorites"));
          
          
          
          for(let index in _this.newDynamics){

            if (_this.newDynamics[index].isLike === false) {
              _this.newDynamics[index].isLike = "../../static/icon/like.png";
            }else {
              _this.newDynamics[index].isLike = "../../static/icon/like-active.png";
            }

            if (_this.newDynamics[index].isCollection === false) {
              _this.newDynamics[index].isCollection = "../../static/icon/collection.png";
            }else {
              _this.newDynamics[index].isCollection = "../../static/icon/collection-active.png";
            }

            if (_this.newDynamics[index].isAttent === false) {
              _this.newDynamics[index].isAttent = "关注TA";
            }else {
              _this.newDynamics[index].isAttent = "已关注";
            }
          }
          console.log(_this.newDynamics);
          console.log("成功获取数据赋值给newDynamics");
        })
        .catch(function (error) {
          console.log(error);
        });
      }
    },
    onShow(){
      this.getPosts();
    },
    beforeMount(){
      this.isLogin();
      // _this.newDynamics.forEach( function(element, index) {
        // _this.$fly.get('http://106.14.46.10:8081/MakeupYou/post/findPostByID/1099841361')
        // .then(function (response) {
        //   console.log(response);
        //   // element = response.data;
        //   // console.log(_this.newDynamics);
        //   console.log("gggggggggggggggg");
        // })
        // .catch(function (error) {
        //   console.log(error);
        // });
      // });
    },
    mounted(){
      this.switches = ["最新", "热门"];
    }
  };
</script>

<style scoped>
  /*----------------------整个页面-----------------------  */
  .container{
    margin: 0;
    padding: 0;
    background-color: #fff;
  }
  .main{
    position: relative;
    width: 90%;
    margin: 0 auto;
  }
  .content {
    box-sizing: border-box;
    margin-top: 41px;
    -webkit-overflow-scrolling: touch;
  }
  /*----------------------顶部栏-----------------------  */
  .mask-item{
    position: fixed;
    top: 0;
    width: 100%;
    height: 40px;
    background-color: #fff;
    z-index: 100;
    box-shadow: 0 3px 5px #E9E9E9;
  }
  .swiper-item {
    height: 100%;
    text-align: center;
  }
  .navbar {
    position: relative;
    left: 50%;
    margin-left: -80px;
    display: -webkit-box;
    display: -webkit-flex;
    display: flex;
    position: fixed;
    z-index: 500;
    top: 0;
    padding-bottom: 0;
    height: 40px;
    width: 160px;
  }

  .navbar_item {
    position: relative;
    display: block;
    -webkit-box-flex: 1;
    -webkit-flex: 1;
    flex: 1;
    padding: 9px 0;
    text-align: center;
    font-size: 0;
  }

  .navbar_item .navbar_item_on {
    color: white;
  }

  .navbar_title {
    color: #000;
    display: inline-block;
    font-size: 15px;
    max-width: 100%;
  }

  .navbar_slider {
    position: absolute;
    content: " ";
    left: 0;
    bottom: 0;
    width: 40%;
    height: 4px;
    background-color: #FFAEAE;
    -webkit-transition: -webkit-transform 0.3s;
    transition: -webkit-transform 0.3s;
    transition: transform 0.3s;
    transition: transform 0.3s, -webkit-transform 0.3s;
  }

  .navbar_slider_0 {
    left: 5%;
    transform: translateX(0);
  }

  .navbar_slider_1 {
    left: 5%;
    transform: translateX(125%);
  }

  .dymamicList-li{
    position: relative;
    top: 40px;
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
    margin-top: 3px;
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
    overflow: hidden;
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
    width: 35px;
    height: 22px;
    font-size: 13px;
    line-height: 22px;
    position: relative;
    top: -5px;
    margin-left: 2px;
    overflow: hidden;
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
  /* .mask {
    position: fixed;
    width: 100vw;
    height: 100vh;
    background-color: rgba(0, 0, 0, 0.3)
  } */
  .coment {
    position: fixed;
    top: 20vh;
    left: 50%;
    margin-left: -40vw;
    width: 80%;
    height: 180px;
    border: 1px solid #B2B2B2;
    border-radius: 10px;
    background-color: #fff;
    z-index: 9999999;
  }
  .coment textarea {
    position: relative;
    width: 68vw;
    height: 110px;
    margin: 15px 4vw 0;
    padding: 5px 2vw;
    border: 1px solid #E4E4E4;
    font-size: 15px;
    z-index: 99999999;
  }
  .coment button {
    width: 72vw;
    height: 28px;
    margin-top: 7px;
    font-size: 14px;
    line-height: 28px;
    background-color: #FFD4D4;
  }
  .coment button:active {
    background-color: #FFB5B5;
  }
  .masker2{
    position: fixed;
    width: 100vw;
    height: 100vh;
    background-color: rgba(0, 0, 0, .2);
    z-index: 999999;
    margin: 0;
    padding: 0;
  }
  .masker1{
    position: fixed;
    width: 100vw;
    height: 100vh;
    background-color: #fff;
    z-index: 999999;
    margin: 0;
    padding: 0;
    z-index: 999999999;
  }
  .masker1 img{
    position: absolute;
    top: 50%;
    left: 50%;
    margin-left: -50px;
    margin-top: -170px;
    width: 100px;
    height: 100px;
  }
  .login button{
    position: absolute;
    left: 50%;
    top: 50%;
    width: 90%;
    height: 40px;
    line-height: 40px;
    margin-left: -45vw;
    margin-top: 20px;
    background-color: #FFC6C6;
  }
  .login:active{
    background-color: #FFB7B7;
  }
  .attent{
    position: absolute;
    top: 15px;
    right: 10px;
    width: 45px;
    height: 18px;
    font-size: 12px;
    line-height: 18px;
    text-align: center;
    border: 1px solid #FF8A8A;
    border-radius: 5px;
    background-color: #FFE9E9;
  }
</style>