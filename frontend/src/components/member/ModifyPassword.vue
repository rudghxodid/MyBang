<template>
  <v-container>
    <v-card>
      <v-card-title>비밀번호를 재설정해주세요.</v-card-title>
      <v-text-field label="pw" v-model="password"></v-text-field>
      <v-text-field label="pw" v-model="checkPassword"></v-text-field>
      <v-card-actions>
        <v-btn @click="modifyPw">확인</v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>


<script>
import axios from 'axios'

export default {
  data () {
    return {
      password: null,
      checkPassword: null,
      userId: null
    }
  },
  created() {
    this.userId = this.$route.query.userId
    console.log(this.userId)
  },
  methods: {
    modifyPw () {
      const password = this.checkPassword

      axios.patch(`http://localhost:7777/member/modifyPw/${this.userId}`, { password }).then(() => {
        alert('비밀번호가 변경되었습니다. 로그인 해주세요.')

        this.$router.push( { name: 'Home' } )
      })
    }
  }
}
</script>