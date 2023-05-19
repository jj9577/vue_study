<template>
  <div class="discount">
    <h4>지금 결제하면 {{percent}}% 할인</h4>
  </div>
</template>

<script>
export default {
    name: 'RoomDiscount',
    props:{
      percent:Number,
    },
}
</script>

<style>
</style>