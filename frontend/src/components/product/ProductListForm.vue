<template>
    <div>
        <!-- 검색하는 부분 -->
        <div>
            <v-layout class="search-btn">
                <v-dialog v-model="searchDialog" persistent max-width="420px">
                    <template v-slot:activator="{ on }">
                        <v-btn icon x-large v-on="on"><v-icon>search</v-icon></v-btn>        
                    </template>
                    <v-card>
                    <v-toolbar color="white darken-3" flat height="50">
                        <v-btn icon x-large @click="cancle()" style="positoin:absolute; left:23em;">
                            <v-icon>clear</v-icon>
                        </v-btn>
                    </v-toolbar>
                    <v-card-text >
                        <v-select
                            v-model="selectAddress"
                            :items="address"
                            label="모든 지역"
                            multiple
                            attach
                            chips
                            style="width: 400px; display: inline-block; margin-right: 40px;"
                            persistent-hint>
                        </v-select>
                        <v-select
                            v-model="selectRoomType"
                            :items="RoomType"
                            label="모든 건물"
                            multiple 
                            attach
                            chips
                            style="width: 400px;display: inline-block; margin-right: 40px;"
                            persistent-hint>
                        </v-select>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="blue lighten-1 white--text" @click="selectSearch()">
                            검색
                        </v-btn>
                    </v-card-actions>
                    </v-card>
                </v-dialog>
            </v-layout>
        </div>

        <!-- 게시판 리스트 나오는 부분 -->
        <v-container style="width:100%;">
            <v-row>
                <v-card v-for="product in products" :key="product.productNo" class="list-card"> 
                    <figure class="snip1477">
                        <figcaption>
                            <h1>{{ product.title }}<br/><br/></h1>
                            <h1>위치 : {{product.address}}<br/></h1>
                            <p>{{ product.room_type }}<br/></p>
                        </figcaption>
                    </figure>
                    <!--
                    <div style="float: right; margin-right: 30px; margin-bottom: 10px;">

                    <v-tooltip bottom>

                        <template v-slot:activator="{ on, attrs }">
                    
                        <v-btn text v-on="on" v-bind="attrs" @click="toDetailPage(product.id)" style="margin-bottom: 5px; margin-right: 10px;">

                        <v-icon color="#42b8d4">
                            assessment
                        </v-icon>

                        </v-btn>
                        </template>

                        <span>상세 정보 보기</span>

                    </v-tooltip>
                    
                    <v-tooltip bottom>

                        <template v-slot:activator="{ on, attrs }">
                    
                        <font-awesome-icon v-show="chkLikedOrNot(product.id)" :icon="['fas','heart']" size="lg" :style="{ color: '#42b8d4' }" v-on="on" v-bind="attrs"
                        @click="deleteLikedProduct(product.id)"/>

                        <font-awesome-icon v-show="!chkLikedOrNot(product.id)" :icon="['far','heart']" size="lg" :style="{ color: '#42b8d4' }" v-on="on" v-bind="attrs"
                        @click="addLikedProduct(product.id)"/>

                        </template>

                        <span v-show="chkLikedOrNot(product.id)">찜해제</span>

                        <span v-show="!chkLikedOrNot(product.id)">찜하기</span>

                    </v-tooltip>
                    </div>
                    -->

                </v-card>
            </v-row>
        </v-container>

        <!-- 페이지네이션 -->
        <v-container>
            <div class="btn-cover">
                <v-btn :disabled="pageNum === 0" @click="prevPage" icon text>
                    <v-icon>chevron_left</v-icon>
                </v-btn>
                <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
                <v-btn  :disabled="pageNum >= pageCount - 1" @click="nextPage" icon text>
                    <v-icon>chevron_right</v-icon>
                </v-btn >
            </div>
        </v-container>
    </div>
</template>

<script>

//import axios from 'axios'
//import { FETCH_PRODUCT_LIST } from '@/store/mutation-types'
//import { mapActions, mapState } from 'vuex';

