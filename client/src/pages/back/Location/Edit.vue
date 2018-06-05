<script>
  import { get as getLocation, update } from '@/apis/Location'
  import { getAll as getItems } from '@/apis/Item'
  import { getAll as getCustomers } from '@/apis/CustomerPartner'

  export default {
    name: 'LocationEdit',

    methods: {
      getItemSelected (id) {
        return this.items.find(function (item) {
          return item.id === id
        })
      },
      calculate () {
        let item = this.getItemSelected(this.itemSelected)
        if (item) {
          this.value = item.value
          this.expectedDateDevolution = item.deadline
        } else {
          this.value = ''
        }
      },
      handleDestroy () {
        let confirmation = confirm('Tem certeza que deseja cancelar esta Locação?')
        if (confirmation) {
          alert('Locação cancelada com sucesso!')
        }
      },
      handleUpdate () {
        update(this.$route.params.id, this.location)
          .then(r => {
            this.handleSuccess('Locação atualizada com sucesso!')
          })
          .catch(err => {
            this.handleError(err)
          })
      },
      handleSuccess (message) {
        this.message.value = message
        this.message.type = 'success'
      },
      handleError (error) {
        this.message.value = 'Ocorreu um erro ao processar a operação: ' + error.response.data.message
        this.message.type = 'error'
      }
    },

    data () {
      return {
        location: {
          _id: null,
          item: null,
          customerId: null,
          customerName: null,
          expectedDateDevolution: null,
          locationDate: null,
          returnDate: null,
          valueItem: null,
          fine: null,
          amount: null
        },
        items: [],
        customers: [],
        editOperation: false,
        message: {
          type: '',
          value: ''
        }
      }
    },

    mounted () {
      getLocation(this.$route.params.id)
        .then(data => {
          this.location._id = data._id
          this.location.item = data.item._id
          this.location.customerId = data.customerId
          this.location.customerName = data.customerName
          this.location.valueItem = String(data.valueItem)
          this.location.expectedReturnDate = data.expectedReturnDate
        })
      getItems()
        .then(data => {
          this.items = data
        })
      getCustomers()
        .then(data => {
          this.customers = data
        })
    }
  }
</script>

<template>
  <div data-component="location-edit">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Locação <small class="operation">alterar</small></h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <button @click="editOperation = !editOperation" class="btn btn-sm btn-outline-secondary mr-2">
          <span data-feather="edit-3"></span>
          Editar
        </button>
        <router-link :to="{ name: 'back.locations.return' }" class="btn btn-sm btn-outline-secondary mr-2">
          <span data-feather="check-circle"></span>
          Devolver
        </router-link>
        <button @click="handleDestroy" class="btn btn-sm btn-outline-secondary">
          <i data-feather="trash-2"></i>
          Cancelar
        </button>
      </div>
    </div>
    <div>
      <alert :type="message.type" :message="message.value"/>
      <form @submit.prevent="handleUpdate">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="item">Item</label>
            <select v-model="location.item" @change="calculate" class="form-control" id="item" name="item" :disabled="!editOperation" >
              <option>Selecione...</option>
              <option v-for="item in items" :value="item._id">{{ `${item.numberSerie} - ${item.title.name}` }}</option>
            </select>
          </div>
          <div class="form-group col-md-6">
            <label for="customer">Cliente</label>
            <select v-model="location.customerId" class="form-control" id="customer" name="customer" :disabled="!editOperation">
              <option>Selecione...</option>
              <option v-for="customer in customers" :value="customer._id">{{ customer.name }}</option>
            </select>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-3">
            <label for="dt_devolucao">Dt. Devolução Prevista</label>
            <input type="date" id="dt_devolucao" v-model="location.expectedReturnDate" :disabled="!editOperation" class="form-control"/>
          </div>
          <div class="form-group col-md-3">
            <label for="value">Valor</label>
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text">R$</span>
              </div>
              <input type="text" class="form-control" id="value" placeholder="0,00" v-model="location.valueItem" :disabled="!editOperation">
            </div>
          </div>
        </div>
        <div class="text-right">
          <button :disabled="!editOperation" type="submit" class="btn btn-primary">Atualizar</button>
        </div>
      </form>
    </div>
  </div>
</template>
