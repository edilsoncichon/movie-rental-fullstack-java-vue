import http from './_HttpConfig'

let resource = 'locations'

export const getAll = () => http.get(resource).then(response => response.data.data)
export const get = (id) => http.get(`${resource}?id=${id}`).then(response => response.data.data)
export const create = (data) => http.post(resource, data).then(response => response.data.data)
export const update = (id, data) => http.put(`${resource}?id=${id}&operation=makeUpdate`, data).then(response => response.data.data)
export const _return = (id, data) => http.put(`${resource}?id=${id}&operation=makeReturn`, data).then(response => response.data.data)
export const remove = (id) => http.delete(`${resource}?id=${id}`).then(response => response.data.data)
