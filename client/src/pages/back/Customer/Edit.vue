<script>
  import InputDate from '@/components/Form/InputDate'
  import { get, remove, update } from '@/apis/CustomerPartner'
  import {
    create as createDependent,
    remove as removeDependent,
    getAllByPartnerId as getByPartnerId
  } from '@/apis/CustomerDependent'
  import Alert from '@/components/Alert'

  export default {
    name: 'CustomerEdit',

    components: { InputDate, Alert },

    methods: {
      handleRemove () {
        let confirmation = confirm('Tem certeza que deseja deletar este Cliente?')
        if (!confirmation) return
        remove(this.$route.params.id)
          .then(() => {
            this.handleSuccess('Deletado com sucesso!')
          })
          .catch(error => {
            this.handleError(error)
          })
      },
      handleUpdate () {
        update(this.$route.params.id, this.item)
          .then(() => {
            this.handleSuccess('Editado com sucesso!')
          })
          .catch(error => {
            this.handleError(error)
          })
      },
      handleNewDependent () {
        this.newDependent.partnerId = this.item._id
        createDependent(this.newDependent)
          .then(() => {
            this.handleSuccessDep('Cadastrado com sucesso!')
            this.loadDependents(this.item._id)
          })
          .catch(error => {
            this.handleErrorDep(error)
          })
      },
      loadDependents (partnerId) {
        getByPartnerId(partnerId)
          .then(data => {
            this.dependents = data
          })
          .then(() => {
            this.$icons.replace()
          })
      },
      handleRemoveDependent (dependent) {
        let confirmation = confirm(`Tem certeza que deseja deletar o dependente "${dependent.name}" ?`)
        if (!confirmation) return
        removeDependent(dependent._id)
          .then(() => {
            this.handleSuccessDep('Deletado com sucesso!')
            this.loadDependents(this.item._id)
          })
          .catch(error => {
            this.handleErrorDep(error)
          })
      },
      handleSuccess (message) {
        this.messages.default.value = message
        this.messages.default.type = 'success'
      },
      handleError (error) {
        this.messages.default.value = 'Ocorreu um erro ao processar a operação: ' + error.response.data.message
        this.messages.default.type = 'error'
      },
      handleSuccessDep (message) {
        this.messages.dependent.value = message
        this.messages.dependent.type = 'success'
      },
      handleErrorDep (error) {
        this.messages.dependent.value = 'Ocorreu um erro ao processar a operação: ' + error.response.data.message
        this.messages.dependent.type = 'error'
      },
      openModalDependents () {
        let condition = !this.modalDependents.show
        let vm = this
        this.modalDependents.displayBlock = condition
        setTimeout(function () { // efeito de fade-in/fade-out
          vm.modalDependents.show = condition
        }, 100)
      }
    },

    computed: {
      hasMessage () {
        return !!this.messages.default.value
      },
      hasMessageDependent () {
        return !!this.messages.dependent.value
      }
    },

    mounted () {
      get(this.$route.params.id)
        .then(data => {
          this.item = data
          this.item.address = JSON.parse(this.item.address)
          this.loadDependents(this.item._id)
        })
    },

    data () {
      return {
        item: {
          name: '',
          phone: '',
          sex: '',
          cpf: '',
          birthDate: '1992-10-10',
          address: {
            cep: '',
            street: '',
            number: '',
            district: '',
            city: '',
            country: '',
            uf: ''
          },
          email: 'edilson@cichon.com',
          password: '123456',
          dependents: []
        },
        newDependent: {
          _id: null,
          name: '',
          sex: '',
          birthDate: new Date(),
          partnerId: null
        },
        dependents: [],
        collections: {
          ufs: [
            'AC', 'AM', 'RR', 'AP', 'RO', 'MT', 'PA',
            'TO', 'MA', 'MS', 'GO', 'DF', 'PI', 'CE',
            'BA', 'MG', 'SP', 'PR', 'SC', 'RS', 'RN',
            'PB', 'PE', 'AL', 'SE', 'ES', 'RJ'
          ]
        },
        messages: {
          default: {
            value: '',
            type: ''
          },
          dependent: {
            value: '',
            type: ''
          }
        },
        updateAllowed: false,
        modalDependents: {
          displayBlock: false,
          show: false
        }
      }
    }
  }
</script>

