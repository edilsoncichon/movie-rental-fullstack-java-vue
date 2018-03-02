<template>
  <div class="nav">
    <nav class="nav-bar-fixed-top clearfix">
      <a class="company-name" href="#">{{ companyName }}</a>
      <router-link :to="{name: 'front.home'}">Home</router-link>
      <router-link :to="{name: 'front.noticies'}">Noticies</router-link>
      <router-link :to="{name: 'front.login'}">Login</router-link>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'navbar',
  data () {
    return {
      companyName: 'YoutubeFlix'
    }
  }
}
</script>

<style scoped>
  .nav-bar-fixed-top {
    width: 100%;
    background-color: #41b883;
  }
  .nav-bar-fixed-top a {
    text-decoration: none;
    float: left;
    width: 20%;
  }
  .nav-bar-fixed-top .company-name {
    width: 40%;
    font-weight: 700;
  }
  .clearfix {
    overflow: auto;
    zoom: 1;
  }
  .dd {
    border: 1px solid red;
  }
</style>
