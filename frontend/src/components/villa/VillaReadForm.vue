<template>
    <v-container>
            <div class="mx-3"> 
                <v-icon color="black" size="30px">home</v-icon>
                사진
                <div class="mx-1" v-if="imageList">
                    <v-card width="400">
                        <swiper class="swiper" :options="swiperOption">
                        <swiper-slide v-for="list in imageList" :key="list.index">
                            <img :src="list">
                        </swiper-slide>
                        <div class="swiper-pagination" slot="pagination"></div>
                        <div class="swiper-button-prev" slot="button-prev"></div>
                        <div class="swiper-button-next" slot="button-next"></div>
                        </swiper>
                    </v-card>
                </div>
                <div v-else>
                    <img :src="require('@/assets/img/noImg.gif')">
                </div>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 주소
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" :value="villa.agentAddress" required disabled></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 이메일
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" :value="villa.agentEmail" required disabled></v-text-field>
                </v-list-item>
            </div> 
            
            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 이름
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" :value="villa.agentName" required disabled></v-text-field>
                </v-list-item>
            </div>  

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 연락처
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" :value="villa.agentPhone" required disabled></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개인 이름
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" :value="villa.userName" required disabled></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                    중개인 연락처
                <div class="mx-1">
                    <v-text-field placeholder="" :value="villa.agentMobile" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    매물의 주소를 입력하세요
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" :value="villa.address" required disabled></v-text-field>
                </v-list-item>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    보증금
                <v-list-item class="mx-1">
                    <v-text-field input type="number" placeholder="" :value="villa.deposit" required disabled></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방구조
                <div class="mx-1">
                    <v-text-field  placeholder="방구조"  :value="villa.roomType" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                판매유형
                <div class="mx-1">
                    <v-text-field  placeholder="" :value="villa.salesType" required disabled></v-text-field>
                </div> 
            </div>  
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비 포함 항목
                <div class="mx-1" >
                    <v-text-field placeholder="" :value="villa.manageCostInc" required disabled></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                크기
                <div class="mx-1">
                    <v-text-field placeholder="제곱미터단위로 입력해주세요" :value="villa.sizeM2" required disabled></v-text-field>
                </div>  
                <div class="mx-1">
                    <v-text-field placeholder="방의 평수를 입력해주세요." :value="villa.size" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                층수
                <div class="mx-1">
                    <v-text-field  placeholder="건물 총 층수" :value="villa.floorAll" required disabled></v-text-field>
                </div>
                <div class="mx-1">
                    <v-text-field  placeholder="해당 층" :value="villa.floor" required disabled></v-text-field>
                </div>  
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방향
                <div class="mx-1">
                    <v-text-field placeholder="" :value="villa.roomDirection" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                옵션
                <div class="mx-1">
                    <v-text-field placeholder="옵션" :value="villa.options" required disabled></v-text-field>
                </div> 
            </div>
           
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                반려동물
                <div class="mx-1">
                    <v-text-field placeholder="반려동물" :value="villa.pets" required disabled></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                주차
                <div class="mx-1">
                    <v-text-field placeholder="주차" :value="villa.parking" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                인근 지하철
                <div class="mx-1">
                    <v-text-field placeholder="인근 지하철" :value="villa.nearSubways" required disabled></v-text-field>
                </div> 
            </div>
            
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                엘리베이터
                <div class="mx-1">
                    <v-text-field placeholder="엘리베이터" :value="villa.elevator" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                입주가능일
                <div class="mx-1">
                    <v-text-field  placeholder="입주가능일" :value="villa.moveinDate" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                소개글
                <div class="mx-1">
                    <v-text-field placeholder="매물에 관한 내용을 100자 이내로 적어주세요" :value="villa.title" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                매물 상세설명
                <div class="mx-1">
                    <v-text-field placeholder="매물에 관한 내용을 상세히 적어주세요" :value="villa.description" required disabled></v-text-field>
                </div> 
            </div>
    </v-container>
</template>

<script>

import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
import { mapState, mapActions } from 'vuex'
//import axios from 'axios'

export default {
    name: 'VillaReadForm',
    components: {
        Swiper,
        SwiperSlide
    },
    props: {
        villaNo: {
            
        },
    },
    data() {
        return {
            show: false,  
            swiperOption: {
                    loop: true,
                    slidesPerView: 1,
                    spaceBetween: 30,
                    pagination: {
                        el: '.swiper-pagination',
                        clickable: true
                    },
                    navigation: {
                        nextEl: '.swiper-button-next',
                        prevEl: '.swiper-button-prev',
                    }
                },
        }
    },
    computed: {
        ...mapState(['villa']),
        
        imageList () {
            if (this.villa.image) {
                return this.villa.image.split(',')
            } else {
                return null
            }
            
        },
    },
    created() {
        console.log(this.villa)
    },
    mounted () {
        this.fetchVilla(this.villaNo)
    },
    methods: {
        ...mapActions(['fetchVilla'])
    }
}
</script>

<style class="scss" scoped>
.swiper-3d {
  width: 400px;
  height: 300px;
  padding-top: 50px;
  padding-bottom: 50px;
}
.swiper {
  height: 100%;
  width: 100%;
}
.swiper-slide {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 300px;
  height: 300px;
  font-weight: bold;
  color: white;
}
.swiper-pagination >>> .swiper-pagination-bullet {
  opacity: 1;
  border: white solid 1px;
  background-color: transparent;
}
.swiper-pagination >>> .swiper-pagination-bullet-active {
  background-color: white;
}
.swiper-button-next {
  color: white;
}
.swiper-button-prev {
  color: white;
}
</style>