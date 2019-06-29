<template>
  <div class="mine">
    <div class="myInfo">
      <div class="myHeader">
        <img :src="myInfo.avatarID">
      </div>
      <div class="myUserName">{{myInfo.name}}</div>
      <div class="mySignature">{{myInfo.description}}<img title="编辑资料" src="@/assets/icon/edit.png" @click="editInfo"></div>
    </div>
    <div class="nav">
      <router-link class="item" to="/mine/">
      <dl>
        <dt>帖子</dt>
        <dd>{{postNum}}</dd>
      </dl>
      </router-link>
      <router-link class="item" to="/mine/attent">
      <dl>
        <dt>关注</dt>
        <dd>{{attentNum}}</dd>
      </dl>
      </router-link>
      <router-link class="item" to="/mine/fans">
      <dl>
        <dt>粉丝</dt>
        <dd>{{fansNum}}</dd>
      </dl>
      </router-link>
    </div>

    <div class="detail">
      <router-view/>
    </div>
    <div class="editInfo" v-if="isEditInfo">
      <c-info></c-info>
    </div>
  </div>
</template>

<script>
import CInfo from "@/components/info"

export default {
  name: 'Mine',
  data () {
    return {
      myInfo: {},
      isEditInfo: 0,
      postNum: 0,
      attentNum: 0,
      fansNum: 0,
      collectionNum: 0
    }
  },
  components: {
    CInfo
  },
  beforeMount(){
    this.getMyPosts();
    this.getMyFocus();
    this.getMyFans();
    setTimeout(() => {
      this.getPosts();
    },100);
    this.myInfo = this.$store.state.myCosInfo;
  },
  methods: {
    editInfo(){
      this.isEditInfo = !this.isEditInfo;
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
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
  @import "../../assets/scss/mine.scss";
</style>
