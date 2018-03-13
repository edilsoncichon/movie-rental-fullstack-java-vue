import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/pages/front/Login'
import Home from '@/pages/front/Home'
import TitleShow from '@/pages/front/TitleShow'
import Dashboard from '@/pages/back/Dashboard'
import Locations from '@/pages/back/Location/Index'
import LocationCreate from '@/pages/back/Location/Create'
import LocationEdit from '@/pages/back/Location/Edit'
import Returns from '@/pages/back/Return/Index'
import ReturnCreate from '@/pages/back/Return/Create'
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

export default new Router({
  mode: 'history',
  routes: [
    /* Frontend routes */
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/',
      component: Home
    },
    {
      path: '/home',
      name: 'front.home',
      component: Home
    },
    {
      path: '/titles/show',
      name: 'front.titles.show',
      component: TitleShow
    },
    /* Backend routes */
      /* CRM */
    {
      path: getPathApp('dashboard'),
      name: getPrefixNameBack('dashboard'),
      component: Dashboard
    },
    {
      path: getPathApp('locations'),
      name: getPrefixNameBack('locations'),
      component: Locations
    },
    {
      path: getPathApp('locations/create'),
      name: getPrefixNameBack('locations.create'),
      component: LocationCreate
    },
    {
      path: getPathApp('locations/edit'),
      name: getPrefixNameBack('locations.edit'),
      component: LocationEdit
    },
    {
      path: getPathApp('returns'),
      name: getPrefixNameBack('returns'),
      component: Returns
    },
    {
      path: getPathApp('returns/create'),
      name: getPrefixNameBack('returns.create'),
      component: ReturnCreate
    },
    {
      path: getPathApp('customers'),
      name: getPrefixNameBack('customers'),
      component: Customers
    },
    {
      path: getPathApp('customers/create'),
      name: getPrefixNameBack('customers.create'),
      component: CustomerCreate
    },
    {
      path: getPathApp('customers/edit'),
      name: getPrefixNameBack('customers.edit'),
      component: CustomerEdit
    },
    {
      path: getPathApp('reports'),
      name: getPrefixNameBack('reports'),
      component: Reports
    },
      /* Acerv control */
    {
      path: getPathApp('actors'),
      name: getPrefixNameBack('actors'),
      component: Actors
    },
    {
      path: getPathApp('actors/create'),
      name: getPrefixNameBack('actors.create'),
      component: ActorCreate
    },
    {
      path: getPathApp('actors/edit'),
      name: getPrefixNameBack('actors.edit'),
      component: ActorEdit
    },
    {
      path: getPathApp('directors'),
      name: getPrefixNameBack('directors'),
      component: Directors
    },
    {
      path: getPathApp('directors/create'),
      name: getPrefixNameBack('directors.create'),
      component: DirectorCreate
    },
    {
      path: getPathApp('directors/edit'),
      name: getPrefixNameBack('directors.edit'),
      component: DirectorEdit
    },
    {
      path: getPathApp('classes'),
      name: getPrefixNameBack('classes'),
      component: Classes
    },
    {
      path: getPathApp('classes/create'),
      name: getPrefixNameBack('classes.create'),
      component: ClasseCreate
    },
    {
      path: getPathApp('classes/edit'),
      name: getPrefixNameBack('classes.edit'),
      component: ClasseEdit
    },
    {
      path: getPathApp('titles'),
      name: getPrefixNameBack('titles'),
      component: Titles
    },
    {
      path: getPathApp('titles/create'),
      name: getPrefixNameBack('titles.create'),
      component: TitleCreate
    },
    {
      path: getPathApp('titles/edit'),
      name: getPrefixNameBack('titles.edit'),
      component: TitleEdit
    },
    {
      path: getPathApp('items'),
      name: getPrefixNameBack('items'),
      component: Items
    },
    {
      path: getPathApp('items/create'),
      name: getPrefixNameBack('items.create'),
      component: ItemCreate
    },
    {
      path: getPathApp('items/edit'),
      name: getPrefixNameBack('items.edit'),
      component: ItemEdit
    }
  ]
})

function getPathApp (path) {
  return '/' + path
}

function getPrefixNameBack (name) {
  return 'back.' + name
}
