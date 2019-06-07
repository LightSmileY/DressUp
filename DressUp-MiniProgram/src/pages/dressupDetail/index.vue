<template>
  <div class="main">
    <div class="theme">{{detail.theme}}</div>
    <dl v-for="(dressup, index) in detail.dressups" :key="index">
      <dt>
        <img :src="dressup.image">
      </dt>
      <dd>
        <p v-for="(content, index1) in dressup.contents" :key="index1">{{content}}</p>
      </dd>
    </dl>
  </div>
</template>

<script>

  export default{
    data () {
      return {
        detail: {}
      }
    },
    components:{
      
    },
    methods: {

    },
    mounted(){
      this.detail = {
        // 妆容推荐
        theme: "毕业照妆容来啦❀❤",
        dressups: [
          
          {
            image: "https://i.loli.net/2019/05/29/5cee4060673a186547.png",
            contents: [
              "又到了每年的毕业季,出一个毕业照妆容给大家,单反拍照的话不要打高光修容比较好噢",
              "眼影用的哑光红棕色扫在上眼皮，橘色扫在卧蚕，没有画内眼线，就用眼线液笔延长了一点眼尾，是向下延长，不是向上噢！",
              "口红是偏橘色系的，因为它能显得年轻😂😂"
              
            ]
          },
          {
            image: "https://i.loli.net/2019/05/29/5cee40606500a42218.png",
            contents: [
              "还有一直被问的头发保养方面，我真的是一个每天熬夜的人，额头还高，再一秃那真的是悲剧，所以我！！！！！",
              "一直很注意我的头发！！！我妈和我外婆的白头发都蛮严重的，我也怕我会早早的就长白头发，所以一直有在喝这个核桃芝麻黑豆粉来养发防脱，每天早上我奶奶会给我加进豆浆里面一起喝，炒鸡好喝！",
              "里面加了奇亚籽和藜麦，口感又香又顺滑，长期坚持，我一定不能秃！哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈！我也会强迫我妈喝，因为她血糖高，里面的奇亚籽对这个有帮助",
              "你们可以用四只手指头比划一下眉毛到额头的距离，超过了就算发际线较高了，还是应该补充一下这方面营养哈哈哈哈哈哈哈哈"
            ]
          }
          
        ]
      }
    }   
  };
</script>

<style scoped>
  .main {
    position: relative;
    width: 90%;
    margin: 0 auto;
  }
  .theme {
    margin: 10px 0;
    font-size: 18px;
  }
  dl dt img {
    width: 100%;
    height: 90vw;
  }
  dl dd p {
    width: 100%;
    font-size: 14px;
    margin: 10px 0;
  }
</style>