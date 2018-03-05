<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Títulos</h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group mr-2">
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
          <th>Sinópse</th>
          <th>Categoria</th>
        </tr>
        </thead>
        <tbody>
        <tr class="clickable-row" data-href="titulo.html">
          <td>7564</td>
          <td>Poeira em alto mar</td>
          <td>1910</td>
          <td>Uma história duvidosa, onde ninguém sabe se...</td>
          <td>Suspense</td>
        </tr>
        <tr class="clickable-row" data-href="titulo.html">
          <td>8354</td>
          <td>Guerra nas Estrelas</td>
          <td>2001</td>
          <td>A gravidade não permite o uso de armas, tornando...</td>
          <td>Ficção Científica</td>
        </tr>
        <tr class="clickable-row" data-href="titulo.html">
          <td>4976</td>
          <td>Os Vingadores</td>
          <td>2010</td>
          <td>A junção dos super heróis mais famosos, levou...</td>
          <td>Ficção Científica</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Titles',
    created () {
      this.$bus.$emit('activateMenuItem', { menu: 'titles' })
    }
  }
</script>
