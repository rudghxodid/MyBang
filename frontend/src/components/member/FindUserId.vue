<template>
  <v-container>
    <v-card class="pa-5">
      <v-card-title>아이디 찾기</v-card-title>
      <v-card-text>가입한 이메일을 입력하세요.</v-card-text>
      <v-text-field label="email" v-model="email" :rules="emailRules"></v-text-field>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="findId" @keydown.enter="findId">찾기</v-btn>
      </v-card-actions>
    </v-card>    
  </v-container>
</template>


<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  data () {
    return {
      email: null
    }
  },
  computed: {
    ...mapState(['emailRules'])
  },
  methods: {
    findId () {
      const email = this.email

      axios.post('http://localhost:7777/member/findingUserId', { email }).then(res => {
        if (res.data == 'success') {
          alert('메일함을 확인해 주세요.')
          this.$router.push( { name: 'MemberLoginPage' } )
        } else if (res.data == 'NotFindUser') {
          alert('일치하는 회원정보가 없습니다.')
        } else {
          alert('이메일 전송이 불가능 합니다.')
        }
      }).catch(() => {
        alert('회원정보를 찾을 수 없습니다.')
      })
    },
  }
}
</script>