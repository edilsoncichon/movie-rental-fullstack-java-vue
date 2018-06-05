<template>
  <div>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <router-link class="navbar-brand col-sm-3 col-md-2 mr-0" :to="{name: 'front.home'}">{{ companyName }}</router-link>
      <input class="form-control form-control-dark w-100" type="text" placeholder="Buscar" aria-label="Buscar">
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a href="#" class="nav-link" @click="handleLoginOrLogout">{{ loginOrLogout }}</a>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'NavBar',

  data () {
    return {
      companyName: 'IuTubi'
    }
  },

  computed: {
    isLogged () {
      return !!window.localStorage.getItem('X-Session-Token')
    },
    loginOrLogout () {
      return this.isLogged ? 'Sair' : 'Entrar'
    }
  },

  methods: {
    handleLoginOrLogout () {
      if (this.isLogged) {
        if (confirm('Tem certeza que deseja sair do sistema?')) {
          window.localStorage.removeItem('X-Session-Token')
          this.$router.push({name: 'login'})
        }
      } else {
        this.$router.push({ name: 'login' })
      }
    }
  }
}
</script>
