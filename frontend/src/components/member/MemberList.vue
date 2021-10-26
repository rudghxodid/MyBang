<template>
    <div>
        <v-data-table
                    :headers="headerTitle"
                    :items="members"
                    :items-per-page="10"
                    class="elevation-1"
                      @click:row="readItem" >
                    
            </v-data-table>
            


    </div>
</template>


<script>


import { mapState, mapActions } from 'vuex'

export default {
    
    name: 'MemberList',
    data() {
        return {
             headerTitle: [
                { text: '회원번호', value: 'memberNo', width: "70px" },
                { text: '아이디', value: 'userId', width: "200px" },
                { text: '이메일', value: 'email', width: "100px" },
                { text: '이름', value: 'name', width: "100px" },
                { text: '생일', value: 'birth', width: "100px" },
                { text: '성별', value: 'sex', width: "100px" },
                { text: '전화번호', value: 'phone', width: "100px" },
                
                
            ],
            
            
        }
    },
    props: {
        members: {
            type: Array,
            require: true
        }
    },
 
 
    methods: {
        ...mapActions(['fetchMember']),
        readItem(member) {
            
            
            
            this.$router.push({ name: 'GongziReadPage',
                                    params: { memberNo: member.memberNo} } )
        }
    },
    computed: {
         ...mapState(['member'])
    }
    
    
}
</script>