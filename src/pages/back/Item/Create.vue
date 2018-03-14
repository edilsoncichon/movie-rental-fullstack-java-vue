<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Item <small class="operation">novo</small></h1>
    </div>
    <div>
      <form>
        <div class="form-row">
          <div class="form-group col-md-9">
            <label for="numberSerie">Nº Série</label>
            <input type="text" class="form-control" id="numberSerie" placeholder="Nº de Série">
          </div>
          <div class="form-group col-md-3">
            <label for="aquisition_date">Dt. Aquisição</label>
            <input-date id="aquisition_date"/>
          </div>
          <div class="form-group col-md-6">
            <label for="title">Título</label>
            <select id="title" class="form-control">
              <option selected>Selecione...</option>
              <option>Filme 1</option>
              <option>Filme 2</option>
              <option>Filme 3</option>
            </select>
          </div>
          <div class="form-group col-md-6">
            <label for="type">Tipo</label>
            <select id="type" class="form-control">
              <option selected>Selecione...</option>
              <option>Fita</option>
              <option>DVD</option>
              <option>BlueRay</option>
            </select>
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  import InputDate from '@/components/Form/InputDate'
  export default {
    name: 'ItemCreate',
    components: { InputDate }
  }
</script>
