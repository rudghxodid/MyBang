<template>
    <div>
        <div align="center">
            <h2>로그인</h2>
        </div>
        <member-login-form @submit="onSubmit"/>
        <v-spacer></v-spacer>
       
    
        <v-btn @click="findUserId" text>아이디 찾기</v-btn>
        <v-btn @click="findUserPw" text>비밀번호 찾기</v-btn>
    </div>
</template>

<script>
import MemberLoginForm from '@/components/member/MemberLoginForm.vue'

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import Vue from 'vue'
import cookies from 'vue-cookies'
Vue.use(cookies)

export default {
    name: 'MemberLoginPage',
    components: {
        MemberLoginForm
    },
   data() {
    return {
      id: "",
      pw: "",
    }
  },
  mounted () {
        this.fetchSession(this.$cookies.get('session'))
        if (this.session != null) {
            this.$store.state.isLogin = true
            this.$store.state.userInfo = this.fetchUserInfo(this.$cookies.get('session'))
        }
    },
    computed: {
        ...mapState(['session'])
    },


    methods: {
        ...mapActions(['fetchSession', 'fetchUserInfo']),
        onSubmit (payload) {

            if (this.$store.state.session == null) {
                const { id, pw } = payload
                axios.post('http://localhost:7777/member/login', { userId: id, password: pw, auth: null })
                .then(res => {

                    if (res.data != "") {
                        alert('환영합니다! ' + res.data.auth)

                        this.$store.commit('USER_LOGIN', true)

                        this.fetchUserInfo(id)
                        if (res.data.auth == '관리자'){
                           this.$router.push({name: 'HostPage'})
                       }else{
                        this.$router.push({name: 'Home'})
                       }

                    }else {

                        alert('로그인 실패! - ' + res.data)
                    }
                })
                .catch(res => {
                    alert(res.response.data.message)
                })
            }else {
            alert('이미 로그인 되어 있습니다: ' + this.$store.state.session.userId)
            }
        },
        findUserId () {
            this.$router.push({ name: 'FindUserId' })
        },
        findUserPw () {
            this.$router.push({ name: 'FindUserPw' })
        },
        
    }
}
</script>
