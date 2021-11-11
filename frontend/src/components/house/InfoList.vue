<template>
  <div>
    <v-card width="400" style="float:right;" v-if="villaList" class="overflow-y-auto"
      id="scrolling-techniques-7" max-height="700"> 
      <!--
      <v-list v-for="list in villaList" :key="list.index">
        <v-list-item-group>
          <v-list-item two-line>
            <v-list-item-title>{{list.title}}</v-list-item-title>
            <v-list-item-subtitle>{{list.description}}</v-list-item-subtitle>
          </v-list-item>
        </v-list-item-group>
      </v-list>
        -->
    </v-card>
  
  </div>
</template>


<script>


export default {
  components: {

  },
  data() {
    return {
      villaList: []
    }
  },
  computed: {
  
  },
  mounted() {

  },
  methods: {

  }
}
</script>

