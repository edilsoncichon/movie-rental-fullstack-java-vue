<template>
  <div data-component="title-create">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Título <small class="operation">novo</small></h1>
    </div>
    <div>
      <alert :type="messageType" :message="message" v-if="hasMessage"/>
      <form v-on:submit.prevent="handleCreate">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="name">Nome</label>
            <input type="text" class="form-control" id="name" placeholder="Nome" v-model="item.name">
          </div>
          <div class="form-group col-md-6">
            <label for="year">Ano</label>
            <input type="number" class="form-control" id="year" placeholder="Ano" value="2018" v-model="item.year">
          </div>
        </div>
        <div class="form-group">
          <label for="sinopse">Sinópse</label>
          <textarea class="form-control" id="sinopse" placeholder="Sinópse e detalhes..." rows="2" v-model="item.sinopse"></textarea>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="category">Categoria</label>
            <select v-model="item.category_id" id="category" class="form-control">
              <option selected>Selecione...</option>
              <option v-for="category in collections.categories" :value="category._id">{{ category.name }}</option>
            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="class">Classe</label>
            <select v-model="item.classe_id" id="class" class="form-control">
              <option selected>Selecione...</option>
              <option v-for="classe in collections.classes" :value="classe._id">{{ classe.name }}</option>
            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="director">Diretor</label>
            <select v-model="item.director_id" id="director" class="form-control">
              <option selected>Selecione...</option>
              <option v-for="director in collections.directors" :value="director._id">{{ director.name }}</option>
            </select>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="actors">Atores</label>
            <select v-model="item.actors" id="actors" class="form-control custom-select" multiple required>
              <option v-for="actor in collections.actors" :value="actor._id">{{ actor.name }}</option>
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
  import { getAll as getCategories } from '@/apis/TitleCategory'
  import { getAll as getDirectors } from '@/apis/Director'
  import { getAll as getClasses } from '@/apis/Classe'
  import { getAll as getActors } from '@/apis/Actor'
  import { create } from '@/apis/Title'
  import Alert from '@/components/Alert'

  export default {
    name: 'TitleCreate',
    components: { Alert },
    data () {
      return {
        item: {
          name: '',
          year: 2018,
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
        messageType: 'success'
      }
    },
    methods: {
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
    }
  }
</script>
