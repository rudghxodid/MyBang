<template>
  <v-container>
    <v-row>
      <v-col>
        <user-activity></user-activity>
      </v-col>
      <v-col>
        <v-card v-if="!successPw" class="pa-10 grey lighten-4" width="500">
          <v-card-title>
            회원정보를 확인하려면 비밀번호를 입력해주세요.
          </v-card-title>

          <span>비밀번호</span>
          <v-text-field v-model="password" type="password" :rules="pwRules" 
            solo class="mt-3"></v-text-field>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn @click="checkPw" @keydown.enter="checkPw">확인</v-btn>
          </v-card-actions>
        </v-card>
        <user-info v-else></user-info>
      </v-col>
      
    </v-row>
    
  </v-container>
</template>


<script>
import UserInfo from '@/components/member/UserInfo'
import UserActivity from '@/components/member/UserActivity'
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  components: {
    UserInfo,
    UserActivity
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