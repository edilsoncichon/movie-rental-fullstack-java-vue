import http from 'axios'

/**
 * Get data address of cep
 *
 * @param {String} cep
 *
 * @returns {Promise}
 */
export const get = (cep) => {
  const urlApi = `https://viacep.com.br/ws/${cep}/json`
  return http.get(urlApi).then(response => response.data)
}
