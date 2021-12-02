<template>
    <div>
        <villa-read-form :villaNo="villaNo"/>
        <v-btn class="button_place" color="secondary" v-if="isLogin" :to="{ name: 'VillaModifyPage', params: { villaNo: this.villaNo } }">
            내용 수정
        </v-btn>
        <v-btn class="button_place" color="white" v-else  @click="villaModifyFail">
            내용 수정
        </v-btn>
        <v-btn class="button_place"  color="white" :to="{ name: 'BrokerHouseListPage' }">
            목록으로 돌아가기
        </v-btn>
    </div>
</template>

<script>

import VillaReadForm from '@/components/villa/VillaReadForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'VillaReadPage',
    /*
    props: {
        villa: {
            type: Array,
            required: true
        }
    },
    */

    data () {
        return {
            villaNo: null,
            villaRead: null,
            isLogin: false,
        }
    },
    components: {
        VillaReadForm
    },
    computed: {
        ...mapState(['session', 'agentVilla']),
    },
    mounted() {
        if (this.agentVilla) {
            this.isLogin = true
        }
    },
    methods: {
        // 로그인 확인하기위해서 추가 
        ...mapActions(['fetchVilla','fetchAgentVilla']),
        villaModifyFail() {
            this.isLogin = false
            alert('게시자만 수정가능합니다')
        },
    },
    created () {
        // villaNo를 쿼리로 읽기위해 필요한 코드
        this.villaNo = this.$route.query.villaNo
        console.log(this.villaNo)
    },
    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Lora&family=Noto+Sans&display=swap');

* {
  font-family: 'Noto Sans KR', sans-serif;
  margin: 0 auto;
}

.button_place {
    left: 58%;
    margin-right: 1%;
    margin-top: 1%;
    /*margin-left: 135px;*/
    
}
</style>
