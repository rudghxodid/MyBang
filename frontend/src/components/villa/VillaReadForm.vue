<template>
    <div class="read-page">
        <InfoDetail :info="villa"></InfoDetail>
    </div>
</template>

<script>


import { mapState, mapActions } from 'vuex'
import InfoDetail from '../map/InfoDetail.vue'

export default {
    name: 'VillaReadForm',
    components: {
        InfoDetail
    },
    props: {
        villaNo: {},  
    },
    data() {
        return {
        }
    },
    computed: {
        ...mapState(['villa']),
    },
    created() {
        console.log(this.villa)
        this.villaNo = this.$route.query.villaNo
    },
    mounted () {
        this.fetchVilla(this.villaNo)
    },
    methods: {
        ...mapActions(['fetchVilla'])
    }
}
</script>

<style class="scss" scoped>

.read-page {
  width: 800px;
}
</style>