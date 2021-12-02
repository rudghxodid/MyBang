<template>
    <div>
        <h1>내가 올린 부동산</h1>
        <broker-house-list-form :agentVilla="agentVilla" :agentOneroom="agentOneroom" :agentOfficetel="agentOfficetel"/>
    </div>
</template>

<script>

import BrokerHouseListForm from '@/components/broker/BrokerHouseListForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'BrokerHouseListPage',
    components: { 
        BrokerHouseListForm 
    },
    data () {
        return {
        }
    },
    computed: {
         ...mapState(['session', 'agentVilla', 'agentOneroom', 'agentOfficetel' ])
    },
    mounted () {
        if(this.session){
            this.fetchAgentVilla(this.session)
            this.fetchAgentOneroom(this.session)
            this.fetchAgentOfficetel(this.session)
        }
    },
    methods: {
      ...mapActions(['fetchAgentVilla', 'fetchAgentOneroom', 'fetchAgentOfficetel' ]) 
    },
    created () {
        
    }
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
    color: #98BAE7;
}
</style>