import axios from 'axios'

const client = axios.create({
  baseURL: 'http://localhost:8080/api',
  timeout: 3000,
  headers: {
    'Cache-Control': 'no-cache'
  }
})

/**
 * Recupera o token do LocalStorage.
 */
let sessionToken = window.localStorage.getItem('X-Session-Token')
client.defaults.headers['X-Session-Token'] = sessionToken

export default client
