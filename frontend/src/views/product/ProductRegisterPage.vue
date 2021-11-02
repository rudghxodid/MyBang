<template>
  <div>
      <div align="center">
        <h2>매물 등록</h2>
      </div>
        <product-register-form @submit="onSubmit"/>
  </div>  
</template>

<script>

import ProductRegisterForm from '@/components/product/ProductRegisterForm.vue'
import axios from 'axios'

export default {
  name: 'ProductRegisterPage',
  components: {
    ProductRegisterForm
  },
  data() {
    return {
       
    }
  },
  methods: {
        onSubmit (payload) {
            const { title, image, description, deposit, price, agent_name, agent_mobile, floor, address, size, size_m2, status, room_type, manage_cost_inc } = payload
            axios.post('http://localhost:7777/product/register', { title, image, description, deposit, price, agent_name, agent_mobile, floor, address, size, size_m2, status, room_type, manage_cost_inc })
                    .then(res => {
                         alert('저장 성공! - ' + res)
                         this.$router.push("list");
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
    }
}
</script>