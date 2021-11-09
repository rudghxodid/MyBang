<template>
    <div>
        <product-list-form :products="products"/>
    </div>
</template>

<script>

import ProductListForm from '@/components/product/ProductListForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'ProductListPage',
    components: {
        ProductListForm
    },
    data () {
        return {
            pageArray: []
        }
    },
    computed: {
        ...mapState(['products'])
    },
    mounted () {
        this.fetchProductList()
    },
    methods: {
        ...mapActions(['fetchProductList'])   
    },
}

</script>