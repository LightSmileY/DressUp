<template>
  <div class="container">
    <div class="masker" v-if="coment" @click="remove"></div>
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
          <div :hidden="activeIndex != 0">
            <div class="dymamicList">
              <ul>
                <li v-for="(dymamic,index) in newDynamics" :key="index" wx:for-index="hello" class="dymamicList-li" >
                  <div class="user">
                    <img :src="dymamic.userHeadURL" class="user-header"/>
                    <div class="name-time">
                      <div class="name">{{dymamic.userName}}</div>
                      <div class="time">{{dymamic.postTime}}</div>
                    </div>
                  </div>
                  <p class="content">{{dymamic.messagebody}}</p>
                  <div class="images">
                    <img v-for="(image,index1) in dymamic.images" :key="index1" class="image" @click="previewImg(index,index1)" :src="image"/>
                  </div>
                  <div class="icons">
                    <div class="forward">
                      <img class="forward-image" :src="dymamic.icon_forward"  @click="toForward(index)">
                      <span>{{dymamic.forward}}</span>
                    </div>
                    <div class="cllection" @click="toCollection1(index)">
                      <img :src="dymamic.icon_collection">
                      <span>{{dymamic.collection}}</span>
                    </div>
                    <div class="like" @click="toLike1(index)">
                      <img :src="dymamic.icon_like">
                      <span>{{dymamic.like}}</span>
                    </div>
                  </div>
                  <div class="comment">
                    <ul class="comment-ul">
                      <li class="comment-li" v-for="(comment, index2) in dymamic.comments" :key="index2">
                        <span class="username">{{comment.userName}}</span>：
                        <span class="content">{{comment.content}}</span>
                      </li>
                    </ul>
                    <button class="toComent" @click="toComent">我也要评论</button>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <!-- *******************************************热门消息*************************************** -->
          <div :hidden="activeIndex != 1">
            <div class="dymamicList">
              <ul>
                <li v-for="(dymamic,index) in hotDynamics" :key="index" class="dymamicList-li" >
                  <div class="user">
                    <img :src="dymamic.userHeadURL" class="user-header"/>
                    <div class="name-time">
                      <div class="name">{{dymamic.userName}}</div>
                      <div class="time">{{dymamic.publishTime}}</div>
                    </div>
                  </div>
                  <p class="content">{{dymamic.content}}</p>
                  <div class="images">
                    <img v-for="(image,index1) in dymamic.images" :key="index1" class="image" @click="previewImg(index,index1)" :src="image"/>
                  </div>
                  <div class="icons">
                    <div class="forward" @click="toForward(index)">
                      <img class="forward-image" :src="dymamic.icon_forward">
                      <span>{{dymamic.forward}}</span>
                    </div>
                    <div class="cllection" @click="toCollection2(index)">
                      <img :src="dymamic.icon_collection">
                      <span>{{dymamic.collection}}</span>
                    </div>
                    <div class="like" @click="toLike2(index)">
                      <img :src="dymamic.icon_like">
                      <span>{{dymamic.like}}</span>
                    </div>
                  </div>
                  <div class="comment">
                    <ul class="comment-ul">
                      <li class="comment-li" v-for="(comment, index2) in dymamic.comments" :key="index2">
                        <span class="username">{{comment.userName}}</span>：
                        <span class="content">{{comment.content}}</span>
                      </li>
                    </ul>
                    <button class="toComent" @click="toComent">我也要评论</button>
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
    <!-- 评论框 -->
    <div class="coment" v-if="coment">
      <textarea autofocus="autofocus" rows="6"></textarea>
      <button @click="toPublish">发表</button>
    </div>
  </div>
</template>

