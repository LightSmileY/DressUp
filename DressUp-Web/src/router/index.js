import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/pages/index'
import Cart from '@/pages/cart'
import Category from '@/pages/category'
import Mine from '@/pages/mine'
import Search from '@/pages/search'
import Product from '@/pages/product'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/index',
      name: 'Index',
      component: Index,
      children: [
        {
          path: 'product/:id',
          name: 'home-product',
          component: Product
        }
      ]
    },
    {
      path: '/cart',
      name: 'Cart',
      component: Cart
    },
    {
      path: '/category',
      name: 'Category',
      component: Category
    },
    {
      path: '/mine',
      name: 'Mine',
      component: Mine
    },
    {
      path: '/search',
      name: 'Search',
      component: Search
    },
    {
      path: '/product',
      name: 'Product',
      component: Product
    },
    {
      path: '*',
      redirect: '/index'
    }
  ]
})
