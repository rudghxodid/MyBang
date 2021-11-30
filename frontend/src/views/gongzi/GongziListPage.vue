<template>
	<v-container>
		<h2 align="center">공지사항</h2>
		<gongzi-list :gongzis="gongzis"/>

		<v-btn v-if="auth" @click="gongziRegister">글쓰기</v-btn>

		
	</v-container>
</template>

<script>
import GongziList from '@/components/gongzi/GongziList.vue'
import { mapState, mapActions } from 'vuex'

export default {
	name: 'GongziListPage',
	components: {
		GongziList
	},
	data() {
		return{
			auth: null
		}
	},
	computed: {
		...mapState(['gongzis', 'userInfo'])
	},
	mounted () {
		this.fetchGongziList()
		if (this.userInfo.authList) {
			if (this.userInfo.authList[0].auth == '관리자') {
				this.auth = 1
			}
		}
	},
	methods: {
		...mapActions(['fetchGongziList']),
		gongziRegister() {
			this.$router.push({ name: 'GongziRegisterPage' })
		}
	}
}
</script>