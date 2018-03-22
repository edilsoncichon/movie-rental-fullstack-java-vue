<template>
  <!--TODO Reutilizar a view do back!-->
  <div data-component="title-show">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Título <small class="operation">Poeira em alto Mar - 2010</small></h1>
      <figure class="figure">
        <img src="@/assets/img/movie-1.jpg" alt="Image of title." class="figure-img img-fluid rounded">
      </figure>
    </div>
    <div>
      <form>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="name">Nome</label>
            <input type="text" class="form-control" id="name" placeholder="Poeira em alto mar" disabled>
          </div>
          <div class="form-group col-md-6">
            <label for="year">Ano</label>
            <input type="number" class="form-control" id="year" placeholder="Ano" value="2010" disabled>
          </div>
        </div>
        <div class="form-group">
          <label for="sinopse">Sinópse</label>
          <textarea class="form-control" id="sinopse" placeholder="Sinópse e detalhes..." rows="2" disabled></textarea>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="category">Categoria</label>
            <select id="category" class="form-control" disabled>
              <option selected>Selecione...</option>
              <option selected>Ação</option>
              <option>Aventura</option>
              <option>Romance</option>
              <option>Suspense</option>
              <option>Ficção</option>
            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="class">Classe</label>
            <select id="class" class="form-control" disabled>
              <option>Selecione...</option>
              <option selected>Lançamento</option>
              <option>Antigo</option>
            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="director">Diretor</label>
            <select id="director" class="form-control" disabled>
              <option>Selecione...</option>
              <option selected>Diretor 1</option>
              <option>Diretor 2</option>
              <option>Diretor 3</option>
            </select>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="actors">Atores</label>
            <select id="actors" class="form-control custom-select" multiple required disabled>
              <option>Angelina Jolie</option>
              <option>Robin Udi</option>
              <option>Jontravolta Robert</option>
              <option>Leonardo di Caprio</option>
              <option>Atriz de Holiwood</option>
              <option>Ator Canadense</option>
              <option>Anderson Silva</option>
              <option>Juliana Paz</option>
            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="value">Valor</label>
            <input type="text" class="form-control" id="value" placeholder="R$ 0,00" disabled>
          </div>
          <div class="form-group col-md-4">
            <label for="qtd_available">Qtd Disponível</label>
            <input type="number" class="form-control" id="qtd_available" placeholder="0 unidades" disabled value="5">
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary" disabled>Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'TitleShow'
  }
</script>
