<template>
  <div>
    <test/>
    <router-link :to="{ name: 'Mypage' }" 
      class="nav-link" 
      active-class="active">Mypage
    </router-link>
  </div>

</template>

<script>
import Test from '@/components/Test'

  export default {
    name: 'Home',

    components: {
      Test,
    },
  }
</script>
