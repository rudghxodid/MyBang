<template>
  <v-sheet>
    <router-link :to="{ name: 'Villa' }" 
      class="nav-link" 
      active-class="active">Villa(test)
    </router-link>
    <router-link :to="{ name: 'Oneroom' }" 
      class="nav-link" 
      active-class="active">Oneroom(test)
    </router-link>
    <router-link :to="{ name: 'Officetel' }" 
      class="nav-link" 
      active-class="active">Officetel(test)
    </router-link>
    <router-link :to="{ name: 'VillaRegisterPage' }" 
      class="nav-link" 
      active-class="active">Villa매물등록
    </router-link>
    <router-link :to="{ name: 'VillaListPage' }" 
      class="nav-link" 
      active-class="active">Villa매물리스트
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
