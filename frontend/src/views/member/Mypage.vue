<template>
  <v-container>
    <v-card v-if="!successPw">
      <v-card-title>
        회원정보를 변경하려면 비밀번호를 입력해주세요.
      </v-card-title>
      <v-text-field label="pw" v-model="password"></v-text-field>
      <v-btn @click="checkPw">확인</v-btn>
    </v-card>
    <user-info v-else></user-info>
  </v-container>
</template>


<script>
import UserInfo from '@/components/member/UserInfo'
import axios from 'axios'

export default {
  components: {
    UserInfo
  },
  data () {
    return {
      userId: 'test',
      password: null,
      successPw: false
    }
  },
  methods: {
    checkPw () {
      const {userId, password} = this
      axios.post('http://localhost:7777/member/checkPw', {userId, password}).then(res => {
        this.successPw = res.data

        if(!this.successPw) {
          alert('비밀번호를 확인해주세요!')
        }
      })
    }
  }
}
</script>