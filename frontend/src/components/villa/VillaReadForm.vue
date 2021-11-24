<template>
    <v-container>
            <div class="mx-3"> 
                <v-icon color="black" size="30px">home</v-icon>
                사진
                <div class="mx-1">

                    <v-container>
                        <swiper class="swiper" :options="swiperOption">
                        <swiper-slide v-for="list in imageList" :key="list.image">
                            <img :src="villa.image">
                        </swiper-slide>
                            <div class="swiper-pagination" slot="pagination"></div>
                            <div class="swiper-button-prev" slot="button-prev"></div>
                            <div class="swiper-button-next" slot="button-next"></div>
                        </swiper>
                    </v-container>

                    <!--<img :src="villa.image" :value="villa.image">-->
                </div>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    보증금
                <v-list-item class="mx-1">
                    <v-text-field placeholder="건물의 특징을 40자 이내로 적어주세요." :value="villa.deposit" required disabled></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방구조
                <div class="mx-1">
                    <v-text-field placeholder="방구조"  :value="villa.salesType" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비
                <div class="mx-1">
                    <v-text-field placeholder="관리비" :value="villa.manageCost" required disabled></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비 포함 항목
                <div class="mx-1">
                    <v-text-field placeholder="관리비 포함 항목" :value="villa.manageCostInc" required disabled></v-text-field>
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
                    <v-text-field placeholder="건물 총 층수" :value="villa.floorAll" required disabled></v-text-field>
                </div>
                <div class="mx-1">
                    <v-text-field placeholder="해당 층" :value="villa.floor" required disabled></v-text-field>
                </div>  
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방향
                <div class="mx-1">
                    <v-text-field placeholder="남향? 북향?" :value="villa.roomDirection" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                옵션
                <div class="mx-1">
                    <v-select placeholder="옵션" :value="villa.options" required disabled></v-select>
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
                엘리베이터
                <div class="mx-1">
                    <v-text-field  placeholder="엘리베이터" :value="villa.elevator" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                입주가능일
                <div class="mx-1">
                    <v-text-field placeholder="입주가능일" :value="villa.moveinDate" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                제목
                <div class="mx-1">
                    <v-text-field placeholder="제목" :value="villa.title" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                상세설명
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" :value="villa.description" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개인 연락처
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" :value="villa.agentMobile" required disabled></v-text-field>
                </div> 
            </div>
    </v-container>
</template>

<script>

import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
//import { mapState } from 'vuex'
import axios from 'axios'

export default {
    name: 'VillaReadForm',
    components: {
        Swiper,
        SwiperSlide
    },
    props: {
        villaNo: {
            // type: Object,
            // required: true
        }
    },
    data() {
        return {
            villa: null,
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
        //...mapState(['villa']),
        
        imageList () {
            return this.villa.image.split(',')
        },
    },
    created() {
    },
    mounted () {
        axios.get(`http://localhost:7777/villa/${this.villaNo}`).then((res) => {
            res.data = this.villa
            console.log(res.data)
        })
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
  color: black;
}
.swiper-pagination >>> .swiper-pagination-bullet {
  opacity: 1;
  border: black solid 1px;
  background-color: transparent;
}
.swiper-pagination >>> .swiper-pagination-bullet-active {
  background-color: black;
}
.swiper-button-next {
  color: black;
}
.swiper-button-prev {
  color: black;
}
</style>