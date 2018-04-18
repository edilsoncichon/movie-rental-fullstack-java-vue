<template>
  <div data-component="customer-create">
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
            <select class="form-control" id="sex" name="sex">
              <option value="">Selecione...</option>
              <option value="M">Masculino</option>
              <option value="F">Feminino</option>
              <option value="O">Outro</option>
            </select>
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
            <input type="text" name="address[cep]" ref="cepInput" v-model="cep" @change="searchCep" class="form-control" id="cep" placeholder="00.000-000">
          </div>
          <div class="form-group col-md-8">
            <label for="address">Endereço</label>
            <input type="text" name="address[street]" v-model="street" class="form-control" id="address" placeholder="Endereço">
          </div>
          <div class="form-group col-md-2">
            <label for="number">Numero</label>
            <input type="text" name="address[number]" ref="numberInput" v-model="number" class="form-control" id="number" placeholder="Numero">
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-5">
            <label for="district">Bairro</label>
            <input type="text" name="address[district]" v-model="district" class="form-control" id="district" placeholder="Bairro">
          </div>
          <div class="form-group col-md-5">
            <label for="city">Cidade</label>
            <input type="text" name="address[city]" v-model="city" class="form-control" id="city" placeholder="Cidade">
          </div>
          <div class="form-group col-md-2">
            <label for="inputState">UF</label>
            <select id="inputState" name="address[uf]" v-model="uf" class="form-control">
              <option selected>Selecione...</option>
              <option v-for="uf in ufList" :value="uf">{{ uf }}</option>
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
  import { get as getCep } from '../../../apis/ViaCep'
  import InputDate from '@/components/Form/InputDate'
  export default {
    name: 'CustomerCreate',
    components: { InputDate },
    methods: {
      searchCep () {
        if (this.cep.length < 8) {
          this.street = 'CEP inválido'
          return
        }
        this.street = 'Buscando...'
        getCep(this.cep)
          .then((data) => {
            this.cep = data.cep
            this.street = data.logradouro
            this.number = data.numero
            this.district = data.bairro
            this.city = data.localidade
            this.country = data.pais
            this.uf = data.uf
            this.$refs.numberInput.focus()
          })
          .catch(() => {
            this.street = 'CEP não encontrado'
          })
      }
    },
    data () {
      return {
        cep: '',
        street: '',
        number: '',
        district: '',
        city: '',
        country: '',
        uf: '',
        ufList: [
          'AC', 'AM', 'RR', 'AP', 'RO', 'MT', 'PA',
          'TO', 'MA', 'MS', 'GO', 'DF', 'PI', 'CE',
          'BA', 'MG', 'SP', 'PR', 'SC', 'RS', 'RN',
          'PB', 'PE', 'AL', 'SE', 'ES', 'RJ'
        ]
      }
    }
  }
</script>
