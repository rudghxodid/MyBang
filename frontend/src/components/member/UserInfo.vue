<template>
  <v-container>
    <v-card class="pa-10">
      <div class="d-flex mb-5">
        <h1 v-if="!modify">회원정보 보기</h1>
        <h1 v-else>회원정보 변경</h1>
        <v-spacer></v-spacer>
        <v-switch v-model="modify" label="회원정보 변경" hide-details
          class="mt-n1" color="secondary"></v-switch>
      </div>
      
      <v-card v-if="!modify" flat>
        <span>아이디</span>
        <v-text-field v-model="userId" solo class="mt-3" readonly></v-text-field>

        <span>이름</span>
        <v-text-field v-model="userInfo.name" solo class="mt-3" readonly></v-text-field>

        <span>생일</span>
        <v-text-field v-model="userInfo.birth" solo class="mt-3" readonly></v-text-field>

        <span>성별</span>
        <v-text-field v-model="userInfo.sex" solo class="mt-3" readonly></v-text-field>

        <span>전화번호</span>
        <v-text-field v-model="userInfo.phone" solo class="mt-3" readonly></v-text-field>

        <span>이메일</span>
        <v-text-field v-model="userInfo.email" solo class="mt-3" readonly></v-text-field>
      </v-card>

      <v-card v-else flat>
        <span>아이디</span>
        <v-text-field v-model="userId" solo class="mt-3" readonly></v-text-field>

        <span>이름</span>
        <v-text-field v-model="userInfo.name" solo class="mt-3" readonly></v-text-field>

        <span>생일</span>
        <v-text-field v-model="userInfo.birth" solo class="mt-3" readonly></v-text-field>

        <span>성별</span>
        <v-text-field v-model="userInfo.sex" solo class="mt-3" readonly></v-text-field>

        <span>전화번호</span>
        <v-text-field v-model="userInfo.phone" solo class="mt-3" required></v-text-field>

        <span>이메일</span>
				<div class="d-flex mt-3">
					<v-text-field v-model="userInfo.email" :rules="emailRules" required
						solo @change="changeEmail"></v-text-field>
					<v-btn v-if="!completeEmail" @click="checkEmail" class="mt-1 ml-2 white--text secondary">인증</v-btn>
					<v-btn v-else @click="checkEmail" class="mt-1 ml-2 secondary--text" icon>
						<v-icon>check</v-icon>
					</v-btn>
				</div>

        <span>비밀번호</span>
        <v-text-field v-model="password" type="password" :rules="pwRules" required
          solo class="mt-3"></v-text-field>

        <span>비밀번호 확인</span>
        <v-text-field v-model="checkPassword" type="password" :rules="matchPwRules" required
          solo class="mt-3" ></v-text-field>
        
        <v-card-actions>
          <check-delete-user-info></check-delete-user-info>
          <v-spacer></v-spacer>
          <v-btn @click="modifyUserInfo" @keydown.enter="modifyUserInfo" color="secondary">수정</v-btn>
        </v-card-actions>
      </v-card>
    </v-card>
    
    <v-dialog v-model="emailDialog" max-width="400">
      <v-card class="pa-3">
        <v-card-title>메일함을 확인해주세요.</v-card-title>
        <v-card-text>인증번호 6자리를 입력해주세요.</v-card-text>
        <v-text-field v-model="code"
          label="인증번호" class="mx-5" solo></v-text-field>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn @click="ckeckCode" class="secondary">확인</v-btn>
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
      completeEmail: true,
      modify: false
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
          this.modify = false
        })
      } else {
        alert('이메일 인증을 완료해주세요.')
      }
      
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
    changeEmail () {
			this.completeEmail = false
		}
  }
}
</script>

<style scoped>
h1 {
  font-size: 25px;
  font-weight: bold;
}
</style>

