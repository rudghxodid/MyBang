<template>
  <v-container>
    <div v-if="isLogin">
      <v-btn @click="logout">로그아웃</v-btn>
      <v-btn @click="gotoMypage">마이페이지</v-btn>
    </div>
    
    <div style="float:left" v-else>
      <v-btn @click="gotoJoin">회원가입</v-btn>
      <v-btn @click="gotoLogin">로그인</v-btn>
    </div>
    <router-link :to="{ name: 'MainPage' }"
      class="nav-link"
      active-class="active">메인페이지로 이동
    </router-link>
  </v-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'
  export default {
    name: 'Home',
    data() {
      return {
        
    }
  },
  computed: {
    ...mapState(['session', 'isLogin'])
  },
  methods: {
    ...mapActions(['fetchSession']),
    gotoJoin() {
      this.$router.push('/member/create')
    },
    gotoLogin() {
      this.$router.push('/login')
    },
    logout () {
      this.$store.commit('USER_LOGIN', false)
      this.fetchSession(this.$cookies.remove('session'))
      this.$store.commit('FETCH_USER_INFO', [])
      alert("로그아웃 되었습니다!")
      this.$router.go()
    },
    gotoMypage () {
      this.$router.push({ name: 'Mypage' })
    }
  }

  
  
  }
</script>
