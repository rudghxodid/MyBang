<template>
<div id="member">
    <h3>관리자 페이지</h3>
    
    <member-list :members="members"/>  
<v-btn @click="GongziRegister">공지작성</v-btn>
<v-btn @click="GongziList">공지목록</v-btn>
    
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
    data() {
        return {
            selected: ''
        }
    },
    
    computed: {
        ...mapState(['members'])
    },
    mounted () {
        this.fetchMemberList()
    },
    
    methods: {
        ...mapActions(['fetchMemberList']),
       
        GongziRegister() {
            this.$router.push('/gongzi/create')
        },
        GongziList() {
            this.$router.push('/gongzi')
        }
    }
}
</script>