<script>
  import Alert from '@/components/Alert'
  import { get as getLocation, _return } from '@/apis/Location'

  export default {
    name: 'LocationReturn',
    components: { Alert },
    methods: {
      handleReturn () {
        _return(this.location._id, this.location)
          .then(() => {
            this.handleSuccess('Devolução efetuada com sucesso!')
          })
          .catch(error => {
            this.handleError(error)
          })
      },
      handleSuccess (message) {
        this.message.value = message
        this.message.type = 'success'
      },
      handleError (error) {
        this.message.value = 'Ocorreu um erro ao processar a operação: ' + error.response.data.message
        this.message.type = 'error'
      },
      updateAmount (value) {
        if (value) {
          this.location.amount = value
        } else {
          let amount = Number(this.location.valueItem) + Number(this.location.fine)
          this.location.amount = amount
          return amount
        }
      }
    },
    computed: {
      amount: {
        get: function () {
          let value = this.updateAmount()
          return value.toFixed(2)
        },
        set: function (value) {
          this.updateAmount(value)
        }
      },
      itemName () {
        return this.location.item.numberSerie + ' - ' + this.location.item.title.name
      }
    },
    data () {
      return {
        location: {
          _id: 1,
          item: {
            _id: 1,
            numberSerie: '',
            title: {
              name: ''
            }
          },
          customerName: '',
          valueItem: 0,
          fine: 0,
          amount: 0,
          locationDate: '2018-05-10',
          expectedReturnDate: '2018-05-02',
          returnDate: '2018-05-15'
        },
        today: new Date(),
        message: {
          type: '',
          value: ''
        }
      }
    },
    mounted () {
      getLocation(this.$route.params.id)
        .then(data => {
          this.location = data
        })
    }
  }
</script>

<template>
  <div data-component="location-return">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Locação <small class="operation">devolver</small></h1>
    </div>
    <div>
      <alert :type="message.type" :message="message.value"/>
      <form v-on:submit.prevent="handleReturn">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="item">Item</label>
            <input class="form-control" id="item" name="item" :value="itemName" disabled/>
          </div>
          <div class="form-group col-md-6">
            <label for="customer">Cliente</label>
            <input class="form-control" id="customer" name="customer" :value="location.customerName" disabled/>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-3">
            <label for="expectedReturnDate">Dt. Devolução Prevista</label>
            <input class="form-control" type="date" id="expectedReturnDate" v-model="location.expectedReturnDate" disabled/>
          </div>
          <div class="form-group col-md-3">
            <label for="returnDate">Dt. Devolução</label>
            <input class="form-control" type="date" id="returnDate" v-model="location.returnDate"/>
          </div>
          <div class="form-group col-md-3">
            <label for="amount">Multa por Atraso</label>
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text">R$</span>
              </div>
              <input type="text" class="form-control" id="amount" placeholder="0,00" v-model="location.fine">
            </div>
          </div>
          <div class="form-group col-md-3">
            <label for="value">Valor Total</label>
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text">R$</span>
              </div>
              <input type="text" class="form-control" id="value" placeholder="0,00" v-model="amount"/>
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
