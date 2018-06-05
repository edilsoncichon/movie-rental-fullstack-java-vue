import axios from 'axios'

const client = axios.create({
  baseURL: 'http://localhost:8080/api',
  timeout: 3000,
  headers: {
    'Cache-Control': 'no-cache'
  }
})

let sessionToken = window.localStorage.getItem('X-Session-Token')

client.defaults.headers['X-Session-Token'] = sessionToken

// const handleResponseSuccess = function (response) {
//   return response
// }
// const handleResponseError = function (err) {
//   let sessionToken = window.localStorage.key('X-Session-Token')
//   if (err.response && err.response.status === 403 && sessionToken === null) {
//     window.location.replace('/login')
//   }
//   return Promise.reject(err)
// }
//
// client.interceptors.response.use(handleResponseSuccess, handleResponseError)

export default client
