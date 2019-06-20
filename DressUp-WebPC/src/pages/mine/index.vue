<template>
  <div class="mine">
    <div class="myInfo">
      <div class="myHeader">
        <img src="@/assets/img/header.jpg">
      </div>
      <div class="myUserName">浅笑半离兮</div>
      <div class="mySignature">不纠结，不抱怨，不后悔，不···<img title="编辑资料" src="@/assets/icon/edit.png" @click="editInfo"></div>
    </div>
    <div class="nav">
      <router-link class="item" to="/mine/">
      <dl>
        <dt>帖子</dt>
        <dd>12</dd>
      </dl>
      </router-link>
      <router-link class="item" to="/mine/collections">
      <dl>
        <dt>收藏</dt>
        <dd>20</dd>
      </dl>
      </router-link>
      <router-link class="item" to="/mine/attent">
      <dl>
        <dt>关注</dt>
        <dd>18</dd>
      </dl>
      </router-link>
      <router-link class="item" to="/mine/fans">
      <dl>
        <dt>粉丝</dt>
        <dd>45</dd>
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
      isEditInfo: 0
    }
  },
  components: {
    CInfo
  },
  methods: {
    editInfo(){
      this.isEditInfo = !this.isEditInfo;
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
  @import "../../assets/scss/mine.scss";
</style>
