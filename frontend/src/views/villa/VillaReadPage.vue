<template>
    <div>
        <villa-read-form :villa="villa"/>
        <v-btn color="white" :to="{ name: 'VillaModifyPage', params: { villaNo } }">
            내용 수정
        </v-btn>
        <!--
        <v-btn color="white" v-else  @click="villaModifyFail">
            내용 수정
        </v-btn>
        -->
        <v-btn color="white" :to="{ name: 'VillaListPage' }">
            리스트로 돌아가기
        </v-btn>
    </div>
</template>

<script>

import VillaReadForm from '@/components/villa/VillaReadForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'VillaReadPage',
    props: {
        villaNo: {
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
        VillaReadForm
    },
    computed: {
        ...mapState(['villa']),
    },
    methods: {
        ...mapActions(['fetchVilla']),
        /*
        villaModifyFail() {
            this.isLogin = false
            alert('게시자만 수정가능합니다')
            this.$router.push("login")
        },
        */
    },
    created () {
        this.fetchVilla(this.villaNo)
        .catch(err => {
            alert(err.response.data.message)
            this.$router.push()
        })
    },
    mounted() {
        console.log(JSON.stringify(this.villa))
        /*
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.isLogin = true
        }
        */
    },
}
</script>