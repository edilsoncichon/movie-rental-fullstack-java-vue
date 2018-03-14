<template>
  <div data-component="customer">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Cliente <small class="operation">novo</small></h1>
    </div>
    <div>
      <form>
        <div class="form-row">
          <div class="form-group col-md-9">
            <label for="name">Nome</label>
            <input type="text" class="form-control" placeholder="Nome" id="name">
          </div>
          <div class="form-group col-md-3">
            <label for="phone">Telefone</label>
            <input type="text" class="form-control" placeholder="Telefone" id="phone">
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="sex">Sexo</label>
            <input type="text" class="form-control" placeholder="Sexo" id="sex">
          </div>
          <div class="form-group col-md-4">
            <label for="cpf">CPF</label>
            <input type="text" class="form-control" placeholder="000.000.000-00" id="cpf">
          </div>
          <div class="form-group col-md-4">
            <label for="birth_date">Dt. Nascimento</label>
            <input-date id="birth_date" />
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-2">
            <label for="cep">CEP</label>
            <input type="text" name="address[cep]" class="form-control" id="cep" placeholder="00.000-000">
          </div>
          <div class="form-group col-md-8">
            <label for="address">Endereço</label>
            <input type="text" name="address[street]" class="form-control" id="address" placeholder="Endereço">
          </div>
          <div class="form-group col-md-2">
            <label for="number">Numero</label>
            <input type="text" name="address[number]" class="form-control" id="number" placeholder="Numero">
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="city">Cidade</label>
            <input type="text" name="address[city]" class="form-control" id="city" placeholder="Cidade">
          </div>
          <div class="form-group col-md-6">
            <label for="inputState">UF</label>
            <select id="inputState" name="address[uf]" class="form-control">
              <option selected>Selecione...</option>
              <option>AC</option>
              <option>ES</option>
              <option>TO</option>
              <option>RJ</option>
              <option>SP</option>
            </select>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" placeholder="Email">
          </div>
          <div class="form-group col-md-6">
            <label for="password">Senha</label>
            <input type="password" class="form-control" id="password" placeholder="Senha">
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
    name: 'CustomerCreate',
    components: { InputDate }
  }
</script>
