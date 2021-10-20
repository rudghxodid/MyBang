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

		<v-btn>
			<router-link to="/roommate" style="text-decoration: none; color: #333;">룸메구하기</router-link>
		</v-btn>
	</v-container>
</template>

<script>
  import {mapActions, mapState} from 'vuex'

  export default {
    name: 'Home',
    data() {
      return {
        userInfo: {
          userId: '',
          password: ''
        },
      }
    },
    computed: {
      ...mapState(['session', 'isLogin'])
    },
    mounted() {
      this.fetchSession(this.$cookies.get('session'))
      if (this.session != null) {
        this.$store.state.isLogin = true
        this.$store.state.userInfo = this.fetchUserInfo(this.$cookies.get('session'))
      }
    },
    methods: {
      ...mapActions(['fetchSession', 'fetchUserInfo']),
      gotoJoin() {
        this.$router.push('/member/create')
      },
      gotoLogin() {
        this.$router.push('/login')
      },
      logout() {
        this.$store.commit('USER_LOGIN', false)
        this.fetchSession(this.$cookies.remove('session'))
        this.$store.commit('FETCH_USER_INFO', [])
        alert("로그아웃 되었습니다!")
        this.$router.go()
      },
      gotoMypage() {
        this.$router.push({name: 'Mypage'})
      }
    }


  }
</script>
