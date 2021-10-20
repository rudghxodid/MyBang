<template>
  <v-container>
    <v-card class="pa-5">
      <v-card-title>아이디 찾기</v-card-title>
      <v-card-text>가입한 이메일을 입력하세요.</v-card-text>
      <v-text-field label="email" v-model="email"></v-text-field>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="findId" @keydown.enter="findId">찾기</v-btn>
      </v-card-actions>
    </v-card>    
  </v-container>
</template>


<script>
import axios from 'axios'

export default {
  data () {
    return {
      email: null
    }
  },
  methods: {
    findId () {
      const email = this.email

      axios.post('http://localhost:7777/member/findingUserId', { email }).then(res => {
        alert('당신의 아이디는 ' + res.data + ' 입니다.')

        this.$router.push( { name: 'MemberLoginPage' } )
      }).catch(() => {
        alert('일치하는 회원정보가 없습니다.')
      })
    },
  }
}
</script>