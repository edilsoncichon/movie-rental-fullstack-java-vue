<script>
  import { validateCredentials } from '@/apis/Auth'
  import http from '@/apis/_HttpConfig'

  export default {
    name: 'Login',
    methods: {
      handleLogin () {
        validateCredentials(this.form)
          .then(res => {
            let sessionToken = res.message

            window.localStorage.setItem('X-Session-Token', sessionToken)

            http.defaults.headers['X-Session-Token'] = sessionToken

            this.$router.push({ name: 'back.dashboard' })
          })
          .catch(err => {
            this.messageValidate = err.response ? err.response.data.message : 'Não foi possível entrar no sistema!'
          })
      }
    },
    data () {
      return {
        title: 'Entrar',
        form: {
          username: '',
          password: ''
        },
        messageValidate: ''
      }
    }
  }
</script>

<template>
  <div data-component="login">
    <h1>Entrar</h1>
    <div class="container col-xs-2 col-md-6 offset-md-3">
      <form @submit.prevent="handleLogin">
        <div class="form-group">
          <label for="username">Usuário</label>
          <input type="text" name="username" id="username" v-model="form.username" class="form-control" placeholder="Usuário"/>
        </div>
        <div class="form-group">
          <label for="password">Senha</label>
          <input type="password" name="password" id="password" v-model="form.password" class="form-control" placeholder="Senha"/>
        </div>
        <div class="form-row ml-0">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" name="keep_connected" id="keep_connected" class="custom-control-input" checked>
            <label for="keep_connected" class="custom-control-label">Manter-me logado!</label>
          </div>
        </div>
        <button type="submit" class="btn btn-primary">Entrar</button>
      </form>
      <alert :type="'error'" :message="messageValidate" v-if="messageValidate"/>
    </div>
  </div>
</template>

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
  .alert {
    margin-top: 10px;
  }
</style>
