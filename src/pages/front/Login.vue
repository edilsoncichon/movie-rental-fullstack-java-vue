<template>
  <div class="login">
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
import handleLogin from '@/services/HandleLogin'
export default {
  name: 'Login',
  methods: {
    handleLogin: handleLogin
  },
  data () {
    return {
      title: 'Login',
      username: '',
      password: '',
      messageValidate: ''
    }
  },
  components: { Alert }
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
