<template>
  <div class="index">
    <!-- <h1>{{ msg }}</h1>
    <form>
      <input type="file" @change="getFile($event)">
      <button class="button button-primary button-pill button-small" @click="submit($event)">提交</button>
    </form> -->
    <!-- <el-upload
      :multiple="multiple"
      action="${pageContext.request.contextPath}/lookup/editEvidence/123"
      list-type="picture-card"
      :auto-upload="false"
      :http-request="uploadFile"
      ref="upload"
      >
    <i class="el-icon-plus"></i>
    </el-upload>
    <el-button @click="subPicForm">提交上传</el-button> -->
    <div class="container">
      <div class="main">
        <div class="tabbar">
          <button class="new" @click="getPosts">最新</button>
          <button class="hot">热门</button>
        </div>
        <div class="write" title="发表帖子" @click="publish">
          <img src="@/assets/icon/edit.png">
        </div>
        <div class="new-dymamics">
          <!-- <c-dymamic :arrayList="newDynamics"/> -->
          <!-- 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000 -->
          <div v-for="(dymamic,index) in newDynamics" :key="index" class="dymamicList">
            <!-- 用户信息及关注按钮 -->
            <div class="user-info">
              <img  :src="dymamic.userHeadURL" alt="头像" class="header">
              <div class="name-time">
                <div class="userName">{{dymamic.userName}}</div>
                <div class="publishTime">{{dymamic.publishTime}}</div>
              </div>
              <button class="attent" @click="toAttent(index)">{{dymamic.isAttent}}</button>
            </div>
            <!-- 帖子内容 -->
            <div class="mainDymamic">
              <span class="title">#{{dymamic.title}}#</span>
              <p class="message">{{dymamic.content}}</p>
              <div class="images">
                <img v-for="(image,index1) in dymamic.images" :key="index1" :src="image"/>
              </div>
            </div>
            <!-- 点赞、收藏、转发 -->
            <div class="operate">
              <div class="like">
                <img :src="dymamic.isLike">
                <span class="count">{{dymamic.likes}}</span>
              </div>
              <div class="collection">
                <img :src="dymamic.isCollection">
                <span class="count">{{dymamic.favorites}}</span>
              </div>
              <div class="share">
                <img src="@/assets/icon/share.png">
                <span class="count">0</span>
              </div>
            </div>
            <!-- 评论 -->
            <div class="comments">
              <div class="comment" v-for="(comment, index2) in dymamic.comments" @click="toComent(index)" :key="index2">
                <span class="userName">{{comment.userName}}</span>:&nbsp;
                <span class="content">{{comment.message}}</span>
              </div>
              <textarea id="coInput" rows="3" placeholder="我也要评论···" v-model="comment_content"></textarea>
              <button class="toComment" @click="toPublish(index)">发表</button>
            </div>
          </div>
          <!-- 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000 -->
        </div>
        <div class="hot-dymamics">
          <!-- <c-dymamic :arrayList="hotDymamics"/> -->
        </div>
      </div>
      <nav>
        <!-- 我的资料 -->
        <div class="Me">
          <div class="myInfo">
            <div class="myHeader">
              <img :src="myInfo.avatarID">
            </div>
            <div class="myUserName">{{myInfo.name}}</div>
            <div class="mySignature">{{myInfo.description}}</div>
          </div>
          <div class="items">
            <dl class="myPosts">
              <dt class="title">帖子</dt>
              <dd class="count">{{postNum}}</dd>
            </dl>
            <dl class="myPosts">
              <dt class="title">关注</dt>
              <dd class="count">{{attentNum}}</dd>
            </dl>
            <dl class="myPosts">
              <dt class="title">粉丝</dt>
              <dd class="count">{{fansNum}}</dd>
            </dl>
          </div>
        </div>
        <ul class="aboutMe">
          <li class="title">与我相关</li>
          <li class="aboutMe-li" @click="likeMe">
            <img src="@/assets/icon/like.png" class="icon">
            <div class="theme">点赞我的</div>
            <div class="messages" v-if="isShowLike">
              <c-message title="点赞我的" :arrayList="message"></c-message>
            </div>
          </li>
          <li class="aboutMe-li" @click="collectMe">
            <img src="@/assets/icon/collection.png" class="icon">
            <div class="theme">收藏我的</div>
            <div class="messages" v-if="isShowCollection">
              <c-message title="收藏我的" :arrayList="message"></c-message>
            </div>
          </li>
          <li class="aboutMe-li" @click="comentMe">
            <img src="@/assets/icon/evaluation.png" class="icon">
            <div class="theme">评论我的</div>
            <div class="messages" v-if="isShowComment">
              <c-message title="评论我的" :arrayList="message"></c-message>
            </div>
          </li>
          <li class="aboutMe-li" @click="attentMe">
            <img src="@/assets/icon/attention.png" class="icon">
            <div class="theme">关注我的</div>
            <div class="mask"></div>
            <div class="messages" v-if="isShowAttent">
              <c-message title="关注我的" :arrayList="message"></c-message>
            </div>
          </li>
          <li class="aboutMe-li"  @click="forwardMe">
            <img src="@/assets/icon/share.png" class="icon">
            <div class="theme">转发我的</div>
            <div class="messages" v-if="isShowForward">
              <c-message title="转发我的" :arrayList="message"></c-message>
            </div>
          </li>
        </ul>
        <div class="recommend">
          
        </div>
      </nav>
      <div class="publishMask" v-if="isPublish">
        <div class="publish">
          <c-publish></c-publish>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  // import CDymamic from '@/components/dymamic';
  import CMessage from '@/components/message';
  import CPublish from '@/components/publishPage';

  export default {
    name: 'Index',
    data() {
      return {
        myInfo: {},
        newDynamics: [],
        message: [],
        nickName: "",
        description: "",
        postNum: 0,
        attentNum: 0,
        fansNum: 0,
        collectionNum: 0,
        isPublish: 0,
        isShowLike: 0,
        isShowCollection: 0,
        isShowComment: 0,
        isShowAttent: 0,
        isShowForward: 0,


        comment_content: "",


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
    components: {
      // CDymamic,
      CMessage,
      CPublish
    },
    beforeMount(){
      this.getMyPosts();
      this.getMyFocus();
      this.getMyFans();
      setTimeout(() => {
        this.getPosts();
        this.getMyInfo();
      },100);
    },
    methods: {
      likeMe(){
        setTimeout(() => {
          this.isShowLike = !this.isShowLike;
          this.isShowCollection = 0;
          this.isShowComment = 0;
          this.isShowAttent = 0;
          this.isShowForward = 0;
        },100);
        this.$options.methods.getLikeMe(this);
      },
      collectMe(){
        setTimeout(() => {
          this.isShowCollection = !this.isShowCollection;
          this.isShowLike = 0;
          this.isShowComment = 0;
          this.isShowAttent = 0;
          this.isShowForward = 0;
        },100);
        this.$options.methods.getCollectMe(this);
      },
      comentMe(){
        setTimeout(() => {
          this.isShowComment = !this.isShowComment;
          this.isShowLike = 0;
          this.isShowCollection = 0;
          this.isShowAttent = 0;
          this.isShowForward = 0;
        },100);
        this.$options.methods.getComentMe(this);
      },
      attentMe(){
        setTimeout(() => {
          this.isShowAttent = !this.isShowAttent;
          this.isShowComment = 0;
          this.isShowLike = 0;
          this.isShowCollection = 0;
          this.isShowForword = 0;
        },100);
        this.$options.methods.getAttentMe(this);
      },  
      forwardMe(){
        setTimeout(() => {
          this.isShowForward = !this.isShowForword;
          this.isShowComment = 0;
          this.isShowLike = 0;
          this.isShowCollection = 0;
          this.isShowAttent = 0;
        },100);
      },  
      // 发表评论
      toPublish(i){
        let _this = this;
        _this.$axios.post('http://106.14.46.10:8081/MakeupYou/comments/addRecord',_this.$qs.stringify({
            userID: _this.$store.state.myCosInfo.uid,
            postID: _this.newDynamics[i].pid,
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
          _this.$axios.post('http://106.14.46.10:8081/MakeupYou/relation/addRelation',_this.$qs.stringify({
              fansID: _this.$store.state.myCosInfo.uid,
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
          _this.$axios.delete('http://106.14.46.10:8081/MakeupYou/relation/deleteRelation',{
              params: {
                fansID: _this.$store.state.myCosInfo.uid,
                followsID: _this.newDynamics[i].uid
              }
            }
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
          _this.$axios.post('http://106.14.46.10:8081/MakeupYou/likes/addRecord',_this.$qs.stringify({
              userID: _this.$store.state.myCosInfo.uid,
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
          _this.$axios.delete('http://106.14.46.10:8081/MakeupYou/likes/deleteRecord',{
              params: {
                userID: _this.$store.state.myCosInfo.uid,
                postID: _this.newDynamics[i].pid,
                time: _this.$store.state.getTime()
              }
            }
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
          _this.$axios.post('http://106.14.46.10:8081/MakeupYou/favorites/addRecord',_this.$qs.stringify({
              userID: _this.$store.state.myCosInfo.uid,
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
          _this.$axios.delete('http://106.14.46.10:8081/MakeupYou/favorites/deleteRecord', {
              params: {
                userID: _this.$store.state.myCosInfo.uid,
                postID: _this.newDynamics[i].pid,
                time: _this.$store.state.getTime()
              }
            }
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
      publish(){
        this.isPublish = !this.isPublish;
      },
      getPosts(){
        let _this = this;
        _this.$axios.get('http://106.14.46.10:8081/MakeupYou/appService/getMainPage', {
            params: {
              userID: _this.$store.state.myCosInfo.uid,
              // _this.$store.state.myCosInfo.uid
            }
          }
        )
        .then(function (response) {
          console.log(response);
          // _this.newDynamics = response.data.sort(_this.$store.state.createComparison(response.data[0].publishTime)).reverse();
          // _this.hotDynamics = response.data.sort(_this.$store.state.createComparison(response.data[0].likes)).reverse();
          
          _this.newDynamics = response.data.reverse();
          
          for(let index in _this.newDynamics){

            if (_this.newDynamics[index].isLike == false) {
              _this.newDynamics[index].isLike = "@/assets/icon/like.png";
            }else {
              _this.newDynamics[index].isLike = "@/assets/icon/like-active.png";
            }

            if (_this.newDynamics[index].isCollection == false) {
              _this.newDynamics[index].isCollection = "@/assets/icon/collection.png";
            }else {
              _this.newDynamics[index].isCollection = "@/assets/icon/collection-active.png";
            }

            if (_this.newDynamics[index].isAttent == false) {
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
      },
      getMyInfo(){
        let _this = this;
        //获取我的资料
        this.$axios.get('http://106.14.46.10:8081/MakeupYou/user/findUserByID/',{
            params: {
              userID: _this.$store.state.myCosInfo.uid,
            }
          }
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
      },
      getMyPosts(){
        let _this = this;
        _this.$axios.get('http://106.14.46.10:8081/MakeupYou/post/findPostByUid',{
            params: {
              userID: _this.$store.state.myCosInfo.uid,
            }
          }
        )
        .then(function (response) {
          console.log(response);
          _this.newDynamics = response.data.reverse();
          _this.postNum = _this.newDynamics.length;
          console.log("成功获取帖子列表长度" + _this.postNum);
        })
        .catch(function (error) {
          console.log(error);
        })
      },
      getMyFocus(){
        let _this = this;
        // 获取我的所有关注
        _this.$axios.get('http://106.14.46.10:8081/MakeupYou/relation/findFollows',{
            params: {
              userID: _this.$store.state.myCosInfo.uid,
            }
          }
        )
        .then(function (response) {
          console.log(response);
          _this.attentions = response.data;
          _this.attentNum = _this.attentions.length;
          console.log("获取我的粉丝列表长度为" + _this.attentNum);
        })
        .catch(function (error) {
          console.log(error);
        });
      },
      getMyFans(){
        let _this = this;
        // 获取我的所有关注
        _this.$axios.get('http://106.14.46.10:8081/MakeupYou/relation/findFans',{
            params: {
              userID: _this.$store.state.myCosInfo.uid,
            }
          }
        )
        .then(function (response) {
          console.log(response);
          _this.fans = response.data;
          _this.fansNum = _this.attentions.length;
          console.log("获取我的粉丝列表长度为" + _this.fansNum);
        })
        .catch(function (error) {
          console.log(error);
        });
      },
      getLikeMe(_this){
        _this.$axios.get('http://106.14.46.10:8081/MakeupYou/appService/getLikesMe',{
            params: {
              userID: _this.$store.state.myCosInfo.uid,
            }
          }
        )
        .then(function (response) {
          console.log(response);
          _this.message = response.data;
          console.log("获取所有评论我的人成功！");
        })
        .catch(function (error) {
          console.log(error);
        });
      },
      getCollectMe(_this){
        _this.$axios.get('http://106.14.46.10:8081/MakeupYou/appService/getFavoritesMe',{
            params: {
              userID: _this.$store.state.myCosInfo.uid,
            }
          }
        )
        .then(function (response) {
          console.log(response);
          _this.message = response.data;
          console.log("获取所有评论我的人成功！");
        })
        .catch(function (error) {
          console.log(error);
        });
      },
      getComentMe(_this){
        _this.$axios.get('http://106.14.46.10:8081/MakeupYou/appService/getCommentsMe',{
            params: {
              userID: _this.$store.state.myCosInfo.uid,
            }
          }
        )
        .then(function (response) {
          console.log(response);
          _this.message = response.data;
          console.log("获取所有评论我的人成功！");
        })
        .catch(function (error) {
          console.log(error);
        });
      },
      getAttentMe(_this){
        _this.$axios.get('http://106.14.46.10:8081/MakeupYou/relation/findFans',{
            params: {
              userID: _this.$store.state.myCosInfo.uid,
            }
          }
        )
        .then(function (response) {
          console.log(response);
          _this.message = response.data;
          console.log("获取所有评论我的人成功！");
        })
        .catch(function (error) {
          console.log(error);
        });
      }
      // uploadFile(file){
      //   this.formDate.append('file', file.file);
      //   console.log(this.file);
      // },
      // subPicForm(){
      //   this.formDate = new FormData();
      //   this.$refs.upload.submit();
      //   this.formDate.append('WS_CODE', "12133");
      //   let config = {
      //     headers: {
      //       'Content-Type': 'multipart/form-data'
      //     }
      //   }
      //   axios.post("http://localhost:8081/MakeupYou/multiUpload/112220", this.formDate).then( res => {
      //       console.log(res)
      //   }).catch( res => {
      //       console.log(res)
      //   })
      // },
      // getFile: function (event) {
      //   this.file = event.target.files[0];
      //   console.log(this.file);
      // },
      // submit: function (event) {
      //   //阻止元素发生默认的行为
      //   event.preventDefault();
      //   let formData = new FormData();
      //   formData.append("file", this.file);

      //   axios.post('http://localhost:8081/MakeupYou/upload', formData)
      //     .then(function (response) {
      //       alert(response.data);
      //       console.log(response);
      //       window.location.reload();
      //     })
      //     .catch(function (error) {
      //       alert("上传失败");
      //       console.log(error);
      //       window.location.reload();
      //     });
      // }
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
  @import "../../assets/scss/index";
</style>
