<template>
  <div>
    <!-- 发表内容填写框 -->
    <div class="content">
      <input v-model="post.title" placeholder="标题"></input>
      <br>
      <textarea v-model="post.messageBody" type="text" placeholder="分享化妆技巧..." rows="5" maxlength="999"></textarea>
    </div>
    <!-- 本地图片添加区 -->
    <div class="j-pic-upload">
      <img @click="previewImg(index)" v-for="(src,index) in urls" :key="src" :src="src" :style="{'width':width || '150rpx','height':height || '150rpx'}" class="img" >
      <div class="j-upload-btn" @click="uploadImg()" :style="{'width':width || '150rpx','height':height || '150rpx'}">
        <span class="j-upload-add">+</span>
      </div>
    </div>
    <!-- 发表按钮 -->
    <button @click="publish">发表</button>
  </div>
</template>
 
<script>
    export default {
      props:["width","height","max","srcs"],
      data(){
        return {
          urls:[],
          tempPid: "",
          post: {
            title: "",
            messageBody: "",
            postTime: "",
            type: "爱妆瓣"
          }
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
            sizeType: ['compressed'],
            sourceType: ['album', 'camera'],
            success: function (res) {
              that.urls = res.tempFilePaths;
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

        // uploadimg(){
        //   var that=this,
        //       i=data.i?data.i:0,//当前上传的哪张图片
        //       success=data.success?data.success:0,//上传成功的个数
        //       fail=data.fail?data.fail:0;//上传失败的个数
        //   wx.uploadFile({
        //       url: "http://106.14.46.10:8081/MakeupYou/multiUpload", 
        //       filePath: data.path[i],
        //       name: 'file',//这里根据自己的实际情况改
        //       formData:{
        //         postID: "1988477923"
        //       },//这里是上传图片时一起上传的数据
        //       success: (resp) => {
        //         success++;//图片上传成功，图片上传成功的变量+1
        //         console.log(resp)
        //         console.log(i);
        //           //这里可能有BUG，失败也会执行这里,所以这里应该是后台返回过来的状态码为成功时，这里的success才+1
        //       },
        //       fail: (res) => {
        //         fail++;//图片上传失败，图片上传失败的变量+1
        //         console.log('fail:'+i+"fail:"+fail);
        //       },
        //       complete: () => {
        //         console.log(i);
        //         i++;//这个图片执行完上传后，开始上传下一张
        //       if(i==data.path.length){   //当图片传完时，停止调用          
        //         console.log('执行完毕');
        //         console.log('成功：'+success+" 失败："+fail);
        //       }else{//若图片还没有传完，则继续调用函数
        //         console.log(i);
        //         data.i=i;
        //         data.success=success;
        //         data.fail=fail;
        //         that.uploadimg(data);
        //       } 
        //     }
        //   });
        // },

        // publish(){//这里触发图片上传的方法
        //   var urls = this.data.urls;
        //   app.uploadimg({
        //     url:'http://106.14.46.10:8081/MakeupYou/multiUpload',//这里是你图片上传的接口
        //     path: this.urls//这里是选取的图片的地址数组
        //   });
        // },


        // 发表帖子
        publish(){

          let _this = this;
          _this.tempPid = _this.$store.state.getPid();

          console.log(_this.tempPid);
          console.log(_this.$store.state.getTime());

          wx.showToast({
              icon: "loading",
              title: "正在上传"
            });

          _this.$fly.post('http://106.14.46.10:8081/MakeupYou/post/addRecord',_this.$qs.stringify({
              pid: _this.tempPid,
              uid: _this.$store.state.openId,
              postTime: _this.$store.state.getTime(),
              title: _this.post.title,
              type: 1,
              messagebody: _this.post.messageBody
            })
          )
          .then(function (response) {

            console.log(response);

            for(let i = 0; i < _this.urls.length; i ++){
              wx.uploadFile({
                url: "http://106.14.46.10:8081/MakeupYou/multiUpload",
                filePath: _this.urls[i], 
                name: 'file',
                header: { "Content-Type": "multipart/form-data" },
                formData: {
                  postID: _this.tempPid
                },
                success: function (res) {
                  console.log(res);
                  if (res.statusCode != 200) { 
                    wx.showModal({
                      title: '提示',
                      content: '上传失败',
                      showCancel: false
                    })
                    return;
                  }
                  var data = res.data;
                },
                fail: function (e) {
                  console.log(e);
                  wx.showModal({
                    title: '提示',
                    content: '上传失败',
                    showCancel: false
                  })
                },
                complete: function () {
                   //隐藏Toast
                }
              })
            }
            // 返回
            wx.hideToast();
            wx.navigateBack({
              delta: 1
            });
            wx.showToast({
              title:'发表成功！',
              icon:'success',
              duration: 1000
            });
            _this.post.title = "",
            _this.post.messageBody = ""
          })
          .catch(function (error) {
            console.log(error);
            wx.showToast({
              title:'发表失败！',
              icon:'success',
              duration: 1000
            });
          });

          // for(let i = 0; i < _this.urls.length; i ++){
          //   wx.uploadFile({
          //     url: "http://106.14.46.10:8081/MakeupYou/multiUpload",
          //     filePath: _this.urls[i], 
          //     name: 'file',
          //     header: { "Content-Type": "multipart/form-data" },
          //     formData: {
          //       postID: _this.$store.state.getPid()
          //     },
          //     // userName: _this.$store.state.openId,
          //     // publishTime: _this.$store.state.getTime(),
          //     // title: _this.post.title,
          //     // content: _this.post.messageBody,
          //     // postID: _this.$store.state.getPid()
          //     success: function (res) {
          //       console.log(res);
          //       if (res.statusCode != 200) { 
          //         wx.showModal({
          //           title: '提示',
          //           content: '上传失败',
          //           showCancel: false
          //         })
          //         return;
          //       }
          //       var data = res.data;
          //     },
          //     fail: function (e) {
          //       console.log(e);
          //       wx.showModal({
          //         title: '提示',
          //         content: '上传失败',
          //         showCancel: false
          //       })
          //     },
          //     complete: function () {
          //       wx.hideToast();  //隐藏Toast
          //     }
          //   })
          // }
        
          // let _this = this;
          // _this.$fly.post('http://106.14.46.10:8081/MakeupYou/post/addRecord',
          //   _this.$qs.stringify({
          //     userID: _this.$store.state.openId,
          //     postTime: _this.$store.state.getTime(),
          //     type: _this.post.type,
          //     title: _this.post.title,
          //     messageBody: _this.post.messageBody
          //   })
          // )
          // .then(function (response) {
          //   console.log(response);
          //   console.log(_this.$store.state.getTime());
          //   setTimeout(function(){
          //     wx.navigateBack({
          //       delta: 1
          //     });
          //     wx.showToast({
          //       title:'发表成功！',
          //       icon:'success',
          //       duration: 1000
          //     });
          //     _this.post.title = "",
          //     _this.post.messageBody = ""
          //     wx.navigateTo({url: "../index/main"});
          //   },500);
          // })
          // .catch(function (error) {
          //   console.log(error);
          // });

          // this.$store.state.getPid()

          // let formData = new FormData();
          // formData.append("file", _this.urls);
          // console.log(_this.urls);
          // _this.$fly.post('http://106.14.46.10:8081/MakeupYou/multiUpload', 
          //   _this.$qs.stringify({
          //     postID: "1988477923",
          //     files: _this.urls
          //   })
          // )
          // .then(function (response) {
          //   console.log(response);
          // })
          // .catch(function (error) {
          //   console.log(error);
          // });
          
          

          // wx.chooseImage({
          //   success(res) {
          //     const tempFilePaths = res.tempFilePaths
          //     wx.uploadFile({
          //       url: 'https://example.weixin.qq.com/upload', // 仅为示例，非真实的接口地址
          //       filePath: tempFilePaths[0],
          //       name: 'file',
          //       formData: {
          //         user: 'test'
          //       },
          //       success(res) {
          //         const data = res.data
          //         // do something
          //       }
          //     })
          //   }
          // })
        }
      }
    };
</script>
 
<style scoped>
  .content{
    min-height: 100px;
  }
  .content input{
    width: 95%;
    height: 40px;
    margin: 2px 2.5%;
    font-size: 17px;
    line-height: 40px;
    border-bottom: 1px solid #E4E4E4;
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