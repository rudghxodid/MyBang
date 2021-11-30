<template>
  <div>
      <div>
        <h2>빌라 등록</h2>
      </div>
        <house-register-form @submit="onSubmit"/>
  </div>  
</template>

<script>

import HouseRegisterForm from '@/components/houseUpload/HouseRegisterForm.vue'
import axios from 'axios'

export default {
  name: 'HouseRegisterPage',
  components: {
    HouseRegisterForm
  },
  data() {
    return {
       
    }
  },
  methods: {
        onSubmit (payload) {
            const { image, deposit, roomType, manageCost, manageCostIncChk, sizeM2, size, floorAll, floor, roomDirection, options, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId } = payload

            let serviceTypeKor = ''

            switch (serviceType) {
              case 'villa' :
                serviceTypeKor = '빌라'
                break
              case 'oneroom' :
                serviceTypeKor = '원룸'
                break
              case 'officetel' :
                serviceTypeKor = '오피스텔'
                break
            }

            let manageCostStr = ''
            for (let i = 0; i < manageCostIncChk; i++) {
              manageCostStr += manageCostIncChk[i] 
            }
            console.log(manageCostStr)
            let manageCostInc = manageCostStr.slice(0, -1)

            axios.post(`http://localhost:7777/${serviceType}/register`, { image, deposit, roomType, manageCost, manageCostInc, sizeM2, size, floorAll, floor, roomDirection, options, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType:serviceTypeKor, userIntro, userName, url, updatedAt, agentId })
                    .then(res => {
                        console.log(res)
                        alert('저장 성공! ')
                        this.$router.push({
                            name: 'BrokerHouseListPage',
                        })
                        this.$router.go()
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
  
}
</style>