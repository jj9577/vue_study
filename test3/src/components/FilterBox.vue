<template>
  <div :class="'filter-item '+ filtername" :style="{backgroundImage: `url(${fileurl})`}" @click="fire">
    <slot></slot>
</div>  
</template>

<script>

export default {
    name:'filterBox',
    props:{
        fileurl:String,
        filtername:String,
    },
    methods:{
        fire(){
            this.emitter.emit('filter', this.filtername);
        }
    }
}
</script>

<style>
.filter-item {
  width: 100px;
  height: 100px;
  margin: 10px 10px 10px auto;
  padding: 8px;
  display: inline-block;
  color : white;
  background-size: cover;
  background-position : center;
}
</style>