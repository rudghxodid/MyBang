<template>
    <v-container>
        <v-stepper v-model="e1">
                <form @submit.prevent="onSubmit">
                    <v-stepper-header>
                    <v-stepper-step color="secondary" :complete="e1 > 1" step="1">중개사무소 정보</v-stepper-step>
                    <v-divider></v-divider>
                    <v-stepper-step color="secondary" :complete="e1 > 2" step="2">매물 입력사항(1)</v-stepper-step>
                    <v-divider></v-divider>
                    <v-stepper-step color="secondary" :complete="e1 > 3" step="3">매물 입력사항(2)</v-stepper-step>
                    <v-divider></v-divider>
                    <v-stepper-step color="secondary" :complete="e1 > 4" step="4">매물 입력사항(3)</v-stepper-step>
                     <v-divider></v-divider>
                    <v-stepper-step color="secondary" step="5">매물 입력사항(4)</v-stepper-step>
                    </v-stepper-header>
                    <v-stepper-items>

                        <v-stepper-content step="1">
                            <v-card class="mb-12" color="" max-height="3000px">

                                <span>중개사 주소</span>
                                <v-list-item>
                                <v-text-field placeholder="" v-model="agentAddress" required solo class="mt-3"></v-text-field>
                                <button class="mb-5 ml-4" @click="onApiAgentAddress">확인하기</button>
                                </v-list-item>

                                <span>중개사 이메일</span>
                                <v-text-field placeholder="" v-model="agentEmail" required solo class="mt-3"></v-text-field>
                                
                                <span>중개사 이름</span>
                                <v-text-field placeholder="" v-model="agentName" required solo class="mt-3"></v-text-field>  

                                <span>중개사 연락처</span>
                                <v-text-field placeholder="" v-model="agentPhone" required solo class="mt-3"></v-text-field>

                                <span>중개인 이름</span>
                                <v-text-field placeholder="" v-model="userName" required solo class="mt-3"></v-text-field>

                                <span>중개인 연락처</span>
                                <v-text-field placeholder="" v-model="agentMobile" required solo class="mt-3"></v-text-field>
                            </v-card>

                            <v-btn color="secondary" @click="e1 = 2">다음</v-btn>

                        </v-stepper-content>

                        <v-stepper-content step="2">
                            <v-card class="mb-12" color="" max-height="3000px">

                                <span>매물의 주소를 입력하세요</span>
                                <v-list-item>
                                <v-text-field placeholder="" v-model="address" required solo class="mt-3"></v-text-field>
                                <button class="mb-5 ml-4" @click="onApiAddress">확인하기</button>
                                </v-list-item>

                                <span>주소</span>
                                    <v-list-item class="mx-1">
                                        <v-text-field placeholder="주소 입력시 자동으로 입력됩니다" v-model="local1" required solo class="mt-3" readonly></v-text-field>
                                        <v-text-field placeholder="주소 입력시 자동으로 입력됩니다" v-model="local2" required solo class="mt-3" readonly></v-text-field>
                                        <v-text-field placeholder="주소 입력시 자동으로 입력됩니다" v-model="local3" required solo class="mt-3" readonly></v-text-field>
                                    </v-list-item>

                                <span>건물사진 등록</span>
                                    <v-card width="400" flat>
                                        <!-- 사진선택 -->
                                        <v-file-input required solo class="mt-3" v-model="files" @change="selectImg" label="사진 선택"
                                        prepend-icon="insert_photo" chips multiple ></v-file-input>

                                        <!-- 선택한 사진 미리보기 -->
                                        <v-card class="mx-10" flat>
                                        <v-img v-for="url in urls" :key="url.index" class="ml-10" :src="url" width="50%"/>
                                        </v-card>

                                        <!-- imgBB에 이미지 전송 -->
                                        <v-btn @click="sendImg">전송</v-btn>
                                        <!-- 전송된 사진 url 확인 -->
                                        <v-btn @click="checkImage">확인</v-btn>

                                        <!-- 저장된 첫번째 사진 미리보기 
                                        <div v-if="viewImage">
                                        <v-img :src="viewImage"></v-img>
                                        </div>-->
                                    </v-card>
  
                                <span>입주가능일</span>
                                    <div class="mx-1">
                                        <v-menu ref="menu" v-model="menu" :close-on-content-click="false"
                                            :return-value.sync="date" transition="scale-transition" offset-y min-width="auto">
                                            <template v-slot:activator="{ on }">
                                            <v-text-field placeholder="입주가능일을 선택해주세요." v-model="moveinDate" 
                                                v-on="on" append-icon="mdi-calendar" required solo class="mt-3"></v-text-field>
                                            </template>
                                            <v-date-picker color="secondary" v-model="moveinDate" no-title scrollable>
                                            
                                            <v-btn text @click="menu = false">
                                                Cancel
                                            </v-btn>
                                            <v-spacer></v-spacer>
                                            <v-btn text @click="$refs.menu.save(date)">
                                                OK
                                            </v-btn>
                                            </v-date-picker>
                                        </v-menu>
                                    </div> 

                                <span>방구조</span>
                                    <div class="mx-1">
                                        <v-select :items='roomTypes' placeholder="방구조"  v-model="roomType" required solo class="mt-3" ></v-select>
                                    </div> 

                                <span>판매유형</span>
                                    <div class="mx-1">
                                        <v-select :items='salesTypes' placeholder="판매유형을 선택해주세요" v-model="salesType" required solo class="mt-3" ></v-select>
                                    </div> 
                                <span>보증금</span>
                                    <div class="mx-1">
                                        <v-text-field input type="number" placeholder="보증금" v-model="deposit" required solo class="mt-3"></v-text-field>
                                    </div>

                                <span>월세</span>
                                    <div class="mx-1">
                                        <v-text-field input type="number" placeholder="전세일 경우 0을 입력해주세요" v-model="rent" required solo class="mt-3"></v-text-field>
                                    </div>
                            </v-card>
                                
                            <v-btn color="secondary" @click="e1 = 3">다음</v-btn>

                            <v-btn text @click="e1 = 1">이전</v-btn>
                        </v-stepper-content>

                        <v-stepper-content step="3">
                            <v-card class="mb-12" color="" max-height="3000px">
                                <span>크기</span>
                                    <div class="mx-1">
                                        <v-text-field placeholder="방의 평수를 입력해주세요." v-model="size" required solo class="mt-3" ></v-text-field>
                                    </div> 
                                    <div class="mx-1">
                                        <v-text-field placeholder="m2" v-model="sizeM2" required solo class="mt-3" readonly></v-text-field>
                                    </div> 

                                <span>관리비 포함 항목</span>
                                    <div class="mx-1" >
                                        <input type="checkbox" value="전기세" v-model="manageCostIncChk">
                                            <label for="전기세" class="check">전기세</label>
                                        <input type="checkbox" value="수도" v-model="manageCostIncChk">
                                            <label for="수도" class="check">수도</label>
                                        <input type="checkbox" value="가스" v-model="manageCostIncChk">
                                            <label for="가스" class="check">가스</label>
                                        <input type="checkbox" value="인터넷" v-model="manageCostIncChk">
                                            <label for="인터넷" class="check">인터넷</label>
                                        <input type="checkbox" value="TV" v-model="manageCostIncChk">
                                            <label for="TV">TV</label>
                                    </div><br>
                                    관리비
                                    <div class="mx-1">
                                        <v-text-field placeholder="관리비를 입력해주세요" v-model="manageCost" required solo class="mt-3"></v-text-field>
                                    </div>  

                                    <span>옵션</span>
                                        <div class="mx-1">
                                            <input type="checkbox" value="에어컨" v-model="optionsChk">
                                                <label for="에어컨" class="check">에어컨</label>
                                            <input type="checkbox" value="냉장고" v-model="optionsChk">
                                                <label for="냉장고" class="check">냉장고</label>
                                            <input type="checkbox" value="세탁기" v-model="optionsChk">
                                                <label for="세탁기" class="check">세탁기</label>
                                            <input type="checkbox" value="가스레인지" v-model="optionsChk">
                                                <label for="가스레인지" class="check">가스레인지</label>
                                            <input type="checkbox" value="인덕션" v-model="optionsChk">
                                                <label for="인덕션" class="check">인덕션</label>
                                        </div>
                                        <div class="mx-1">
                                            <input type="checkbox" value="전자레인지" v-model="optionsChk">
                                                <label for="전자레인지" class="check">전자레인지</label>
                                            <input type="checkbox" value="옷장" v-model="optionsChk">
                                                <label for="옷장" class="check">옷장</label>
                                            <input type="checkbox" value="책상" v-model="optionsChk">
                                                <label for="책상" class="check">책상</label>
                                            <input type="checkbox" value="책장" v-model="optionsChk">
                                                <label for="책장" class="check">책장</label>
                                            <input type="checkbox" value="침대" v-model="optionsChk">
                                                <label for="침대" class="check">침대</label>
                                        </div>
                                        <div class="mx-1">
                                            <input type="checkbox" value="싱크대" v-model="optionsChk">
                                                <label for="싱크대" class="check">싱크대</label>
                                            <input type="checkbox" value="신발장" v-model="optionsChk">
                                                <label for="신발장" >신발장</label>
                                        </div> 
                                
                                    <span>반려동물</span>
                                        <div class="mx-1">
                                            <v-select :items='petcheck' placeholder="반려동물" v-model="pets" required solo class="mt-3"></v-select>
                                        </div> 

                                    <span>주차</span>
                                        <div class="mx-1">
                                            <v-select :items='parkings' placeholder="주차" v-model="parking" required solo class="mt-3"></v-select>
                                        </div>  
                            </v-card>
                                
                            <v-btn color="secondary" @click="e1 = 4">다음</v-btn>

                            <v-btn text @click="e1 = 2">이전</v-btn>
                        </v-stepper-content>

                        <v-stepper-content step="4">
                            <v-card class="mb-12" color="" max-height="2000px">

                                <span>인근 지하철</span>
                                    <div class="mx-1">
                                        <v-text-field placeholder="인근 지하철" v-model="nearSubways" required solo class="mt-3"></v-text-field>
                                    </div> 
                                
                                <span>엘리베이터</span>
                                    <div class="mx-1">
                                        <v-select :items='exist' placeholder="엘리베이터" v-model="elevator" required solo class="mt-3"></v-select>
                                    </div> 

                                <span>층수</span>
                                    <div class="mx-1">
                                        <v-select :items='floorCheck' placeholder="건물 총 층수" v-model="floorAll" required solo class="mt-3"></v-select>
                                    </div>
                                    <div class="mx-1">
                                        <v-select :items='floorCheck' placeholder="해당 층" v-model="floor" required solo class="mt-3"></v-select>
                                    </div>  

                                <span>방향</span>
                                    <div class="mx-1">
                                        <v-select :items='roomDirections' placeholder="" v-model="roomDirection" required solo class="mt-3"></v-select>
                                    </div> 
                            </v-card>

                            <v-btn color="secondary" @click="e1 = 5">다음</v-btn>

                            <v-btn text @click="e1 = 3">이전</v-btn>
                        </v-stepper-content>

                        <v-stepper-content step="5">
                            <v-card class="mb-12" color="" max-height="3000px"> 

                                <span>소개글</span>
                                    <div class="mx-1">
                                        <v-text-field placeholder="매물에 관한 내용을 100자 이내로 적어주세요" v-model="title" required solo class="mt-3"></v-text-field>
                                    </div> 

                                <span>매물 상세설명</span>
                                    <div class="mx-1">
                                        <v-textarea placeholder="매물에 관한 내용을 상세히 적어주세요" v-model="description" required solo class="mt-3"></v-textarea>
                                    </div> 
                            </v-card>
                            <v-btn text @click="e1 = 4">이전</v-btn>
                        </v-stepper-content>
                    

                    <!-- 자동으로 입력되는 부분 --> 
                    <div class="mx-3" hidden> 
                        <v-icon color="black" size="30px">label</v-icon>
                        중개사무소 좌표
                        <div class="mx-1">
                            <v-text-field placeholder="" v-model="agentLat" required readonly></v-text-field>
                        </div> 
                    </div>
                    <div class="mx-3" hidden> 
                        <v-icon color="black" size="30px">label</v-icon>
                        중개사무소 좌표
                        <div class="mx-1">
                            <v-text-field placeholder="" v-model="agentLng" required readonly></v-text-field>
                        </div> 
                    </div>
                    <div class="mx-3" hidden> 
                        <v-icon color="black" size="30px">label</v-icon>
                        좌표(lat)
                        <div class="mx-1">
                            <v-text-field placeholder="좌표(lat)" v-model="lat" required readonly></v-text-field>
                        </div> 
                    </div>
                    <div class="mx-3" hidden> 
                        <v-icon color="black" size="30px">label</v-icon>
                        좌표(lng)
                        <div class="mx-1">
                            <v-text-field placeholder="좌표(lng)" v-model="lng" required readonly></v-text-field>
                        </div> 
                    </div>
                    <div class="mx-3" hidden> 
                        <v-icon color="black" size="30px">label</v-icon>
                        작성자
                        <div class="mx-1">
                            <v-text-field placeholder="" v-model="agentId" required readonly></v-text-field>
                        </div> 
                    </div>

                    <div class="mt-3">
                        <v-btn class="button_place" color="secondary" tile large button type="submit">수정완료</v-btn>
                        <v-btn class="button_place" color="white" @click="onDelete">삭제</v-btn> 
                        <v-btn class="button_place" color="white" :to="{ name: 'BrokerHouseListPage' }">목록으로 돌아가기</v-btn>
                    </div>
                </v-stepper-items>
            </form>
        </v-stepper>
    </v-container>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'OfficetelModifyForm',
    props: {
        officetel: {
            type: Object,
            required: true
        }
    },
    data () {
      return {
            e1: 1,
            image: null,
            rent: '',
            deposit: '',
            roomType: '',
            manageCost: '',
            manageCostInc: '',
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
            serviceType: '오피스텔',
            userIntro: '',
            userName: '',
            url: '',
            updatedAt: '',
            agentId: '',
            menu: false,
            date: null,
            manageCostIncChk: [],
            optionsChk: [],
            viewImage: null,
            files: [],
            urls: [],
            imageStr: '',
            floorCheck:['1층', '2층', '3층', '4층', '5층', '6층','7층', '8층', '9층', '10층', '11층','12층','13층','14층','15층','16층','17층','18층','19층','20층',
                        '21층','22층','23층','24층','25층','26층','27층','28층','29층','30층','31층','32층','33층','34층','35층','36층','37층','38층','39층','40층',
                        '50층'],
            roomTypes: ['오픈형 원룸(방1)','분리형 원룸(방1 거실1)','복층형 원룸', '투룸(방2, 거실1)', '쓰리룸+'],
            salesTypes: ['월세','전세','매매'],
            exist: ['있음', '없음'],
            parkings: ['가능', '없음'],
            roomDirections: ['북향', '남향', '동향', '서향', '남동향', '남서향', '북동향', '북서향', '확인필요'],
            petcheck: ['가능', '불가능', '고양이만', '확인필요'],
        }
    },
    computed: {
        ...mapState(['userInfo']),
        sizeM2 () {
            return this.size * 3.305785
        }
    },
    mounted() {
        this.agentId = this.userInfo.userId
        if (this.$store.state.session != null) {
            this.isLogin = true
        }
    },
    methods: {
        selectImg () {
            try {
                this.urls = []
                this.imageStr = ''

                for (let i = 0; i < this.files.length; i++) {
                this.urls.push(URL.createObjectURL(this.files[i]))
                }
            }catch(e) {
                this.urls = []
                this.imageStr = ''
            }
        },
        sendImg() {
            const formData = new FormData()

            // 아래 빈칸에 key 입력
            formData.set('key', 'ca442ada99076d1fda16e811a57f9d6d')
            
            for (let i = 0; i < this.files.length; i++) {
                formData.append('image', this.files[i])

                axios.post(`https://api.imgbb.com/1/upload`, formData).then(res => {
                console.log(res.data.data.display_url)
                this.imageStr += res.data.data.display_url + ','
                })
            }
            alert('확인버튼을 눌러주세요')
        },
        checkImage () {
            // imageStr의 마지막 ',' 제거
            this.image = this.imageStr.slice(0, -1)
            console.log(this.image)

            // 불러온 imageStr을 img로 표시하려면 ',' 기준으로 잘라서 배열로 저장 후 사용
            let imageList = this.image.split(',')
            console.log(imageList)

            // 배열에 저장된 첫번째 사진 url
            this.viewImage = imageList[0]
            alert('사진등록이 완료되었습니다')
        },
        onSubmit () {
            this.agentId = this.userInfo.userId 
            const { image, rent, deposit, roomType, manageCost, manageCostIncChk, sizeM2, size, floorAll, floor, roomDirection, optionsChk, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId} = this

            this.$emit('submit', { image, rent, deposit, roomType, manageCost, manageCostIncChk, sizeM2, size, floorAll, floor, roomDirection, optionsChk, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId})
        },
        onDelete () {
            const { officetelNo } = this.officetel
            axios.delete(`http://localhost:7777/officetel/${officetelNo}`)
                .then(() => {
                    alert("등록하신 매물이 삭제되었습니다")
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
        this.address = this.officetel.address
        this.agentAddress = this.officetel.agentAddress
        this.agentEmail = this.officetel.agentEmail
        this.agentLat = this.officetel.agentLat
        this.agentLng = this.officetel.agentLng
        this.agentMobile = this.officetel.agentMobile
        this.agentName = this.officetel.agentName
        this.agentPhone = this.officetel.agentPhone
        this.buildingType = this.officetel.buildingType
        this.deposit = this.officetel.deposit
        this.description = this.officetel.description
        this.elevator = this.officetel.elevator
        this.floor = this.officetel.floor
        this.floorAll = this.officetel.floorAll
        this.image = this.officetel.image
        this.lat = this.officetel.lat
        this.lng = this.officetel.lng
        this.local1 = this.officetel.local1
        this.local2 = this.officetel.local2
        this.local3 = this.officetel.local3
        this.manageCost = this.officetel.manageCost
        this.manageCostInc = this.officetel.manageCostInc
        this.moveinDate = this.officetel.moveinDate
        this.nearSubways = this.officetel.nearSubways
        this.options = this.officetel.options
        this.parking = this.officetel.parking
        this.pets = this.officetel.pets
        this.roomDirection = this.officetel.roomDirection
        this.roomType = this.officetel.roomType
        this.salesType = this.officetel.salesType
        this.serviceType = this.officetel.serviceType
        this.size = this.officetel.size
        this.sizeM2 = this.officetel.sizeM2
        this.title = this.officetel.title
        this.updatedAt = this.officetel.updatedAt
        this.userIntro = this.officetel.userIntro
        this.userName = this.officetel.userName
        this.url = this.officetel.url
        this.agentId = this.officetel.agentId
        this.rent = this.officetel.rent
    },
}
</script>

<style scoped>

.button_place {
    left: 68%;
    margin-right: 1%;
    margin-top: -8%;
    /*margin-left: 135px;*/ 
}
.check {
    width: 93px;
    margin-right: 20px;
}
</style>
