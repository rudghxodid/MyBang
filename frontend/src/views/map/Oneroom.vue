<template>
  <v-sheet class="fill-height">
    <Map :houseList="oneroomList"></Map>
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
      oneroomList: []
    }
  },
  mounted () {
    axios.get('http://localhost:7777/oneroom/lists').then(res => {
      this.oneroomList = res.data
    })
  },
}
</script>