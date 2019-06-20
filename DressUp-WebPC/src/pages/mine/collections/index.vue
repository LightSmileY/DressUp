<template>
  <div class="collections">
    <c-dymamic></c-dymamic>
  </div>
</template>

<script>
import CDymamic from '@/components/dymamic';
export default {
  name: 'collections',
  data () {
    return {
      
    }
  },
  components: {
    CDymamic
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">

  .collections{
    width: 85%;
    margin: 20px auto;
  }
</style>
