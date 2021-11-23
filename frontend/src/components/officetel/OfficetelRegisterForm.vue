<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 주소
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="agentAddress" required></v-text-field>
                    <button @click="onApiAgentAddress">입력</button>
                </v-list-item>
            </div> 

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 이메일
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="agentEmail" required></v-text-field>
                </v-list-item>
            </div> 
            
            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 이름
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="agentName" required></v-text-field>
                </v-list-item>
            </div>  

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 전화
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="agentPhone" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개인 설명
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="userIntro" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개인 이름
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="userName" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개인 연락처
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" v-model="agentMobile" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    매물의 주소를 입력하세요
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="address" required></v-text-field>
                    <button @click="onApiAddress">확인</button>
                </v-list-item>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    주소(시)
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="local1" required readonly></v-text-field>
                </v-list-item>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    주소(구)
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="local2" required readonly></v-text-field>
                </v-list-item>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    주소(동)
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="local3" required readonly></v-text-field>
                </v-list-item>
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">home</v-icon>
                    건물사진 등록
                <div class="mx-1">
                    <input type="file" id="files" ref="files" height="100%" width="100%" multiple v-on:change="handleFileUpload()">
                </div>
            </div> 
            
            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    건물타입
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="buildingType" required></v-text-field>
                </v-list-item>
            </div>  

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    보증금
                <v-list-item class="mx-1">
                    <v-text-field placeholder="건물의 특징을 40자 이내로 적어주세요." v-model="deposit" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방구조
                <div class="mx-1">
                    <v-text-field placeholder="방구조"  v-model="roomType" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                판매유형(전세, 월세...)
                <div class="mx-1">
                    <v-text-field placeholder="판매유형" v-model="salesType" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                서비스 유형(원룸, 빌라, 아파트)
                <div class="mx-1">
                    <v-text-field placeholder="판매유형" v-model="serviceType" required></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비
                <div class="mx-1">
                    <v-text-field placeholder="관리비" v-model="manageCost" required></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비 포함 항목
                <div class="mx-1">
                    <v-text-field placeholder="관리비 포함 항목" v-model="manageCostInc" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                크기
                <div class="mx-1">
                    <v-text-field placeholder="제곱미터단위로 입력해주세요" v-model="sizeM2" required></v-text-field>
                </div> 
                <div class="mx-1">
                    <v-text-field placeholder="방의 평수를 입력해주세요." v-model="size" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                층수
                <div class="mx-1">
                    <v-text-field placeholder="건물 총 층수" v-model="floorAll" required></v-text-field>
                </div>
                <div class="mx-1">
                    <v-text-field placeholder="해당 층" v-model="floor" required></v-text-field>
                </div>  
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방향
                <div class="mx-1">
                    <v-text-field placeholder="남향? 북향?" v-model="roomDirection" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                옵션
                <div class="mx-1">
                    <v-text-field placeholder="옵션" v-model="options" required></v-text-field>
                </div> 
            </div>
           
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                반려동물
                <div class="mx-1">
                    <v-text-field placeholder="반려동물" v-model="pets" required></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                주차
                <div class="mx-1">
                    <v-text-field placeholder="주차" v-model="parking" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                인근 지하철
                <div class="mx-1">
                    <v-text-field placeholder="인근 지하철" v-model="nearSubways" required></v-text-field>
                </div> 
            </div>
            
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                엘리베이터
                <div class="mx-1">
                    <v-text-field :items='option' placeholder="엘리베이터" v-model="elevator" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                입주가능일
                <div class="mx-1">
                    <v-text-field :items='option' placeholder="입주가능일" v-model="moveinDate" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                제목
                <div class="mx-1">
                    <v-text-field placeholder="제목" v-model="title" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                매물 상세설명
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" v-model="description" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개사무소 좌표
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" v-model="agentLat" required readonly></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개사무소 좌표
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" v-model="agentLng" required readonly></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                좌표(lat)
                <div class="mx-1">
                    <v-text-field placeholder="좌표(lat)" v-model="lat" required readonly></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                좌표(lng)
                <div class="mx-1">
                    <v-text-field placeholder="좌표(lng)" v-model="lng" required readonly></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                회원구분
                <div class="mx-1">
                    <v-text-field placeholder="좌표(lng)" v-model="agentId" required readonly></v-text-field>
                </div> 
            </div>
            <!--
             <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                옵션
                <div class="mx-1">
                    <v-select :items='option' placeholder="옵션의 여부를 입력해주세요." v-model="manage_cost_inc" required>
                        <template >
                            <v-list-item  @click="toggle">
                                <v-list-item-action>
                                    <v-icon :color="manage_cost_inc.length > 0 ? 'indigo darken-4' : ''">
                                        {{ icon }}
                                    </v-icon>
                                </v-list-item-action>

                                <v-list-item-content>
                                    <v-list-item-title>
                                    모두 선택
                                    </v-list-item-title>
                                </v-list-item-content>
                            </v-list-item>
                        </template>  
                    </v-select>
                </div> 
            </div>
             -->

            <div class="mt-3">
                <v-btn color="white" tile large button type="submit" v-on:click="submitFiles()">방 등록하기</v-btn>
            </div>
        </form>
    </v-container>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'OfficetelRegisterForm',
    data () {
      return {
            image: '',
            deposit: '',
            roomType: '',
            manageCost: '',
            manageCostInc: '',
            sizeM2: '',
            size: '',
            floorAll: '',
            floor: '',
            roomDirection: '',
            options: '',
            pets: '',
            parking: '',
            elevator: '',
            moveinDate: '',
            title: '',
            description: '',
            nearSubways: '',
            address: '',
            salesType: '',
            agentAddress: '',
            agentEmail: '',
            agentLat: '',
            agentLng: '',
            agentMobile: '',
            agentName: '',
            agentPhone: '',
            buildingType: '',
            lat: '',
            lng: '',
            local1: '',
            local2: '',
            local3: '',
            serviceType: '',
            userIntro: '',
            userName: '',
            url: '',
            updatedAt: '',
            agentId: '',
            roomTypes: [ '오픈형 원룸(방1)', '분리형 원룸(방1 거실1)', '복층형 원룸', '투룸(방2 거실1)', '쓰리룸+'],
            option: ['에어컨', '냉장고', '세탁기', '가스레인지', '전자레인지', '옷장', '신발장', '싱크대', '인터넷', '인덕션', '책상', '침대'],
        }
    },
    computed: {
        likesAllOption () {
            return this.manage_cost_inc.length === this.option.length
        },
        likesSomeOption () {
            return this.manage_cost_inc.length > 0 && !this.likesAllOption
        },
        icon () {
            if (this.likesAllOption) return 'mdi-close-box'
            if (this.likesSomeOption) return 'mdi-minus-box'
            return 'mdi-checkbox-blank-outline'
        },
        ...mapState(['userInfo']),
    },
    mounted() {
        this.agentId = this.userInfo.userId
        if (this.$store.state.session != null) {
            this.isLogin = true
        }
    },
    methods: {
        onSubmit () {
            const { image, deposit, roomType, manageCost, manageCostInc, sizeM2, size, floorAll, floor, roomDirection, options, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId} = this

            this.$emit('submit', { image, deposit, roomType, manageCost, manageCostInc, sizeM2, size, floorAll, floor, roomDirection, options, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId})
        },
        handleFileUpload () {
            this.files = this.$refs.files.files
            const info = this.files
            this.image = info[0].name
        },
        submitFiles () {
            let formData = new FormData()
            for (var idx = 0; idx < this.files.length; idx++) {
                formData.append('officetelList', this.files[idx])
            }
            axios.post('http://localhost:7777/file/uploadOfficetelImg', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
            .then (res => {
                this.response = res.data
            })
            .catch (res => {
                this.response = res.message
            }) 
        },
        toggle () {
            this.$nextTick(() => {
            if (this.likesAllOption) {
                this.manage_cost_inc = []
            } else {
                this.manage_cost_inc = this.option.slice()
            }
            })
        },
        onApiAddress () {
            axios.get(`https://dapi.kakao.com/v2/local/search/address.json?query=${this.address}`,
            { headers: { 'Authorization': 'KakaoAK ' + '005dda6eedb914e554e8810f970149d9' }}).then(res => {
                alert("입력성공")
                console.log(res.data)
            this.lat += res.data.documents[0].y
            this.lng += res.data.documents[0].x
            this.local1 += res.data.documents[0].road_address.region_1depth_name
            this.local2 += res.data.documents[0].road_address.region_2depth_name
            this.local3 += res.data.documents[0].road_address.region_3depth_name
            })
        },
        onApiAgentAddress () {
            axios.get(`https://dapi.kakao.com/v2/local/search/address.json?query=${this.agentAddress}`,
            { headers: { 'Authorization': 'KakaoAK ' + '005dda6eedb914e554e8810f970149d9' }}).then(res => {
                alert("입력성공")
                console.log(res.data)
                this.agentLat += res.data.documents[0].y
                this.agentLng += res.data.documents[0].x
            })
        },
    },
}
</script>