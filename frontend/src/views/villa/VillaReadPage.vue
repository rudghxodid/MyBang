<template>
    <div>
        <villa-read-form :villaNo="villaNo"/>
        <v-btn color="white" :to="{ name: 'VillaModifyPage', params: { villaNo } }">
            내용 수정
        </v-btn>
        <!--
        <v-btn color="white" v-else  @click="villaModifyFail">
            내용 수정
        </v-btn>
        -->
        <v-btn color="white" :to="{ name: 'BrokerHouseListPage' }">
            목록으로 돌아가기
        </v-btn>
    </div>
</template>

<script>

import VillaReadForm from '@/components/villa/VillaReadForm.vue'
import { mapActions } from 'vuex'

export default {
    name: 'VillaReadPage',
    /*
    props: {
        villaNo: {
            required: true
        }
    },
    */
    data () {
        return {
            villaNo: null,
            villaRead: null
        }
    },
    components: {
        VillaReadForm
    },
    computed: {
    },
    methods: {
        ...mapActions(['fetchVilla'])
        /*
        villaModifyFail() {
            this.isLogin = false
            alert('게시자만 수정가능합니다')
            this.$router.push("login")
        },
        */
    },
    created () {
        this.villaNo = this.$route.query.villaNo
        console.log(this.villaNo)
    },
    mounted() { 
        
    }
}
</script>

