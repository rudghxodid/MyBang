<template>
    <div>
        <officetel-read-form :officetel="officetel"/>
        <v-btn color="white" :to="{ name: 'OfficetelModifyPage', params: { officetelNo } }">
            내용 수정
        </v-btn>
        <!--
        <v-btn color="white" v-else  @click="officetelModifyFail">
            내용 수정
        </v-btn>
        -->
        <v-btn color="white" :to="{ name: 'BrokerHouseListPage' }">
            목록으로 돌아가기
        </v-btn>
    </div>
</template>

<script>

import OfficetelReadForm from '@/components/officetel/OfficetelReadForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'OfficetelReadPage',
    props: {
        officetelNo: {
            type: String,
            required: true
        }
    },
    data () {
        return {
            //isLogin: false,
        }
    },
    components: {
        OfficetelReadForm
    },
    computed: {
        ...mapState(['officetel']),
    },
    methods: {
        ...mapActions(['fetchOfficetel']),
        /*
        officetelModifyFail() {
            this.isLogin = false
            alert('게시자만 수정가능합니다')
            this.$router.push("login")
        },
        */
    },
    created () {
        this.fetchOfficetel(this.officetelNo)
        .catch(err => {
            alert(err.response.data.message)
            this.$router.push()
        })
    },
    mounted() {
        console.log(JSON.stringify(this.officetel))
        /*
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.isLogin = true
        }
        */
    },
}
</script>