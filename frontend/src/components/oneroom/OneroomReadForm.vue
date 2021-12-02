<template>
    <div class="read-page">
        <InfoDetail :info="oneroom"></InfoDetail>
    </div>
</template>

<script>


import { mapState, mapActions } from 'vuex'
import InfoDetail from '../map/InfoDetail.vue'

export default {
    name: 'OneroomReadForm',
    components: {
        InfoDetail
    },
    props: {
        oneroomNo: {},  
    },
    data() {
        return {
        }
    },
    computed: {
        ...mapState(['oneroom']),
    },
    created() {
        console.log(this.oneroom)
        this.oneroomNo = this.$route.query.oneroomNo
    },
    mounted () {
        this.fetchOneroom(this.oneroomNo)
    },
    methods: {
        ...mapActions(['fetchOneroom'])
    }
}
</script>

<style class="scss" scoped>

.read-page {
  width: 800px;
}
</style>