<template>
  <v-container>
    <v-card class="pa-5">
      <v-card-title>회원정보 변경</v-card-title>
      <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>아이디</v-list-item-title>
            <v-list-item-subtitle>{{ userId }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>이름</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.name }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>생일</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.birth }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>성별</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.sex }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>비밀번호</v-list-item-title>
            <v-text-field v-model="password" type="password" :rules="pwRules" class="mr-3"></v-text-field>
            <v-text-field v-model="checkPassword" type="password" :rules="matchPwRules" class="ml-3"></v-text-field>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>전화번호</v-list-item-title>
            <v-text-field v-model="userInfo.phone" :rules="phoneRules"></v-text-field>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>이메일</v-list-item-title>
            <v-text-field v-model="userInfo.email" :rules="emailRules"></v-text-field>
            <v-btn @click="checkEmail">이메일 인증</v-btn>
          </v-list-item-content>
        </v-list-item>
     
      <v-card-actions>
        <check-delete-user-info></check-delete-user-info>
        <v-spacer></v-spacer>
        <v-btn @click="goHome">메인으로</v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="modifyUserInfo" @keydown.enter="modifyUserInfo">수정</v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="brokerHouseList">매물 등록 및 확인</v-btn>
      </v-card-actions>
    </v-card>

    <v-dialog v-model="emailDialog" max-width="400">
      <v-card>
        <v-card-title>메일함을 확인해주세요.</v-card-title>
        <v-card-text>인증번호 6자리를 입력해주세요.</v-card-text>
        <v-text-field v-model="code" class="mx-5" label="인증번호"></v-text-field>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn @click="ckeckCode">확인</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>


<script>
import CheckDeleteUserInfo from '@/components/member/CheckDeleteUserInfo'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'

export default {
  components: { 
    CheckDeleteUserInfo
  },
  data () {
    return {
      userId: null,
      password: null,
      checkPassword: null,
      matchPwRules: [
        pw => !!pw || '비밀번호를 입력해주세요!',
        pw => pw === this.password || '비밀번호가 일치하지 않습니다!'
      ],
      emailDialog: false,
      code: null,
      randomCode: null,
      completeEmail: false
    }
  },
  computed: {
    ...mapState(['userInfo','pwRules', 'emailRules', 'phoneRules'])
  },
  mounted() {
    this.userId = this.userInfo.userId
  },
  methods: {
    ...mapActions(['fetchUserInfo']),
    modifyUserInfo () {
      const password = this.checkPassword
      const phone = this.userInfo.phone
      const email = this.userInfo.email

      if (this.completeEmail) {
        axios.patch(`http://localhost:7777/member/mypage/modify/${this.userId}`, { password, email, phone }).then(() => {
          alert('회원정보가 수정되었습니다.')

          this.fetchUserInfo(this.userId)
        })
      } else {
        alert('이메일 인증을 완료해주세요.')
      }
      
    },
    goHome () {
      this.$router.push({ name: 'Home' })
    },
    checkEmail () {
      const email = this.userInfo.email

      if (email) {
        axios.post(`http://localhost:7777/member/checkEmail/${email}`).then(res => {
          if (res.data == 'AlreadyUser') {
            alert('이미 사용중인 회원입니다.')
          } else {
            this.emailDialog = true
            this.randomCode = res.data
          }
        })
      } else {
        alert('이메일을 입력해주세요.')
      }    
    },
    ckeckCode () {
      if (this.code == this.randomCode) {
        alert('이메일 인증이 완료되었습니다.')

        this.emailDialog = false
        this.code = null
        this.completeEmail = true
      } else {
        alert('인증번호가 일치하지 않습니다.')
      }
    },
    brokerHouseList () {
      this.agentId = this.userInfo.userId
        if (this.$store.state.session != null) {
            this.isLogin = true
      }
      this.$router.push({ name: 'BrokerHouseListPage' })
      this.$router.go()
    },
  }
}
</script>