<template>
  <div>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
      <h1 class="h2">Locação <small class="operation">nova</small></h1>
    </div>
    <div>
      <form>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="item">Item</label>
            <select v-model="itemSelected" @change="calculate" class="form-control" id="item" name="item">
              <option value="">Selecione...</option>
              <option v-for="item in items" :value="item.id">{{ item.name }}</option>
            </select>
          </div>
          <div class="form-group col-md-6">
            <label for="customer">Cliente</label>
            <select class="form-control" id="customer" name="customer">
              <option>Selecione...</option>
              <option v-for="customer in customers" :value="customer.id">{{ customer.name }}</option>
            </select>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-3">
            <label for="dt_devolucao">Dt. Devolução Prevista</label>
            <input-date id="dt_devolucao" :defaultDate="expectedDateDevolution"/>
          </div>
          <div class="form-group col-md-3">
            <label for="value">Valor</label>
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text">R$</span>
              </div>
              <input type="text" class="form-control" id="value" placeholder="0,00" v-model="value">
            </div>
          </div>
        </div>
        <div class="text-right">
          <button type="submit" class="btn btn-primary">Salvar</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  import InputDate from '@/components/Form/InputDate'
  export default {
    name: 'Location',
    components: { InputDate },
    data () {
      return {
        itemSelected: '',
        items: [
          {id: 1, name: 'Poeira em Alto Mar', value: 2.99, deadline: new Date(2018, 2, 15)},
          {id: 2, name: 'Homem das Cavernas', value: 1.99, deadline: new Date(2018, 4, 10)}
        ],
        customers: [
          {id: 1, name: 'Edilson Cichon'},
          {id: 2, name: 'Fernanda Rodrigues'}
        ],
        expectedDateDevolution: new Date(),
        value: ''
      }
    },
    methods: {
      getItemSelected (id) {
        return this.items.find(function (item) {
          return item.id === id
        })
      },
      calculate () {
        let item = this.getItemSelected(this.itemSelected)
        if (item) {
          this.value = item.value
          this.expectedDateDevolution = item.deadline
        } else {
          this.value = ''
        }
      }
    },
    created () {
      this.$bus.$emit('activateMenuItem', { menu: 'locations' })
    }
  }
</script>
