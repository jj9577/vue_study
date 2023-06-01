<template>
    <div style="padding : 10px">
        <table>
            <tr>
                <td>basDt</td>
                <td>itmsNm</td>
                <td>mkp</td>
                <td>calc</td>
            </tr>
            <tr v-for="(a,i) in gold" :key="i">
                <td>{{a.basDt}}</td>
                <td>{{a.itmsNm}}</td>
                <td>{{a.mkp}}</td>
                <td>{{a.mkp * 3.75}}</td>
            </tr>
        </table>
    </div>
</template>
<script>
import { onMounted, ref} from 'vue';
import axios from 'axios';

export default {
    name:'OpenApiTest',
    setup(){
        let gold = ref([]);
        
        onMounted(()=>{
            axios.get('https://apis.data.go.kr/1160100/service/GetGeneralProductInfoService/getGoldPriceInfo?serviceKey=DNFBb8LScs9uUwweGW%2Br4kOzHnLx3GiZ%2BBBuyyy3yohmQAqyPfqrW8Xcv%2F7jZ4D6j7Xs2zJhyDJEtaLo429mpw%3D%3D&numOfRows=50&resultType=json&beginbasDt=20230520')
                .then((a)=>{ 
                gold.value = a.data.response.body.items.item;
            })
        })

        return {gold};
    }
}
</script>