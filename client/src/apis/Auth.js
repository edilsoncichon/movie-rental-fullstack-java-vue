import http from './_HttpConfig'

let resource = 'login'

export const validateCredentials = (data) => http.post(resource, data).then(response => response.data)
