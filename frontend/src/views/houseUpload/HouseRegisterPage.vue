<template>
  <div>
      <div>
        <h1>매물 등록</h1>
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
            const { image, rent, deposit, roomType, manageCost, manageCostIncChk, sizeM2, size, floorAll, floor, roomDirection, optionsChk, pets, parking, elevator, moveinDate, title, 
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
        
            axios.post(`http://localhost:7777/${serviceType}/register`, { image, rent, deposit, roomType, manageCost, manageCostInc, sizeM2, size, floorAll, floor, roomDirection, options, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType:serviceTypeKor, userIntro, userName, url, updatedAt, agentId })
                    .then(res => {
                        console.log(res)
                        alert('저장 성공! ')
                        this.$router.push({
                            name: 'BrokerHouseListPage',
                        })
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