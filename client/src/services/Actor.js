import http from './Http'

export const getAll = () => http.get('/actors').then(response => response.data.data)
export const get = (id) => http.get(`/actors?id=${id}`).then(response => response.data.data)
export const create = (data) => http.post('/actors', data).then(response => response.data.data)
export const update = (id, data) => http.put(`/actors?id=${id}`, data).then(response => response.data.data)
export const remove = (id) => http.delete(`/actors?id=${id}`).then(response => response.data.data)
