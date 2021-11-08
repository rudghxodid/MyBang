<template>
  <v-card>
    <v-toolbar>
      <v-text-field v-model="search" @keyup="searchStation" label="역" append-icon="mdi-magnify" solo hide-details></v-text-field>
    </v-toolbar>
    <v-card v-if="searchList" flat>
      <v-list>
        <v-list-item-group v-for="list in searchList" :key="list.index">
            <v-list-item @click="selectStation(list.name, list.lat, list.lng)">
              <v-list-item-content>
              <v-list-item-subtitle>
                {{list.name}}
              </v-list-item-subtitle>
            </v-list-item-content>   
            </v-list-item>
          </v-list-item-group>
      </v-list>
    </v-card>
  </v-card>
</template>


<script>
import axios from 'axios'

export default {
  data () {
    return {
      search: null,
      searchList: null
    }
  },
  methods: {
    searchStation () {
      if (this.search) {
        axios.get(`http://localhost:7777/station/${this.search}`).then(res => {
          console.log(res.data)
          this.searchList = res.data
        }) 
      }   
    },
    selectStation (name, lat, lng) {
      this.search = name
      this.$emit('selectStation', lat, lng)
      this.searchList = null
    }
  }
}
</script>