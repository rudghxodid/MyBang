<template>
  <div>

    <router-link :to="{ name: 'Mypage' }"
      class="nav-link"
      active-class="active">Mypage
    </router-link>

    <router-link :to="{ name: 'MemberRegisterPage' }"
                        class="nav-link"
                        active-class="active">
                    회원가입 테스트
                </router-link>

    <router-link :to="{ name: 'MemberLoginPage' }"
                        class="nav-link"
                        active-class="active">
                    로그인 테스트
                </router-link>

    <v-btn @click="logout" color="#ffffff" height="80px" x-large fontSize="15" v-if="isLogin">로그아웃</v-btn>
             <div style="float:left" v-else>
             <v-btn @click="gotoJoin" color="#FFCC97" height="80px" x-large fontSize="15" >회원가입</v-btn>
            <v-btn @click="gotoLogin" color="#FFCC97" height="80px" x-large fontSize="15" depressed >로그인</v-btn>
            </div>

  </div>


</template>

<script>
import { mapState } from 'vuex'

import Vue from 'vue'
import cookies from 'vue-cookies'
Vue.use(cookies)

  export default {
    name: 'Home',
    data() {
      return {
        isLogin: false,
        userInfo: {
                userId: '',
                password: ''
            },
    }
    
  },
   computed: {
        ...mapState(['session'])
   },
   
    mounted () {  
       
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.isLogin = true
        
    }
    
    },
   methods: {
    
        gotoJoin() {
            
            this.$router.push('/member/create')
        },
        gotoLogin() {
            this.$router.push('/login')
            
       
        },
        logout () {
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.session = null
            alert("로그아웃 되었습니다!")
        },
       
   }

  
  
  }
</script>
