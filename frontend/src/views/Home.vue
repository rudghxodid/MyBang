<template>
  <v-sheet>
     <router-link :to="{ name: 'Villa' }" 
      class="nav-link" 
      active-class="active">Villa(test)
    </router-link>
    <main-page></main-page>
  </v-sheet>
</template>


<script>
import MainPage from './MainPage.vue'

export default {
  components: { 
    MainPage 
  },
  name: 'Home',
  data() {
    return {
      
    }
  }
}
</script>
