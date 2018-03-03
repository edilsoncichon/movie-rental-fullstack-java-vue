<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Locações</h1>
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
          <th>Título</th>
          <th>Cliente</th>
          <th>Dt Devolução</th>
          <th>Atraso</th>
        </tr>
        </thead>
        <tbody>
        <tr class="clickable-row" data-href="locacao.html">
          <td>7564</td>
          <td>Poeira em alto mar</td>
          <td>Edilson Cichon</td>
          <td>11/02/18 às 17:19</td>
          <td>11 dias</td>
        </tr>
        <tr class="clickable-row" data-href="locacao.html">
          <td>8354</td>
          <td>Guerra nas Estrelas</td>
          <td>Fernanda Rodrigues</td>
          <td>15/02/18 às 08:55</td>
          <td>6 dias</td>
        </tr>
        <tr class="clickable-row" data-href="locacao.html">
          <td>4976</td>
          <td>Os Vingadores</td>
          <td>Thiago Colosio</td>
          <td>21/02/18 às 08:00</td>
          <td>1 dias</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
