<script>
  import { get, remove, update } from '@/apis/Classe'
  import Alert from '@/components/Alert'

  export default {
    name: 'ClasseEdit',
    components: { Alert },
    data () {
      return {
        item: {
          _id: '',
          name: '',
          value: 0.00,
          maximumRentalTime: 0
        },
        message: '',
        messageType: 'success',
        updateAllowed: false
      }
    },
    methods: {
      handleRemove () {
        let confirmation = confirm('Tem certeza que deseja deletar?')
        if (!confirmation) return
        remove(this.$route.params.id)
          .then(() => {
            this.handleSuccess('Deletado com sucesso!')
          })
          .catch(error => {
            this.handleError(error)
          })
      },
      handleUpdate () {
        update(this.$route.params.id, this.itemFormated)
          .then(() => {
            this.handleSuccess('Editado com sucesso!')
          })
          .catch(error => {
            this.handleError(error)
          })
      },
      handleSuccess (message) {
        this.message = message
        this.messageType = 'success'
      },
      handleError (error) {
        this.message = 'Ocorreu um erro ao processar a operação: ' + error.response.data.message
        this.messageType = 'error'
      }
    },
    computed: {
      hasMessage () {
        return !!this.message
      },
      itemFormated () {
        this.item.value = parseFloat(this.item.value)
        this.item.maximumRentalTime = parseInt(this.item.maximumRentalTime)
        return this.item
      }
    },
    mounted () {
      get(this.$route.params.id)
        .then(data => {
          this.item = data
        })
    }
  }
</script>

<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Classe <small class="operation">alterar</small></h1>
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
            <input type="text" class="form-control" id="name" placeholder="Nome" v-model="item.name" :disabled="!updateAllowed" />
          </div>
          <div class="form-group col-md-12">
            <label for="value">Valor</label>
            <input type="text" class="form-control" id="value" placeholder="R$ 0,00" v-model="item.value" :disabled="!updateAllowed"/>
          </div>
          <div class="form-group col-md-12">
            <label for="maximumRentalTime">Tempo Máximo Locação</label>
            <input type="number" id="maximumRentalTime" class="form-control" placeholder="5 dias" v-model="item.maximumRentalTime" :disabled="!updateAllowed"/>
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary alignle" :disabled="!updateAllowed">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>
