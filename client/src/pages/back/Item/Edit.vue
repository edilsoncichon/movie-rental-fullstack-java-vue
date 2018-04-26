<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Item <small class="operation">Alterar</small></h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <button @click="updateAllowed = !updateAllowed" class="btn btn-sm btn-outline-secondary mr-2">
          <span data-feather="edit-3"></span>
          Editar
        </button>
        <button @click="handleRemove" class="btn btn-sm btn-outline-secondary">
          <i data-feather="trash-2"></i>
          Excluir
        </button>
      </div>
    </div>
    <div>
      <alert :type="messageType" :message="message" v-if="hasMessage"/>
      <form v-on:submit.prevent="handleUpdate">
        <div class="form-row">
          <div class="form-group col-md-9">
            <label for="numberSerie">Nº Série</label>
            <input type="text" class="form-control" id="numberSerie" placeholder="Nº de Série">
          </div>
          <div class="form-group col-md-3">
            <label for="aquisition_date">Dt. Aquisição</label>
            <input-date id="aquisition_date"/>
          </div>
          <div class="form-group col-md-6">
            <label for="title">Título</label>
            <select id="title" class="form-control">
              <option selected>Selecione...</option>
              <option>Filme 1</option>
              <option>Filme 2</option>
              <option>Filme 3</option>
            </select>
          </div>
          <div class="form-group col-md-6">
            <label for="type">Tipo</label>
            <select id="type" class="form-control">
              <option selected>Selecione...</option>
              <option>Fita</option>
              <option>DVD</option>
              <option>BlueRay</option>
            </select>
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
  import { remove, update } from '@/apis/Item'
  import Alert from '@/components/Alert'
  import InputDate from '@/components/Form/InputDate'

  export default {
    name: 'ItemEdit',
    components: { InputDate, Alert },
    data () {
      return {
        item: {
          serieNumber: '',
          aquisitionDate: new Date(),
          title: {_id: null},
          type: ''
        },
        collections: {
          titles: []
        },
        message: '',
        messageType: '',
        updateAllowed: true
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
        update(this.$route.params.id, this.item)
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
      }
    }
  }
</script>
