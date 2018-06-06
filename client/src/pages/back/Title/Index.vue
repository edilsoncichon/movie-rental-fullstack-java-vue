<template>
  <div data-component="title-index">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Títulos</h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group mr-2">
          <router-link :to="{name: 'back.titles.create'}" class="btn btn-sm btn-outline-secondary">
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
          <th>Ano</th>
          <th>Categoria</th>
          <th>Classe</th>
          <th>Diretor</th>
          <th>Atores</th>
          <th></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="item in list">
          <td>{{ item._id }}</td>
          <td>{{ item.name }}</td>
          <td>{{ item.year }}</td>
          <td>{{ item.category.name }}</td>
          <td>{{ item.classe.name }}</td>
          <td>{{ item.director.name }}</td>
          <td>{{ item.actors.length }}</td>
          <td>
            <router-link :to="{ name: 'back.titles.edit', params: {id: item._id} }">
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
  import { getAll } from '@/apis/Title'

  export default {
    name: 'TitlesIndex',
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
      }
    },
    mounted () {
      this.getItems()
    }
  }
</script>
