<template>
  <div>
    <div class="content">
      <textarea type="text" placeholder="分享化妆技巧..." rows="5" maxlength="999"></textarea>
    </div>
    <div class="j-pic-upload">
      <img @click="previewImg(index)" v-for="(src,index) in urls" :key="src" :src="src" :style="{'width':width || '150rpx','height':height || '150rpx'}" class="img" >
      <div class="j-upload-btn" @click="uploadImg()" :style="{'width':width || '150rpx','height':height || '150rpx'}">
        <span class="j-upload-add">+</span>
      </div>
    </div>
    <button @click="publish">发表</button>
  </div>
</template>
 
<script>
    export default {
      props:["width","height","max","srcs"],
      data(){
        return {
          urls:[]
        }
      },
      mounted(){
        this.urls = this.srcs || [];
      },
      methods:{
        uploadImg(){
          let that = this;
          wx.chooseImage({
            count: that.max || 9,
            sizeType: ['original', 'compressed'],
            sourceType: ['album', 'camera'],
            success: function (res) {
              res.tempFilePaths.forEach(v=>{
                that.urls.push(v);
              });
              that.$emit("choosed",{all:that.urls,currentUpload:res.tempFilePaths});
            }
          })
        },
        previewImg(index){
          let that = this;
          wx.showActionSheet({
            itemList:["预览","删除"],
            success: function(res) {
              if(res.tapIndex === 0){
                wx.previewImage({
                  current:that.urls[index],
                  urls:that.urls
                });
              } else {
                that.urls.splice(index,1);
                that.$emit("delete",that.urls);
              }
            },
          });
        },  
        publish() {
          wx.chooseImage({
            success(res) {
              const tempFilePaths = res.tempFilePaths
              wx.uploadFile({
                url: 'https://example.weixin.qq.com/upload', // 仅为示例，非真实的接口地址
                filePath: tempFilePaths[0],
                name: 'file',
                formData: {
                  user: 'test'
                },
                success(res) {
                  const data = res.data
                  // do something
                }
              })
            }
          })
        }
      }
    };
</script>
 
<style scoped>
  .content{
    min-height: 100px;
  }
  .content textarea{
    width: 95%;
    height: 90px;
    margin: 12px 2.5%;
    font-size: 16px;
  }
  .j-pic-upload{
    padding-left: 49rpx;
    padding-bottom: 25rpx;
    display: flex;
    flex-direction: row;
    align-items: center;
    flex-wrap: wrap;
    border-bottom: 1px solid #E2E2E2;
  }
  .j-upload-btn{
    border: 1px solid #ddd;
    border-radius: 5px;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    margin-right: 20rpx;
  }
  .j-upload-add{
    font-size: 80rpx;
    font-weight: 500;
    color:#C9C9C9;
  }
  .img{
    margin:10rpx 20rpx 10rpx 0;
  }
  .img:last-child{
    margin:10rpx 0 10rpx 0;
  }
  button{
    position: relative;
    top: 20px;
    width: 90%;
    height: 40px;
    font-size: 16px;
    line-height: 40px;
    background-color: #FFC1C1;
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