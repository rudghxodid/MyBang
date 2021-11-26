<template>
	<v-container>
		<h2 align="center">공지사항</h2>
		<gongzi-list :gongzis="gongzis"/>
		<v-btn @click="gongziRegister">공지작성</v-btn>
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
		
		}
	},
	computed: {
		...mapState(['gongzis'])
	},
	mounted () {
		this.fetchGongziList()
	},
	methods: {
		...mapActions(['fetchGongziList']),
		gongziRegister() {
			this.$router.push({ name: 'GongziRegisterPage' })
		}
	}
}
</script>