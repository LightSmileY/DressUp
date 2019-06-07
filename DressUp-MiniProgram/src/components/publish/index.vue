<template>
	<div class="btn">
		<navigator url="../publishPage/main" class="circle">
			+
		</navigator>
	</div>
</template>

export default {
  data () {
    return {
      
    }
  }
};
</script>

<style scoped>
	.btn{
		position: fixed;
		bottom: 50px;
		right: 5px;
	}
	.circle{
		width: 50px;
		height: 50px;
		border-radius: 50%;
		font-size: 35px;
		color: #fff;
		line-height: 45px;
		text-align: center;
		background-color: #FFB5AB;
		box-shadow: 0 0 5px #737272;
	}
</style>