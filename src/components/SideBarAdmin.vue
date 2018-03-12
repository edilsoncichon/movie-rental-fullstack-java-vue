<template>
  <side-bar class="sidebar-admin">
    <ul class="nav flex-column">
      <li class="nav-item">
        <router-link :to="{name: 'back.dashboard'}" v-bind:class="{active: isDashboard}" class="nav-link">
          <span data-feather="home"></span>
          Dashboard <span class="sr-only">(current)</span>
        </router-link>
      </li>
    </ul>
    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
      <span>CRM</span>
      <a class="d-flex align-items-center text-muted" href="#">
        <span data-feather="plus-circle"></span>
      </a>
    </h6>
    <ul class="nav flex-column">
      <li class="nav-item">
        <router-link :to="{name: 'back.locations'}" v-bind:class="{active: isLocations}" class="nav-link">
          <span data-feather="shopping-bag"></span>
          Locações
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.returns'}" v-bind:class="{active: isReturns}" class="nav-link">
          <span data-feather="check-circle"></span>
          Devoluções
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.customers'}" v-bind:class="{active: isCustomers}" class="nav-link">
          <span data-feather="users"></span>
          Clientes
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: ''}" v-bind:class="{active: isPlans}" class="nav-link">
          <span data-feather="dollar-sign"></span>
          Plans
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.reports'}" v-bind:class="{active: isReports}" class="nav-link">
          <span data-feather="bar-chart-2"></span>
          Relatórios
        </router-link>
      </li>
    </ul>
    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
      <span>CONTROLE ACERVO</span>
      <a class="d-flex align-items-center text-muted" href="#">
        <span data-feather="plus-circle"></span>
      </a>
    </h6>
    <ul class="nav flex-column">
      <li class="nav-item">
        <router-link :to="{name: 'back.actors'}" v-bind:class="{active: isActor}" class="nav-link">
          <span data-feather="users"></span>
          Atores
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.directors'}" v-bind:class="{active: isDirector}" class="nav-link">
          <span data-feather="users"></span>
          Diretores
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.classes'}" v-bind:class="{active: isClass}" class="nav-link">
          <span data-feather="flag"></span>
          Classes
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.titles'}" v-bind:class="{active: isTitles}" class="nav-link">
          <span data-feather="film"></span>
          Títulos
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.items'}" v-bind:class="{active: isItem}" class="nav-link">
          <span data-feather="voicemail"></span>
          Item
        </router-link>
      </li>
    </ul>
  </side-bar>
</template>

<script>
  import SideBar from '@/components/SideBar'
  export default {
    name: 'SideBarAdmin',
    components: {
      SideBar
    },
    data () {
      return {
        isDashboard: false,
        isLocations: false,
        isReturns: false,
        isCustomers: false,
        isReports: false,
        isPlans: false,
        isTitles: false,
        isActor: false,
        isDirector: false,
        isClass: false,
        isItem: false
      }
    },
    created () {
      this.$bus.$on('activateMenuItem', ($event) => {
        this.activateMenuItem($event.menu)
      })
    },
    methods: {
      disableMenus () {
        this.isDashboard = false
        this.isLocations = false
        this.isReturns = false
        this.isCustomers = false
        this.isReports = false
        this.isPlans = false
        this.isTitles = false
        this.isActor = false
        this.isDirector = false
        this.isClass = false
        this.isItem = false
      },
      activateMenuItem (menu) {
        this.disableMenus()
        switch (menu) {
          case 'dashboard':
            this.isDashboard = true
            break
          case 'locations':
            this.isLocations = true
            break
          case 'returns':
            this.isReturns = true
            break
          case 'customers':
            this.isCustomers = true
            break
          case 'reports':
            this.isReports = true
            break
          case 'plans':
            this.isPlans = true
            break
          case 'titles':
            this.isTitles = true
            break
          case 'actors':
            this.isActor = true
            break
          case 'directors':
            this.isDirector = true
            break
          case 'classes':
            this.isClass = true
            break
          case 'items':
            this.isItem = true
            break
        }
      }
    }
  }
</script>
