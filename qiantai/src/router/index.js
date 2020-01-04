import Vue from 'vue'
import Router from 'vue-router'

import Index from "../components/Index"
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
      // 主页
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
      //首页
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      //重定向到首页
      path: '/goHome',
      redirect: '/'
    },
    {
      //错误页
      path: '*',
      component: NotFound
    }
  ]
});
