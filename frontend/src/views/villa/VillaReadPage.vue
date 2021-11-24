<template>
    <div>
        <villa-read-form :villa="villaRead"/>
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
//import { mapState, mapActions } from 'vuex'
import axios from 'axios'
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
    },
    mounted() { 
            axios.get(`http://localhost:7777/villa/${this.villaNo}`).then(
                res => { res.data = this.villaRead})    
        }
}
</script>

