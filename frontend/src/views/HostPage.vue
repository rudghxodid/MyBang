<template>
	<v-container id="member">
		<h3>관리자 페이지</h3>
		<member-list/>  
		<v-btn @click="GongziRegister">공지작성</v-btn>
		<v-btn @click="GongziList">공지목록</v-btn>
	</v-container>
</template>


<script>
import MemberList from '@/components/member/MemberList.vue'

export default {
	name: 'HostPage',
	components: {
		MemberList
	},
	data() {
		return {
			
		}
	},
	methods: {
		GongziRegister() {
			this.$router.push({ name: 'GongziRegisterPage' })
		},
		GongziList() {
			this.$router.push({ name: 'GongziListPage' })
		}
	}
}
</script>