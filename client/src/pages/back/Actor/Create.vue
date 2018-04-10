<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Ator <small class="operation">novo</small></h1>
    </div>
    <div>
      <alert :type="messageType" :message="message" v-if="hasMessage"/>
      <form v-on:submit.prevent="createActor">
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
  import { create as createActor } from '@/services/Actor'
  import Alert from '@/components/Alert'

  export default {
    name: 'CustomerCreate',
    components: { Alert },
    methods: {
      createActor () {
        createActor({name: this.name})
          .then(() => {
            this.message = 'Ator registrado com sucesso!'
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
