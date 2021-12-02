<template>
	<div class="main_wrap">
		<div class="banner">
			<swiper class="swiper_bn" :options="swiperOption">
				<swiper-slide><img src="../assets/img/banner4.jpg"></swiper-slide>
				<swiper-slide><img src="../assets/img/banner3.png"></swiper-slide>
				<swiper-slide><img src="../assets/img/banner5.jpg"></swiper-slide>
				<div class="swiper-pagination" slot="pagination"></div>
				<div class="swiper-button-prev" slot="button-prev"></div>
				<div class="swiper-button-next" slot="button-next"></div>

			</swiper>
			<div id=tabHouse>
				<h1 class="main_text">어떤 집을 찾고 있나요?</h1>
				<v-tabs center-active>
					<v-tab>아파트</v-tab>
					<v-tab>빌라, 투룸+</v-tab>
					<v-tab>원룸</v-tab>
					<v-tab>오피스텔</v-tab>
					<v-tab>셰어하우스</v-tab>
				</v-tabs>
				<br>
				<div id=search>
					<input type="text" class="form_control" placeholder="검색 키워드를 입력하세요!" flat none>
					<div id=search-icon>
						<v-btn class="ma-2" color="white">
							<v-icon>mdi-magnify</v-icon>
						</v-btn>
					</div>
				</div>
			</div>
		</div>
		<!--   뉴스, 공지사항 영역 시작   -->
		<div class="board_content">
			<article>
				<div class="more_btn">
					<h2>뉴스</h2>
					<v-btn depressed>
						더보기
					</v-btn>

				</div>
				<hr>
				<div class="tablemargin">
					<v-card elevation="0">
						<ul>
							<li>

								<div class="tablemargin">
									<v-card elevation="0">
										<v-simple-table elevation="0">
											<tbody class="table">
											<tr v-for="(list,idx) in lists.slice(0,5)" :key="idx" width="50px">
												<div v-show="(idx<5)">
													<td style="color: gray" width="40px">{{ list.newsNo }}</td>
													<td @click="clickNews(list.address)" class="maxlength">{{ list.title }}</td>
												</div>
											</tr>
											</tbody>
										</v-simple-table>
									</v-card>
								</div>

							</li>
						</ul>
					</v-card>
				</div>
			</article>

			<article>
				<div class="more_btn">
					<h2>공지사항</h2>
					<v-btn @click="gongziList" depressed>
						더보기
					</v-btn>
				</div>
				<gongzi-preview></gongzi-preview>
			</article>
		</div>
		<!--   소개할게요, 뉴스, 공지사항 영역 끝   -->

		<div class="store">
			<div class="title_bg">
				<h1>방 구하셨나요?</h1>
				<p>나에게 딱 맞는 가구 장만하러 GO!</p>
				<v-btn>VIEW ALL</v-btn>
			</div>

			<div class="product">
				<div class="itemImg">
					<img src="../assets/img/store1.png">
					<div class="itemText">
						<h2>
							<span>퀵슬립</span>
							<span>Q4 유로탑 롤팩 매트리스 2size</span>
						</h2>
						<p>273,900원</p>
						<strong>★4.8</strong> <span>리뷰 9195</span>
					</div>
				</div>
				<div class="itemImg">
					<img src="../assets/img/store2.png">
					<div class="itemText">
						<h2>
							<span>미닉스</span>
							<span>4차완판! 미닉스 미니 건조기 3kg</span>
						</h2>
						<p>279,000원</p>
						<strong>★4.8</strong> <span>리뷰 3089</span>
					</div>
				</div>
				<div class="itemImg">
					<img src="../assets/img/store3.png">
					<div class="itemText">
						<h2>
							<span>두닷</span>
							<span>콰트로 에어 데스크 16size 5colors (800~2000mm)</span>
						</h2>
						<p>99,000원</p>
						<strong>★4.7</strong> <span>리뷰 4375</span>
					</div>
				</div>
				<div class="itemImg">
					<img src="../assets/img/store4.png">
					<div class="itemText">
						<h2>
							<span>보니애가구</span>
							<span>프라제르 아쿠아텍스 4인용 소파 (스툴증정) 2colors</span>
						</h2>
						<p>479,000원</p>
						<strong>★4.6</strong> <span>리뷰 2924</span>
					</div>
				</div>
<!--				<img src="../assets/img/store1.png">-->
<!--				<img src="../assets/img/store2.png">-->
<!--				<img src="../assets/img/store3.png">-->
<!--				<img src="../assets/img/store4.png">-->
			</div>
		</div>

		<section id="icon_wrap">
			<div class="inner">
