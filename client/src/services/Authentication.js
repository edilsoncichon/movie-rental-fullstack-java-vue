'use strict'

function AuthenticationService () {
  return {
    handleLogin: function handleLogin (data) {
      return (data.username === 'ecichon' && data.password === '123456')
    },
    handleLogout: function handleLogout (data) {
      console.error('//TODO Implements logout')
    }
  }
}

export default AuthenticationService()