export default {
    name: 'ProductListForm',
    data () {
        return {
            pageNum: 0,
            searchDialog: false,
            address: [ '서울', '경기', '인천', '강원', '충북', '충남', '충북', '전북', '전남', '경북', '경남', '부산', '대구', '제주' ],
            selectAddress: [],
            selectRoomType: [],
            RoomType: [ '아파트', '빌라', '원룸', '투룸', '셰어하우스' ],
        }
    },
    props: {
        products: {
            type: Array,
            required: true
        },
        pageSize: {
            type: Number,
            required: false,
            default: 8
        }
    },
    methods: {
            //...mapActions(['fetchLikedProductList']),
        nextPage () {
        this.pageNum += 1;
        },
        prevPage () {
        this.pageNum -= 1;
        },
        cancle() {
        this.searchDialog = false
        },
        toDetailPage(productNo) {
        this.$router.push({
            name: 'ProductReadPage',
            params: { "productNo": productNo }
        })
        },
        /*
        selectSearch() {
        const { selectAddress, selectRoomType } = this
        return axios.get('http://localhost:8888/product/list')
                .then((res) => {
                var ani = []
                if(selectAddress.length > 0 && selectRoomType.length > 0) {
                    var len = selectRoomType.length + selectAddress.length
                    for(var i=0; i<res.data.length; i++) {
                    for(var j=0; j< len; j++) {
                        for(var o=0; o< len; o++)
                        if((res.data[i].id.includes(selectAddress[j]) && res.data[i].kind.includes(selectRoomType[o]))) {
                        ani.push(res.data[i])
                        this.$store.commit(FETCH_PRODUCT_LIST, ani)
                        }
                    }
                    }
                } else if(selectAddress.length > 0) {
                    for(var k=0; k<res.data.length; k++) {
                        for(var l=0; l< selectAddress.length; l++) {
                        if(res.data[k].id.includes(selectAddress[l])) {
                            ani.push(res.data[k])
                            this.$store.commit(FETCH_PRODUCT_LIST, ani)
                        }
                        }
                    }
                } else if(selectRoomType.length > 0) {
                    for(var m=0; m<res.data.length; m++) {
                        for(var n=0; n< selectRoomType.length; n++) {
                        if(res.data[m].kind.includes(selectRoomType[n])) {
                            ani.push(res.data[m])
                            this.$store.commit(FETCH_PRODUCT_LIST, ani)
                        }
                        }
                    }
                }
                this.searchDialog = false
            })
        },
        addLikedProduct(id) {
      
        const memberNo = this.$store.state.session.memberNo
        const noticeNo = id
        axios.post('http://localhost:8888/member/addLikedProduct', { memberNo, noticeNo })
            .then(() => {
            this.$store.state.likedProductList.push({ 'memberNo': memberNo, 'noticeNo': noticeNo })
            })
            .catch(() => {
            alert('잠시후에 다시 시도해주세요.')
            })
        },
        chkLikedOrNot(id) {
        for(var i=0; i<this.$store.state.likedProductList.length; i++) {
            if(id == this.$store.state.likedProductList[i].noticeNo) {
            return true
            }
        }
        return false
        },
        deleteLikedProduct(id) {
        
        const memberNo = this.$store.state.session.memberNo
        const noticeNo = id
        axios.put('http://localhost:8888/petto/member/deleteLikedProduct', { memberNo, noticeNo }, {
            headers: {
            'Content-Type': 'application/json'
            }
        })
            .then(() => {
            const targetIndex = this.$store.state.likedProductList.findIndex(v => v.noticeNo === id)
            this.$store.state.likedProductList.splice(targetIndex, 1)
            })
            .catch(() => {
            alert('잠시후에 다시 시도해주세요.')
            })
        }*/
    },
    computed: {
    //...mapState(['session', 'likedProductList']),

    pageCount () {
      let listLeng = this.products.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData () {
        const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
        return this.products.slice(start, end);
        }
    },
    mounted() {
        /*   로그인한 상태에서 기능을 이용할 수 있게 코드를 작성 해야함 (찜 기능 같은거)
        if(this.$cookies.get("user").id) { 
        this.$store.state.session = this.$cookies.get("user")
        this.fetchLikedProductList(this.$cookies.get("user").memberNo)
        }
        */
    }
}
</script>

<style lang="scss" scoped>
.search-btn{
  position: absolute;
  top:11em;
  right: 10em;
}
table {
  width: 100%;
  border-collapse: collapse;
}
table th {
  font-size: 1.2rem;
}
table tr {
  height: 2rem;
  text-align: center;
  border-bottom: 1px solid #505050;
}
table tr:first-of-type {
  border-top: 2px solid #404040;
}
table tr td {
  padding: 1rem 0;
  font-size: 1.1rem;
}
.btn-cover {
  margin-top: 2rem;
  margin-bottom: 5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
.list-card{
  width: 335px;
  float: left;
  margin: 0% 3% 2% 3%;
  align-items: center;
}
@import url(https://fonts.googleapis.com/css?family=Raleway:400,500,700);
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
figure.snip1477 {
    height: 500px;
    width: 100%;
    font-family: 'Raleway', Arial, sans-serif;
    position: relative;
    overflow: hidden;
    margin: 10px;
    margin-bottom: 10px;
    min-width: 230px;
    max-width: 315px;
    color: #ffffff;
    text-align: center;
    font-size: 16px;
    background-color: #000000;
}
figure.snip1477 *,
figure.snip1477 *:before,
figure.snip1477 *:after {
-webkit-box-sizing: border-box;
  box-sizing: border-box;
-webkit-transition: all 0.55s ease;
  transition: all 0.55s ease;
}
figure.snip1477 img {
  max-width: 100%;
  backface-visibility: hidden;
  vertical-align: top;
  opacity: 0.9;
}

@font-face {
  font-family: 'SangSangRock';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/SangSangRockOTF.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
figure.snip1477 h4 {
  font-family: 'SangSangRock';
  font-size: 20px;
  display: block;
  font-weight: 500;
  // background-color: rgba(0, 0, 0, 0.3);
  padding: 1px 1px;
  color: #fff;
}
figure.snip1477 figcaption {
  position: absolute;
  bottom: 42%;
  left: 25px;
  text-align: left;
  opacity: 0;
  padding: 5px 60px 5px 10px;
  font-size: 0.8em;
  font-weight: 500;
  letter-spacing: 1.5px;
}
figure.snip1477 figcaption p {
  margin: 0;
}
figure.snip1477 a {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}
figure.snip1477:hover img,
figure.snip1477.hover img {
  zoom: 1;
  filter: alpha(opacity=35);
-webkit-opacity: 0.35;
  opacity: 0.35;
}

figure.snip1477:hover figcaption,
figure.snip1477.hover figcaption {
    opacity: 1;
    -webkit-transition-delay: 0.2s;
    transition-delay: 0.2s;
}
</style>