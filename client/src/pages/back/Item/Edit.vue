<script>
  import { get as getItem, remove, update } from '@/apis/Item'
  import { getAll as getTitles } from '@/apis/Title'

  export default {
    name: 'ItemEdit',

    data () {
      return {
        item: {
          _id: null,
          numberSerie: null,
          aquisitionDate: null,
          title_id: null,
          type: null
        },
        collections: {
          titles: []
        },
        message: '',
        messageType: '',
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
    },

    mounted () {
      getTitles()
        .then(res => {
          this.collections.titles = res
        })
      getItem(this.$route.params.id)
        .then(res => {
          this.item = res
          this.item.title_id = res.title._id
        })
    }
  }
</script>

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
            <input type="text" v-model="item.numberSerie" class="form-control" id="numberSerie" placeholder="Nº de Série" :disabled="!updateAllowed" />
          </div>
          <div class="form-group col-md-3">
            <label for="aquisition_date">Dt. Aquisição</label>
            <input type="date" id="aquisition_date" v-model="item.aquisitionDate" class="form-control" :disabled="!updateAllowed"/>
          </div>
          <div class="form-group col-md-6">
            <label for="title">Título</label>
            <select v-model="item.title_id" id="title" class="form-control" :disabled="!updateAllowed">
              <option selected>Selecione...</option>
              <option v-for="title in collections.titles" :value="title._id">{{ title.name }}</option>
            </select>
          </div>
          <div class="form-group col-md-6">
            <label for="type">Tipo</label>
            <select v-model="item.type" id="type" class="form-control" :disabled="!updateAllowed">
              <option selected>Selecione...</option>
              <option value="fita">Fita</option>
              <option value="dvd">DVD</option>
              <option value="blueray">BlueRay</option>
            </select>
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary" :disabled="!updateAllowed">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>
