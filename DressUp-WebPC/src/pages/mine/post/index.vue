<template>
  <div class="post">
    <c-dymamic></c-dymamic>
  </div>
</template>

<script>
import CDymamic from '@/components/dymamic';

export default {
  name: 'post',
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
  .post{
    width: 85%;
    margin: 20px auto;
  }
</style>
