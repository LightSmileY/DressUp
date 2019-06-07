<template>
	<div class="TabBbar">
		<i-tab-bar :current="current" color="#f759ab" @change="handleChange" fixed >
	    <i-tab-bar-item key="homepage" icon="homepage" current-icon="homepage_fill" title="Home"></i-tab-bar-item>
	    <i-tab-bar-item key="remind" icon="remind" current-icon="remind_fill" count="3" title="DressUp"></i-tab-bar-item>
	    <i-tab-bar-item key="mine" icon="mine" current-icon="mine_fill" dot title="My"></i-tab-bar-item>
	</i-tab-bar>
	</div>
</template>

<script>
	export default {
    data () {
      return {
        current: "homepage"
      };
    },
    methods: {
      handleChange ({ mp }) {
        this.current = mp.detail.key;
      }
    }
  };
</script>

<style scoped>
	
</style>