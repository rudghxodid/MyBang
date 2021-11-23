<template>
  <v-sheet class="fill-height">
    <Map :houseList="officetelList"></Map>
  </v-sheet>
</template>


<script>
import Map from '@/components/map/Map'
import axios from 'axios'

export default {
  components: {
    Map,
  },
  data () {
    return {
      officetelList: []
    }
  },
  mounted () {
    axios.get('http://localhost:7777/officetel/lists').then(res => {
      this.officetelList = res.data
    })
  },
}
</script>