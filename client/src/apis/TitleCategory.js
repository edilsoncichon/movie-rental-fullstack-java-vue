import http from './_HttpConfig'

let resource = 'titles_categories'

export const getAll = () => http.get(resource).then(response => response.data.data)
export const get = (id) => http.get(`${resource}?id=${id}`).then(response => response.data.data)
