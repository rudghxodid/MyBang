<template>
	<v-container id="member">
		<div align="center">
			<h3>관리자 페이지</h3>
		</div>
		<member-list/>  
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
		
	}
}
</script>