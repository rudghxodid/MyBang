<template>
  <div>
      <div>
        <h2>원룸 등록</h2>
      </div>
        <oneroom-register-form @submit="onSubmit"/>
  </div>
</template>

<script>

import OneroomRegisterForm from '@/components/oneroom/OneroomRegisterForm.vue'
import axios from 'axios'

export default {
  name: 'OneroomRegisterPage',
  components: {
    OneroomRegisterForm
  },
  data() {
    return {

    }
  },
  methods: {
        onSubmit (payload) {
            const { image, deposit, roomType, manageCost, manageCostInc, sizeM2, size, floorAll, floor, roomDirection, options, pets, parking, elevator, moveinDate, title,
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId } = payload
            axios.post('http://localhost:7777/oneroom/register', { image, deposit, roomType, manageCost, manageCostInc, sizeM2, size, floorAll, floor, roomDirection, options, pets, parking, elevator, moveinDate, title,
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId })
                    .then(res => {
                         alert('저장 성공! - ' + res)
                         //this.$router.push("list");
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

* {
  font-family: 'Noto Sans KR', sans-serif;
  margin: 0 auto;
}

h2 {
  text-align: center;
  color: gray;
}
</style>