<template>
  <div id="app">
    <nav-bar/>
    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <side-bar-customer v-if="isCustomer"/>
          <side-bar-admin v-else/>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <router-view/>
        </main>
      </div>
    </div>
  </div>
</template>

<script>
import SideBarAdmin from '@/components/SideBarAdmin'
import SideBarCustomer from '@/components/SideBarCustomer'
import NavBar from '@/components/NavBar'
export default {
  name: 'App',
  components: {
    SideBarCustomer,
    SideBarAdmin,
    NavBar
  },
  data () {
    return {
      isCustomer: true,
      isAdmin: true
    }
  },
  created () {
    this.$bus.$on('activateMenuItem', ($event) => {
      if ($event.menu === 'home') {
        this.isCustomer = true
        this.isAdmin = false
      } else {
        this.isAdmin = true
        this.isCustomer = false
      }
    })
  }
}
</script>

<style lang="scss">
@import "../assets/scss/app";
</style>
