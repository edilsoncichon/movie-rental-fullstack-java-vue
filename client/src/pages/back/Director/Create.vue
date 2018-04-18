<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Diretor <small class="operation">novo</small></h1>
    </div>
    <div>
      <alert :type="messageType" :message="message" v-if="hasMessage"/>
      <form v-on:submit.prevent="create">
        <div class="form-row">
          <div class="form-group col-md-12">
            <label for="name">Nome</label>
            <input type="text" class="form-control" id="name" placeholder="Nome" v-model="name">
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  import { create } from '@/apis/Director'
  import Alert from '@/components/Alert'

  export default {
    name: 'DirectorCreate',
    components: { Alert },
    methods: {
      create () {
        create({name: this.name})
          .then(() => {
            this.message = 'Diretor registrado com sucesso!'
          })
          .catch((data) => {
            console.error(data)
            this.message = data.response.data.error
            this.messageType = 'error'
          })
      }
    },
    data () {
      return {
        name: '',
        message: '',
        messageType: 'success'
      }
    },
    computed: {
      hasMessage () {
        return !!this.message
      }
    }
  }
</script>
