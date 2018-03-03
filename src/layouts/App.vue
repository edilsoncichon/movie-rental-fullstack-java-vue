<template>
  <div id="app">
    <nav-bar/>
    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <side-bar isDashboard="true"/>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <router-view/>
        </main>
      </div>
    </div>
  </div>
</template>

<script>
import SideBar from '@/components/SideBarAdmin'
import NavBar from '@/components/NavBar'
export default {
  name: 'App',
  components: {
    SideBar,
    NavBar
  }
}
</script>

<style>

</style>
