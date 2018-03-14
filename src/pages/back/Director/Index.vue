<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Diretores</h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group mr-2">
          <router-link :to="{name: 'back.directors.create'}" class="btn btn-sm btn-outline-secondary">
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
          <th>Títulos Dirigidos</th>
          <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>7000</td>
          <td>Fernanda Rodrigues</td>
          <td>50</td>
          <td>
            <router-link :to="{ name: 'back.directors.edit' }">
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
    name: 'DirectorIndex'
  }
</script>