<!--				<h1>빠른 메뉴</h1>-->

				<div class="icon">
					<article>
						<div class="pic">
							<v-icon>mdi-home-floor-2</v-icon>
							<p>빌라,투룸</p>
						</div>
					</article>
					<article>
						<div class="pic">
							<v-icon>mdi-home-floor-1</v-icon>
							<p>원룸</p>
						</div>
					</article>
					<article>
						<div class="pic">
							<v-icon>mdi-home-city</v-icon>
							<p>오피스텔</p>
						</div>
					</article>
					<article>
						<div class="pic">
							<v-icon>mdi-account-multiple</v-icon>
							<p>룸메구하기</p>
						</div>
					</article>
					<article>
						<div class="pic">
							<v-icon>mdi-bullhorn</v-icon>
							<p>공지사항</p>
						</div>
					</article>

				</div>
			</div>
		</section>
	</div>
</template>

<script>
import {mapState} from 'vuex'
import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
import GongziPreview from '../components/gongzi/GongziPreview.vue'

  export default {
		name: 'MainPage',
	  components: {
			Swiper,
			SwiperSlide,
			GongziPreview
		},
    data() {
      return {
        swiperOption: {
          slidesPerView: 1,
          spaceBetween: 30,
          loop: true,
          pagination: {el: '.swiper-pagination', clickable: true},
          navigation: {nextEl: '.swiper-button-next', prevEl: '.swiper-button-prev'},
          autoplay: {delay: 4000, disableOnInteraction: false}
        },
        item: [
        ],
      }
    },
    mounted() {
    },
    computed: {
      ...mapState({
        lists: state => state.lists
      })
    },
    methods: {
      clickNews(address) {
        window.open(address, 'newslink', 'width: 200px, height: 200px')
      },
      newsLink() {
        this.$router.push({name: 'InfoNews'})
      },
			gongziList () {
				this.$router.push({ name: 'GongziListPage' })
			}
    },

  }
</script>

