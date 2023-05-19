<template>

  <div class="menu">
    <a v-for="menu in menus" :key="menu.id">{{menu.text}}</a>
  </div>

  <button @click="titleSort">이름순정렬</button>
  <button @click="priceSort">가격순정렬</button>
  <button @click="priceSort2">가격역순정렬</button>
  <button @click="sortBack">되돌리기</button>

  <RoomDiscount v-if="showDiscount == true" :percent="percent" />
  <RoomCard v-for="(product, i) in products" :products="products[i]" :key="i"></RoomCard>
</template>

<script>
import rooms from './assets/rooms.js';
import RoomCard from './components/RoomCard.vue';
import RoomDiscount from './components/RoomDiscount.vue';

export default{
  name: 'App',
  data() {
      return{
        products:rooms,
        original:[...rooms],
        showDiscount : true,
        percent:30,
        menus:[
          {id:0, text:'Home'},
          {id:1, text:'Shop'},
          {id:2, text:'About'}
        ]
    }
  },
  mounted(){
    setInterval(() => {
      if(this.percent > 0){this.percent--;}
    }, 1000);
  },
  beforeUpdate(){
    if(this.percent <= 0){this.showDiscount = false;}
  },
  components : {
    RoomCard,
    RoomDiscount,
  },

  methods: {
    titleSort(){
      this.products.sort(function(a,b){
        let x=a.title;
        let y=b.title;

        if(x<y){
          return -1;
        }
        if(x>y){
          return 1;
        }
        return 0;
      })
    },
    priceSort(){
      this.products.sort(function(a,b){return a.price - b.price;})
    },
    priceSort2(){
      this.products.sort(function(a,b){return b.price - a.price;})
    },
    sortBack(){
      this.products = [...this.original];
    }
  },
}
</script>

<style>
body{
  margin:0;
}
div{
  box-sizing: border-box;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.menu{
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}
.menu a{
  color:white;
  padding: 10px;
}
.room-img{
  width:100%;
  margin-top:40px;
}
.black-bg{
  width:100%; height:100%;
  background:rgba(0,0,0,0.5);
  position:fixed; padding:20px;
}
.white-bg{
  width:100%;background: white;
  border-radius: 8px;
  padding: 20px;
}
.discount {
  background: rgb(204, 204, 204);
  padding:10px;
  margin:10px;
  border-radius: 15px;
}
</style>
