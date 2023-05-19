<template>

    <transition name="fade">
        <RoomModal @openModal="modal=openModal;" :products="products" :modal="modal"></RoomModal>
    </transition>
  <div>
    <img :src="products.image" class="room-img">
    <h4 @click="change(products.id)">{{products.title}}</h4>
    <p>{{products.price}} 원</p>
  </div>
</template>

<script>
import RoomModal from './RoomModal.vue';
export default {
    name: 'RoomCard',
    data(){
        return{
            modal:false,
            modalnum:0,
        }
    },
    props : {
        products : Array,
    },
    components:{
        RoomModal,
    },
    methods:{
        change(i){
        this.modal = true;
        this.modalnum = i;
        }
    },

}
</script>

<style>
.fade-enter-from{
    transform: translateY(-1000px);
}
.fade-enter-active{
    transition: all 1s;
}
.fade-enter-to{
    transform: translateY(0px);
}
.fade-leave-from{
    opacity: 1;
}
.fade-leave-active{
    transition: all 1s;
}
.fade-leave-to{
    opacity: 0;
}

</style>