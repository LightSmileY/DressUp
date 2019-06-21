import Vue from 'vue'
import Router from 'vue-router'
import home from '@/pages/home'
import UserList from '@/pages/UserList'
import AdminList from '@/pages/AdminList'
import PostList from '@/pages/PostList'
import Comment from '@/pages/Comment'
import EditUser from '@/pages/EditUser'
import MainHome from '@/pages/MainHome'
import login from '@/components/login'

Vue.use(Router)

export default new Router({
  routes: [
		// {
		//   path: '/',
		// 	redirect: '/login'
		// },
		{
		  path: '/',
		  name: 'login',
		  component: login
		},
		{
		  path: '/MainHome',
		  name: 'MainHome',
		  component: MainHome,
			children:[
				{
				  path: '/MainHome/home',
						name: 'home',
						component: home
				},
				{
				  path: '/MainHome/UserList',
				  name: 'UserList',
				  component: UserList
				},
				{
				  path: '/MainHome/AdminList',
				  name: 'AdminList',
				  component: AdminList
				},
				{
				  path: '/MainHome/PostList',
				  name: 'PostList',
				  component: PostList
				},
				{
				  path: '/MainHome/Comment',
				  name: 'Comment',
				  component: Comment
				},
				{
				  path: '/MainHome/EditUser',
				  name: 'EditUser',
				  component: EditUser
				}
			]
		}
		
  ]
})
// // 导航守卫
// // 使用 router.beforeEach 注册一个全局前置守卫，判断用户是否登陆
// router.beforeEach((to, from, next) => {
//   if (to.path === '/login') {
//     next();
//   } else {
//     let token = localStorage.getItem('Authorization');
//  
//     if (token === 'null' || token === '') {
//       next('/login');
//     } else {
//       next();
//     }
//   }
// });
//  
// export default router;

