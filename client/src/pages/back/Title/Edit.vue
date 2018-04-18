<template>
  <div data-component="title-edit">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Título <small class="operation">alterar</small></h1>
      <div class="btn-toolbar mb-2 mb-md-0">
        <button @click="updateAllowed = !updateAllowed" class="btn btn-sm btn-outline-secondary mr-2">
          <span data-feather="edit-3"></span>
          Editar
        </button>
        <button @click="handleRemove" class="btn btn-sm btn-outline-secondary mr-2">
          <i data-feather="trash-2"></i>
          Excluir
        </button>
      </div>
    </div>
    <div>
      <alert :type="messageType" :message="message" v-if="hasMessage"/>
      <form v-on:submit.prevent="handleUpdate">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="name">Nome</label>
            <input type="text" class="form-control" id="name" placeholder="Nome" v-model="item.name" :disabled="!updateAllowed">
          </div>
          <div class="form-group col-md-6">
            <label for="year">Ano</label>
            <input type="number" class="form-control" id="year" placeholder="Ano" value="2018" v-model="item.year" :disabled="!updateAllowed">
          </div>
        </div>
        <div class="form-group">
          <label for="sinopse">Sinópse</label>
          <textarea class="form-control" id="sinopse" placeholder="Sinópse e detalhes..." rows="2" v-model="item.sinopse" :disabled="!updateAllowed"></textarea>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="category">Categoria</label>
            <select v-model="item.category._id" id="category" class="form-control" :disabled="!updateAllowed">
              <option>Selecione...</option>
              <option v-for="category in collections.categories" :value="category._id">{{ category.name }}</option>
            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="class">Classe</label>
            <select v-model="item.classe._id" id="class" class="form-control" :disabled="!updateAllowed">
              <option>Selecione...</option>
              <option v-for="classe in collections.classes" :value="classe._id">{{ classe.name }}</option>
            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="director">Diretor</label>
            <select v-model="item.director._id" id="director" class="form-control" :disabled="!updateAllowed">
              <option>Selecione...</option>
              <option v-for="director in collections.directors" :value="director._id">
                {{ director.name }}
              </option>
            </select>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="actors">Atores</label>
            <select v-model="item.actors" id="actors" class="form-control custom-select" multiple required :disabled="!updateAllowed">
              <option v-for="actor in collections.actors" :value="actor._id">{{ actor.name }}</option>
            </select>
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary" :disabled="!updateAllowed">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  import { get as getItem, remove, update } from '@/apis/Title'
  import { getAll as getCategories } from '@/apis/TitleCategory'
  import { getAll as getDirectors } from '@/apis/Director'
  import { getAll as getClasses } from '@/apis/Classe'
  import { getAll as getActors } from '@/apis/Actor'
  import Alert from '@/components/Alert'

  export default {
    name: 'TitleEdit',
    data () {
      return {
        ids: [49, 51],
        item: {
          name: '',
          year: 2018,
          sinopse: '',
          category: {_id: null},
          classe: {_id: null},
          director: {_id: null},
          actors: []
        },
        collections: {
          categories: [],
          classes: [],
          directors: [],
          actors: []
        },
        message: '',
        messageType: '',
        updateAllowed: true
      }
    },
    components: { Alert },
    methods: {
      handleRemove () {
        let confirmation = confirm('Tem certeza que deseja deletar?')
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
      handleSuccess (message) {
        this.message = message
        this.messageType = 'success'
      },
      handleError (error) {
        this.message = 'Ocorreu um erro ao processar a operação: ' + error.response.data.message
        this.messageType = 'error'
      },
      extractIdsActors () {
        this.item.actors =
          this.item.actors.map(function (item) {
            return item._id
          })
      }
    },
    computed: {
      hasMessage () {
        return !!this.message
      }
    },
    mounted () {
      getCategories()
        .then(data => {
          this.collections.categories = data
        })
      getActors()
        .then(data => {
          this.collections.actors = data
        })
      getClasses()
        .then(data => {
          this.collections.classes = data
        })
      getDirectors()
        .then(data => {
          this.collections.directors = data
        })
      getItem(this.$route.params.id)
        .then(data => {
          this.item = data
          this.extractIdsActors()
        })
    }
  }
</script>
