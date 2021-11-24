<template>
    <v-container>
            <div class="mx-3"> 
                <v-icon color="black" size="30px">home</v-icon>
                사진
                <div class="mx-1">
                   <img height="300px" width="500px" :src="require()" aspect-ratio="1">
                </div>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    보증금
                <v-list-item class="mx-1">
                    <v-text-field placeholder="건물의 특징을 40자 이내로 적어주세요." :value="oneroom.deposit" required disabled></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방구조
                <div class="mx-1">
                    <v-text-field placeholder="방구조"  :value="oneroom.roomType" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비
                <div class="mx-1">
                    <v-text-field placeholder="관리비" :value="oneroom.manageCost" required disabled></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비 포함 항목
                <div class="mx-1">
                    <v-text-field placeholder="관리비 포함 항목" :value="oneroom.manageCostInc" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                크기
                <div class="mx-1">
                    <v-text-field placeholder="제곱미터단위로 입력해주세요" :value="oneroom.sizeM2" required disabled></v-text-field>
                </div> 
                <div class="mx-1">
                    <v-text-field placeholder="방의 평수를 입력해주세요." :value="oneroom.size" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                층수
                <div class="mx-1">
                    <v-text-field placeholder="건물 총 층수" :value="oneroom.floorAll" required disabled></v-text-field>
                </div>
                <div class="mx-1">
                    <v-text-field placeholder="해당 층" :value="oneroom.floor" required disabled></v-text-field>
                </div>  
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방향
                <div class="mx-1">
                    <v-text-field placeholder="남향? 북향?" :value="oneroom.roomDirection" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                옵션
                <div class="mx-1">
                    <v-select placeholder="옵션" :value="oneroom.options" required disabled></v-select>
                </div> 
            </div>
           
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                반려동물
                <div class="mx-1">
                    <v-text-field placeholder="반려동물" :value="oneroom.pets" required disabled></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                주차
                <div class="mx-1">
                    <v-text-field placeholder="주차" :value="oneroom.parking" required disabled></v-text-field>
                </div> 
            </div>
            
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                엘리베이터
                <div class="mx-1">
                    <v-text-field  placeholder="엘리베이터" :value="oneroom.elevator" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                입주가능일
                <div class="mx-1">
                    <v-text-field placeholder="입주가능일" :value="oneroom.moveinDate" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                제목
                <div class="mx-1">
                    <v-text-field placeholder="제목" :value="oneroom.title" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                상세설명
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" :value="oneroom.description" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개인 연락처
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" :value="oneroom.agentMobile" required disabled></v-text-field>
                </div> 
            </div>
    </v-container>
</template>

<script>

export default {
    name: 'OneroomReadForm',
    props: {
        oneroom: {
            type: Object,
            required: true
        },
        
    },
}
</script>