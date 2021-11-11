<template>
    <v-container>
        <form @submit.prevent="onSubmit">
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
                    <v-text-field placeholder="건물의 특징을 40자 이내로 적어주세요." v-model="deposit" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                    월세 (전세일경우 0을 입력하세요)
                <v-list-item class="mx-1">
                    <v-text-field placeholder="자세한 정보를 적어주세요." v-model="monthyRent" required></v-text-field>
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
                관리비
                <div class="mx-1">
                    <v-text-field placeholder="가격을 입력해주세요." v-model="manageCost" required></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                관리비 포함 항목
                <div class="mx-1">
                    <v-text-field placeholder="몇 층에 위치해 있나요?" v-model="manageCostInc" required></v-text-field>
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
                상세설명
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" v-model="description" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개인 연락처
                <div class="mx-1">
                    <v-text-field placeholder="상세설명" v-model="agentMobile" required></v-text-field>
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

export default {
    name: 'ProductRegisterForm',
    data () {
      return {
            image: '',
            deposit: '',
            monthyRent: '',
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
            agentMobile: '',
            roomTypes: [ '오픈형 원룸(방1)', '분리형 원룸(방1 거실1)', '복층형 원룸', '투룸(방2 거실1)', '쓰리룸+'],
            option: ['에어컨', '냉장고', '세탁기', '가스레인지', '전자레인지', '옷장', '신발장', '싱크대', '인터넷', '인덕션', '책상', '침대']
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
    },
    methods: {
        onSubmit () {
            const { title, image, description, deposit, price, agent_name, agent_mobile, floor, address, size, size_m2, status, room_type, manage_cost_inc } = this
            this.$emit('submit', { title, image, description, deposit, price, agent_name, agent_mobile, floor, address, size, size_m2, status, room_type, manage_cost_inc })
        },
        handleFileUpload () {
            this.files = this.$refs.files.files
            const info = this.files
            this.image = info[0].name
        },
        submitFiles () {
            let formData = new FormData()
            for (var idx = 0; idx < this.files.length; idx++) {
                formData.append('fileList', this.files[idx])
            }
            axios.post('http://localhost:7777/file/uploadImg', formData, {
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
    },
}
</script>