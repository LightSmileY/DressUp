// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router';
import router from './router'// 导入路由文件
import axios from 'axios'// 导入axios
// import VueAxios from 'vue-axios'
import iView from 'iview';
import 'iview/dist/styles/iview.css';
import Store from './store/store'
var qs = require('qs');

Vue.use(VueRouter);
Vue.use(iView);
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
Vue.prototype.$axios = axios;
Vue.prototype.$store = Store;
// Vue.use(VueAxios,axios);
Vue.config.productionTip = false
 Vue.prototype.$qs = qs;
/* eslint-disable no-new */

// 添加请求拦截器，在请求头中加token
// axios.interceptors.request.use(
//   config => {
//     if (localStorage.getItem('Authorization')) {
//       config.headers.Authorization = localStorage.getItem('Authorization');
//     }
//  
//     return config;
//   },
//   error => {
//     return Promise.reject(error);
//   });
//   localStorage.removeItem('Authorization');
//       this.$router.push('/login');


new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  // store:store
})
