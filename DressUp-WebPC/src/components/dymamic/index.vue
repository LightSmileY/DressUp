<template>
  <div class="dymamic">
    <div v-for="(dymamic,index) in arrayList" :key="index" class="dymamicList">
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
          <span class="count">11</span>
        </div>
      </div>
      <!-- 评论 -->
      <div class="comments">
        <div class="comment" v-for="(comment, index2) in dymamic.comments" @click="toComent(index)" :key="index2">
          <span class="userName">{{comment.userName}}</span>:&nbsp;
          <span class="content">{{comment.message}}</span>
        </div>
        <textarea id="coInput" rows="3" placeholder="我也要评论···" v-model="comment_content"></textarea>
        <button class="toComment" @click="toPublish()">发表</button>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'App',
    data(){
      return{
        newDynamics:[],
        comment_content: ""
      }
    },
    props: {
      arrayList: Array

    },
    methods: {
      // 发表评论
      toPublish(){
        let _this = this;
        _this.$axios.post('http://106.14.46.10:8081/MakeupYou/comments/addRecord',_this.$qs.stringify({
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
      // 关注
      toAttent(i){
        let _this = this;
        if(this.newDynamics[i].isAttent == "关注TA"){
          //调用接口
          _this.$axios.post('http://106.14.46.10:8081/MakeupYou/relation/addRelation',_this.$qs.stringify({
              fansID: "qxblx",
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
          _this.$axios.delete('http://106.14.46.10:8081/MakeupYou/relation/deleteRelation',_this.$qs.stringify({
              fansID: "qxblx",
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
          _this.$axios.post('http://106.14.46.10:8081/MakeupYou/likes/addRecord',_this.$qs.stringify({
              userID: "qxblx",
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
          _this.$axios.delete('http://106.14.46.10:8081/MakeupYou/likes/deleteRecord',_this.$qs.stringify({
              userID: "qxblx",
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
          _this.$axios.post('http://106.14.46.10:8081/MakeupYou/favorites/addRecord',_this.$qs.stringify({
              userID: "qxblx",
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
          _this.$axios.delete('http://106.14.46.10:8081/MakeupYou/favorites/deleteRecord', _this.$qs.stringify({
              userID: "qxblx",
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
      }
    },
    mounted(){
      console.log("-----------------------------------");
      console.log(this.arrayList.isLike);
      console.log("-----------------------------------");
    }
  };
</script>

<style lang="scss">
  @import "../../assets/scss/dymamic";
</style>