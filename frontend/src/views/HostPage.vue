<template>
<div id="member">
    <h3>관리자 페이지</h3>
    <select v-model="selected" multiple @click="SelectPage">
    <option disabled value="">골라주세요</option>
    <option>회원</option>
    <option>공지사항</option>
    <option>매물</option>
</select>
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
        SelectPage() {
            if(this.selected == '회원') {
                this.$router.push({name: 'MemberList'})
            }
            else if(this.selected == '매물') {
                this.$router.push({name: 'BrokerRegister'})
            }
        },
        GongziRegister() {
            this.$router.push('/gongzi/create')
        },
        GongziList() {
            this.$router.push('/gongzi')
        }
    }
}
</script>