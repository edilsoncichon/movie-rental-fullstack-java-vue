/* The Vue build version to load with the `import` command
   (runtime-only or standalone) has been set in webpack.base.conf with an alias. */
import Vue from 'vue'
import App from './layouts/App'
import router from './router'
import featherIcons from 'feather-icons'

Vue.config.productionTip = false

const EventBus = new Vue()
Object.defineProperties(Vue.prototype, {
  $bus: {
    get: function () {
      return EventBus
    }
  },
  $featherIcons: {
    get: function () {
      return featherIcons
    }
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
