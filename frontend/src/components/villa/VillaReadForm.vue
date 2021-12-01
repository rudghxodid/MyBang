<template>
    <v-container>
        <v-stepper :value="e1">
                <form @submit.prevent="onSubmit">
                    <v-stepper-header>
                    <v-stepper-step :complete="e1 > 1" step="1">매물 종류 선택</v-stepper-step>
                    <v-divider></v-divider>
                    <v-stepper-step :complete="e1 > 2" step="2">중개사무소 정보</v-stepper-step>
                    <v-divider></v-divider>
                    <v-stepper-step :complete="e1 > 3" step="3">매물 입력사항(1)</v-stepper-step>
                    <v-divider></v-divider>
                    <v-stepper-step :complete="e1 > 4" step="4">매물 입력사항(2)</v-stepper-step>
                    <v-divider></v-divider>
                    <v-stepper-step :complete="e1 > 4" step="5">매물 입력사항(3)</v-stepper-step>
                     <v-divider></v-divider>
                    <v-stepper-step step="6">매물 입력사항(4)</v-stepper-step>
                    </v-stepper-header>
                    <v-stepper-items>

                        <v-stepper-content step="1">
                            <v-card class="mb-12" color="" max-height="500px">
                                <div class="mx-3">
                                    <v-text-field placeholder="" :value="villa.serviceType" required readonly></v-text-field>
                                </div>
                            </v-card>
                                
                            <v-btn color="primary" @click="e1 = 2">다음</v-btn>

                            <v-btn text>취소</v-btn>
                        </v-stepper-content>

                        <v-stepper-content step="2">
                            <v-card class="mb-12" color="" max-height="3000px">
                                <div class="mx-3">
                                    <v-icon color="black" size="30px">label</v-icon>
                                        중개사 주소
                                    <v-list-item class="mx-1">
                                        <v-text-field placeholder="" :value="villa.agentAddress" required readonly></v-text-field>
                                    </v-list-item>
                                </div> 

                                <div class="mx-3">
                                    <v-icon color="black" size="30px">label</v-icon>
                                        중개사 이메일
                                    <v-list-item class="mx-1">
                                        <v-text-field placeholder="" :value="villa.agentEmail" required readonly></v-text-field>
                                    </v-list-item>
                                </div> 
                                
                                <div class="mx-3">
                                    <v-icon color="black" size="30px">label</v-icon>
                                        중개사 이름
                                    <v-list-item class="mx-1">
                                        <v-text-field placeholder="" :value="villa.agentName" required readonly></v-text-field>
                                    </v-list-item>
                                </div>  

                                <div class="mx-3">
                                    <v-icon color="black" size="30px">label</v-icon>
                                        중개사 연락처
                                    <v-list-item class="mx-1">
                                        <v-text-field placeholder="" :value="villa.agentPhone" required readonly></v-text-field>
                                    </v-list-item>
                                </div> 

                                <div class="mx-3">
                                    <v-icon color="black" size="30px">label</v-icon>
                                        중개인 이름
                                    <v-list-item class="mx-1">
                                        <v-text-field placeholder="" :value="villa.userName" required readonly></v-text-field>
                                    </v-list-item>
                                </div> 

                                <div class="mx-3"> 
                                    <v-icon color="black" size="30px">label</v-icon>
                                        중개인 연락처
                                    <div class="mx-1">
                                        <v-text-field placeholder="" :value="villa.agentMobile" required readonly></v-text-field>
                                    </div> 
                                </div>
                            </v-card>

                            <v-btn color="primary" @click="e1 = 3">다음</v-btn>

                            <v-btn text @click="e1 = 1">취소</v-btn>
                        </v-stepper-content>

                        <v-stepper-content step="3">
                            <v-card class="mb-12" color="" max-height="3000px">
                                <div class="mx-3">
                                    <v-icon color="black" size="30px">label</v-icon>
                                        매물의 주소를 입력하세요
                                    <v-list-item class="mx-1">
                                        <v-text-field placeholder="" :value="villa.address" required readonly></v-text-field>
                                    </v-list-item>
                                </div>

                                <div class="mx-3">
                                    <v-icon color="black" size="30px">label</v-icon>
                                        주소
                                    <v-list-item class="mx-1">
                                        <v-text-field placeholder="주소 입력시 자동으로 입력됩니다" :value="villa.local1" required readonly ></v-text-field>
                                        <v-text-field placeholder="주소 입력시 자동으로 입력됩니다" :value="villa.local2" required readonly ></v-text-field>
                                        <v-text-field placeholder="주소 입력시 자동으로 입력됩니다" :value="villa.local3" required readonly ></v-text-field>
                                    </v-list-item>
                                </div>

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
                                    입주가능일
                                    <div class="mx-1">
                                        <v-text-field placeholder="방구조"  :value="villa.moveinDate" required readonly></v-text-field>
                                    </div> 
                                </div>

                                <div class="mx-3"> 
                                    <v-icon color="black" size="30px">label</v-icon>
                                    방구조
                                    <div class="mx-1">
                                        <v-text-field placeholder="방구조"  :value="villa.roomType" required readonly></v-text-field>
                                    </div> 
                                </div>

                                <div class="mx-3"> 
                                    <v-icon color="black" size="30px">label</v-icon>
                                    판매유형
                                    <div class="mx-1">
                                        <v-text-field placeholder="판매유형을 선택해주세요" :value="villa.salesType" required readonly></v-text-field>
                                    </div> 
                                </div>
                                <div class="mx-3">
                                    <v-icon color="black" size="30px">label</v-icon>
                                        보증금
                                    <div class="mx-1">
                                        <v-text-field placeholder="보증금" :value="villa.deposit" required readonly></v-text-field>
                                    </div>
                                </div>
                                <div class="mx-3">
                                    <v-icon color="black" size="30px">label</v-icon>
                                        월세
                                    <div class="mx-1">
                                        <v-text-field placeholder="전세일 경우 0을 입력해주세요" :value="villa.rent" required readonly></v-text-field>
                                    </div>
                                </div>
                            </v-card>
                                
                            <v-btn color="primary" @click="e1 = 4">다음</v-btn>

                            <v-btn text @click="e1 = 2">취소</v-btn>
                        </v-stepper-content>

                        <v-stepper-content step="4">
                            <v-card class="mb-12" color="" max-height="3000px">
                                <div class="mx-3"> 
                                    <v-icon color="black" size="30px">label</v-icon>
                                    크기
                                    <div class="mx-1">
                                        <v-text-field placeholder="방의 평수를 입력해주세요." :value="villa.size" required readonly ></v-text-field>
                                    </div> 
                                    <div class="mx-1">
                                        <v-text-field placeholder="m2" :value="villa.sizeM2" required readonly ></v-text-field>
                                    </div> 
                                </div>

                                <div class="mx-3"> 
                                    <v-icon color="black" size="30px">label</v-icon>
                                        관리비 포함 항목
                                        <div class="mx-1" >
                                            <v-text-field placeholder="" :value="villa.manageCostInc" required readonly ></v-text-field>
                                        </div> 
                                    </div><br>
                                    관리비
                                    <div class="mx-1">
                                        <v-text-field placeholder="관리비를 입력해주세요" :value="villa.manageCost" required readonly></v-text-field>
                                    </div> 

                                    <div class="mx-3"> 
                                        <v-icon color="black" size="30px">label</v-icon>
                                        옵션
                                        <div class="mx-1">
                                            <v-text-field placeholder="옵션" :value="villa.options" required readonly ></v-text-field>
                                        </div> 
                                    </div>
                                
                                    <div class="mx-3"> 
                                        <v-icon color="black" size="30px">label</v-icon>
                                        반려동물
                                        <div class="mx-1">
                                            <v-text-field placeholder="반려동물" :value="villa.pets" required readonly></v-text-field>
                                        </div> 
                                    </div> 

                                    <div class="mx-3"> 
                                        <v-icon color="black" size="30px">label</v-icon>
                                        주차
                                        <div class="mx-1">
                                            <v-text-field placeholder="주차" :value="villa.parking" required readonly></v-text-field>
                                        </div> 
                                    </div> 
                            </v-card>
                                
                            <v-btn color="primary" @click="e1 = 5">다음</v-btn>

                            <v-btn text @click="e1 = 3">취소</v-btn>
                        </v-stepper-content>

                        <v-stepper-content step="5">
                            <v-card class="mb-12" color="" max-height="2000px">

                                <div class="mx-3"> 
                                    <v-icon color="black" size="30px">label</v-icon>
                                    인근 지하철
                                    <div class="mx-1">
                                        <v-text-field placeholder="인근 지하철" :value="villa.nearSubways" required readonly></v-text-field>
                                    </div> 
                                </div>
                                
                                <div class="mx-3"> 
                                    <v-icon color="black" size="30px">label</v-icon>
                                    엘리베이터
                                    <div class="mx-1">
                                        <v-text-field  placeholder="엘리베이터" :value="villa.elevator" required readonly></v-text-field>
                                    </div> 
                                </div>

                                <div class="mx-3"> 
                                        <v-icon color="black" size="30px">label</v-icon>
                                        층수
                                    <div class="mx-1">
                                        <v-text-field placeholder="건물 총 층수" :value="villa.floorAll" required readonly></v-text-field>
                                    </div>
                                    <div class="mx-1">
                                        <v-text-field placeholder="해당 층" :value="villa.floor" required readonly></v-text-field>
                                    </div>  
                                </div>

                                <div class="mx-3"> 
                                    <v-icon color="black" size="30px">label</v-icon>
                                    방향
                                    <div class="mx-1">
                                        <v-text-field placeholder="" :value="villa.roomDirection" required readonly></v-text-field>
                                    </div> 
                                </div>
                            </v-card>

                            <v-btn color="primary" @click="e1 = 6">다음</v-btn>

                            <v-btn text @click="e1 = 4">취소</v-btn>
                        </v-stepper-content>

                        <v-stepper-content step="6">
                            <v-card class="mb-12" color="" max-height="3000px"> 

                                <div class="mx-3"> 
                                    <v-icon color="black" size="30px">label</v-icon>
                                    소개글
                                    <div class="mx-1">
                                        <v-text-field placeholder="매물에 관한 내용을 100자 이내로 적어주세요" :value="villa.title" required readonly></v-text-field>
                                    </div> 
                                </div>

                                <div class="mx-3"> 
                                    <v-icon color="black" size="30px">label</v-icon>
                                    매물 상세설명
                                    <div class="mx-1">
                                        <v-textarea placeholder="매물에 관한 내용을 상세히 적어주세요" :value="villa.description" required readonly></v-textarea>
                                    </div> 
                                </div>
                            </v-card>

                            <v-btn color="primary">다음</v-btn>

                            <v-btn text @click="e1 = 5">취소</v-btn>
                        </v-stepper-content>
                    
                    <!-- 자동으로 입력되는 부분 --> 
                    <div class="mx-3" hidden> 
                        <v-icon color="black" size="30px">label</v-icon>
                        중개사무소 좌표
                        <div class="mx-1">
                            <v-text-field placeholder="" :value="villa.agentLat" required readonly></v-text-field>
                        </div> 
                    </div>
                    <div class="mx-3" hidden> 
                        <v-icon color="black" size="30px">label</v-icon>
                        중개사무소 좌표
                        <div class="mx-1">
                            <v-text-field placeholder="" :value="villa.agentLng" required readonly></v-text-field>
                        </div> 
                    </div>
                    <div class="mx-3" hidden> 
                        <v-icon color="black" size="30px">label</v-icon>
                        좌표(lat)
                        <div class="mx-1">
                            <v-text-field placeholder="좌표(lat)" :value="villa.lat" required readonly></v-text-field>
                        </div> 
                    </div>
                    <div class="mx-3" hidden> 
                        <v-icon color="black" size="30px">label</v-icon>
                        좌표(lng)
                        <div class="mx-1">
                            <v-text-field placeholder="좌표(lng)" :value="villa.lng" required readonly ></v-text-field>
                        </div> 
                    </div>
                    <div class="mx-3" hidden> 
                        <v-icon color="black" size="30px">label</v-icon>
                        작성자
                        <div class="mx-1">
                            <v-text-field placeholder="" :value="villa.agentId" required readonly ></v-text-field>
                        </div> 
                    </div>
                </v-stepper-items>
            </form>
        </v-stepper>
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
            e1: 1,
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
        this.villaNo = this.$route.query.villaNo
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