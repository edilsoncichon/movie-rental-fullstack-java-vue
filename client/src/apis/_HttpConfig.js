import axios from 'axios'

const client = axios.create({
  baseURL: 'http://localhost:8080/api',
  timeout: '3000',
  headers: {
    'Cache-Control': 'no-cache'
  }
})

const handleResponseSuccess = function (response) {
  return response
}
const handleResponseError = function (err) {
  if (err.response && err.response.status === 403) {
    window.location.replace('/login')
  }
  return Promise.reject(err)
}

client.interceptors.response.use(handleResponseSuccess, handleResponseError)

export default client
