let instaled = false

const install = Vue => {
  if (instaled) {
    return
  }
  const EventBus = new Vue()
  Object.defineProperties(Vue.prototype, {
    $bus: {
      get: function () {
        return EventBus
      }
    }
  })
  instaled = true
}

export default { install }
