import axios from 'axios'

const client = axios.create({
  baseURL: 'localhost:8080/api',
  timeout: '1000',
  headers: {
    // 'X-Custom-Header': 'teste'
  }
})

export default client
