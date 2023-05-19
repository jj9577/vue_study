<template>
    <div class="black-bg" v-if="modal">
        <div class="white-bg">
            <img :src="products.image" class="room-img">
            <h4>{{ products.title }}</h4>
            <p>{{ products.content }}</p>
            <p>{{ month }} 개월 선택 함 : {{ month * products.price }}원</p>
            <input v-model="month">
            <button @click="$emit('openModal', false)">close</button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'RoomModal',
    data(){
        return{
            month:1
        }
    },
    props : {
        products : Array,
        modal : Boolean,
    },
    beforeUpdate(){
        if(this.month <= 2){
            alert('3개월 미만은 안팔아용~~');
            this.month = 3;
        }
    },
    watch:{
        month(){
            if(isNaN(this.month)){
                alert("no");
                this.month = 1;
            }
            if(this.month >= 13){
                alert("no");
                this.month = 12;
            }
        }
    }
}
</script>

<style>

</style>