<template>
  <side-bar>
    <ul class="nav flex-column">
      <li class="nav-item">
        <router-link :to="{name: 'back.dashboard'}" v-bind:class="{active: isDashboard}" class="nav-link">
          <span data-feather="home"></span>
          Dashboard <span class="sr-only">(current)</span>
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.locations'}" v-bind:class="{active: isLocations}" class="nav-link">
          <span data-feather="shopping-bag"></span>
          Locações
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.titles'}" v-bind:class="{active: isTitles}" class="nav-link">
          <span data-feather="film"></span>
          Títulos
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
      <span>Item</span>
      <a class="d-flex align-items-center text-muted" href="#">
        <span data-feather="plus-circle"></span>
      </a>
    </h6>
    <ul class="nav flex-column mb-2">
      <li class="nav-item">
        <router-link class="nav-link" :to="{name: ''}">
          <span data-feather="file-text"></span>
          Sub Item
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
        isTitles: false,
        isCustomers: false,
        isReports: false,
        isPlans: false
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
        this.isTitles = false
        this.isCustomers = false
        this.isPlans = false
        this.isReports = false
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
          case 'titles':
            this.isTitles = true
            break
          case 'customers':
            this.isCustomers = true
            break
          case 'plans':
            this.isPlans = true
            break
          case 'reports':
            this.isReports = true
            break
        }
      }
    }
  }
</script>
