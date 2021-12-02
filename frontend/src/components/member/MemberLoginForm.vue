<template>
	<v-container>
		<v-card class="pa-10 mx-auto" width="500" color="grey lighten-4">
			<span>아이디</span>
			<v-text-field v-model="id" :rules="idRules" required 
				solo class="mt-3"></v-text-field>
			
			<span>비밀번호</span>
			<v-text-field type="password" v-model="pw" :rules="pwRules" required
				solo class="mt-3"></v-text-field>
			<v-btn @click="onSubmit" class="white--text secondary" large block>Login</v-btn>
		</v-card>
		
		<router-link :to="{ name: 'KakaoLoginPage' }"
			class="nav-link"
			active-class="active">
			Kakao Login
		</router-link>
			
	</v-container>
</template>

<script>
import { mapState } from 'vuex'

export default {
	name: 'MemberLoginForm',
	data () {
		return {
			id: '',
			pw: ''
		}
	},
	computed: {
		...mapState(['idRules', 'pwRules'])
	},
	methods: {
		onSubmit () {
			const { id, pw } = this
			this.$emit('submit', { id, pw })
		},
		goHome() {
			this.$router.push({ name: 'Home' })
		},
	}
}
</script>
