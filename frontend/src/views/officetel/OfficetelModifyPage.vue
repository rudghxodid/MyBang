<template>
  <div>
    <officetel-modify-form :officetel="officetel" @submit="onSubmit"/>
  </div>  
</template>

<script>

import OfficetelModifyForm from '@/components/officetel/OfficetelModifyForm.vue'
import axios from 'axios'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'OfficetelModifyPage',
    components: {
        OfficetelModifyForm
    },
    props: {
        officetelNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['officetel'])
    },
    methods: {
        ...mapActions(['fetchOfficetel']),
        onSubmit (payload) {
            const { image, rent, deposit, roomType, manageCost, manageCostIncChk, sizeM2, size, floorAll, floor, roomDirection, optionsChk, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId } = payload

            let manageCostStr = ''
            let manageCostInc = ''

            if (manageCostIncChk.length != 0) {
              for (let i = 0; i < manageCostIncChk.length; i++) {
                manageCostStr += manageCostIncChk[i] + ', '
              }
              manageCostInc = manageCostStr.slice(0, -2)
            }

            let optionsStr = ''
            let options = ''

            if (optionsChk.length != 0) {
              for (let i = 0; i < optionsChk.length; i++) {
                optionsStr += optionsChk[i] + ', '
              }
              options = optionsStr.slice(0, -2)
            }
            
            axios.put(`http://localhost:7777/officetel/${this.officetelNo}`, { image, rent, deposit, roomType, manageCost, manageCostInc, sizeM2, size, floorAll, floor, roomDirection, options, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId })
                .then(res => {
                    console.log(res)
                    alert('수정 성공')
                this.$router.push({
                    name: 'OfficetelReadPage',
                    query: { officetelNo: this.officetelNo }
                })
            })
            .catch(err => {
                alert(err.response.data.message)
            })
        }
    },
    created () {
        this.fetchOfficetel(this.officetelNo)
            .catch(err => {
                alert(err.response.data.message)
                this.$router.back()
            })
    }
}
</script>

