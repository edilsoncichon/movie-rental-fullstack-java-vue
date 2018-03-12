<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Itens</h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group mr-2">
          <router-link :to="{name: 'back.items.create'}" class="btn btn-sm btn-outline-secondary">
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
          <th>Nº Série</th>
          <th>Título</th>
          <th>Dt Aquisição</th>
          <th>Tipo</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>77</td>
          <td>786545AAABBBCCC</td>
          <td>Homem das Cavernas</td>
          <td>25/Fev/2016</td>
          <td>
            BlueRay
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Items',
    created () {
      this.$bus.$emit('activateMenuItem', { menu: 'items' })
    }
  }
</script>
