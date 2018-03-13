<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Classes</h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group mr-2">
          <router-link :to="{name: 'back.classes.create'}" class="btn btn-sm btn-outline-secondary">
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
          <th>Nome</th>
          <th>Valor</th>
          <th class="text-center">Tempo Máximo Locação</th>
          <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>9000</td>
          <td>Lançamento</td>
          <td>R$ 2,99</td>
          <td class="text-center">5 dias</td>
          <td>
            <router-link :to="{ name: 'back.classes.edit' }">
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
  export default {
    name: 'Classes',
    created () {
      this.$bus.$emit('activateMenuItem', { menu: 'classes' })
    }
  }
</script>
