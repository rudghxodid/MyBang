<template>
  <v-container>
    <v-card class="pa-5">
      <v-card-title>비밀번호 재설정</v-card-title>
      <v-card-text>가입한 아이디와 이메일을 입력하세요.</v-card-text>
      <v-text-field label="id" v-model="userId" :rules="idRules"></v-text-field>
      <v-text-field label="email" v-model="email" :rules="emailRules"></v-text-field>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="findPw" @keydown.enter="findPw">찾기</v-btn>
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
      email: null,
      userId: null
    }
  },
  computed: {
    ...mapState(['idRules', 'emailRules'])
  },
  methods: {
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