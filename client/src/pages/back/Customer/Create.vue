<script>
  import { get as getCep } from '@/apis/ViaCep'
  import { create } from '@/apis/CustomerPartner'

  export default {
    name: 'CustomerCreate',

    methods: {
      searchCep () {
        if (this.item.address.cep.length < 8) {
          this.item.address.street = 'CEP inválido'
          return
        }
        this.item.address.street = 'Buscando...'
        getCep(this.item.address.cep)
          .then((data) => {
            this.item.address.cep = data.cep
            this.item.address.street = data.logradouro
            this.item.address.number = data.numero
            this.item.address.district = data.bairro
            this.item.address.city = data.localidade
            this.item.address.country = data.pais
            this.item.address.uf = data.uf
            this.$refs.numberInput.focus()
          })
          .catch(() => {
            this.item.address.street = 'CEP não encontrado'
          })
      },
      handleCreate () {
        create(this.item)
          .then(() => {
            this.handleSuccess('Cadastrado com sucesso!')
          })
          .catch(error => {
            this.handleError(error)
          })
      },
      handleSuccess (message) {
        this.message = message
        this.messageType = 'success'
      },
      handleError (error) {
        this.message = error.response.data.message
        this.messageType = 'error'
      }
    },

    computed: {
      hasMessage () {
        return !!this.message
      }
    },

    data () {
      return {
        item: {
          name: '',
          phone: '',
          sex: '',
          cpf: '',
          birthDate: new Date('10-10-1992'),
          address: {
            cep: '',
            street: '',
            number: '',
            district: '',
            city: '',
            country: '',
            uf: ''
          },
          email: '',
          password: ''
        },
        collections: {
          ufs: [
            'AC', 'AM', 'RR', 'AP', 'RO', 'MT', 'PA',
            'TO', 'MA', 'MS', 'GO', 'DF', 'PI', 'CE',
            'BA', 'MG', 'SP', 'PR', 'SC', 'RS', 'RN',
            'PB', 'PE', 'AL', 'SE', 'ES', 'RJ'
          ]
        },
        message: '',
        messageType: ''
      }
    }
  }
</script>

<template>
  <div data-component="customer-create">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Cliente <small class="operation">novo</small></h1>
    </div>
    <div>
      <alert :message="message" :type="messageType" v-if="hasMessage" />
      <form v-on:submit.prevent="handleCreate">
        <div class="form-row">
          <div class="form-group col-md-9">
            <label for="name">Nome</label>
            <input type="text" class="form-control" v-model="item.name" placeholder="Nome" id="name">
          </div>
          <div class="form-group col-md-3">
            <label for="phone">Telefone</label>
            <input type="text" class="form-control" v-model="item.phone" placeholder="Telefone" id="phone">
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="sex">Sexo</label>
            <select class="form-control" id="sex" name="sex" v-model="item.sex">
              <option value="">Selecione...</option>
              <option value="M">Masculino</option>
              <option value="F">Feminino</option>
              <option value="O">Outro</option>
            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="cpf">CPF</label>
            <input type="text" class="form-control" v-model="item.cpf" placeholder="000.000.000-00" id="cpf">
          </div>
          <div class="form-group col-md-4">
            <label for="birth_date">Dt. Nascimento</label>
            <input-date id="birth_date" :default="item.birthDate"/>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-2">
            <label for="cep">CEP</label>
            <input type="text" name="address[cep]" ref="cepInput" v-model="item.address.cep" @change="searchCep" class="form-control" id="cep" placeholder="00.000-000">
          </div>
          <div class="form-group col-md-8">
            <label for="address">Endereço</label>
            <input type="text" name="address[street]" v-model="item.address.street" class="form-control" id="address" placeholder="Endereço">
          </div>
          <div class="form-group col-md-2">
            <label for="number">Numero</label>
            <input type="text" name="address[number]" ref="numberInput" v-model="item.address.number" class="form-control" id="number" placeholder="Numero">
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-5">
            <label for="district">Bairro</label>
            <input type="text" name="address[district]" v-model="item.address.district" class="form-control" id="district" placeholder="Bairro">
          </div>
          <div class="form-group col-md-5">
            <label for="city">Cidade</label>
            <input type="text" name="address[city]" v-model="item.address.city" class="form-control" id="city" placeholder="Cidade">
          </div>
          <div class="form-group col-md-2">
            <label for="inputState">UF</label>
            <select id="inputState" name="address[uf]" v-model="item.address.uf" class="form-control">
              <option selected>Selecione...</option>
              <option v-for="uf in collections.ufs" :value="uf">{{ uf }}</option>
            </select>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="email">Email</label>
            <input type="email" class="form-control" v-model="item.email" id="email" placeholder="Email">
          </div>
          <div class="form-group col-md-6">
            <label for="password">Senha</label>
            <input type="password" class="form-control" v-model="item.password" id="password" placeholder="Senha">
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>
