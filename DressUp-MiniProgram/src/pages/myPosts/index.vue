<template>
  <div class="container">
    <div class="masker2" v-if="coment" @click="remove"></div>
    <div class="main">
      <div class="content">
        <div>
          <!-- *******************************************最新消息*************************************** -->
          <div>
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
                  <div class="attent" @click="toAttent(index)">{{dymamic.isAttent}}</div>
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
                    <div class="cllection" @click="toCollection(index)">
                      <img :src="dymamic.isCollection">
                      <span>{{dymamic.favorites}}</span>
                    </div>
                    <div class="like" @click="toLike(index)">
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
                    <button class="toComent" @click="toComent(index)">我也要评论</button>
                    <!-- 评论框 -->
                    <div class="coment" v-if="coment">
                      <textarea autofocus="autofocus" rows="6" v-model="comment_content"></textarea>
                      <button @click="toPublish()">发表</button>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import Search from "@/components/search"
  import SwitchBar from "@/components/switch"

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
      // 点击评论按钮
      toComent(i){
        this.index = i;
        this.coment = !this.coment;
      },
      //点击遮罩层
      remove(){
        this.coment = !this.coment;
      },
      // 发表评论
      toPublish(){
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
      toAttent(i){
        let _this = this;
        if(this.newDynamics[i].isAttent == "关注TA"){
          //调用接口
          _this.$fly.post('http://106.14.46.10:8081/MakeupYou/relation/addRelation',_this.$qs.stringify({
              fansID: _this.$store.state.openId,
              followsID: _this.newDynamics[i].uid
            })
          )
          .then(function (response) {
            console.log(response);
            console.log("关注成功！");
            _this.getMyPosts();
          })
          .catch(function (error) {
            console.log(error);
          });
          this.newDynamics[i].isAttent = "已关注";
        }
        else{
          _this.$fly.delete('http://106.14.46.10:8081/MakeupYou/relation/deleteRelation',_this.$qs.stringify({
              fansID: _this.$store.state.openId,
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
      toLike(i){
        let _this = this;
        if(this.newDynamics[i].isLike == "../../static/icon/like.png"){
          // 点赞
          _this.$fly.post('http://106.14.46.10:8081/MakeupYou/likes/addRecord',_this.$qs.stringify({
              userID: _this.$store.state.openId,
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
              userID: _this.$store.state.openId,
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
      toCollection(i){
        let _this = this;
        if(this.newDynamics[i].isCollection == "../../static/icon/collection.png"){
          // 收藏
          _this.$fly.post('http://106.14.46.10:8081/MakeupYou/favorites/addRecord',_this.$qs.stringify({
              userID: _this.$store.state.openId,
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
              userID: _this.$store.state.openId,
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
      getMyPosts(){
        let _this = this;
        _this.$fly.get('http://106.14.46.10:8081/MakeupYou/appService/getMyPosts', _this.$qs.stringify({
            userID: _this.$store.state.openId
          })
        )
        .then(function (response) {
          console.log(response);
          _this.newDynamics = response.data.reverse();
          
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
      this.getMyPosts();
    },
    beforeMount(){
      console.log(this.$store.state.getTime());
      this.getMyPosts();
    },
    mounted(){

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

  .dymamicList-li{
    position: relative;
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