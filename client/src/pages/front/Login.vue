<template>
  <div data-component="login">
    <h1>Entrar</h1>
    <div class="container col-xs-2 col-md-6 offset-md-3">
      <form v-on:submit.prevent="handleLogin">
        <div class="form-group">
          <label for="username">Usuário</label>
          <input type="text" name="username" id="username" v-model="username" class="form-control" placeholder="Usuário"/>
        </div>
        <div class="form-group">
          <label for="password">Senha</label>
          <input type="password" name="password" id="password" v-model="password" class="form-control" placeholder="Senha"/>
        </div>
        <div class="form-row ml-0">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" name="keep_connected" id="keep_connected" class="custom-control-input" checked>
            <label for="keep_connected" class="custom-control-label">Manter-me logado!</label>
          </div>
        </div>
        <button type="submit" class="btn btn-primary">Entrar</button>
      </form>
      <alert :message="messageValidate" v-if="messageValidate" />
    </div>
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
    text-align: center;
  }
</style>