<style scoped>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

	* {
		/*width: 100%;*/
		font-family: 'Noto Sans KR', sans-serif;
	}

	/*.main_wrap {*/
	/*	width: 1200px;*/
	/*	margin: 0 auto;*/
	/*}*/

	/*이미지 슬라이드*/
	.swiper-container {
		--swiper-theme-color: #fff;
		--swiper-pagination-color: #ffffff;
	}

	.swiper_bn {
		height: 700px;
		position: relative;
	}

	.swiper_bn .swiper-slide {
		display: flex;
		justify-content: center;
		align-items: center;
		text-align: center;
		font-weight: bold;
	}

	.swiper_bn .swiper-slide img {
		width: 100%;
	}

	#crawl-box {
		/*width: 1900px;*/
		height: 270px;
		border: 0px solid #000000;
		padding: 40px 0 27px 0;
		display: block;
	}

	.pages {
		text-align: center;
		display: block;
	}

	.banner {position: relative;}

	#search-icon {
		/* Box */
		height: 60px;
		width: 66px;
		margin: 0px;
		padding: 13px 18px 15px 20px;


		/* Positioning */
		position: absolute;
		top: -7px;
		bottom: 0px;
		right: 0px;
		left: 390px;
		float: none;
		display: flex;
		clear: none;
	}

	#tabHouse::after {
		display: block;
		content: "";
		position: absolute;
		z-index: -1;
		top: 80%;
		left: 50%;
		transform: translate( -50%, 0% );
		min-width: 700px;
		height: 300px;
		background: #fff;
		opacity: 0.6;
	}

	#tabHouse {
		align-content: center;
		height: 174px;
		width: 484px;
		font-size: 16px;
		line-height: 16px;
		display: block;
		margin: 0 auto;
		position: absolute;
		z-index: 1;
		top: 20%;
		left: 50%;
		transform: translate( -50%, -50% );
	}

	#search {
		/* Font & Text */
		font-size: 16px;
		font-style: normal;
		font-variant: normal;
		font-weight: 400;
		letter-spacing: normal;
		line-height: 16px;
		text-decoration: none solid rgb(0, 0, 0);
		text-align: start;
		text-indent: 0px;
		text-transform: none;
		vertical-align: baseline;
		white-space: normal;
		word-spacing: 0px;

		/* Color & Background */
		background-color: rgb(242, 242, 242);
		background-image: none;
		background-position: 0% 0%;
		background-repeat: repeat;
		color: rgb(0, 0, 0);

		/* Box */
		height: 60px;
		width: 410px;
		margin: 0px;
		padding: 6px 20px 10px 20px;

		/* Positioning */
		position: relative;
		top: 0px;
		bottom: 0px;
		right: 0px;
		left: 0px;
		float: none;
		display: flex;
		clear: none;
		z-index: 0;

		/* Effects */
		border-top-left-radius: 8px;
		border-top-right-radius: 8px;
		border-bottom-left-radius: 8px;
		border-bottom-right-radius: 8px;
	}

	.main_text {
		text-align: center;
		line-height: 426px;
		font-size: 40px;
		font-weight: 700;
		background: 0% 0%;
		white-space: pre-wrap;
		text-decoration: none solid rgb(0, 0, 0);
		display: block;
		/*margin: 0 129px 0 129px;*/
		height: 276px;
		color: #000;
	}

	/* 뉴스, 공지사항 영역 시작 */
	.board_content {
		padding: 15px 0;
		width: 1400px;
		margin: 0 auto;
		margin-top: 100px;
	}

	.board_content::after, .board_content .more_btn::after {
		display: block;
		content: '';
		clear: both;
	}

	.board_content article {
		float: left;
		width: calc(80% / 2);
		margin-right: 20%;
	}

	.board_content article:nth-child(2) {
		margin-right: 0;
	}

	.board_content article h2 {
		font-size: 19px;
		padding-bottom: 14px;
	}

	.board_content article .more_btn > h2 {
		float: left;
		padding-left: 2px;
		font-size: 22px;
	}

	.board_content article .more_btn .v-btn {
		float: right;
		font-size: 12px;
		padding: 0;
	}

	.board_content hr {
		height: 1px;
		border: none;
		background-color: #ccc;
	}

	.board_content article ul {
		margin-top: 14px;
		padding-left: 0;
	}

	.board_content article ul li {
		padding: 3px 0;
	}

	/* 소개할게요, 뉴스, 공지사항 영역 끝 */

	.form_control {
		width: 500px;
		text-decoration: none;
	}

	/* store */
	.store {
		width: 1400px;
		margin: 0 auto;
		padding: 100px 0;
		/*margin-bottom: 300px;*/
	}

	.store::after, .store .title_bg::after, .store .product::after {
		display: block;
		content: '';
		clear: both;
	}

	.store .title_bg {
		float: left;
		width: 23%;
		/*margin-right: 100px;*/
		/*border: 1px solid red;*/
		box-sizing: border-box;
	}

	.store .product {
		float: left;
		width: 77%;
		/*border: 1px solid red;*/
		box-sizing: border-box;
	}

	.store .product img {
		/*width: 12%;*/
		width: calc(94%/4);
		margin-right: 2%;
	}

	.store .product img:last-child {
		margin-right: 0;
	}

	/* 아이콘 */
	#icon_wrap {
		width: 100%;
		/*padding: 50px 40px;*/
		padding: 50px 0px;
		box-sizing: border-box;
		transition: 0.5s;
		background-color: rgba(238, 238, 238, 0.45);
		margin: 50px 0;
		/*border: 1px solid red;*/
	}

	#icon_wrap::after, #icon_wrap .inner::after{
		content: "";
		display: block;
		clear: both;
	}

	#icon_wrap .inner {
		width: 1400px;
		margin: 0 auto;
		/*border: 1px solid red;*/
	}

	#icon_wrap .inner h1 {
		/*float: left;*/
		margin-bottom: 35px;
		font-size: 25px;
	}

	#icon_wrap .inner .icon {
		/*float: right;*/
		transition: 0.5s;
		box-sizing: border-box;
	}

	#icon_wrap .inner .icon article {
		float: left;
		margin-right: 3%;
		/*width: 58px;*/
		width: calc(88%/5);
	}

	#icon_wrap .inner .icon article:nth-of-type(5) {
		margin-right: 0px;
		/*border: 1px solid red;*/
	}

	#icon_wrap .inner .icon article .pic {
		width: 100%;
		height: 58px;
		text-align: center;
	}

	#icon_wrap .inner .icon article .pic > i {
		font-size: 40px;
		color: #777;
		transition: .3s;
	}

	#icon_wrap .inner .icon article .pic > p {
		font-size: 12px;
		margin-top: 10px;
	}

	#icon_wrap .inner .icon article .pic:hover i {
		transform: scale(1.2);
	}

</style>
