<template>
	<v-card class="grey lighten-4">
		<v-card flat>
			<v-card-title>
				{{info.local1}}
				{{info.local2}}
				{{info.local3}}
			</v-card-title>
			<v-divider></v-divider>
			<v-container>
				<swiper class="swiper" :options="swiperOption">
					<swiper-slide v-for="list in imageList" :key="list.index">
						<img :src="list">
					</swiper-slide>
					<div class="swiper-pagination" slot="pagination"></div>
					<div class="swiper-button-prev" slot="button-prev"></div>
					<div class="swiper-button-next" slot="button-next"></div>
				</swiper>
			</v-container>

			<v-card-title v-if="info.salesType == '월세'" class="ml-3">{{info.salesType}} {{info.deposit}}/{{info.rent}}
			</v-card-title>
			<v-card-title v-else class="ml-3">{{info.salesType}} {{info.deposit}}</v-card-title>
			<v-divider/>

			<div class="d-flex justify-space-between my-2 mx-7">
				<div>
					<div>면적</div>
					<div class="title">{{info.sizeM2}}㎡</div>
				</div>
				<div>
					<div>관리비</div>
					<div class="title">{{info.manageCost}}</div>
				</div>
				<div>
					<div>구조</div>
					<div class="title">{{info.roomType}}</div>
				</div>
			</div>
			<v-divider/>
			<v-card-text>{{info.title}}</v-card-text>
		</v-card>

		<v-card class="mt-3" flat>
			<v-list-item>
				<v-list-item-title>매물 정보</v-list-item-title>
				<v-btn icon @click="show = !show">
					<v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
				</v-btn>
			</v-list-item>
			<v-expand-transition>
				<div v-show="show">
					<v-simple-table>
						<tbody>
						<tr>
							<td>주차</td>
							<td>{{info.parking}}</td>
						</tr>
						<tr>
							<td>엘리베이터</td>
							<td>{{info.elevator}}</td>
						</tr>
						<tr>
							<td>입주가능일</td>
							<td>{{info.moveinDate}}</td>
						</tr>
						<tr>
							<td>관리비</td>
							<td>{{info.manageCost}}</td>
						</tr>
						<tr>
							<td>구조</td>
							<td>{{info.roomType}}</td>
						</tr>
						<tr>
							<td>방향</td>
							<td>{{info.roomDirection}}</td>
						</tr>
						<tr>
							<td>면적(평/㎡)</td>
							<td>{{info.size}}/{{info.sizeM2}}</td>
						</tr>
						<tr>
							<td>층/건물층수</td>
							<td>{{info.floor}}/{{info.floorAll}}</td>
						</tr>
						<tr>
							<td>주소</td>
							<td>{{info.address}}</td>
						</tr>
						</tbody>
					</v-simple-table>

				</div>
			</v-expand-transition>
		</v-card>

		<v-card class="mt-3" flat>
			<v-list-item>
				<v-list-item-title>옵션 정보</v-list-item-title>
				<v-btn icon @click="show1 = !show1">
					<v-icon>{{ show1 ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
				</v-btn>
			</v-list-item>
			<v-expand-transition>
				<div v-show="show1">
					<div class="py-3 px-5">{{info.options}}</div>
				</div>
			</v-expand-transition>
		</v-card>

		<v-card class="mt-3" flat>
			<v-list-item>
				<v-list-item-title>관리비 포함 항목</v-list-item-title>
				<v-btn icon @click="show2 = !show2">
					<v-icon>{{ show2 ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
				</v-btn>
			</v-list-item>
			<v-expand-transition>
				<div v-show="show2">
					<div class="py-3 px-5">{{info.manageCostInc}}</div>
				</div>
			</v-expand-transition>
		</v-card>

		<v-card class="mt-3" flat>
			<v-list-item>
				<v-list-item-title>인근 전철역</v-list-item-title>
				<v-btn icon @click="show3 = !show3">
					<v-icon>{{ show3 ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
				</v-btn>
			</v-list-item>
			<v-expand-transition>
				<div v-show="show3">
					<div class="py-3 px-5">{{info.nearSubways}}</div>
				</div>
			</v-expand-transition>
		</v-card>

		<v-card class="mt-3" flat>
			<v-list-item>
				<v-list-item-title>상세 설명</v-list-item-title>
				<v-btn icon @click="show4 = !show4">
					<v-icon>{{ show4 ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
				</v-btn>
			</v-list-item>
			<v-expand-transition>
				<div v-show="show4">
					<div class="py-3 px-5" v-html="description"></div>
				</div>
			</v-expand-transition>
		</v-card>

		<v-card class="mt-3" flat>
			<v-list-item>
				<v-list-item-title>중개사 정보</v-list-item-title>
				<v-btn icon @click="show5 = !show5">
					<v-icon>{{ show5 ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
				</v-btn>
			</v-list-item>
			<v-expand-transition>
				<div v-show="show5">
					<v-list>
						<v-list-item>
							<v-list-item-content>
								<v-list-item-title>중개사/중개인</v-list-item-title>
								<v-list-item-subtitle>{{info.agentName}}</v-list-item-subtitle>
							</v-list-item-content>
						</v-list-item>
						<v-list-item>
							<v-list-item-content>
								<v-list-item-title>소개</v-list-item-title>
								<v-list-item-subtitle v-if="info.userIntro" class="text-wrap">{{info.userIntro}}</v-list-item-subtitle>
								<v-list-item-subtitle v-else>-</v-list-item-subtitle>
							</v-list-item-content>
						</v-list-item>
						<v-list-item>
							<v-list-item-content>
								<v-list-item-title>전화</v-list-item-title>
								<v-list-item-subtitle>{{info.agentPhone}}</v-list-item-subtitle>
								<v-list-item-subtitle>{{info.agentMobile}}</v-list-item-subtitle>
							</v-list-item-content>
						</v-list-item>
						<v-list-item>
							<v-list-item-content>
								<v-list-item-title>이메일</v-list-item-title>
								<v-list-item-subtitle>{{info.agentEmail}}</v-list-item-subtitle>
							</v-list-item-content>
						</v-list-item>
						<v-list-item>
							<v-list-item-content>
								<v-list-item-title>주소</v-list-item-title>
								<v-list-item-subtitle class="text-wrap">{{info.agentAddress}}</v-list-item-subtitle>
							</v-list-item-content>
						</v-list-item>
					</v-list>
				</div>
			</v-expand-transition>
		</v-card>
	</v-card>
</template>


<script>
  import {Swiper, SwiperSlide} from 'vue-awesome-swiper'
  import 'swiper/css/swiper.css'

  export default {
    components: {
      Swiper,
      SwiperSlide
    },
    props: {
      info: {
        type: Object
      },
    },
    data() {
      return {
        show: false,
        show1: false,
        show2: false,
        show3: false,
        show4: false,
        show5: false,
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
      imageList() {
        return this.info.image.split(',')
      },
      description() {
        return this.info.description.replace(/(?:\r\n|\r|\n)/g, '<br />')
      }
    },
    methods: {}
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
