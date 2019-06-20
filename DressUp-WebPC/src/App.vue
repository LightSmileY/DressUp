<template>
  <div id="app" class="g-container">
    <div class="g-header-container">
      <c-tabbar/>
    </div>
    <div class="g-view-container">
      <router-view/>
    </div>
  </div>
</template>

<script>
  import CTabbar from '@/components/tabbar';

  export default {
    name: 'App',
    components: {
      CTabbar
    }
  };
</script>

<style lang="scss">
* {
  margin: 0;
  padding: 0;
}
.g-header-container{
  position: fixed;
  width: 100%;
  height: 8vh;
  z-index: 999999999999;
}
.g-view-container{
  position: relative;
  top: 8vh;
  background-image: url("~@/assets/img/bg.jpg");
  background-size: 100% 92vh;
  background-position: 0 8vh;
  background-attachment: fixed;
}
</style>