<template>
    <div>
        <product-read-form :product="product"/>
        <v-btn color="white" :to="{ name: 'ProductModifyPage', params: { productNo } }">
            내용 수정
        </v-btn>
        <!--
        <v-btn color="white" v-else  @click="productModifyFail">
            내용 수정
        </v-btn>
        -->
        <v-btn color="white" :to="{ name: 'ProductListPage' }">
            리스트로 돌아가기
        </v-btn>
    </div>
</template>

<script>

import ProductReadForm from '@/components/product/ProductReadForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'ProductReadPage',
    props: {
        productNo: {
            type: String,
            required: true
        }
    },
    data () {
        return {
            //isLogin: false,
        }
    },
    components: {
        ProductReadForm
    },
    computed: {
        ...mapState(['product']),
    },
    methods: {
        ...mapActions(['fetchProduct']),
        /*
        productModifyFail() {
            this.isLogin = false
            alert('게시자만 수정가능합니다')
            this.$router.push("login")
        },
        */
    },
    created () {
        this.fetchProduct(this.productNo)
        .catch(err => {
            alert(err.response.data.message)
            this.$router.push()
        })
    },
    mounted() {
        console.log(JSON.stringify(this.product))
        /*
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.isLogin = true
        }
        */
    },
}
</script>