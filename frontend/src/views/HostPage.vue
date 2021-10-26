<template>
<div id="member">
    <h3>관리자 페이지</h3>
     <member-list :members="members"/>
</div>
</template>


<script>
import MemberList from '@/components/member/MemberList.vue'
import { mapState, mapActions } from 'vuex'



export default {
    name: 'HostPage',
    components: {
        MemberList
    },
    
    computed: {
        ...mapState(['members'])
    },
    mounted () {
        this.fetchMemberList()
    },
    
    methods: {
        ...mapActions(['fetchMemberList'])
    }
}
</script>