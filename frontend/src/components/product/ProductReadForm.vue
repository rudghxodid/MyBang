<template>
    <v-container>

            <div class="mx-3"> 
                <v-icon color="black" size="30px"></v-icon>
                    이미지
                <div class="mx-1">
                    <v-img max-height="400" max-width="350">
                    <img :src="require(`@/assets/productUploadImage/${this.product.image}`)"></v-img>
                </div> 
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">home</v-icon>
                    특징
                <v-list-item class="mx-1">
                    <v-text-field placeholder="건물의 특징을 40자 이내로 적어주세요." :value="product.title"  disabled></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                상세설명
                <v-list-item class="mx-1">
                    <v-text-field placeholder="자세한 정보를 적어주세요." :value="product.description"  disabled></v-text-field>
                </v-list-item> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                보증금
                <div class="mx-1">
                    <v-text-field placeholder="보증금의 가격을 입력해주세요."  :value="product.deposit"  disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                가격
                <div class="mx-1">
                    <v-text-field placeholder="가격을 입력해주세요." :value="product.price"  disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                층 위치
                <div class="mx-1">
                    <v-text-field placeholder="몇 층에 위치해 있나요?" :value="product.floor"  disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                주소
                <div class="mx-1">
                    <v-text-field placeholder="주소를 입력해주세요." :value="product.address"  disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                면적(평 수)
                <div class="mx-1">
                    <v-text-field placeholder="방의 평수를 입력해주세요." :value="product.size"  disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                면적(제곱미터)
                <div class="mx-1">
                    <v-text-field placeholder="방의 면적을 제곱미터 단위로 입력해주세요." :value="product.size_m2"  disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                광고 상태
                <div class="mx-1">
                    <v-text-field placeholder="광고여부의 상태 변환을 어케해야하지" :value="product.status"  disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                건물 유형
                <div class="mx-1">
                    <v-text-field placeholder="건물 유형 빌라? 아파트? 원룸? 투룸? 아래에 메뉴바 나오게하기" :value="product.room_type"  disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                옵션
                <div class="mx-1">
                    <v-text-field placeholder="옵션의 여부를 입력해주세요." :value="product.manage_cost_inc"  disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개사무소
                <div class="mx-1">
                    <v-text-field placeholder="사무소의 이름을 입력해주세요." :value="product.agent_name"  disabled></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                전화번호
                <div class="mx-1">
                    <v-text-field placeholder="사업자의 전화번호를 입력해주세요." :value="product.agent_mobile"  disabled></v-text-field>
                </div> 
            </div> 

    </v-container>
</template>

<script>

export default {
    name: 'ProductReadForm',
    props: {
        product: {
            type: Object,
            required: true
        },
    },
}
</script>