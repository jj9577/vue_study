<template>
  <div class="card mb-3">
    <div class="card-body">
      <h5 class="card-title">{{ListData[$route.params.id].title}}</h5>
      <h6 class="card-subtitle mb-2 text-body-secondary">{{ListData[$route.params.id].date}}</h6>
      <p class="card-text">{{ListData[$route.params.id].content}}</p>
    </div>
  </div>
</template>

<script>
export default {
    name:'detaliPage',
    props:{
        ListData:Array
    }
}
</script>

<style>

</style>