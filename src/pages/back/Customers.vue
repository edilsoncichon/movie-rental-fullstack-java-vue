<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Clientes</h1>
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
          <th>Dt Nascimento</th>
          <th>Sexo</th>
          <th class="text-center">Status</th>
        </tr>
        </thead>
        <tbody>
        <tr class="clickable-row" data-href="cliente.html">
          <td>9000</td>
          <td>Edilson Cichon</td>
          <td>1992</td>
          <td>Masculino</td>
          <td class="text-center">
            <span data-feather="check-square"></span>
          </td>
        </tr>
        <tr class="clickable-row" data-href="cliente.html">
          <td>7000</td>
          <td>Fernanda Rodrigues</td>
          <td>1994</td>
          <td>Feminimo</td>
          <td class="text-center">
            <span data-feather="check-square"></span>
          </td>
        </tr>
        <tr class="clickable-row" data-href="cliente.html">
          <td>1000</td>
          <td>Thiago Colosio</td>
          <td>1986</td>
          <td>Masculino</td>
          <td class="text-center">
            <span data-feather="x"></span>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
