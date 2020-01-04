import Vue from 'vue'
import Router from 'vue-router'

import Login from "../views/Login"
import Main from '../views/Main'

// 用于嵌套的路由组件
import UserProfile from '../views/customer/Profile'
import UserList from '../views/customer/List'

import NotFound from '../views/NotFound'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      // 登录页
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      // 首页
      path: '/main/:name',
      props: true,
      name: 'Main',
      component: Main,
      // 配置嵌套路由
      children: [
        {path: '/customer/profile/:id', name: 'UserProfile', component: UserProfile, props: true},
        {path: '/customer/list', component: UserList},
      ]
    },
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/goHome',
      redirect: '/'
    },
    {
      path: '*',
      component: NotFound
    }
  ]
});
