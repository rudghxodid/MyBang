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
        <v-list-item three-line>
          <v-list-item-content>
            <v-list-item-title>비밀번호</v-list-item-title>
            <!--
            <v-text-field v-model="password" type="password"></v-text-field>
            -->
            <v-text-field v-model="checkPassword" type="password" :rules="pwRules"></v-text-field>
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
          </v-list-item-content>
        </v-list-item>
     
      <v-card-actions>
        <check-delete-user-info></check-delete-user-info>
        <v-spacer></v-spacer>
        <v-btn @click="goHome">메인으로</v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="modifyUserInfo" @keydown.enter="modifyUserInfo">수정</v-btn>
      </v-card-actions>
    </v-card>
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
      checkPassword: null
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

      axios.patch(`http://localhost:7777/member/mypage/modify/${this.userId}`, { password, email, phone }).then(() => {
        alert('회원정보가 수정되었습니다.')

        this.fetchUserInfo(this.userId)
      })
    },
    goHome () {
      this.$router.push({ name: 'Home' })
    }
  }
}
</script>