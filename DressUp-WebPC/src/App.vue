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
  height: 60px;
  z-index: 99999;
}
.g-view-container{
  position: relative;
  top: 80px;
}
</style>