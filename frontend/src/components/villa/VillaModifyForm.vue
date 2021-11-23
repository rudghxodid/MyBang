<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 주소
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="villa.agentAddress" required></v-text-field>
                    <button @click="onApiAgentAddress">입력</button>
                </v-list-item>
            </div> 

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 이메일
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="villa.agentEmail" required></v-text-field>
                </v-list-item>
            </div> 
            
            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 이름
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="villa.agentName" required></v-text-field>
                </v-list-item>
            </div>  

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개사 전화
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="villa.agentPhone" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개인 설명
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="villa.userIntro" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    중개인 이름
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="villa.userName" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개인 연락처
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" v-model="villa.agentMobile" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    매물의 주소를 입력하세요
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="villa.address" required></v-text-field>
                    <button @click="onApiAddress">확인</button>
                </v-list-item>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    주소(시)
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="villa.local1" required readonly></v-text-field>
                </v-list-item>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    주소(구)
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="villa.local2" required readonly></v-text-field>
                </v-list-item>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    주소(동)
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="villa.local3" required readonly></v-text-field>
                </v-list-item>
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">home</v-icon>
                    건물사진 등록
                <div class="mx-1">
                    <input type="file" id="files" ref="files" height="100%" width="100%" multiple v-on:change="handleFileUpload()">
                    
                </div>
            </div> 
            
            <div class="mx-3" hidden>
                <v-icon color="black" size="30px">label</v-icon>
                    건물타입
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="villa.buildingType" required readonly></v-text-field>
                </v-list-item>
            </div>  

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    보증금
                <v-list-item class="mx-1">
                    <v-text-field placeholder="건물의 특징을 40자 이내로 적어주세요." v-model="villa.deposit" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방구조
                <div class="mx-1">
                    <v-text-field placeholder="방구조"  v-model="villa.roomType" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                판매유형(전세, 월세...)
                <div class="mx-1">
                    <v-text-field placeholder="판매유형" v-model="villa.salesType" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                서비스 유형(원룸, 빌라, 아파트)
                <div class="mx-1">
                    <v-text-field placeholder="판매유형" v-model="villa.serviceType" required></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비
                <div class="mx-1">
                    <v-text-field placeholder="관리비" v-model="villa.manageCost" required></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비 포함 항목
                <div class="mx-1">
                    <v-text-field placeholder="관리비 포함 항목" v-model="villa.manageCostInc" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                크기
                <div class="mx-1">
                    <v-text-field placeholder="제곱미터단위로 입력해주세요" v-model="villa.sizeM2" required></v-text-field>
                </div> 
                <div class="mx-1">
                    <v-text-field placeholder="방의 평수를 입력해주세요." v-model="villa.size" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                층수
                <div class="mx-1">
                    <v-text-field placeholder="건물 총 층수" v-model="villa.floorAll" required></v-text-field>
                </div>
                <div class="mx-1">
                    <v-text-field placeholder="해당 층" v-model="villa.floor" required></v-text-field>
                </div>  
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방향
                <div class="mx-1">
                    <v-text-field placeholder="남향? 북향?" v-model="villa.roomDirection" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                옵션
                <div class="mx-1">
                    <v-text-field placeholder="옵션" v-model="villa.options" required></v-text-field>
                </div> 
            </div>
           
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                반려동물
                <div class="mx-1">
                    <v-text-field placeholder="반려동물" v-model="villa.pets" required></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                주차
                <div class="mx-1">
                    <v-text-field placeholder="주차" v-model="villa.parking" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                인근 지하철
                <div class="mx-1">
                    <v-text-field placeholder="인근 지하철" v-model="villa.nearSubways" required></v-text-field>
                </div> 
            </div>
            
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                엘리베이터
                <div class="mx-1">
                    <v-text-field :items='option' placeholder="엘리베이터" v-model="villa.elevator" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                입주가능일
                <div class="mx-1">
                    <v-text-field :items='option' placeholder="입주가능일" v-model="villa.moveinDate" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                제목
                <div class="mx-1">
                    <v-text-field placeholder="제목" v-model="villa.title" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                매물 상세설명
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" v-model="villa.description" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개사무소 좌표
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" v-model="villa.agentLat" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개사무소 좌표
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" v-model="villa.agentLng" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                좌표(lat)
                <div class="mx-1">
                    <v-text-field placeholder="좌표(lat)" v-model="villa.lat" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                좌표(lng)
                <div class="mx-1">
                    <v-text-field placeholder="좌표(lng)" v-model="villa.lng" required disabled></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                회원구분
                <div class="mx-1">
                    <v-text-field placeholder="회원구분" v-model="villa.agentId" required disabled></v-text-field>
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
                <v-btn color="white" tile large button type="submit" v-on:click="submitFiles()">수정완료</v-btn>
                <v-btn color="white" @click="onDelete">삭제</v-btn> 
                <v-btn color="white" :to="{ name: 'BrokerHouseListPage' }">목록으로 돌아가기</v-btn>
            </div>
        </form>
    </v-container>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'VillaModifyForm',
    props: {
        villa: {
            type: Object,
            required: true
        }
    },
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
            this.agentId = this.userInfo.userId 
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
                formData.append('villaList', this.files[idx])
            }
            axios.post('http://localhost:7777/file/uploadVillaImg', formData, {
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
        onDelete () {
            const { villaNo } = this.villa
            axios.delete(`http://localhost:7777/villa/${villaNo}`)
                .then(() => {
                    alert("프로젝트가 삭제되었습니다")
                    this.$router.push({name: 'BrokerHouseListPage' })
                })
                .catch(err => {
                    alert(err.response.data.message)
                })
        },
        onApiAddress () {
            axios.get(`https://dapi.kakao.com/v2/local/search/address.json?query=${this.address}`,
            { headers: { 'Authorization': 'KakaoAK ' + '005dda6eedb914e554e8810f970149d9' }}).then(res => {
                alert("입력성공")
                console.log(res.data)
            this.lat = res.data.documents[0].y
            this.lng = res.data.documents[0].x
            this.local1 = res.data.documents[0].road_address.region_1depth_name
            this.local2 = res.data.documents[0].road_address.region_2depth_name
            this.local3 = res.data.documents[0].road_address.region_3depth_name
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
    created () {
        this.address = this.villa.address
        this.agentAddress = this.villa.agentAddress
        this.agentEmail = this.villa.agentEmail
        this.agentLat = this.villa.agentLat
        this.agentLng = this.villa.agentLng
        this.agent_mobile = this.villa.agent_mobile
        this.agentName = this.villa.agentName
        this.agentPhone = this.villa.agentPhone
        this.buildingType = this.villa.buildingType
        this.deposit = this.villa.deposit
        this.description = this.villa.description
        this.elevator = this.villa.elevator
        this.floor = this.villa.floor
        this.floorAll = this.villa.floorAll
        this.image = this.villa.image
        this.lat = this.villa.lat
        this.lng = this.villa.lng
        this.local1 = this.villa.local1
        this.local2 = this.villa.local2
        this.local3 = this.villa.local3
        this.manageCost = this.villa.manageCost
        this.manageCostInc = this.villa.manageCostInc
        this.moveinDate = this.villa.moveinDate
        this.nearSubways = this.villa.nearSubways
        this.options = this.villa.options
        this.parking = this.villa.parking
        this.pets = this.villa.pets
        this.roomDirection = this.villa.roomDirection
        this.roomType = this.villa.roomType
        this.salesType = this.villa.salesType
        this.serviceType = this.villa.serviceType
        this.size = this.villa.size
        this.sizeM2 = this.villa.sizeM2
        this.title = this.villa.title
        this.updatedAt = this.villa.updatedAt
        this.userIntro = this.villa.userIntro
        this.userName = this.villa.userName
        this.url = this.villa.url
        this.agentId = this.villa.agentId
    },
}
</script>