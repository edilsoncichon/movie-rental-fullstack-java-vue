import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/pages/front/Login'
import Home from '@/pages/front/Home'
import TitleShow from '@/pages/front/TitleShow'
import Dashboard from '@/pages/back/Dashboard'
import Locations from '@/pages/back/Location/Index'
import LocationCreate from '@/pages/back/Location/Create'
import LocationEdit from '@/pages/back/Location/Edit'
import ReturnCreate from '@/pages/back/Location/Return'
import Titles from '@/pages/back/Title/Index'
import TitleCreate from '@/pages/back/Title/Create'
import TitleEdit from '@/pages/back/Title/Edit'
import Customers from '@/pages/back/Customer/Index'
import CustomerCreate from '@/pages/back/Customer/Create'
import CustomerEdit from '@/pages/back/Customer/Edit'
import Reports from '@/pages/back/Report/Index'
import Actors from '@/pages/back/Actor/Index'
import ActorCreate from '@/pages/back/Actor/Create'
import ActorEdit from '@/pages/back/Actor/Edit'
import Directors from '@/pages/back/Director/Index'
import DirectorCreate from '@/pages/back/Director/Create'
import DirectorEdit from '@/pages/back/Director/Edit'
import Classes from '@/pages/back/Classe/Index'
import ClasseCreate from '@/pages/back/Classe/Create'
import ClasseEdit from '@/pages/back/Classe/Edit'
import Items from '@/pages/back/Item/Index'
import ItemCreate from '@/pages/back/Item/Create'
import ItemEdit from '@/pages/back/Item/Edit'

Vue.use(Router)

/**
 * Utils
 */
function getPathApp (path) {
  return '/' + path
}
function getPrefixNameBack (name) {
  return 'back.' + name
}

/**
 * Session Validate
 */
const redirectIfNotAuthenticated = (to, from, next) => {
  if (to.name !== 'login') {
    let sessionToken = window.localStorage.getItem('X-Session-Token')
    !sessionToken ? next({ name: 'login' }) : next()
  }
  next()
}

const router = new Router({
  mode: 'history',
  linkExactActiveClass: 'active',
  linkActiveClass: 'active',
  routes: [
    /* Frontend routes */
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/',
      name: 'front.home',
      component: Home
    },
    {
      path: '/titles/:id/show',
      name: 'front.titles.show',
      component: TitleShow
    },
    /* Backend routes */
      /* CRM */
    {
      path: getPathApp('dashboard'),
      name: getPrefixNameBack('dashboard'),
      component: Dashboard,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('locations'),
      name: getPrefixNameBack('locations'),
      component: Locations,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('locations/create'),
      name: getPrefixNameBack('locations.create'),
      component: LocationCreate,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('locations/:id/edit'),
      name: getPrefixNameBack('locations.edit'),
      component: LocationEdit,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('locations/:id/return'),
      name: getPrefixNameBack('locations.return'),
      component: ReturnCreate,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('customers'),
      name: getPrefixNameBack('customers'),
      component: Customers,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('customers/create'),
      name: getPrefixNameBack('customers.create'),
      component: CustomerCreate,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('customers/:id/edit'),
      name: getPrefixNameBack('customers.edit'),
      component: CustomerEdit,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('reports'),
      name: getPrefixNameBack('reports'),
      component: Reports,
      beforeEnter: redirectIfNotAuthenticated
    },
      /* Acerv control */
    {
      path: getPathApp('actors'),
      name: getPrefixNameBack('actors'),
      component: Actors,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('actors/create'),
      name: getPrefixNameBack('actors.create'),
      component: ActorCreate,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('actors/:id/edit'),
      name: getPrefixNameBack('actors.edit'),
      component: ActorEdit,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('directors'),
      name: getPrefixNameBack('directors'),
      component: Directors,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('directors/create'),
      name: getPrefixNameBack('directors.create'),
      component: DirectorCreate,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('directors/:id/edit'),
      name: getPrefixNameBack('directors.edit'),
      component: DirectorEdit,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('classes'),
      name: getPrefixNameBack('classes'),
      component: Classes,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('classes/create'),
      name: getPrefixNameBack('classes.create'),
      component: ClasseCreate,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('classes/:id/edit'),
      name: getPrefixNameBack('classes.edit'),
      component: ClasseEdit,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('titles'),
      name: getPrefixNameBack('titles'),
      component: Titles,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('titles/create'),
      name: getPrefixNameBack('titles.create'),
      component: TitleCreate,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('titles/:id/edit'),
      name: getPrefixNameBack('titles.edit'),
      component: TitleEdit,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('items'),
      name: getPrefixNameBack('items'),
      component: Items,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('items/create'),
      name: getPrefixNameBack('items.create'),
      component: ItemCreate,
      beforeEnter: redirectIfNotAuthenticated
    },
    {
      path: getPathApp('items/:id/edit'),
      name: getPrefixNameBack('items.edit'),
      component: ItemEdit,
      beforeEnter: redirectIfNotAuthenticated
    }
  ]
})

export default router
