<template>
  <v-container>
    <v-card>
      <v-card-title>가입한 이메일을 입력하세요.</v-card-title>
      <v-text-field label="email" v-model="email"></v-text-field>
      <v-card-actions>
        <v-btn @click="findId">찾기</v-btn>
      </v-card-actions>
    </v-card>

    <v-card>
      <v-card-title>가입한 아이디와 이메일을 입력하세요.</v-card-title>
      <v-text-field label="id" v-model="userId"></v-text-field>
      <v-text-field label="email" v-model="email"></v-text-field>
      <v-card-actions>
        <v-btn @click="findPw">찾기</v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>


<script>
import axios from 'axios'

export default {
  data () {
    return {
      email: null,
      userId: null
    }
  },
  methods: {
    findId () {
      const email = this.email

      axios.post('http://localhost:7777/member/findingUserId', { email }).then(res => {
        alert('당신의 아이디는 ' + res.data + ' 입니다.')

        this.$router.push( { name: 'Home' } )
      }).catch(() => {
        alert('일치하는 회원정보가 없습니다.')
      })
    },
    findPw () {
      const email = this.email
      const userId = this.userId

      axios.post('http://localhost:7777/member/findingUser', { email, userId }).then(res => {
        if (res.data) {
          this.$router.push(
            { name: 'ModifyPassword', query: { userId: userId } } 
          )
        } else {
          alert('회원정보를 바르게 입력하세요.')
        }

      }).catch(() => {
        alert('일치하는 회원정보가 없습니다.')
      })
    }
  }
}
</script>