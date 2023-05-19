<template>
  <div class="card mb-3" v-for="list in ListData" :key="list.number" >
    <div class="card-body">
      <h5 class="card-title" @click="$router.push('/detail/'+list.number)">
        {{list.title}}
      </h5>
    </div>
  </div>
</template>

<script>
export default {
    name:'blogList',
    props:{
      ListData : Array
    },
}
</script>

<style>

</style>