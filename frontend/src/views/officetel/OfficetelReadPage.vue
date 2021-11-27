<template>
    <div>
        <officetel-read-form :officetelNo="officetelNo"/><br/>
        <v-btn class="button_place" color="white" v-if="isLogin" :to="{ name: 'OfficetelModifyPage', params: { officetelNo: this.officetelNo } }">
            내용 수정
        </v-btn>
        <v-btn class="button_place" color="white" v-else  @click="officetelModifyFail">
            내용 수정
        </v-btn>
        <v-btn  color="white" :to="{ name: 'BrokerHouseListPage' }">
            목록으로 돌아가기
        </v-btn>
    </div>
</template>

<script>

import OfficetelReadForm from '@/components/officetel/OfficetelReadForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'OfficetelReadPage',
    /*
    props: {
        officetel: {
            type: Array,
            required: true
        }
    },
    */

    data () {
        return {
            officetelNo: null,
            officetelRead: null,
            isLogin: false,
        }
    },
    components: {
        OfficetelReadForm
    },
    computed: {
        ...mapState(['session', 'agentOfficetel']),
    },
    mounted() {
        if (this.agentOfficetel) {
            this.isLogin = true
        }
    },
    methods: {
        // 로그인 확인하기위해서 추가 
        ...mapActions(['fetchOfficetel','fetchAgentOfficetel']),
        officetelModifyFail() {
            this.isLogin = false
            alert('게시자만 수정가능합니다')
        },
    },
    created () {
        // officetelNo를 쿼리로 읽기위해 필요한 코드
        this.officetelNo = this.$route.query.officetelNo
        console.log(this.officetelNo)
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
    margin-left: 1325px;
    margin-right: 15px;
}
</style>
