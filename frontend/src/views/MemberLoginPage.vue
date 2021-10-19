<template>
    <div>
        <div align="center">
            <h2>로그인</h2>
        </div>
        <member-login-form @submit="onSubmit"/>
        <v-spacer></v-spacer>
       
    </div>
</template>

<script>
import MemberLoginForm from '@/components/member/MemberLoginForm.vue'

import axios from 'axios'
import { mapState } from 'vuex'
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
      isLogin: false,
    }
  },
  mounted () {
        // this.fetchSession()
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.isLogin = true
        }
    },
    computed: {
        ...mapState(['session'])
    },
    
    
    methods: {
        onSubmit (payload) {
       
            if (this.$store.state.session == null) {
            const { id, pw } = payload
            axios.post('http://localhost:7777/member/login', { userId: id, password: pw, auth: null })
                    .then(res => {
                        
                        if (res.data != "") {
                            alert('로그인 성공! - ' + res.data.auth)
                                this.isLogin = true
                                this.$store.state.session = res.data
                                this.$cookies.set("user", res.data, '1h')
                            
                            this.$router.push({name: 'Home'})
                            
                        } else {
                            alert('로그인 실패! - ' + res.data)
                            this.isLogin = false
                        }
                        
                        
                        
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
            }else {
            alert('이미 로그인 되어 있습니다: ' + this.$store.state.session.userId)
        }
        }
    }
}
</script>