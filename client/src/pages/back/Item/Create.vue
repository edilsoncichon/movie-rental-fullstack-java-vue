<template>
  <div data-component="item-create">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Item <small class="operation">novo</small></h1>
    </div>
    <div>
      <alert :type="messageType" :message="message" v-if="hasMessage"/>
      <form v-on:submit.prevent="handleCreate">
        <div class="form-row">
          <div class="form-group col-md-9">
            <label for="numberSerie">Nº Série</label>
            <input type="text" class="form-control" id="numberSerie" placeholder="Nº de Série" v-model="item.numberSerie" required>
          </div>
          <div class="form-group col-md-3">
            <label for="aquisition_date">Dt. Aquisição</label>
            <input-date id="aquisition_date" :default="item.aquisitionDate"/>
          </div>
          <div class="form-group col-md-6">
            <label for="title">Título</label>
            <select v-model="item.title_id" id="title" class="form-control" required>
              <option value="">Selecione...</option>
              <option v-for="title in collections.titles" :value="title._id">{{ title.name }}</option>
            </select>
          </div>
          <div class="form-group col-md-6">
            <label for="type">Tipo</label>
            <select v-model="item.type" id="type" class="form-control" required>
              <option value="">Selecione...</option>
              <option value="fita">Fita</option>
              <option value="dvd">DVD</option>
              <option value="blueray">BlueRay</option>
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
  import { getAll as getTitles } from '@/apis/Title'
  import { create } from '@/apis/Item'
  import InputDate from '@/components/Form/InputDate'
  import Alert from '@/components/Alert'

  export default {
    name: 'ItemCreate',
    components: { InputDate, Alert },
    data () {
      return {
        item: {
          numberSerie: '',
          aquisitionDate: new Date(),
          title_id: '',
          type: ''
        },
        collections: {
          titles: []
        },
        message: '',
        messageType: 'success'
      }
    },
    methods: {
      handleCreate () {
        create(this.item)
          .then(() => {
            this.handleSuccess('Cadastrado com sucesso!')
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
        this.message = error.response.data.message
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
        .then(data => {
          this.collections.titles = data
        })
    }
  }
</script>
