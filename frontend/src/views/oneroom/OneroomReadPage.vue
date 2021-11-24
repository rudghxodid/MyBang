<template>
    <div>
        <oneroom-read-form :oneroom="oneroom"/>
        <v-btn color="white" :to="{ name: 'OneroomModifyPage', params: { oneroomNo } }">
            내용 수정
        </v-btn>
        <!--
        <v-btn color="white" v-else  @click="oneroomModifyFail">
            내용 수정
        </v-btn>
        -->
        <v-btn color="white" :to="{ name: 'BrokerHouseListPage' }">
            목록으로 돌아가기
        </v-btn>
    </div>
</template>

<script>

import OneroomReadForm from '@/components/oneroom/OneroomReadForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'OneroomReadPage',
    props: {
        oneroomNo: {
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
        OneroomReadForm
    },
    computed: {
        ...mapState(['oneroom']),
    },
    methods: {
        ...mapActions(['fetchOneroom']),
        /*
        oneroomModifyFail() {
            this.isLogin = false
            alert('게시자만 수정가능합니다')
            this.$router.push("login")
        },
        */
    },
    created () {
        this.fetchOneroom(this.oneroomNo)
        .catch(err => {
            alert(err.response.data.message)
            this.$router.push()
        })
    },
    mounted() {
        console.log(JSON.stringify(this.oneroom))
        /*
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.isLogin = true
        }
        */
    },
}
</script>