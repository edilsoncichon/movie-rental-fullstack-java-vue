<script>
  import { getAll } from '@/apis/CustomerPartner'
  import Alert from '@/components/Alert'
  import { dateBrMask } from '@/services/mask'

  export default {
    name: 'CustomersIndex',

    computed: {
      list () {
        return this.items
      },
      hasMessage () {
        return !!this.message.value
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
        this.message.value = message
        this.message.type = 'success'
      },
      handleError (error) {
        this.message.value = 'Ocorreu um erro ao processar a operação: ' + error.response.data.message
        this.message.type = 'error'
      },
      dateBrMask
    },

    mounted () {
      this.getItems()
    },

    components: { Alert },

    data () {
      return {
        items: [],
        message: {
          value: '',
          type: ''
        }
      }
    }
  }
</script>

<template>
  <div data-component="customer-index">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Clientes</h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group mr-2">
          <router-link :to="{name: 'back.customers.create'}" class="btn btn-sm btn-outline-secondary">
            Novo <i data-feather="plus-circle"></i>
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
    <alert :type="message.type" :message="message.value" v-if="hasMessage"/>
    <div class="table-responsive">
      <table class="table table-striped table-sm">
        <thead>
        <tr>
          <th>#</th>
          <th>Nome</th>
          <th>Dt Nascimento</th>
          <th>Sexo</th>
          <th class="text-center">Status</th>
          <th></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="item in list">
          <td>{{ item._id }}</td>
          <td>{{ item.name }}</td>
          <td>{{ dateBrMask(item.birthDate) }}</td>
          <td>{{ item.sex === 'M' ? 'Masculino' : 'Feminino' }}</td>
          <td class="text-center">
            <i data-feather="check-square"></i>
          </td>
          <td>
            <router-link :to="{name: 'back.customers.edit', params:{ id: item._id }}">
              <i data-feather="edit-3"></i>
            </router-link>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
