<template>
  <div class="main">
    <div class="theme">{{detail.theme}}</div>
    <dl v-for="(teaching, index) in detail.teachings" :key="index">
      <dt>
        <img :src="teaching.image">
      </dt>
      <dd>
        <p v-for="(content, index1) in teaching.contents" :key="index1">{{content}}</p>
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
        theme: "新手化妆步骤和建议",
        teachings: [
          {
            image: "https://i.loli.net/2019/05/29/5cee421e782d593288.png",
            contents: [
              "一般的化妆步骤（新手可参考）",
              "防晒-隔离-遮瑕-粉底液-定妆-眉笔-眉粉-染眉膏-眼影-睫毛夹-眼线-睫毛膏-修容-高光-腮红-润唇膏-唇线笔-口红"
            ]
          },
          {
            image: "https://i.loli.net/2019/05/29/5cee421e7a8ad30385.png",
            contents: [
              "一、新手化妆顺序疑问整理",
              "1、先隔离or先防晒",
              "先防晒，防晒属于护肤，隔离属于化妆，先护肤后化妆",
              "",
              "2、先遮瑕or先粉底",
              "①先上粉底的好处：粉底本身有遮瑕功能，可以根据肌肤瑕疵情况定遮瑕膏的用量，不会涂抹过多，底妆会更加自然",
              "②先遮瑕的好处：既能遮住瑕疵，又能均衡肤色，让脸蛋看起来光洁无暇，后在粉底的融合下也是自然妆感",
              "",
              "3、先修容or先定妆",
              "①先修容的好处：修容棒很好推开和晕染，妆感更干净",
              "②先定妆的好处：油性肌肤先薄薄盖一点定妆粉可以很好的控油，让妆容更持久",
              "二、新手化妆怎么选",
              "1、粉饼和散粉、定妆喷雾怎么选",
              "喷雾适合干皮，不会改掉原有的妆容光泽感；散粉可以吸收更多油脂，适合油皮；混合肌可以用散粉或者粉饼局部定妆",
              "",
              "2、气垫、粉底液、BB霜怎么选",
              "脸上瑕疵不多的话可以用BB或者气垫，粉底液的使用范围广一些，色号、遮瑕力的选择范围也大",
              "",
              "3、选择什么色系的眼影腮红不容易出错",
              "新手前期可以入1986眼影盘，显色度高、粉质细腻不飞粉，珠光色真的太美了！",
              "老夫滴少女心呀！一盘可以有很多种画法的，颜色偏日常，还是很好上手的！",
              "冷白皮选粉色系腮红、暖黄皮选橘色系的腮红",
              "",
              "三、新手化妆要注意的地方",
              "黑眼圈、痘印要用比肤色深一个色号的遮瑕膏",
              "卸妆产品一定要有两瓶，眼唇和全脸分开，眼唇妆要用眼唇卸妆液",
              "夹睫毛：将睫毛夹放在睫毛根部，夹紧睫毛并微微上翘，停留20秒，然后把睫毛夹向睫毛尖部移动，每隔5毫米夹一次"
            ]
          }
        ],
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