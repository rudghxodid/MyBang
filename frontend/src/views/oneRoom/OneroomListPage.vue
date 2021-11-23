<template>
    <div>
        <h1>원룸</h1>
        <oneroom-list-form :oneroomList="oneroomList"/>
    </div>
</template>

<script>

import OneroomListForm from '@/components/oneroom/OneroomListForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'OneroomListPage',
    components: {
        OneroomListForm
    },
    data () {
        return {
            pageArray: []
        }
    },
    computed: {
        ...mapState(['oneroomList'])
    },
    mounted () {
        this.fetchOneroomList()
    },
    methods: {
        ...mapActions(['fetchOneroomList'])   
    },
}

</script>