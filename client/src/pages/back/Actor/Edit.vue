<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Ator <small class="operation">Alterar</small></h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <button @click="editOperation = !editOperation" class="btn btn-sm btn-outline-secondary mr-2">
          <span data-feather="edit-3"></span>
          Editar
        </button>
        <button class="btn btn-sm btn-outline-secondary mr-2">
          <i data-feather="trash-2"></i>
          Excluir
        </button>
      </div>
    </div>
    <div>
      <form>
        <div class="form-row">
          <div class="form-group col-md-12">
            <label for="name">Nome</label>
            <input type="email" class="form-control" id="name" placeholder="Nome" v-model="actor.name">
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary alignle">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  import { get } from '@/services/Actor'
  export default {
    name: 'CustomerEdit',
    data () {
      return {
        actor: {
          _id: '',
          name: '',
          titlesActuated: 0
        }
      }
    },
    mounted () {
      get(this.$route.params.id)
        .then(data => {
          this.actor = data
        })
    }
  }
</script>
