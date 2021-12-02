<template>
    <div>
        <oneroom-read-form :oneroomNo="oneroomNo"/><br/>
        <v-btn class="button_place" color="white" v-if="isLogin" :to="{ name: 'OneroomModifyPage', params: { oneroomNo: this.oneroomNo } }">
            내용 수정
        </v-btn>
        <v-btn class="button_place" color="white" v-else  @click="oneroomModifyFail">
            내용 수정
        </v-btn>
        <v-btn class="button_place" color="white" :to="{ name: 'BrokerHouseListPage' }">
            목록으로 돌아가기
        </v-btn>
    </div>
</template>

<script>

import OneroomReadForm from '@/components/oneroom/OneroomReadForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'OneroomReadPage',
    /*
    props: {
        oneroom: {
            type: Array,
            required: true
        }
    },
    */

    data () {
        return {
            oneroomNo: null,
            oneroomRead: null,
            isLogin: false,
        }
    },
    components: {
        OneroomReadForm
    },
    computed: {
        ...mapState(['session', 'agentOneroom']),
    },
    mounted() {
        if (this.agentOneroom) {
            this.isLogin = true
        }
    },
    methods: {
        // 로그인 확인하기위해서 추가 
        ...mapActions(['fetchOneroom','fetchAgentOneroom']),
        oneroomModifyFail() {
            this.isLogin = false
            alert('게시자만 수정가능합니다')
        },
    },
    created () {
        // oneroomNo를 쿼리로 읽기위해 필요한 코드
        this.oneroomNo = this.$route.query.oneroomNo
        console.log(this.oneroomNo)
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
    left: 59.3%;
    margin-right: 1%;
    margin-top: 1%;
    /*margin-left: 135px;*/
    
}
</style>