<script>

  import Search from "@/components/search"
  import SwitchBar from "@/components/switch"
  import Publish from "@/components/publish"

  const newDynamics_URL = 'http://10.100.45.205:8081/MakeupYou/post/findAllPostMessages';

  export default {

    data () {
      return {
        // switches: [],
        newDynamics:[],
        hotDynamics: [],
        dymamicList1: [],
        dymamicList2: [],
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
        icon_like: "",
        icon_collection: "",
        icon_forward: "",
        like1: false,
        collection1: false,
        like2: false,
        collection2: false,
        coment: false
      }
    },
    components:{
      // Search,
      // SwitchBar,
      Publish
    },
    computed: {
      navbarSliderClass() {
        if (this.activeIndex == 0) {
          return "navbar_slider_0";
        }
        if (this.activeIndex == 1) {
          return "navbar_slider_1";
        }
      }
    },
    methods: {
      // 点击评论按钮
      toComent(){
        this.coment = !this.coment;
      },
      //点击遮罩层
      remove(){
        this.coment = !this.coment;
      },
      // 发表评论
      toPublish(){
        setTimeout(function(){
          wx.showToast({
            title:'已评论！',
            icon:'success',
            duration: 1000
          })
        },500)
        this.coment = !this.coment;
      },
      tabClick(e) {
        this.activeIndex = e.currentTarget.id;
      },
      toLike1(i){
        if(this.like1 == false){
          this.like1 = true;
          this.newDynamics[i].icon_like = "../../static/icon/like-active.png";
          this.newDynamics[i].like += 1;
        }
        else{
          this.like1 = false;
          this.newDynamics[i].icon_like = "../../static/icon/like.png";
          this.newDynamics[i].like -= 1;
        }
      },
      toCollection1(i){
        if(this.collection1 == false){
          this.collection1 = true;
          this.newDynamics[i].icon_collection = "../../static/icon/collection-active.png";
          this.newDynamics[i].collection += 1;
        }
        else{
          this.collection1 = false;
          this.newDynamics[i].icon_collection = "../../static/icon/collection.png";
          this.newDynamics[i].collection -= 1;
        }
      },
      toLike2(i){
        if(this.like2 == false){
          this.like2 = true;
          this.hotDynamics[i].icon_like = "../../static/icon/like-active.png";
          this.hotDynamics[i].like += 1;
        }
        else{
          this.like2 = false;
          this.hotDynamics[i].icon_like = "../../static/icon/like.png";
          this.hotDynamics[i].like -= 1;
        }
      },
      toCollection2(i){
        if(this.collection2 == false){
          this.collection2 = true;
          this.hotDynamics[i].icon_collection = "../../static/icon/collection-active.png";
          this.hotDynamics[i].collection += 1;
        }
        else{
          this.collection2 = false;
          this.hotDynamics[i].icon_collection = "../../static/icon/collection.png";
          this.hotDynamics[i].collection -= 1;
        }
      },
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
      previewImg(i,j){
        wx.previewImage({
          current: this.newDynamics[i].images[j],
          urls: this.newDynamics[i].images
        });
      }
    },
    
    beforeMount(){

      // 请求帖子数据
      // this.$fly.get(newDynamics_URL)
      //   .then( (response) => {
      //     console.log(response);
      //     this.newDynamics = response.data;
      //     console.log(this.newDynamics);
      //     // for(let i = 0; i < dynamicList.length; i ++){
      //     //   this.newDynamics[i].content = this.dynamicList[i].messagebody; 
      //     // }
      //     // console.log(this.newDynamics[i].content);
      //   })
      //   .catch( (error) => {
      //     console.log(error);
      //   });

    },
    mounted(){
      this.switches = ["最新", "热门"];
      this.newDynamics = [
        {
          userHeadURL: "https://i.loli.net/2019/05/29/5cee7d6a45c0737392.png",
          userName: "Healer.",
          publishTime: "今天10:20",
          content: "#妆容分享#🍊橘子汽水妆容，夏天的妆真的很难画得让人觉得清爽的感觉，图中的妆容我都没有上粉底 只用了妆前+局部遮瑕 这样的妆感更轻薄。照片是我带妆半天回家拍的 都没有掉哈哈哈",
          images: [
            "https://i.loli.net/2019/05/29/5cee7d6a4064548026.png",
            "https://i.loli.net/2019/05/29/5cee7d6a4229970078.png",
            "https://i.loli.net/2019/05/29/5cee7d6a43f8d73963.png"
          ],
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 42,
          collection: 15,
          forward: 12,
          //评论列表
          comments: [
            {
              userName: '坡皮',
              content: '这个眉毛这个眼睛这个鼻子这个嘴巴这张脸简直完美！'
            },
            {
              userName: 'Pikámo',
              content: '我真是太喜欢你这张脸了仙女'
            },
            {
              userName: '鲜甜御萝',
              content: '好看！'
            }
          ]
        },
        {
          userHeadURL: "https://i.loli.net/2019/05/29/5cee7e1a5ed2b65491.jpg",
          userName: "Safe",
          publishTime: "今天11:20",
          content: "#妆容分享#今天主要是和大家分享一下我日常高光修容都用啥，没有高光修容的妆容可是没有灵魂的哈哈哈。修容：我一般用中间颜色修鼻子，右边颜色修饰脸部，这盘很方便，鼻子和面部都可以搞定～面部修容打在颧骨两侧和下颚角，少量多次，防止晕染的不自然。高光：鼻子不要直接连接一整条，在山根和鼻头处提亮就可以，颧骨不是很高的人化在颧骨处，颧骨高的人化在颧骨内侧，唇峰眉骨下巴处点一下高光，布灵布灵的。",
          images: [
            "https://i.loli.net/2019/05/29/5cee7e5f3f3d451764.png",
            "https://i.loli.net/2019/05/29/5cee7e5f4150a66715.png",
            "https://i.loli.net/2019/05/29/5cee7e5f5f8f558985.png",
            "https://i.loli.net/2019/05/29/5cee7e5f6197d54870.png"
         
          ],
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 66,
          collection: 38,
          forward: 24,
          //评论列表
          comments: [
            {
              userName: 'fukami',
              content: '学到了！'
            },
            {
              userName: '十一',
              content: '这盘修容我也有！'
            },
            {
              userName: '竹早静弥',
              content: '怎么可以这么好看！'
            }
          ]
        },
        {
          userHeadURL: "https://i.loli.net/2019/05/29/5cee7f416db7856715.png",
          userName: "Shem",
          publishTime: "今天11:13",
          content: "#妆品推荐#NAKED #reloaded 💰 348。德云社女孩因为张云雷买的一盘！这盘老实说日常使用价值不高，喜欢画欧美妆的就很实用，日常妆就不怎么行，里面的能用的几个色又好像能够被替代，可是无奈它颜值高，买回来供着也开心",
          images: [
            "https://i.loli.net/2019/05/29/5cee7f705e2cc69933.png",
           
          ],
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 66,
          collection: 38,
          forward: 24,
          //评论列表
          comments: [
            {
              userName: '卡密子',
              content: '有点贵！'
            },
            {
              userName: '夜空',
              content: '颜色还是比较经典的哈'
            },
            {
              userName: 'Chris',
              content: '好看'
            },
            {
              userName: '日尧cool',
              content: '入了大理石盘，可是新手不知道该怎么搭配颜色，谢谢分享～'
            }
          ]
        },
        {
          userHeadURL: "https://i.loli.net/2019/05/29/5cee80022b26996770.png",
          userName: "초 심",
          publishTime: "今天9:22",
          content: "#好物推荐# ZOEVA #南瓜盘 198r!也是我用了一个冬天的眼影盘，红遍大江南北，使用次数最多，平时不知道用什么就会用它，每一个颜色都很实用，很好晕开，不怎么飞粉，南瓜色大地色日落妆容都妥妥的，现在好像还有六色mini的盘，超可爱的。",
          images: [
            "https://i.loli.net/2019/05/29/5cee800244d5925505.png",
           
          ],
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 66,
          collection: 38,
          forward: 24,
          //评论列表
          comments: [
            {
              userName: '安妮',
              content: '配色真的很适合冬天！'
            },
            {
              userName: '817汉子',
              content: '这盘我已经快用光了！'
            },
            {
              userName: '付卡密',
              content: '大师球'
            }
          ]
        },
        {
          userHeadURL: "https://i.loli.net/2019/05/29/5cee8958b1d2d58452.jpg",
          userName: "清风烈酒",
          publishTime: "今天9:26",
          content: "话不多说！上图！colourpop这盘sweet talk没啥可说的 直接买就对了粉粉嫩嫩的珊瑚盘 我今天画的时候可激动了！因为和我刚染的的粉毛太配了！反正这盘我觉得是我手里边所有cp里最好看的，审美也是最符合大众的，太适合夏天画了",
          images: [
            "https://i.loli.net/2019/05/29/5cee895a4426565212.png"
          ],
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 66,
          collection: 38,
          forward: 24,
          //评论列表
          comments: [
            {
              userName: 'Sain',
              content: '美瞳也好美！'
            },
            {
              userName: 'Rainstorm',
              content: '第二格的土豆泥干了要怎么办'
            },
            {
              userName: '付卡密',
              content: '大师球'
            },
             {
              userName: '回复 Rainstorm',
              content: '一般是不会干的！到时候可以用酒精润一下。'
            }
          ]
        }
      ];
      
      this.hotDynamics = [
        {
          userHeadURL: "https://i.loli.net/2019/05/29/5cee8de72c73357510.png",
          userName: "淡然",
          publishTime: "今天8:40",
          content: "#好物推荐#给大家种草这个眉笔！其实并不是很夸张的惊艳法，只不过用下来非常顺滑适合自己！它是眉笔➕眉粉➕眉刷，3头为一体。",
          images: [
            "https://i.loli.net/2019/05/29/5cee8e992031933482.png",
          ],
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 66,
          collection: 38,
          forward: 24,
          //评论列表
          comments: [
            {
              userName: '空口吃奶油',
              content: '这个我也买了！'
            },
            {
              userName: '鲜甜御萝',
              content: '多少钱呐'
            },
            {
              userName: '回复 鲜甜御萝',
              content: '68r'
            },
            {
              userName: '玩物丧志',
              content: '已种草'
            }
          ]
        },
        {
          userHeadURL: "https://i.loli.net/2019/05/29/5cee8de716f5c62782.png",
          userName: "fukami",
          publishTime: "今天8:40",
          content: "#妆容分享#今天的眼妆，嘻嘻",
          images: [
            "https://i.loli.net/2019/05/29/5cee8eaeb3a8a75607.png",
          ],
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 66,
          collection: 38,
          forward: 24,
          //评论列表
          comments: [
            {
              yozora: '点赞',
              content: '好哒好哒好哒好哒好哒好哒好哒好哒好哒好哒'
            },
            {
              userName: '淡然',
              content: '滤镜美'
            },
            {
              userName: '鲜甜御萝',
              content: '请教我画眼线！'
            }
          ]
        },
        {
          userHeadURL: "https://i.loli.net/2019/05/29/5cee8de727be190265.png",
          userName: "一只变强的hacker",
          publishTime: "今天9:40",
          content: "有没有什么好用的防晒推荐呐？适合男生夏天用的！昆明的太阳太毒了！",
          images: [
            "https://i.loli.net/2019/05/29/5cee8ec4b8a2259560.png",
          ],
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 66,
          collection: 38,
          forward: 24,
          //评论列表
          comments: [
            {
              userName: '一尺江山',
              content: '没事，你已经够黑了：）'
            },
            {
              userName: '往生山',
              content: '安耐晒防晒喷雾'
            },
            {
              userName: '唧唧唧唧',
              content: '小金瓶很适合你'
            }
          ]
        },
        {
          userHeadURL: "https://i.loli.net/2019/05/29/5cee8de72a22b75961.png",
          userName: "zhang",
          publishTime: "今天18:30",
          content: "#好物推荐#这盘眼影盘太美了！大家一定要种草！配色炒鸡少女！适合夏天用❤",
          images: [
            "https://i.loli.net/2019/05/29/5cee8ed9ad4ac76362.png",
            "https://i.loli.net/2019/05/29/5cee8ed9b611847144.png",
            "https://i.loli.net/2019/05/29/5cee8ed9bb74b43894.png"
          ],
          icon_like: "../../static/icon/like.png",
          icon_collection: "../../static/icon/collection.png",
          icon_forward: "../../static/icon/forward.png",
          like: 66,
          collection: 38,
          forward: 24,
          //评论列表
          comments: [
            {
              userName: '空口吃奶油',
              content: '种草了！！'
            },
            {
              userName: '鲜甜御萝',
              content: '：这个颜色好美！'
            },
            {
              userName: '往生山',
              content: '已加入购物车。'
            }
          ]
        }
      ];
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
  .masker{
    position: fixed;
    width: 100vw;
    height: 100vh;
    background-color: rgba(0, 0, 0, 0.2);
    z-index: 999999;
    margin: 0;
    padding: 0;
  }
</style>