<template>
	<v-container >
		<h2 align="center">공지사항</h2>
		<gongzi-read/>
	</v-container>
</template>

<script>
import GongziRead from '@/components/gongzi/GongziRead.vue'
import { mapActions } from 'vuex'

export default {
	name: 'GongziReadPage',
	components: {
		GongziRead
	},
	data () {
		return {
			gongziNo: null
		}
	},
	mounted () {
		this.gongziNo = this.$route.query.gongziNo
		this.fetchGongzi(this.gongziNo)
	},
	methods: {
		...mapActions(['fetchGongzi']),
	}
    
}
</script>