<template>
    <swiper class="swiper" :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval" :duration="duration">
        <block v-for="(item, index) in arrayList" :key="index">
            <swiper-item>
                <image :src="item.url" class="slide-image" mode="aspectFill"/>
            </swiper-item>
        </block>
    </swiper> 
</template>

<script>
export default {
  props: {
    arrayList: Array
  },
  data() {
    return {
      indicatorDots: true,
      autoplay: true,
      interval: 3000,
      duration: 500
    };
  }
};
</script>

<style scoped>
  block{
    border: 1px solid #959595;
  }
  .swiper {
    height: 120px !important;
  }
  image {
    height: 100%;
    width: 100%;
  }
</style>