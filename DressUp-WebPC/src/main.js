import 'babel-polyfill'
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import fastclick from 'fastclick'
import axios from 'axios'
// import fancyBox from 'vue-fancybox'
import qs from 'qs'
import store from './store/store'


fastclick.attach(document.body)

Vue.config.productionTip = false

Vue.prototype.$axios = axios;
Vue.prototype.$qs = qs;
Vue.prototype.$store = store;

Vue.use(ElementUI, { size: 'small', zIndex: 3000 });

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
