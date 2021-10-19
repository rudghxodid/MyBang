import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Mypage from '@/views/member/Mypage'
import MemberRegisterPage from '@/views/MemberRegisterPage.vue'
















import TestSignup from '@/components/member/TestSignup'
import FindUserIdPw from '@/components/member/FindUserIdPw'
import ModifyPassword from '@/components/member/ModifyPassword'


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
    path: '/testSignup',
    name: 'TestSignup',
    component: TestSignup
  },
  {
    path: '/findUserIdPw',
    name: 'FindUserIdPw',
    component: FindUserIdPw
  },
  {
    path: '/modifyPassword/:userId',
    name: 'ModifyPassword',
    component: ModifyPassword
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
