import Vue from 'vue'
import App from './App'
import store from './store/store'
import qs from 'qs'
import weiui from 'weiui'

Vue.prototype.$qs = qs;
Vue.prototype.$store = store;
var Fly = require("flyio/dist/npm/wx") 


var fly=new Fly

Vue.config.productionTip = false
App.mpType = 'app'

Vue.prototype.$fly = fly

const app = new Vue(App)
app.$mount()

export default {
  config: {
    
  }
}