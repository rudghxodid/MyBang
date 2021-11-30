<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <input type="radio" value="villa" v-model="serviceType">
                <label for="빌라">빌라</label>
            <input type="radio" value="oneroom" v-model="serviceType">
                <label for="원룸">원룸</label>
            <input type="radio" value="officetel" v-model="serviceType">
                <label for="오피스텔">오피스텔</label>
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
                    중개사 연락처
                <v-list-item class="mx-1">
                    <v-text-field placeholder="" v-model="agentPhone" required></v-text-field>
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
                    <v-text-field placeholder="" v-model="agentMobile" required></v-text-field>
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
                    <v-text-field placeholder="주소 입력시 자동으로 입력됩니다" v-model="local1" required readonly></v-text-field>
                </v-list-item>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    주소(구)
                <v-list-item class="mx-1">
                    <v-text-field placeholder="주소 입력시 자동으로 입력됩니다" v-model="local2" required readonly></v-text-field>
                </v-list-item>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    주소(동)
                <v-list-item class="mx-1">
                    <v-text-field placeholder="주소 입력시 자동으로 입력됩니다" v-model="local3" required readonly></v-text-field>
                </v-list-item>
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">home</v-icon>
                    건물사진 등록
                <div class="mx-1">
                    <v-card width="400" flat>
                        <!-- 사진선택 -->
                        <v-file-input class="mx-10" v-model="files" @change="selectImg" label="사진 선택"
                        prepend-icon="insert_photo" chips multiple ></v-file-input>

                        <!-- 선택한 사진 미리보기 -->
                        <v-card class="mx-10" flat>
                        <v-img v-for="url in urls" :key="url.index" class="ml-10" :src="url" width="80%"/>
                        </v-card>

                        <!-- imgBB에 이미지 전송 -->
                        <v-btn @click="sendImg">전송</v-btn>
                        <!-- 전송된 사진 url 확인 -->
                        <v-btn @click="checkImage">확인</v-btn>

                        <!-- 저장된 첫번째 사진 미리보기 -->
                        <div v-if="viewImage">
                        <v-img :src="viewImage"></v-img>
                        </div>
                    </v-card>
                </div>
            </div>  

            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                    보증금
                <v-list-item class="mx-1">
                    <v-text-field input type="number" placeholder="" v-model="deposit" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방구조
                <div class="mx-1">
                    <v-select :items='roomTypes' placeholder="방구조"  v-model="roomType" required></v-select>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                판매유형
                <div class="mx-1">
                    <v-select :items='salesTypes' placeholder="" v-model="salesType" required></v-select>
                </div> 
            </div>  
            <div class="mx-3">
                <v-icon color="black" size="30px">label</v-icon>
                관리비 포함 항목
                <div class="mx-1" >
                    <input type="checkbox" value="전기세" v-model="manageCostIncChk">
                        <label for="전기세">전기세</label>
                    <input type="checkbox" value="수도" v-model="manageCostIncChk">
                        <label for="수도">수도</label>
                    <input type="checkbox" value="가스" v-model="manageCostIncChk">
                        <label for="가스">가스</label>
                    <input type="checkbox" value="인터넷" v-model="manageCostIncChk">
                        <label for="인터넷">인터넷</label>
                    <input type="checkbox" value="TV" v-model="manageCostIncChk">
                        <label for="TV">TV</label>
                </div><br>
                관리비
                <div class="mx-1">
                    <v-text-field placeholder="" v-model="manageCost" required></v-text-field>
                </div>  
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                크기
                <div class="mx-1">
                    <v-text-field placeholder="방의 평수를 입력해주세요." v-model="size" required ></v-text-field>
                </div> 
                <div class="mx-1">
                    <v-text-field placeholder="m2" v-model="sizeM2" required readonly></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                층수
                <div class="mx-1">
                    <v-select :items='floorCheck' placeholder="건물 총 층수" v-model="floorAll" required></v-select>
                </div>
                <div class="mx-1">
                    <v-select :items='floorCheck' placeholder="해당 층" v-model="floor" required></v-select>
                </div>  
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                방향
                <div class="mx-1">
                    <v-select :items='roomDirections' placeholder="" v-model="roomDirection" required></v-select>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                옵션
                <div class="mx-1">
                    <input type="checkbox" value="에어컨" v-model="optionsChk">
                        <label for="에어컨">에어컨</label>
                    <input type="checkbox" value="냉장고" v-model="optionsChk">
                        <label for="냉장고">냉장고</label>
                    <input type="checkbox" value="세탁기" v-model="optionsChk">
                        <label for="세탁기">세탁기</label>
                    <input type="checkbox" value="가스레인지" v-model="optionsChk">
                        <label for="가스레인지">가스레인지</label>
                    <input type="checkbox" value="전자레인지" v-model="optionsChk">
                        <label for="전자레인지">전자레인지</label>
                </div>
                <div class="mx-1">
                    <input type="checkbox" value="인덕션" v-model="optionsChk">
                        <label for="인덕션">인덕션</label>
                    <input type="checkbox" value="싱크대" v-model="optionsChk">
                        <label for="싱크대">싱크대</label>
                    <input type="checkbox" value="책상" v-model="optionsChk">
                        <label for="책상">책상</label>
                    <input type="checkbox" value="책장" v-model="optionsChk">
                        <label for="책장">책장</label>
                    <input type="checkbox" value="침대" v-model="optionsChk">
                        <label for="침대">침대</label>
                    <input type="checkbox" value="옷장" v-model="optionsChk">
                        <label for="옷장">옷장</label>
                    <input type="checkbox" value="신발장" v-model="optionsChk">
                        <label for="신발장">신발장</label>
                </div> 
            </div>
           
            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                반려동물
                <div class="mx-1">
                    <v-select :items='petcheck' placeholder="반려동물" v-model="pets" required></v-select>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                주차
                <div class="mx-1">
                    <v-select :items='parkings' placeholder="주차" v-model="parking" required></v-select>
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
                    <v-select :items='exist' placeholder="엘리베이터" v-model="elevator" required></v-select>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">hourglass_empty</v-icon>
                 입주가능일
                <div class="mx-1">
                    <v-menu ref="menu" v-model="menu" :close-on-content-click="false"
                        :return-value.sync="date" transition="scale-transition" offset-y min-width="auto">
                        <template v-slot:activator="{ on }">
                        <v-text-field placeholder="입주가능일을 선택해주세요." v-model="moveinDate" 
                            v-on="on" append-icon="mdi-calendar" required></v-text-field>
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
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                소개글
                <div class="mx-1">
                    <v-text-field placeholder="매물에 관한 내용을 100자 이내로 적어주세요" v-model="title" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                매물 상세설명
                <div class="mx-1">
                    <v-textarea placeholder="매물에 관한 내용을 상세히 적어주세요" v-model="description" required></v-textarea>
                </div> 
            </div>

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
                <v-btn color="white" tile large button type="submit">방 등록하기</v-btn>
            </div>
        </form>
    </v-container>
</template>

<script>

import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'HouseRegisterForm',
    data () {
      return {
            image: null,
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
            serviceType: '',
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
        },
        onSubmit () {
            const { image, deposit, roomType, manageCost, manageCostIncChk, sizeM2, size, floorAll, floor, roomDirection, optionsChk, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId} = this

            this.$emit('submit', { image, deposit, roomType, manageCost, manageCostIncChk, sizeM2, size, floorAll, floor, roomDirection, optionsChk, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId})
        },
        onApiAddress () {
            axios.get(`https://dapi.kakao.com/v2/local/search/address.json?query=${this.address}`,
            { headers: { 'Authorization': 'KakaoAK ' + '005dda6eedb914e554e8810f970149d9' }}).then(res => {
                alert("입력성공")
                console.log(res.data)
            this.agentId = this.userInfo.userId 
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
                this.agentLat = res.data.documents[0].y
                this.agentLng = res.data.documents[0].x
            })
        },
    },
}
</script>