<template>
  <div class="noticies">
    <h1>{{ title }}</h1>
  </div>
</template>

<script>
export default {
  name: 'Noticies',
  data () {
    return {
      title: 'Noticies'
    }
  }
}
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
}
</style>
