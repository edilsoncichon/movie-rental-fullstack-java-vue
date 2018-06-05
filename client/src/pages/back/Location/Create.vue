<script>
  import { getAll as getItems } from '@/apis/Item'
  import { getAll as getCustomers } from '@/apis/CustomerPartner'
  import { create } from '@/apis/Location'

  export default {
    name: 'LocationCreate',
    data () {
      return {
        item: {
          item_id: '',
          customer_id: '',
          expectedDateDevolution: new Date(),
          valueItem: ''
        },
        collections: {
          items: [],
          customers: []
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
      },
      getItemSelected (id) {
        return this.collections.items.find(function (item) {
          return item._id === id
        })
      },
      calculate () {
        let item = this.getItemSelected(this.item.item_id)
        if (item) {
          this.item.valueItem = String(item.title.classe.value)
        } else {
          this.item.valueItem = ''
        }
      }
    },
    computed: {
      hasMessage () {
        return !!this.message
      }
    },
    mounted () {
      getCustomers()
        .then(data => {
          this.collections.customers = data
        })
      getItems()
        .then(data => {
          this.collections.items = data
        })
    }
  }
</script>

<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Locação <small class="operation">nova</small></h1>
    </div>
    <div>
      <alert :type="messageType" :message="message" v-if="hasMessage"/>
      <form v-on:submit.prevent="handleCreate">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="item">Item</label>
            <select v-model="item.item_id" @change="calculate" class="form-control" id="item" name="item">
              <option value="">Selecione...</option>
              <option v-for="item in collections.items" :value="item._id">{{ item.title.name }}</option>
            </select>
          </div>
          <div class="form-group col-md-6">
            <label for="customer">Cliente</label>
            <select v-model="item.customer_id" class="form-control" id="customer" name="customer">
              <option>Selecione...</option>
              <option v-for="customer in collections.customers" :value="customer._id">{{ customer.name }}</option>
            </select>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-3">
            <label for="dt_devolucao">Dt. Devolução Prevista</label>
            <input-date id="dt_devolucao" :default="item.expectedDateDevolution"/>
          </div>
          <div class="form-group col-md-3">
            <label for="valueItem">Valor</label>
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text">R$</span>
              </div>
              <input type="text" class="form-control" id="valueItem" placeholder="0,00" v-model="item.valueItem">
            </div>
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>
