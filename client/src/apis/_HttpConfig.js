import axios from 'axios'

const client = axios.create({
  baseURL: 'http://localhost:8080/api',
  timeout: '3000',
  headers: {
    // 'X-Custom-Header': 'true'
  }
})

export default client
