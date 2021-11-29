<template>
  <div>
      <div>
        <h2>오피스텔 정보수정</h2>
      </div>
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
            const { image, deposit, roomType, manageCost, manageCostInc, sizeM2, size, floorAll, floor, roomDirection, options, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId } = payload
            axios.put(`http://localhost:7777/officetel/${this.officetelNo}`, { image, deposit, roomType, manageCost, manageCostInc, sizeM2, size, floorAll, floor, roomDirection, options, pets, parking, elevator, moveinDate, title, 
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

