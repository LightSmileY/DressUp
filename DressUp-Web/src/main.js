import Vue from 'vue'
import App from './App'
// import Store from './store/store'
import qs from 'qs';

Vue.prototype.$qs = qs;
var Fly = require("flyio/dist/npm/wx") 


var fly=new Fly

Vue.config.productionTip = false
App.mpType = 'app'

// Vue.prototype.$store = store

Vue.prototype.$fly = fly

const app = new Vue(App)
app.$mount()

export default {
  config: {
    
  }
}