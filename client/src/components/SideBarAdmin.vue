<template>
  <side-bar data-component="sidebar-admin">
    <ul class="nav flex-column">
      <li class="nav-item">
        <router-link :to="{name: 'back.dashboard'}" class="nav-link">
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
        <router-link :to="{name: 'back.locations'}" class="nav-link">
          <span data-feather="shopping-bag"></span>
          Locações
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.customers'}" class="nav-link">
          <span data-feather="users"></span>
          Clientes
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.reports'}" class="nav-link">
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
        <router-link :to="{name: 'back.actors'}" class="nav-link">
          <span data-feather="users"></span>
          Atores
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.directors'}" class="nav-link">
          <span data-feather="users"></span>
          Diretores
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.classes'}" class="nav-link">
          <span data-feather="flag"></span>
          Classes
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.titles'}" class="nav-link">
          <span data-feather="film"></span>
          Títulos
        </router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{name: 'back.items'}" class="nav-link">
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
    }
  }
</script>
