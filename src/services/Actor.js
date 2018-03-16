import http from './Http'

export const getAll = () => http.get('/actors').then(response => response.data)
