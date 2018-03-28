import http from './Http'

export const getAll = () => http.get('/actors').then(response => response.data.data)
export const get = (id) => http.get(`/actors?id=${id}`).then(response => response.data.data)
export const create = () => http.post('/actors').then(response => response.data.data)
export const update = () => http.put('/actors').then(response => response.data.data)
export const remove = () => http.delete('/actors').then(response => response.data.data)
