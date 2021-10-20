<template>
  <v-app>
    <v-main>
      <header></header>
      <router-view/>
      <footer></footer>
    </v-main>
  </v-app>
</template>

<script>
import Footer from '@/layouts/Footer'
import Header from '@/layouts/Header'


export default {
  name: 'App',
  components: {
    Header,
    Footer
    
  },
    
  data: () => ({
    
  }),
};
</script>
