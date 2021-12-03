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
			<div class="store_bg"></div>
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
							<span>콰트로 에어 데스크 16size</span>
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
							<span>프라제르 아쿠아텍스 4인용 소파</span>
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
							<router-link to="/villa">
								<v-icon>mdi-home-floor-2</v-icon>
								<p>빌라,투룸</p>
							</router-link>
						</div>
					</article>
					<article>
						<div class="pic">
							<router-link to="/oneroom">
								<v-icon>mdi-home-floor-1</v-icon>
								<p>원룸</p>
							</router-link>
						</div>
					</article>
					<article>
						<div class="pic">
							<router-link to="/officetel">
								<v-icon>mdi-home-city</v-icon>
								<p>오피스텔</p>
							</router-link>
						</div>
					</article>
					<article>
						<div class="pic">
							<router-link to="/roommate">
								<v-icon>mdi-account-multiple</v-icon>
								<p>룸메구하기</p>
							</router-link>
						</div>
					</article>
					<article>
						<div class="pic">
							<router-link to="/gongzi">
								<v-icon>mdi-bullhorn</v-icon>
								<p>공지사항</p>
							</router-link>
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

	* {
		font-family: 'Noto Sans KR', sans-serif;
	}

	a, em, strong, b {
		font-style: normal;
		font-weight: normal;
		text-decoration: none;
		color: #000;
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
		padding: 200px 0;
		/*margin-bottom: 300px;*/
		position: relative;
		/*border: 1px solid red;*/
	}

	.store_bg::after {
		display: block;
		content: '';
		background: #adf5f6;
		border-radius: 0 0 30px 0;
		width: 64%;
		height: 500px;
		position: absolute;
		top: 50%;
		left: 0%;
		transform: translate(-56%, -50%);
	}

	.store::after, .store .title_bg::after, .store .product::after, .store .product .itemImg::after {
		display: block;
		content: '';
		clear: both;
	}

	.store .title_bg {
		float: left;
		width: 23%;
		box-sizing: border-box;
		position: relative;
		z-index: 1;
		margin-top: 80px;
	}

	.store .title_bg h1 {
		font-weight: bold;
	}

	.store .title_bg p {

	}

	.store .title_bg .v-btn {
		margin-top: 50px;
		border-radius: 20px;
	}

	.store .product {
		float: left;
		width: 77%;
		/*border: 1px solid red;*/
		box-sizing: border-box;
		position: relative;
		z-index: 1;
		border-radius: 20px;
	}

	.store .product .itemImg {
		float: left;
		width: calc(94%/4);
		margin-right: 2%;
		box-shadow: 5px 5px 8px #ddd;
		border-radius: 20px;
	}

	.store .product .itemImg:last-child {
		margin-right: 0;
	}

	.store .product .itemImg img {
		width: 100%;
		border-radius: 20px 20px 0 0;
	}

	.store .product .itemImg .itemText {
		background: #fff;
		padding: 15px 20px;
		border-radius: 0 0 20px 20px;
	}

	.store .product .itemImg .itemText h2 {
		line-height: 0.8;
	}

	.store .product .itemImg .itemText h2 span:first-child {
		color: #aaa;
		font-size: 13px;
		display: block;
		margin-top: 2px;
	}

	.store .product .itemImg .itemText h2 span:last-child {
		/*border: 1px solid red;*/
		color: #333;
		font-size: 15px

	}

	.store .product .itemImg .itemText p {
		color: #000;
		font-size: 18px;
		font-weight: bold;
		margin-bottom: 3px;
	}

	.store .product .itemImg .itemText strong {
		font-size: 13px;
		color: #5a92db;
	}

	.store .product .itemImg .itemText > span {
		color: #888;
		font-size: 13px;
		font-weight: bold;
	}

	/* 아이콘 */
	#icon_wrap {
		width: 100%;
		/*padding: 50px 40px;*/
		padding: 50px 0px;
		box-sizing: border-box;
		transition: 0.5s;
		background-color: rgba(238, 238, 238, 0.45);
		margin: 150px 0;
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

	#icon_wrap .inner .icon article .pic i {
		font-size: 40px;
		color: #777;
		transition: .3s;
	}

	#icon_wrap .inner .icon article .pic p {
		font-size: 13px;
		margin-top: 10px;
		color: #000;
	}

	#icon_wrap .inner .icon article .pic:hover i {
		transform: scale(1.2);
	}

</style>
