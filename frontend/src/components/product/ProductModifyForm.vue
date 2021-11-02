<template>
    <v-container>
        <form @submit.prevent="onSubmit">

            <div class="mx-3"> 
                <v-icon color="black" size="30px"></v-icon>
                    이미지
                <div class="mx-1">
                    <input type="file" id="files" ref="files" height="100%" width="100%" multiple v-on:change="handleFileUpload()">
                </div>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">home</v-icon>
                    특징
                <v-list-item class="mx-1">
                    <v-text-field placeholder="건물의 특징을 40자 이내로 적어주세요." v-model="title" required></v-text-field>
                </v-list-item>
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                상세설명
                <v-list-item class="mx-1">
                    <v-text-field placeholder="자세한 정보를 적어주세요." v-model="description" required></v-text-field>
                </v-list-item> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                보증금
                <div class="mx-1">
                    <v-text-field placeholder="보증금의 가격을 입력해주세요."  v-model="deposit" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                가격
                <div class="mx-1">
                    <v-text-field placeholder="가격을 입력해주세요." v-model="price" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                중개사무소
                <div class="mx-1">
                    <v-text-field placeholder="사무소의 이름을 입력해주세요." v-model="agent_name" required></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                전화번호
                <div class="mx-1">
                    <v-text-field placeholder="사업자의 전화번호를 입력해주세요." v-model="agent_mobile" required></v-text-field>
                </div> 
            </div> 

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                면적(평 수)
                <div class="mx-1">
                    <v-text-field placeholder="방의 평수를 입력해주세요." v-model="size" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                면적(제곱미터)
                <div class="mx-1">
                    <v-text-field placeholder="방의 면적을 제곱미터 단위로 입력해주세요." v-model="size_m2" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                광고 상태
                <div class="mx-1">
                    <v-text-field placeholder="광고여부의 상태 변환을 어케해야하지" v-model="status" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                건물 유형
                <div class="mx-1">
                    <v-select :items='items' placeholder="건물 유형 빌라? 아파트? 원룸? 투룸? 아래에 메뉴바 나오게하기" v-model="room_type" required></v-select>
                </div> 
            </div>

            <!--
                옵션 중복 선택을 위한 코드
             <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                옵션
                <div class="mx-1">
                    <v-select :items='option' placeholder="옵션의 여부를 입력해주세요." v-model="manage_cost_inc" required multiple>
                        <template v-slot:prepend-item>
                            <v-list-item ripple @click="toggle">
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

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                옵션
                <div class="mx-1">
                    <v-select :items='option' placeholder="옵션의 여부를 입력해주세요." v-model="manage_cost_inc" required></v-select>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                층 위치
                <div class="mx-1">
                    <v-text-field placeholder="몇 층에 위치해 있나요?" v-model="floor" required></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                주소
                <div class="mx-1">
                    <v-text-field placeholder="주소를 입력해주세요." v-model="address" required></v-text-field>
                </div> 
            </div>

            <div class="mt-3">
                <v-btn color="white" tile large button type="submit" v-on:click="submitFiles()">등록</v-btn>
                <!--
                <router-link :to="{ name: 'ProductReadPage', params: { productNo: product.productNo.toString() } }" >
                    취소
                </router-link>
                -->
                <v-btn color="white" @click="onDelete">삭제</v-btn> 
            </div>
        </form>
    </v-container>
</template>

<script>
import axios from 'axios'

export default {
    name: 'ProductRegisterForm',
    props: {
        product: {
            type: Object,
            required: true
        }
    },
    data () {
      return {
            title: '',
            image: '',
            description: '',
            deposit: '',
            price: '',
            agent_name: '',
            agent_mobile: '',
            floor: '',
            address: '',
            size: '',
            size_m2: '',
            status: '',
            room_type: '',
            manage_cost_inc: '',
            items: ['아파트','빌라,투룸+','원룸', '오피스텔', '셰어하우스'],
            option: ['에어컨', '냉장고', '세탁기', '가스레인지', '전자레인지', '옷장', '신발장', '싱크대', '인터넷']
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
        onDelete () {
            const { productNo } = this.product
            axios.delete(`http://localhost:7777/product/${productNo}`)
                .then(() => {
                    alert("프로젝트가 삭제되었습니다")
                    this.$router.push({name: 'ProductListPage' })
                })
                .catch(err => {
                    alert(err.response.data.message)
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
    created () {
        this.title = this.product.title
        this.iamge = this.product.iamge
        this.description = this.product.description
        this.deposit = this.product.deposit
        this.price = this.product.price
        this.agent_name = this.product.agent_name
        this.agent_mobile = this.product.agent_mobile
        this.floor = this.product.floor
        this.address = this.product.address
        this.size = this.product.size
        this.size_m2 = this.product.size_m2
        this.status = this.product.status
        this.room_type = this.product.room_type
        this.manage_cost_inc = this.product.manage_cost_inc
    },
}
</script>

<style scoped>

img {
  width: 300px;
  height: 200px;
  object-fit: cover;
}

</style>