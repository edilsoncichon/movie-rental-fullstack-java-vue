<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Atores</h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group mr-2">
          <router-link :to="{name: 'back.actors.create'}" class="btn btn-sm btn-outline-secondary">
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
          <th>Títulos atuados</th>
          <th></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="actor in list">
          <td>{{ actor._id }}</td>
          <td>{{ actor.name }}</td>
          <td>{{ actor.titlesActuated }}</td>
          <td>
            <router-link :to="{ name: 'back.actors.edit', params: { id: actor._id } }">
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
  import { getAll as getActors } from '@/services/Actor'
  export default {
    name: 'CustomersIndex',
    data () {
      return {
        actors: []
      }
    },
    computed: {
      list () {
        return this.actors
      }
    },
    mounted () {
      getActors()
        .then((data) => {
          this.actors = data
        })
        .then(() => {
          this.$icons.replace()
        })
        .catch(() => {
          console.error('getActors failed!')
        })
    }
  }
</script>
