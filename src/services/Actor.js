'use strict'

function Actor () {
  return {
    show: function (data) {
      console.warn('//SHOW Actor')
    },
    create: function (data) {
      console.warn('//CREATE Actor')
    },
    update: function (data) {
      console.warn('//UPDATE Actor')
    },
    edit: function (data) {
      console.warn('//EDIT Actor')
    }
  }
}

export default Actor
