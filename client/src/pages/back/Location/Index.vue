<script>
  import { getAll } from '@/apis/Location'
  import Alert from '@/components/Alert'
  import { dateBrMask } from '@/services/mask'

  export default {
    name: 'LocationsIndex',
    computed: {
      list () {
        return this.items
      },
      hasMessage () {
        return !!this.message
      }
    },
    methods: {
      getItems () {
        getAll()
          .then((data) => {
            this.items = data
            this.$icons.replace()
          })
          .then(() => {
            this.$icons.replace()
          })
          .catch(() => {
            this.handleError('Não foi possível carregar os registros! =/')
          })
      },
      handleSuccess (message) {
        this.message = message
        this.messageType = 'success'
      },
      handleError (error) {
        this.message = 'Ocorreu um erro ao processar a operação: ' + error.response.data.message
        this.messageType = 'error'
      },
      dateBrMask,
      getStatusLocation (location) {
        return location.returnDate ? 'Devolvido' : 'Locado'
      }
    },
    mounted () {
      this.getItems()
    },
    components: { Alert },
    data () {
      return {
        items: [],
        message: '',
        messageType: ''
      }
    }
  }
</script>

<template>
  <div data-component="location-index">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Locações</h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group mr-2">
          <router-link :to="{name: 'back.locations.create'}" class="btn btn-sm btn-outline-secondary">
            Nova <i data-feather="plus-circle"></i>
          </router-link>
          <button class="btn btn-sm btn-outline-secondary">Imprimir</button>
          <button class="btn btn-sm btn-outline-secondary">Exportar</button>
        </div>
        <button class="btn btn-sm btn-outline-secondary dropdown-toggle">
          <span data-feather="calendar"></span>
          Período
        </button>
      </div>
    </div>
    <alert :type="messageType" :message="message" v-if="hasMessage"/>
    <div class="table-responsive">
      <table class="table table-striped table-sm">
        <thead>
        <tr>
          <th>#</th>
          <th>Item</th>
          <th>Cliente</th>
          <th>Dt Locação</th>
          <th>Dt Devolução (prevista)</th>
          <th>Dt Devolução</th>
          <th>Valor</th>
          <th>Status</th>
          <th></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="item in items">
          <td>{{ item._id }}</td>
          <td>{{ item.item.numberSerie + ' - ' + item.item.title.name }}</td>
          <td>{{ item.customerName }}</td>
          <td>{{ dateBrMask(item.locationDate) }}</td>
          <td>{{ dateBrMask(item.expectedReturnDate) }}</td>
          <td>{{ dateBrMask(item.returnDate) }}</td>
          <td>R$ {{ item.valueItem }}</td>
          <td>{{ getStatusLocation(item) }}</td>
          <td>
            <router-link title="Editar" :to="{name: 'back.locations.edit', params: {id: item._id}}">
              <i data-feather="edit-3"></i>
            </router-link>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
