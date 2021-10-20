<template>
  <v-dialog v-model="dialog" max-width="400">
    <template v-slot:activator="{ on }">
      <v-btn v-on="on">탈퇴</v-btn>
    </template>
    <v-card class="pa-2">
      <v-card-title>정말 탈퇴하시겠습니까?</v-card-title>
      <v-card-actions>
        <v-btn @click="cancle">취소</v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="deleteUserInfo">확인</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>


<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  data () {
    return {
      userId: null,
      dialog: false,

    }
  },
  computed: {
    ...mapState(['userInfo'])
  },
  mounted() {
    this.userId = this.userInfo.userId
  },
  methods: {
    ...mapActions(['fetchSession']),
    cancle () {
      this.dialog = false
    },
    deleteUserInfo () {
      axios.delete(`http://localhost:7777/member/mypage/remove/${this.userId}`).then(() => {

        this.dialog = false

        this.$store.commit('USER_LOGIN', false)
        
        this.fetchSession(this.$cookies.remove('session'))

        this.$store.commit('FETCH_USER_INFO', [])

        alert('탈퇴가 완료되었습니다.')

        this.$router.push( { name: 'Home' } )
      })
    }
  }
}
</script>