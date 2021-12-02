<template>
    <div class="read-page">
        <InfoDetail :info="officetel"></InfoDetail>
    </div>
</template>

<script>


import { mapState, mapActions } from 'vuex'
import InfoDetail from '../map/InfoDetail.vue'

export default {
    name: 'OfficetelReadForm',
    components: {
        InfoDetail
    },
    props: {
        officetelNo: {},  
    },
    data() {
        return {
        }
    },
    computed: {
        ...mapState(['officetel']),
    },
    created() {
        console.log(this.officetel)
        this.officetelNo = this.$route.query.officetelNo
    },
    mounted () {
        this.fetchOfficetel(this.officetelNo)
    },
    methods: {
        ...mapActions(['fetchOfficetel'])
    }
}
</script>

<style scoped>

.read-page {
  width: 800px;
}
</style>