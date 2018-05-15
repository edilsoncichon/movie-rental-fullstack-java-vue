<template>
  <div class="alert" v-bind:class="getAlertClass" role="alert">
    {{ message }}
  </div>
</template>

<script>
    export default {
      name: 'Alert',
      props: ['message', 'type'],
      data () {
        return {
          styles: {
            error: 'alert-danger',
            success: 'alert-success',
            warning: 'alert-warning',
            secondary: 'alert-secondary'
          }
        }
      },
      computed: {
        getAlertClass: function () {
          return this.styles[this.type]
        }
      }
    }
</script>

<style scoped>
  .alert {
    font-weight: bold;
    text-align: center;
  }
</style>
