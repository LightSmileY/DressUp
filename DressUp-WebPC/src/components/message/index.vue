<template>
  <div class="like">
    <ul class="like-ul">
      <div class="title">{{title}}</div>
      <div v-for="item in arrayList" class="like-li">
        <div class="user">
          <img :src="item.post.userHeadURL" class="user-header"/>
          <div class="name-time">
            <div class="name">{{item.post.userName}}</div>
            <div class="time">{{item.post.publishTime}}</div>
          </div>
          <p>详情</p>
        </div>
        <div class="content">
          <span>赞了我的帖子</span>
        </div>
        <div class="image">
          <img :src="item.post.images[0]"/>
        </div>
        <div class="info">
            <span>#{{item.post.title}}#</span>
            <p>{{item.post.content}}</p>
        </div>
      </div>
    </ul>
  </div>
</template>

<script>
export default {
  data () {
    return {
      
    }
  },
  props: {
    title: String,
    arrayList: Array
  }
};
</script>

<style lang="scss">
  .like-li{
    width: 95%;
    border: 1px solid #A0A0A0;
    border-radius: 3px;
    margin: 10px auto;
    overflow: hidden;
    text-align: left;
    background-color: #fff;

    .user{
      width: 100%;
      margin: 5px 0;
      overflow: hidden;

      .user-header{
        width: 30px;
        height: 30px;
        margin: 0 10px 0 8px;
        background-color: #FFBABA;
        border-radius: 50%;
        float: left;
      }

      .name-time{
        height: 30px;
        width: 150px;
        float: left;
        // background-color: red;

        .name{
          height: 18px;
          font-size: 13px;
          line-height: 20px;
        }

        .time{
          line-height: 12px;
          font-size: 7px;
        }
      }

      p{
        color: #1B5EA0;
        font-size: 13px;
        line-height: 30px;
        float: right;
        margin-right: 10px;
        // background-color: #BFFFFE;
      }
    }

    .content{
      width: 94%;
      margin: 0 auto;
      font-size: 12px;
      line-height: 20px;
      // background-color: #AAE4FF;

      span:first-child{
        margin-left: 3px;
      }
    }

    .image{
      width: 50px;;
      height: 50px;;
      float: left;
      margin: 3px 0 5px 10px;;

      img{
        width: 100%;
        height: 100%;
      }
    }
    .info{
      width: 200px;
      height: 50px;
      line-height: 15px;
      float: right;
      margin: 3px 10px 5px 0;
      font-size: 12px;
      // background-color: #B0FFF1;
    }

  }
</style>