<template>
  <div data-component="customer">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Cliente <small class="operation">Alterar</small></h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <a href="#dependent_name" class="btn btn-sm btn-outline-secondary mr-2">
          <span data-feather="plus-circle"></span>
          Dependente
        </a>
        <button @click="editOperation = !editOperation" class="btn btn-sm btn-outline-secondary mr-2">
          <span data-feather="edit-3"></span>
          Editar
        </button>
        <button @click="handleDestroy" class="btn btn-sm btn-outline-secondary mr-2">
          <i data-feather="trash-2"></i>
          Excluir
        </button>
        <button class="btn btn-sm btn-outline-secondary">
          <i data-feather="user-minus"></i>
          Inativar
        </button>
      </div>
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
        <div class="card">
          <div class="card-header">
            Dependentes
          </div>
          <div class="card-body">
            <form name="add_dependent">
              <div class="form-row">
                <div class="form-group col-md-5">
                  <label for="dependent_name">Nome</label>
                  <input type="text" name="dependent[name]" id="dependent_name" class="form-control" placeholder="Nome">
                </div>
                <div class="form-group col-md-3">
                  <label for="dependent_sex">Sexo</label>
                  <select name="dependent[sex]" id="dependent_sex" class="form-control">
                    <option value="">Sexo...</option>
                    <option value="M">Masculino</option>
                    <option value="F">Feminino</option>
                  </select>
                </div>
                <div class="form-group col-md-3">
                  <label for="dependent_birth_dt">Dt. Nascimento</label>
                  <input-date id="dependent_birth_dt"/>
                </div>
                <div class="form-group col-1">
                  <label>&nbsp;</label>
                  <button type="submit" class="btn btn-primary form-control">
                    <span data-feather="plus"></span>
                  </button>
                </div>
              </div>
            </form>
            <table class="table">
              <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">Sexo</th>
                <th scope="col">Dt. Nascimento</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <th scope="row">199</th>
                <td>Mark</td>
                <td>Masculino</td>
                <td>10/out/1992</td>
              </tr>
              <tr>
                <th scope="row">355</th>
                <td>Jasmine</td>
                <td>Feminino</td>
                <td>10/out/1980</td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>

        <div class="text-right mt-5 mb-5">
          <button type="submit" class="btn btn-primary">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  import InputDate from '@/components/Form/InputDate'
  export default {
    name: 'CustomerEdit',
    components: { InputDate },
    methods: {
      handleDestroy () {
        let confirmation = confirm('Tem certeza que deseja excluir este Cliente?')
        if (confirmation) {
          alert('Cliente excluído com sucesso!')
        }
      }
    }
  }
</script>
