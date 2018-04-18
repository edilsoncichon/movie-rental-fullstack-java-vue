<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Classes</h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group mr-2">
          <router-link :to="{name: 'back.classes.create'}" class="btn btn-sm btn-outline-secondary">
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
    <div class="table-responsive">
      <table class="table table-striped table-sm">
        <thead>
        <tr>
          <th>#</th>
          <th>Nome</th>
          <th class="text-center">Valor</th>
          <th class="text-center">Locação Máxima (dias)</th>
          <th></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="item in list">
          <td>{{ item._id }}</td>
          <td>{{ item.name }}</td>
          <td class="text-center">R$ {{ item.value }}</td>
          <td class="text-center">{{ item.maximumRentalTime }}</td>
          <td>
            <router-link :to="{ name: 'back.classes.edit', params: { id: item._id } }">
              <i data-feather="edit-3"></i>
            </router-link>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  import { getAll } from '@/apis/Classe'
  export default {
    name: 'ClasseIndex',
    data () {
      return {
        items: []
      }
    },
    computed: {
      list () {
        return this.items
      }
    },
    methods: {
      getItems () {
        getAll()
          .then((data) => {
            this.items = data
          })
          .then(() => {
            this.$icons.replace()
          })
          .catch(() => {
            console.error('getAll failed!')
          })
      }
    },
    mounted () {
      this.getItems()
    }
  }
</script>
