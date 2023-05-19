import { createWebHistory, createRouter } from "vue-router";
import list from "../components/ListPage.vue"
import main from "../components/MainPage.vue"
import detail from "../components/DetailPage.vue"

const routes = [
  {
    path: "/list",
    component: list,
  },
  {
    path: "/",
    component: main,
  },
  {
    path: "/detail/:id",
    component: detail,
    props: true
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router; 