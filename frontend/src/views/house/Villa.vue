<template>
  <v-sheet class="fill-height">
    <Map :houseList="villaList"></Map>
  </v-sheet>
</template>


<script>
import Map from '@/components/house/Map'
import axios from 'axios'

export default {
  components: {
    Map,
  },
  data () {
    return {
      villaList: []
    }
  },
  mounted () {
    axios.get('http://localhost:7777/villa/lists').then(res => {
      this.villaList = res.data
    })
  },
}
</script>