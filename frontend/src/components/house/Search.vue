<template>
  <v-card max-width="250">
    <v-row class="mt-1 mx-1">
      <v-col>
        <v-autocomplete v-model="gu" label="구" solo></v-autocomplete>
      </v-col>
      <v-col>
        <v-autocomplete v-model="dong" label="동" solo></v-autocomplete>
      </v-col>
    </v-row>
    
    <v-menu offset-y>
      <template v-slot:activator="{on}">
        <v-text-field v-model="search" v-on="on" @keyup="searchStation" label="역" 
          class="mx-3 mb-3" append-icon="mdi-magnify" solo hide-details></v-text-field>
      </template>
      <v-list v-if="searchList" id="scrolling-techniques-7" class="overflow-y-auto" 
        max-height="350">
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
    </v-menu>
  </v-card>
</template>


<script>
import axios from 'axios'

export default {
  data () {
    return {
      search: null,
      searchList: null,
      gu: null,
      dong: null
    }
  },
  methods: {
    searchStation () {
      if (this.search) {
        axios.get(`http://localhost:7777/station/${this.search}`).then(res => {
          if (res.data.length != 0) {
            this.searchList = res.data
          } else {
            this.searchList = null
          }
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