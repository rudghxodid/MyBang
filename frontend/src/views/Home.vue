<template>
  <v-sheet>
     <router-link :to="{ name: 'Villa' }" 
      class="nav-link" 
      active-class="active">Villa(test)
    </router-link>
    <router-link :to="{ name: 'VillaRegisterPage' }" 
      class="nav-link" 
      active-class="active">Villa매물등록
    </router-link>
    <router-link :to="{ name: 'OneroomRegisterPage' }" 
      class="nav-link" 
      active-class="active">원룸매물등록
    </router-link>
    <router-link :to="{ name: 'OfficetelRegisterPage' }" 
      class="nav-link" 
      active-class="active">오피스텔매물등록
    </router-link>
    <router-link :to="{ name: 'BrokerHouseListPage' }" 
      class="nav-link" 
      active-class="active">사업자 등록한거 확인
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
