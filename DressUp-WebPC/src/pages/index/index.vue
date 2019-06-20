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
          <button class="new">最新</button>
          <button class="hot">热门</button>
        </div>
        <div class="write" title="发表帖子">
          <img src="@/assets/icon/edit.png">
        </div>
        <div class="new-dymamics">
          <c-dymamic :arrayList="newDymamics"/>
        </div>
        <div class="hot-dymamics">
          <c-dymamic/>
        </div>
      </div>
      <nav>
        <!-- 我的资料 -->
        <div class="Me">
          <div class="myInfo">
            <div class="myHeader">
              <img src="@/assets/img/header.jpg">
            </div>
            <div class="myUserName">浅笑半离兮</div>
            <div class="mySignature">一切都会很美好！</div>
          </div>
          <div class="items">
            <dl class="myPosts">
              <dt class="title">帖子</dt>
              <dd class="count">12</dd>
            </dl>
            <dl class="myPosts">
              <dt class="title">关注</dt>
              <dd class="count">12</dd>
            </dl>
            <dl class="myPosts">
              <dt class="title">粉丝</dt>
              <dd class="count">12</dd>
            </dl>
          </div>
        </div>
        <ul class="aboutMe">
          <li class="title">与我相关</li>
          <li class="aboutMe-li">
            <img src="@/assets/icon/like.png" class="icon">
            <div class="theme">点赞我的</div>
            <div class="messages" v-if="isShowLike">
              <c-message></c-message>
            </div>
          </li>
          <li class="aboutMe-li">
            <img src="@/assets/icon/collection.png" class="icon">
            <div class="theme">收藏我的</div>
            <div class="messages" v-if="isShowCollection">
              <c-message></c-message>
            </div>
          </li>
          <li class="aboutMe-li">
            <img src="@/assets/icon/evaluation.png" class="icon">
            <div class="theme">评论我的</div>
            <div class="messages" v-if="isShowComment">
              <c-message></c-message>
            </div>
          </li>
          <li class="aboutMe-li">
            <img src="@/assets/icon/attention.png" class="icon">
            <div class="theme">关注我的</div>
            <div class="messages" v-if="isShowAttent">
              <c-message></c-message>
            </div>
          </li>
          <li class="aboutMe-li">
            <img src="@/assets/icon/share.png" class="icon">
            <div class="theme">转发我的</div>
            <div class="messages" v-if="isShowForword">
              <c-message></c-message>
            </div>
          </li>
        </ul>
        <div class="recommend">
          
        </div>
      </nav>
    </div>
    
  </div>
</template>

<script>
  import CDymamic from '@/components/dymamic';
  import CMessage from '@/components/message';

  export default {
    name: 'Index',
    data() {
      return {
        newDymamics: [],
        // msg: '上传图片',
        // file: '',
        // multiple:true,
        // formDate:""
        isShowLike: 0,
        isShowCollection: 0,
        isShowComment: 0,
        isShowAttent: 0,
        isShowForword: 0
      }
    },
    components: {
      CDymamic,
      CMessage
    },
    methods: {
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
