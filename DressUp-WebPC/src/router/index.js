import Vue from 'vue'
import Router from 'vue-router'
import Community from '@/pages/index'
import LoveDressUp from '@/pages/loveDressUp'
import Login from '@/pages/login'
import Register from '@/pages/register'
import Mine from '@/pages/mine/index'
import Posts from '@/pages/mine/post'
import Attent from '@/pages/mine/attent'
import Collections from '@/pages/mine/collections'
import Fans from '@/pages/mine/fans'



Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/community',
      name: 'Community',
      component: Community
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
          path: '/mine/collections',
          name: 'Collections',
          component: Collections
        },
        {
          path: '/mine/attent',
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
      redirect: '/login'
    }
  ]
})
