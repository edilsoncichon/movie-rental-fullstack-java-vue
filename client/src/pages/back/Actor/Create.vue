<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Ator <small class="operation">novo</small></h1>
    </div>
    <div>
      <div class="alert alert-danger" role="alert" v-show="error">{{ error }}</div>
      <div class="alert alert-success" role="alert" v-show="success">{{ success }}</div>
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
  export default {
    name: 'CustomerCreate',
    methods: {
      createActor () {
        createActor({name: this.name})
          .then(() => {
            this.success = 'Salvo com sucesso!'
          })
          .catch(function (data) {
            console.error(data)
            this.error = data
          })
      }
    },
    data () {
      return {
        name: '',
        success: '',
        error: ''
      }
    }
  }
</script>
