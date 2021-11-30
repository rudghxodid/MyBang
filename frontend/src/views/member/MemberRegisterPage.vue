<template>
    <div>
        <div align="center">
            <h2>회원 가입</h2>
        </div>
        <member-join-column-form v-bind:kakao_account="kakao_account" @submit="onSubmit"/>
        
        <v-spacer></v-spacer>
       
            
     
    </div>
</template>

<script>
import MemberJoinColumnForm from '@/components/member/MemberJoinColumnForm.vue'
import axios from 'axios'
export default {
    name: 'MemberRegisterPage',
    components: {
        MemberJoinColumnForm
    },
    props: {
        kakao_account: {
            type: Object,
            require: true
        }
    },
    methods: {
        onSubmit (payload) {
            const { userId, password, email, name, birth, sex, phone, auth } = payload
            axios.post('http://localhost:7777/member/register', {
                        userId, password, email, name, birth, sex, phone, auth
                    })
                    .then(res => {
                        alert('회원가입이 완료되었습니다' + res)
                        
                        this.$router.push({
                            name: 'Home'
                            
                        })
                        
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>