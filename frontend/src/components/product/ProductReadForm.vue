<template>
    <v-container>
            <div class="mx-3"> 
                <v-icon color="black" size="30px"></v-icon>
                    사진 등록
                <div class="mx-1">
                    대표사진
                    <input type="file" id="files" ref="files" height="100%" width="100%" multiple v-on:change="handleFileUpload()">
                </div>
                <!--
                <div class="mx-1">
                    화장실
                    <input type="file" id="files" ref="files" height="100%" width="100%" multiple v-on:change="handleFileUpload()">
                </div>
                <div class="mx-1">
                    주방
                    <input type="file" id="files" ref="files" height="100%" width="100%" multiple v-on:change="handleFileUpload()">
                </div>
                <div class="mx-1">
                    방사진
                    <input type="file" id="files" ref="files" height="100%" width="100%" multiple v-on:change="handleFileUpload()">
                </div>
                <div class="mx-1">
                    방사진
                    <input type="file" id="files" ref="files" height="100%" width="100%" multiple v-on:change="handleFileUpload()">
                </div>
                <div class="mx-1">
                    방사진
                    <input type="file" id="files" ref="files" height="100%" width="100%" multiple v-on:change="handleFileUpload()">
                </div>
                -->
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px"></v-icon>
                    보증금
                <v-list-item class="mx-1">
                    <v-text-field placeholder="건물의 특징을 40자 이내로 적어주세요." :value="deposit" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                    월세 (전세일경우 0을 입력하세요)
                <v-list-item class="mx-1">
                    <v-text-field placeholder="(전세일경우 0을 입력하세요)" :value="monthyRent" required></v-text-field>
                </v-list-item> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방구조
                <div class="mx-1">
                    <v-text-field placeholder="방구조"  :value="roomType" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비
                <div class="mx-1">
                    <v-text-field placeholder="관리비" :value="manageCost" required></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비 포함 항목
                <div class="mx-1">
                    <v-text-field placeholder="관리비 포함 항목" :value="manageCostInc" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                크기
                <div class="mx-1">
                    <v-text-field placeholder="제곱미터단위로 입력해주세요" :value="sizeM2" required></v-text-field>
                </div> 
                <div class="mx-1">
                    <v-text-field placeholder="방의 평수를 입력해주세요." :value="size" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                층수
                <div class="mx-1">
                    <v-text-field placeholder="건물 총 층수" :value="floorAll" required></v-text-field>
                </div>
                <div class="mx-1">
                    <v-text-field placeholder="해당 층" :value="floor" required></v-text-field>
                </div>  
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방향
                <div class="mx-1">
                    <v-text-field placeholder="남향? 북향?" :value="roomDirection" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                옵션
                <div class="mx-1">
                    <v-text-field placeholder="옵션" :value="options" required></v-text-field>
                </div> 
            </div>
           
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                반려동물
                <div class="mx-1">
                    <v-text-field placeholder="반려동물" :value="pets" required></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                주차
                <div class="mx-1">
                    <v-text-field placeholder="주차" :value="parking" required></v-text-field>
                </div> 
            </div>
            
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                엘리베이터
                <div class="mx-1">
                    <v-text-field :items='option' placeholder="엘리베이터" :value="elevator" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                입주가능일
                <div class="mx-1">
                    <v-text-field :items='option' placeholder="입주가능일" :value="moveinDate" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                제목
                <div class="mx-1">
                    <v-text-field placeholder="제목" :value="title" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                상세설명
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" :value="description" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개인 연락처
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" :value="agentMobile" required></v-text-field>
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