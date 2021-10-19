import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Mypage from '@/components/member/Mypage'
import MemberRegisterPage from '@/views/MemberRegisterPage.vue'
import MemberLoginPage from '@/views/MemberLoginPage.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/mypage',
    name: 'Mypage',
    component: Mypage
  },
  {
    path: '/member/create',
    name: 'MemberRegisterPage',
    components: {
      default: MemberRegisterPage
    },
    props: {

      default: true
    }
  },
  {
    path: '/login',
    name: 'MemberLoginPage',
    components: {
      default: MemberLoginPage
    }
  },




 

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
