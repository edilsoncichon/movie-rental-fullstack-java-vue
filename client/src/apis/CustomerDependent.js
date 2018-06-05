import http from './_HttpConfig'

let resource = 'admin/customers-dependents'

export const getAll = () => http.get(resource).then(response => response.data.data)
export const getAllByPartnerId = (id) =>
  http.get(`${resource}?operation=getAllByPartnerId&id=${id}`)
    .then(response => response.data.data)
export const getById = (id) => http.get(`${resource}?operation=getById&id=${id}`).then(response => response.data.data)
export const create = (data) => http.post(resource, data).then(response => response.data.data)
export const update = (id, data) => http.put(`${resource}?id=${id}`, data).then(response => response.data.data)
export const remove = (id) => http.delete(`${resource}?id=${id}`).then(response => response.data.data)
