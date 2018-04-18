<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Classe <small class="operation">novo</small></h1>
    </div>
    <div>
      <alert :type="messageType" :message="message" v-if="hasMessage"/>
      <form v-on:submit.prevent="handleCreate">
        <div class="form-row">
          <div class="form-group col-md-12">
            <label for="name">Nome</label>
            <input type="text" class="form-control" id="name" placeholder="Nome" v-model="item.name">
          </div>
          <div class="form-group col-md-12">
            <label for="value">Valor</label>
            <input type="text" class="form-control" id="value" placeholder="R$ 0,00" v-model="item.value">
          </div>
          <div class="form-group col-md-12">
            <label for="maximumRentalTime">Tempo Máximo Locação</label>
            <input type="number" id="maximumRentalTime" class="form-control" placeholder="5 dias" v-model="item.maximumRentalTime" />
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
  import { create } from '@/apis/Classe'
  import Alert from '@/components/Alert'

  export default {
    name: 'ClasseCreate',
    components: { Alert },
    data () {
      return {
        item: {
          name: '',
          value: 0.00,
          maximumRentalTime: 0
        },
        message: '',
        messageType: 'success'
      }
    },
    methods: {
      handleCreate () {
        create(this.itemFormated)
          .then(() => {
            this.message = 'Classe registrada com sucesso!'
          })
          .catch((data) => {
            this.message = data.response.data.error
            this.messageType = 'error'
          })
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
    }
  }
</script>
