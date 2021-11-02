<template>
  <div>
      <div>
        <h2>매물 정보수정</h2>
      </div>
        <product-modify-form :product="product" @submit="onSubmit"/>
  </div>  
</template>

<script>

import ProductModifyForm from '@/components/product/ProductModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'ProductModifyPage',
    components: {
        ProductModifyForm
    },
    props: {
        productNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['product'])
    },
    methods: {
        ...mapActions(['fetchProduct']),
        onSubmit (payload) {
            const { title, image, description, deposit, price, agent_name, agent_mobile, floor, address, size, size_m2, status, room_type, manage_cost_inc } = payload
            axios.put(`http://localhost:7777/product/${this.productNo}`, {  title, image, description, deposit, price, agent_name, agent_mobile, floor, address, size, size_m2, status, room_type, manage_cost_inc })
            .then(res => {
                alert('수정 성공')
            this.$router.push({
              name: 'ProductReadPage',
              params: { productNo: res.data.productNo.toString() }
            })
          })
            .catch(err => {
                alert(err.response.data.message)
            })
        }
    },
    created () {
        this.fetchProduct(this.productNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    }
}
</script>