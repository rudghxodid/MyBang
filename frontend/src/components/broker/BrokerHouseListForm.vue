<template>
    <v-container>
      <tr>
        <th align="left" width="118"><a @click="houseRegisterPage()">매물 등록하기</a></th>
      </tr>
      <table >
          <tr>
              <th align="center" width="160">건물 유형</th>
              <th align="center" width="350">매물 이름</th>
              <th align="center" width="650">매물 주소</th>
              <th align="center" width="240">작성자</th>
          </tr>
          
          <tr v-for="villa in agentVilla" :key="villa.villaNo">
              <td align="center">{{ villa.serviceType }}</td>
              <td align="center">{{ villa.title }}</td>
              <a class=addressName @click="villaDetailPage(villa.villaNo)">
              <td align="center">{{ villa.address }}</td>
              </a>
              <td align="center">{{ villa.agentId }}</td>
          </tr>

          <tr v-for="oneroom in agentOneroom" :key="oneroom.oneroomNo">
              <td align="center">{{ oneroom.serviceType }}</td>
              <td align="center">{{ oneroom.title }}</td>
              <a class=addressName @click="oneroomDetailPage(oneroom.oneroomNo)">
              <td align="center">{{ oneroom.address }}</td>
              </a>
              <td align="center">{{ oneroom.agentId }}</td>
          </tr>
          <tr v-for="officetel in agentOfficetel" :key="officetel.officetelNo">
              <td align="center">{{ officetel.serviceType }}</td>
              <td align="center">{{ officetel.title }}</td>
              <a class=addressName @click="officetelDetailPage(officetel.officetelNo)">
              <td align="center">{{ officetel.address }}</td>
              </a>
              <td align="center">{{ officetel.agentId }}</td>
          </tr>
      </table>
    </v-container>
</template>

<script>


export default {
    name: 'BrokerHouseListForm',
    data () {
        return {
            // 페이지 구분
            //pageNum: 0,
            
        }
    },
    props: {
        agentVilla: {
            type: Array,
            required: true
        },
        agentOneroom: {
            type: Array,
            required: true
        },
        agentOfficetel: {
            type: Array,
            required: true
        },
    },
    computed: {
    },
    mounted() {
      
    },
    methods: {
        villaDetailPage(villaNo) {
          this.$router.push({
              name: 'VillaReadPage',
              query: { villaNo: villaNo }
          })
        },
        oneroomDetailPage(oneroomNo) {
          this.$router.push({
              name: 'OneroomReadPage',
              query: { "oneroomNo": oneroomNo }
          })
        },
        officetelDetailPage(officetelNo) {
          this.$router.push({
              name: 'OfficetelReadPage',
              query: { "officetelNo": officetelNo }
          })
        },
        houseRegisterPage() {
            this.$router.push({
            name: 'HouseRegisterPage',
        })
        }
    },
}
</script>

<style scoped>
.search-btn{
  position: absolute;
  top:11em;
  right: 10em;
}
table {
  width: 100%;
  border-collapse: collapse;
  border-left: none;
  border-right: none;
}
table th {
  font-size: 1.2rem;
}
table tr {
  height: 2rem;
  text-align: center;
  border-bottom: 1px solid #505050;
}
table tr:first-of-type {
  border-top: 2px solid #404040;
}
table tr td {
  padding: 1rem 0;
  font-size: 1.1rem;
}
.btn-cover {
  margin-top: 2rem;
  margin-bottom: 5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
.a .addressName{
  border-left: none;
  border-right: none;
  border-top: none;
  border-bottom: none;
  text-align: center;
  color: black;
}
a:visited { text-decoration: none; }

</style>

