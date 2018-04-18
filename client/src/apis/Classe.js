import http from './_HttpConfig'

let resource = 'classes'

export const getAll = () => http.get(resource).then(response => response.data.data)
export const get = (id) => http.get(`${resource}?id=${id}`).then(response => response.data.data)
export const create = (data) => http.post(resource, data).then(response => response.data.data)
export const update = (id, data) => http.put(`${resource}?id=${id}`, data).then(response => response.data.data)
export const remove = (id) => http.delete(`${resource}?id=${id}`).then(response => response.data.data)
