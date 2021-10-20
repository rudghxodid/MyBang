<template>
  <v-app>
    <v-main>
      <Header />
        <router-view/>
      <Footer />
    </v-main>
  </v-app>
</template>

<script>

import Header from '../src/layouts/Header'
import Footer from '../src/layouts/Footer'

export default {
  name: 'App',
  components: { Header, Footer },
 

  data: () => ({
    
  }),
};
</script>
