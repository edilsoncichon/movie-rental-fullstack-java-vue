<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Classe <small class="operation">nova</small></h1>
    </div>
    <div>
      <form>
        <div class="form-row">
          <div class="form-group col-md-12">
            <label for="name">Nome</label>
            <input type="email" class="form-control" id="name" placeholder="Nome">
          </div>
          <div class="form-group col-md-12">
            <label for="value">Valor</label>
            <input type="text" class="form-control" id="value" placeholder="R$ 0,00">
          </div>
          <div class="form-group col-md-12">
            <label for="maximumRentalTime">Tempo Máximo Locação</label>
            <input type="number" name="maximumRentalTime" id="maximumRentalTime" class="form-control" placeholder="5 dias">
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary alignle">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'ClasseCreate'
  }
</script>
