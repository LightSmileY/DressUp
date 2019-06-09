import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/pages/index'
import LoveDressUp from '@/pages/loveDressUp'
import Mine from '@/pages/mine'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/loveDressUp',
      name: 'LoveDressUp',
      component: LoveDressUp
    },
    {
      path: '/mine',
      name: 'Mine',
      component: Mine
    }
  ]
})
