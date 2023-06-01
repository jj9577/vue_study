<template>
  <div style="padding : 10px">
    <h4>팔로워</h4>
    <input placeholder="?" @input="fnSearch($event.target.value)" />
    <div class="post-header" v-for="(a,i) in follower" :key="i">
        <div class="profile" :style="{backgroundImage: `url(${a.image})`}"></div>
        <span class="profile-name">{{a.name}}</span>
    </div>
    </div>
</template>

<script>
import { onMounted, ref} from 'vue';
import axios from 'axios';
export default {
    name:'myPage',
    setup(){
        let follower = ref([]);
        let ori = ref([]);
        
        function fnSearch(text){
            let newFllower = ori.value.filter((filter)=>String(filter.name).toLowerCase().includes(String(text).toLowerCase()));
            follower.value=newFllower;
        }
        onMounted(()=>{
            axios.get('/follower.json').then((a)=>{ 
                ori.value=[...a.data];
                follower.value = a.data;
            })
        })
        
        return {follower, fnSearch};
    }
}
</script>

<style>

</style>