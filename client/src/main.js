/* The Vue build version to load with the `import` command
   (runtime-only or standalone) has been set in webpack.base.conf with an alias. */
import Vue from 'vue'
import App from './layouts/App'
import router from './router'
import IconsPlugin from './plugins/Icons'
import EventBusPlugin from './plugins/EventBus'
import './_global'
Vue.use(IconsPlugin)
Vue.use(EventBusPlugin)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