<template>
  <div data-component="customer-edit">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Cliente <small class="operation">alterar</small></h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <button @click="openModalDependents" class="btn btn-sm btn-outline-secondary mr-2">
          <span data-feather="plus-circle"></span>
          Dependente
        </button>
        <button @click="editOperation = !editOperation" class="btn btn-sm btn-outline-secondary mr-2">
          <span data-feather="edit-3"></span>
          Editar
        </button>
        <button @click="handleRemove" class="btn btn-sm btn-outline-secondary mr-2">
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
      <alert :type="messages.default.type" :message="messages.default.value" v-if="hasMessage"/>
      <form @submit.prevent="handleUpdate">
        <div class="form-row">
          <div class="form-group col-md-9">
            <label for="name">Nome</label>
            <input v-model="item.name" type="text" class="form-control" placeholder="Nome" id="name">
          </div>
          <div class="form-group col-md-3">
            <label for="phone">Telefone</label>
            <input v-model="item.phone" type="text" class="form-control" placeholder="Telefone" id="phone">
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="sex">Sexo</label>
            <select v-model="item.sex" class="form-control" id="sex">
              <option value="">Selecione...</option>
              <option value="M">Masculino</option>
              <option value="F">Feminino</option>
              <option value="O">Outro</option>
            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="cpf">CPF</label>
            <input v-model="item.cpf" type="text" class="form-control" placeholder="000.000.000-00" id="cpf">
          </div>
          <div class="form-group col-md-4">
            <label for="birth_date">Dt. Nascimento</label>
            <input type="date" v-model="item.birthDate" class="form-control" id="birth_date" />
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-2">
            <label for="cep">CEP</label>
            <input v-model="item.address.cep" type="text" class="form-control" id="cep" placeholder="00.000-000"/>
          </div>
          <div class="form-group col-md-8">
            <label for="address">Endereço</label>
            <input type="text" v-model="item.address.street" class="form-control" id="address" placeholder="Endereço">
          </div>
          <div class="form-group col-md-2">
            <label for="number">Numero</label>
            <input type="text" v-model="item.address.number" class="form-control" id="number" placeholder="Numero">
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="city">Cidade</label>
            <input type="text" v-model="item.address.city" class="form-control" id="city" placeholder="Cidade">
          </div>
          <div class="form-group col-md-6">
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
            <input v-model="item.email" type="email" class="form-control" id="email" placeholder="Email">
          </div>
          <div class="form-group col-md-6">
            <label for="password">Senha</label>
            <input v-model="item.password" type="password" class="form-control" id="password" placeholder="Senha">
          </div>
        </div>
        <div class="text-right mt-5 mb-5">
          <button type="submit" class="btn btn-primary">Salvar</button>
        </div>
      </form>
    </div>
    <div :class="modalDependents.show ? 'show' : ''" class="modal fade" tabindex="-1" role="dialog" :style="modalDependents.displayBlock ? 'display: block;' : 'display: none;'" style="padding-right: 15px;">
      <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalCenterTitle">Dependentes</h5>
            <button @click="openModalDependents" type="button" class="close" aria-label="Close">
              <span aria-hidden="true" title="Fechar">×</span>
            </button>
          </div>
          <div class="modal-body">
            <alert :type="messages.dependent.type" :message="messages.dependent.value" v-if="hasMessageDependent"/>
            <div class="card" id="dependentes_card">
              <div class="card-body">
                <form v-on:submit.prevent="handleNewDependent">
                  <div class="form-row">
                    <div class="form-group col-md-5">
                      <label for="dependent_name">Nome</label>
                      <input type="text" v-model="newDependent.name" id="dependent_name" class="form-control" placeholder="Nome"/>
                    </div>
                    <div class="form-group col-md-3">
                      <label for="dependent_sex">Sexo</label>
                      <select v-model="newDependent.sex" id="dependent_sex" class="form-control">
                        <option value="">Sexo...</option>
                        <option value="M">Masculino</option>
                        <option value="F">Feminino</option>
                      </select>
                    </div>
                    <div class="form-group col-md-3">
                      <label for="dependent_birth_dt">Dt. Nascimento</label>
                      <input-date :default="newDependent.birthDate" id="dependent_birth_dt"/>
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
                    <th></th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr v-for="dependent in dependents">
                    <th scope="row">{{ dependent._id }}</th>
                    <td>{{ dependent.name }}</td>
                    <td>{{ dependent.sex === 'M' ? 'Menino' : 'Menina'  }}</td>
                    <td>{{ dependent.birthDate }}</td>
                    <td>
                      <div class="btn-link active" @click="handleRemoveDependent(dependent)" title="Excluir">
                        <i data-feather="trash"></i>
                      </div>
                    </td>
                  </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
