<template>
  <v-container>
    <v-card v-if="!successPw" class="pa-5">
      <v-card-title>
        회원정보를 변경하려면 비밀번호를 입력해주세요.
      </v-card-title>
      <v-text-field label="pw" v-model="password" type="password" :rules="pwRules"></v-text-field>
      <v-card-actions>
        <v-spacer>
          <v-btn @click="checkPw" @keydown.enter="checkPw">확인</v-btn>
        </v-spacer>
      </v-card-actions>
    </v-card>
    <user-info v-else></user-info>
  </v-container>
</template>


<script>
import UserInfo from '@/components/member/UserInfo'
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  components: {
    UserInfo
  },
  data () {
    return {
      userId: null,
      password: null,
      successPw: false
    }
  },
  computed: {
    ...mapState(['userInfo', 'pwRules'])
  },
  mounted() {
    this.userId = this.userInfo.userId
  },
  methods: {
    checkPw () {
      const { userId, password } = this

      axios.post('http://localhost:7777/member/checkPw', { userId, password }).then(res => {
        this.successPw = res.data

        if(!this.successPw) {
          alert('비밀번호를 확인해주세요!')
        }
      })
    }
  }
}
</script>