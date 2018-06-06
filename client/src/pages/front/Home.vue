<script>
  import { getAll } from '@/apis/Title'

  export default {
    name: 'Home',

    data () {
      return {
        titles: [],

        modalTrailer: {
          display: 'none',
          isVisible: false,
          url: null
        }
      }
    },

    methods: {
      openModalTrailer (title) {
        let vm = this
        this.modalTrailer.url = title.urlTrailer
        this.modalTrailer.display = 'block'
        setTimeout(function () { // efeito de fade-in/fade-out
          vm.modalTrailer.isVisible = true
        }, 100)
      },
      closeModalTrailer () {
        this.modalTrailer.url = ''
        this.modalTrailer.display = 'none'
        this.modalTrailer.isVisible = false
      }
    },

    mounted () {
      getAll()
        .then(res => {
          this.titles = res
        })
    },

    updated () {
      this.$icons.replace()
    }
  }
</script>

<template>
  <div class="container">
    <div class="row">
      <div v-for="title in titles" class="col-sm-6 col-md-4 col-lg-3">
        <div class="card mb-4 box-shadow">
          <img class="card-img-top" :src="title.urlCapa" :alt="`Capa do Título ${title.name}`" :title="title.name"/>
          <div class="card-body pb-2">
            <h4 class="card-subtitle">
              {{ title.name }}
            </h4>
            <p class="card-text sinopse">
              {{ title.sinopse }}
            </p>
            <div class="card-text actions">
              <div class="flex-row text-center">
                <router-link :to="{name: 'front.titles.show', params: {id: title._id}}" class="btn btn-sm btn-outline-secondary">
                  <i data-feather="external-link"></i>
                  Ver mais...
                </router-link>
                <button @click="openModalTrailer(title)" class="btn btn-sm btn-outline-secondary">
                  <i data-feather="film"></i>
                  Ver Trailer
                </button>
              </div>
            </div>
            <div class="card-text information">
              <div class="flex-row text-right mt-1 mb-0">
                <small class="text-muted">Categoria: {{ title.category.name }}</small>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--MODAL TRAILER-->
    <div :class="{show: modalTrailer.isVisible}" class="modal fade" tabindex="-1" role="dialog" :style="{display: modalTrailer.display}">
      <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
          <button @click="closeModalTrailer" type="button" class="btn-close" aria-label="Close">
            <span aria-hidden="true" title="Fechar">×</span>
          </button>
          <div class="modal-body p-0">
            <div class="card" id="trailer_card">
              <iframe
                width="100%" height="600px"
                :src='`https://www.youtube-nocookie.com/embed/${modalTrailer.url}?rel=0&amp;showinfo=0"`'
                frameborder="0"
                allow="autoplay; encrypted-media"
                allowfullscreen>
              </iframe>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
  .sinopse {
    height: 60px;
    overflow: auto;
  }
  .modal {
    padding-right: 15px;
    background-color: rgba(0,0,0,0.4);
    .btn-close {
      position: absolute;
      right: -10px;
      top: -10px;
      z-index: 999;
      background: white;
      border-radius: 50px;
      border-color: transparent;
      color: black;
      zoom: 2;
      :hover {
        color: red;
        font-weight: bold;
      }
    }
  }
</style>
