import icons from 'feather-icons'

let instaled = false

const install = Vue => {
  if (instaled) {
    return
  }
  Object.defineProperties(Vue.prototype, {
    $icons: {
      get: function () {
        return icons
      }
    }
  })
  instaled = true
}

export default { install }
