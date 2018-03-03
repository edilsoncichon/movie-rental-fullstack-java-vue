<template>
  <div>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">{{ companyName }}</a>
      <input class="form-control form-control-dark w-100" type="text" placeholder="Buscar" aria-label="Buscar">
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <router-link class="nav-link" :to="{name: 'login'}">Entrar</router-link>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'NavBarAdmin',
  data () {
    return {
      companyName: 'iutube'
    }
  }
}
</script>
