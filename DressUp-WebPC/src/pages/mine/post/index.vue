<template>
  <div class="mine">
    <c-dymamic></c-dymamic>
  </div>
</template>

<script>
import CDymamic from '@/components/dymamic';

export default {
  name: 'Mine',
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
  .mine{
    width: 85%;
  }
</style>
