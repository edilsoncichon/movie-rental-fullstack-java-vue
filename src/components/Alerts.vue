<template>
  <div class="alerts">
    <span class="alert">
      {{ message }}
    </span>
  </div>
</template>

<script>
    export default {
      name: 'Alerts',
      props: ['message']
    }
</script>

<style scoped>
* {
  margin: 10px;
  padding: 10px;
}
.alert {
  color: #41b883;
  font-size: 30px;
  border: 1px solid #2c3e50;
}
.alerts {
  text-align: center;
}
</style>
