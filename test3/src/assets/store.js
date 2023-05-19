import {createStore} from 'vuex'
import axios from 'axios'

const store = createStore({
    state (){
        return {
            age : 0,
            likes: 0,
            likeflag:false,
            moredata:[{}],
            morecnt:0
        }
    },
    // 데이터 수정 관련 정의
    mutations : {
        plus(state){
            state.age++;
        },
        likeClick(state, data) {
            state.likes = data.cnt;
            state.likeflag = data.likeflag;
            if(state.likeflag){
                state.likes--;
                state.likeflag=false;
            }else{
                state.likes++;
                state.likeflag=true;
            }
        },
        setMore(state, result){
            state.moredata=result.data; 
            state.morecnt++;
        }
    },
    // ajax 요청 처리
    actions:{
        async more(context, cnt){
            await axios.get(`https://codingapple1.github.io/vue/more${cnt}.json`)
            .then((result)=>{
                context.commit('setMore', result);
            })
        }
    },
})

export default store;