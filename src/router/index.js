import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/front/Home'
import Noticies from '@/pages/front/Noticies'
import Login from '@/pages/front/Login'
import Dashboard from '@/pages/back/Dashboard'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      components: { default: Home }
    },
    {
      path: '/home',
      name: 'front.home',
      components: { default: Home }
    },
    {
      path: '/noticies',
      name: 'front.noticies',
      components: { default: Noticies }
    },
    {
      path: '/login',
      name: 'front.login',
      components: { default: Login }
    },
    {
      path: '/app/dashboard',
      name: 'back.dashboard',
      component: Dashboard
    }
  ]
})
