import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/pages/front/Login'
import Home from '@/pages/front/Home'
import Dashboard from '@/pages/back/Dashboard'
import Locations from '@/pages/back/Locations'
import Location from '@/pages/back/Location'
import Titles from '@/pages/back/Titles'
import Title from '@/pages/back/Title'
import Customers from '@/pages/back/Customers'
import Customer from '@/pages/back/Customer'
import Reports from '@/pages/back/Reports'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/home',
      name: 'front.home',
      component: Home
    },
    {
      path: '/app/dashboard',
      name: 'back.dashboard',
      component: Dashboard
    },
    {
      path: '/app/locations',
      name: 'back.locations',
      component: Locations
    },
    {
      path: '/app/location',
      name: 'back.location',
      component: Location
    },
    {
      path: '/app/titles',
      name: 'back.titles',
      component: Titles
    },
    {
      path: '/app/title',
      name: 'back.title',
      component: Title
    },
    {
      path: '/app/customers',
      name: 'back.customers',
      component: Customers
    },
    {
      path: '/app/customer',
      name: 'back.customer',
      component: Customer
    },
    {
      path: '/app/reports',
      name: 'back.reports',
      component: Reports
    }
  ]
})
