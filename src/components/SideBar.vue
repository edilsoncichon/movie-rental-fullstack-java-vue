<template>
  <div class="sidebar-sticky">
    <slot></slot>
  </div>
</template>

<script>
export default {
  props: [
    'isDashboard',
    'isLocations',
    'isTitles',
    'isCustomers',
    'isReports'
  ]
}
</script>
