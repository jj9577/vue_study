import Vue from 'vue'
import VueRouter from 'vue-router'

import Board from 'BOARD/List.vue'
import BoardDetail from 'BOARD/Input.vue'
import BoardUpdate from 'BOARD/Update.vue'

Vue.use(VueRouter)

const router = new VueRouter({
    mode: 'history',
    routes: [
        { path : '/board', component: Board },
        { path : '/board/new', component: BoardDetail },
        { path : '/board/update', component: BoardUpdate }
    ]
})

export default router