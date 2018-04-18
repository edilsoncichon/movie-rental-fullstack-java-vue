<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Diretor <small class="operation">Alterar</small></h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <button @click="updateAllowed = !updateAllowed" class="btn btn-sm btn-outline-secondary mr-2">
          <span data-feather="edit-3"></span>
          Editar
        </button>
        <button @click="handleRemove" class="btn btn-sm btn-outline-secondary mr-2">
          <i data-feather="trash-2"></i>
          Excluir
        </button>
      </div>
    </div>
    <div>
      <alert :type="messageType" :message="message" v-if="hasMessage"/>
      <form v-on:submit.prevent="handleUpdate">
        <div class="form-row">
          <div class="form-group col-md-12">
            <label for="name">Nome</label>
            <input name="name" type="text" class="form-control" id="name" placeholder="Nome" v-model="item.name" :disabled="!updateAllowed" />
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary alignle" :disabled="!updateAllowed">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  import { get, remove, update } from '@/apis/Director'
  import Alert from '@/components/Alert'

  export default {
    name: 'DirectorEdit',
    components: { Alert },
    data () {
      return {
        item: {
          _id: '',
          name: ''
        },
        message: '',
        messageType: 'success',
        updateAllowed: false
      }
    },
    mounted () {
      get(this.$route.params.id)
        .then(data => {
          this.item = data
        })
    },
    methods: {
      handleRemove () {
        let confirmation = confirm('Tem certeza que deseja deletar?')
        if (!confirmation) return
        remove(this.$route.params.id)
          .then(() => {
            this.message = 'Deletado com sucesso!'
          })
          .catch((data) => {
            console.error(data)
            this.message = data.response.data.error
            this.messageType = 'error'
          })
      },
      handleUpdate () {
        update(this.$route.params.id, this.item)
          .then(() => {
            this.message = 'Editado com sucesso!'
          })
          .catch((data) => {
            console.error(data)
            this.message = data.response.data.error
            this.messageType = 'error'
          })
      }
    },
    computed: {
      hasMessage () {
        return !!this.message
      }
    }
  }
</script>
