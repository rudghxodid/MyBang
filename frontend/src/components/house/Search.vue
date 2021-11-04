<template>
    <v-toolbar>
      <v-text-field v-model="search" @keyup.enter="searchStation" label="역" solo hide-details></v-text-field>
      <v-btn @click="searchStation" icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>
    </v-toolbar>
</template>


<script>
import axios from 'axios'

export default {
  data () {
    return {
      search: null
    }
  },
  methods: {
    searchStation () {
      const search = this.stationName(this.search)

      axios.get(`http://localhost:7777/station/${search}`).then(res => {
        console.log(res.data)
        this.$emit('searchStation', res.data.lat, res.data.lng)
      }) 
      
    },
    stationName (name) {
      if (name.indexOf('역') == -1) {
        return name
      } else if (name.indexOf('역') == 0) {
        if (name.indexOf('역', 1) == -1) {
          return name
        } else {
          return name.slice(0, -1)
        }
      }
      else {
        return name.slice(0, -1)
      }
    }
  }
}
</script>