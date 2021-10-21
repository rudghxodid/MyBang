<template>
  <v-container>
    <v-card class="pa-5">
      <v-card-title>비밀번호를 재설정해주세요.</v-card-title>
      <v-text-field label="pw" v-model="password" type="password" :rules="pwRules"></v-text-field>
      <v-text-field label="pw" v-model="checkPassword" type="password" :rules="matchPwRules"></v-text-field>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="modifyPw" @keydown.enter="modifyPw">확인</v-btn>
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
      password: null,
      checkPassword: null,
      userId: null,
      matchPwRules: [
        pw => !!pw || '비밀번호를 입력해주세요!',
        pw => pw === this.password || '비밀번호가 일치하지 않습니다!'
      ],
    }
  },
  computed: {
    ...mapState(['pwRules'])
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

        this.$router.push( { name: 'MemberLoginPage' } )
      })
    }
  }
}
</script>