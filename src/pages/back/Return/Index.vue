<template>
  <div data-component="page-locations">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Devoluções</h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group mr-2">
          <router-link :to="{name: 'back.returns.create'}" class="btn btn-sm btn-outline-secondary">
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
    <div class="table-responsive">
      <table class="table table-striped table-sm">
        <thead>
        <tr>
          <th>#</th>
          <th>Item</th>
          <th>Cliente</th>
          <th>Dt Locação</th>
          <th>Dt Devolução</th>
          <th>Valor</th>
          <th>Atraso</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>7564</td>
          <td>Poeira em alto mar</td>
          <td>Edilson Cichon</td>
          <td>11/02/18 às 17:19</td>
          <td>15/02/18 às 17:19</td>
          <td>R$ 9,00</td>
          <td>23 dias</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Returns',
    created () {
      this.$bus.$emit('activateMenuItem', { menu: 'returns' })
    }
  }
</script>
