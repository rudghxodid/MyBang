<template>
    <div>
        <h1>빌라 리스트</h1>
        <villa-list-form :villas="villas"/>
    </div>
</template>

<script>

import VillaListForm from '@/components/villa/VillaListForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'VillaListPage',
    components: {
        VillaListForm
    },
    data () {
        return {
            pageArray: []
        }
    },
    computed: {
        ...mapState(['villas'])
    },
    mounted () {
        this.fetchVillaList()
    },
    methods: {
        ...mapActions(['fetchVillaList'])   
    },
}

</script>

<style scoped>
@font-face {
    font-family: 'GowunDodum-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/GowunDodum-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
h1 {
    font-family: 'GowunDodum-Regular';
    font-size: 30px;
    text-align: center;
    padding: 5% 0% 5% 0%;
}
</style>