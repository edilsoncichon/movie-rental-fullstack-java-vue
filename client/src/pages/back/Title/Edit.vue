<script>
  import { get as getTitle, remove, update } from '@/apis/Title'
  import { getAll as getCategories } from '@/apis/TitleCategory'
  import { getAll as getDirectors } from '@/apis/Director'
  import { getAll as getClasses } from '@/apis/Classe'
  import { getAll as getActors } from '@/apis/Actor'

  export default {
    name: 'TitleEdit',

    data () {
      return {
        item: {
          name: '',
          year: 2018,
          urlCapa: null,
          urlTrailer: null,
          sinopse: '',
          category_id: null,
          classe_id: null,
          director_id: null,
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
        updateAllowed: false
      }
    },

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
        this.item.year = String(this.item.year)
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
      getTitle(this.$route.params.id)
        .then(data => {
          this.item = data
          this.item.category_id = data.category._id
          this.item.classe_id = data.classe._id
          this.item.director_id = data.director._id
          this.extractIdsActors()
        })
    }
  }
</script>

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
            <select v-model="item.category_id" id="category" class="form-control" :disabled="!updateAllowed">
              <option>Selecione...</option>
              <option v-for="category in collections.categories" :value="category._id">{{ category.name }}</option>
            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="class">Classe</label>
            <select v-model="item.classe_id" id="class" class="form-control" :disabled="!updateAllowed">
              <option>Selecione...</option>
              <option v-for="classe in collections.classes" :value="classe._id">{{ classe.name }}</option>
            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="director">Diretor</label>
            <select v-model="item.director_id" id="director" class="form-control" :disabled="!updateAllowed">
              <option>Selecione...</option>
              <option v-for="director in collections.directors" :value="director._id">
                {{ director.name }}
              </option>
            </select>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="category">URL capa</label>
            <input type="text" v-model="item.urlCapa" id="url_capa" class="form-control" :disabled="!updateAllowed" />
          </div>
          <div class="form-group col-md-6">
            <label for="class">Código do Trailer (Youtube)</label>
            <input type="text" v-model="item.urlTrailer" id="url_trailer" class="form-control" :disabled="!updateAllowed" />
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
