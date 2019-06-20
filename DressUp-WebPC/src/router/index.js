import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/pages/index'
import LoveDressUp from '@/pages/loveDressUp'
import Mine from '@/pages/mine/index'
import Posts from '@/pages/mine/post'
import Attent from '@/pages/mine/attent'
import Collections from '@/pages/mine/collections'
import Fans from '@/pages/mine/fans'


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
      component: Mine,
      children: [
        {
          path: '/mine/',
          name: 'Posts',
          component: Posts
        },
        {
          path: '/mine/attent',
          name: 'Collections',
          component: Collections
        },
        {
          path: '/mine/collections',
          name: 'Attent',
          component: Attent
        },
        {
          path: '/mine/fans',
          name: 'Fans',
          component: Fans
        }
      ]
    },
    {
      path: '*',
      redirect: '/'
    }
  ]
})
