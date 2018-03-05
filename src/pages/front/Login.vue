<template>
  <div class="component-login">
    <h1>{{ title }}</h1>
    <form action="login" method="post" v-on:submit.prevent="handleLogin">
      <label for="username">Username</label>
      <input type="text" name="username" id="username" v-model="username"/>
      <label for="password">Password</label>
      <input type="password" name="password" id="password" v-model="password"/>
      <button type="submit">Entrar</button>
    </form>
    <alert :message="messageValidate" v-if="messageValidate" />
  </div>
</template>

<script>
import Alert from '@/components/Alerts'
import { handleLogin } from '@/services/Authentication'
export default {
  name: 'Login',
  methods: {
    handleLogin
  },
  components: { Alert },
  data () {
    return {
      title: 'Entrar',
      username: '',
      password: '',
      messageValidate: ''
    }
  },
  created () {
    this.$bus.$emit('activateMenuItem', { menu: 'home' })
  }
}
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
  margin-bottom: 10px;
}
form {
  text-align: center;
  display: block;
}
input {
  display: block;
  margin: auto;
  margin-bottom: 10px;
}
</style>
