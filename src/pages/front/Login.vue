<template>
  <div class="component-login">
    <h1>{{ title }}</h1>
    <form v-on:submit.prevent="handleLogin" class="col-md-6 offset-3">
      <div class="form-group">
        <label for="username">Usuário</label>
        <input type="text" name="username" id="username" v-model="username" class="form-control"/>
      </div>
      <div class="form-group">
        <label for="password">Senha</label>
        <input type="password" name="password" id="password" v-model="password" class="form-control"/>
      </div>
      <button type="submit" class="btn btn-primary">Entrar</button>
    </form>
    <alert :message="messageValidate" v-if="messageValidate" />
  </div>
</template>

<script>
import Alert from '@/components/Alerts'
import AuthService from '@/services/Authentication'
export default {
  name: 'Login',
  methods: {
    handleLogin: function () {
      if (AuthService.handleLogin(this.$data)) {
        this.messageValidate = ''
        this.$router.push({name: 'back.dashboard'})
      } else {
        this.messageValidate = 'Login inválido!'
      }
    }
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
  text-align: center;
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
