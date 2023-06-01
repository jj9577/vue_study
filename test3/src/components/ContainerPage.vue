<template>
    <div>
        <div v-if="step==0">
            <PostPage v-for="(post,i) in postData" :key="i" :post="post" />
        </div>
        <!-- 필터선택페이지 -->
        <div v-if="step==1">
            <div class="upload-image" :class="filtername" :style="{backgroundImage: `url(${fileurl})`}"></div>
            <div class="filters">
                <FilterBox v-for="filter in filterdata" :key="filter" :fileurl ="fileurl" :filtername="filter">
                    {{ filter }}
                </FilterBox>
            </div>
        </div>

        <!-- 글작성페이지 -->
        <div v-if="step==2">
            <div class="upload-image" :class="filtername" :style="{backgroundImage: `url(${fileurl})`}"></div>
            <div class="write">
                <textarea class="write-box" @input="$emit('write',$event.target.value)">write!</textarea>
            </div>
        </div>

        <!-- mypage -->
        <div v-if="step==3">
            <MyPage :one="1"></MyPage>
        </div>

        <!-- apitest -->
        <div v-if="step==4">
            <OpenApi></OpenApi>
        </div>
    </div>
</template>

<script>
import PostPage from './PostPage.vue'
import FilterBox from './FilterBox.vue'
import MyPage from './MyPage.vue'
import filter from '@/assets/filter'
import OpenApi from './OpenApiTestPage.vue'

export default {
    name:'ContainerPage',
    data(){
        return {
            filterdata : filter,
            filtername:'',
        }
    },
    props:{
        postData:Array,
        step:Number,
        fileurl:String,
    },
    components:{
        PostPage:PostPage,
        FilterBox:FilterBox,
        MyPage:MyPage,
        OpenApi:OpenApi,
    },
    mounted(){
        this.emitter.on('filter', (a)=>{this.filtername = a; });
    }
}
</script>

<style>
.upload-image{
width: 100%;
height: 450px;
background: cornflowerblue;
background-size : cover;
}
.filters{
overflow-x:scroll;
white-space: nowrap;
}
.filter-1 {
width: 100px;
height: 100px;
background-color: cornflowerblue;
margin: 10px 10px 10px auto;
padding: 8px;
display: inline-block;
color : white;
background-size: cover;
}
.filters::-webkit-scrollbar {
height: 5px;
}
.filters::-webkit-scrollbar-track {
background: #f1f1f1; 
}
.filters::-webkit-scrollbar-thumb {
background: #888; 
border-radius: 5px;
}
.filters::-webkit-scrollbar-thumb:hover {
background: #555; 
}
.write-box {
border: none;
width: 90%;
height: 100px;
padding: 15px;
margin: auto;
display: block;
outline: none;
}
</style>