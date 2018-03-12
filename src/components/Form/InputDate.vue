<template>
  <div class="input-group">
    <select v-model="day" :name="idDay" :id="idDay" class="form-control" :disabled="disabled">
      <option value="">dia</option>
      <option v-for="n in 31" :value="n">{{ n++ }}</option>
    </select>
    <select v-model="month" :name="idMonth" :id="idMonth" class="form-control" :disabled="disabled">
      <option value="">mês</option>
      <option v-for="(month, key) in months" :value="key+1">{{ month }}</option>
    </select>
    <select v-model="year" :name="idYear" :id="idYear" class="form-control" :disabled="disabled">
      <option value="">ano</option>
      <option v-for="year in years" :value="year">{{ year }}</option>
    </select>
  </div>
</template>

<script>
  export default {
    name: 'InputDate',
    props: [
      'id',
      'defaultDate',
      'disabled'
    ],
    computed: {
      idDay: function () {
        return this.id + '_day'
      },
      idMonth: function () {
        return this.id + '_month'
      },
      idYear: function () {
        return this.id + '_year'
      },
      years: function () {
        return Array(201).fill(2100).map((x, y) => x - y)
      },
      months: function () {
        return [ 'jan', 'fev', 'mar', 'abr', 'mai', 'jun',
          'jul', 'ago', 'set', 'out', 'nov', 'dez']
      },
      day: function () {
        return this.defaultDate
          ? this.defaultDate.getDate()
          : ''
      },
      month: function () {
        return this.defaultDate
          ? this.defaultDate.getMonth()
          : ''
      },
      year: function () {
        return this.defaultDate
          ? this.defaultDate.getFullYear()
          : ''
      }
    }
  }
</script>

<style scoped>
  .form-control {
    text-align: center;
  }
</style>
