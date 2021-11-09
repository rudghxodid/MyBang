<template>
    <div>
		<div class='grad'>
			<strong class="first_area_01" style="">
			    온라인 부동산! 내방으로 한번에 쉽게 해결하세요!<br>
				내방에서 확실한 광고 효과를 누리기 위해 최선을 다합니다.<br>
				<v-btn class="br_register" height="50px" color="blue" href="/member/create">중개사무소 회원가입 신청하기</v-btn>
				<div class="i_call_info"><p >문의전화 5959-1818 (05:09~18:18)</p></div>
			</strong>
        </div>
		<!--<div class='second_area' :style="{backgroundImage: 'url('+item+')'}"></div>-->


        <div class="bmj bmj_ct01" style="">
			<div class="sok" style="">
				<strong class="main_txt" style="">
					잘 만들어진 홈페이지!<br>
					이제는 마케팅의 핵심 전략입니다.
				</strong>
				<div class="readme" style="">
					<div class="rd rd01" style="">
						<span class="txt01" style="">스마트폰 사용자 90% 이상<br>중개사무소 가기 전 인터넷 매물검색</span>
						<span class="txt02" style="">발품보다 검색이 먼저!</span>
					</div>
					<div class="rd rd02" style="">
						<span class="txt01" style="">지도기반 부동산홈페이지,<br>웹사이트의 지속적인 사용률 증가!</span>
						<span class="txt02" style="">정확한 정보를 쉽고 빠르게!</span>
					</div>
					<div class="rd rd03" style="">
						<span class="txt01" style="">21세기 고객이 원하는 정보와<br>신뢰를 주는 번듯한 홈페이지는 기본!</span>
						<span class="txt02" style="">온라인 광고 브랜딩 필수</span>
					</div>
				</div>
			</div>
		</div>
    </div>
</template>

<script>
export default {
    name: 'BrokerRegister',
    data() {
      return {
		  	/*
		    item: [
           		require('@/assets/img/promotion_01.png'),
        ],
		*/
      }
    },
}
</script>

<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

	* {
		font-family: 'Noto Sans KR', sans-serif;
		box-sizing: border-box;
		-webkit-font-smoothing: antialiased;
	}

	div {
		display: block;
	}

	.grad{
		/*width: 1900px;*/
		height: 450px;
        background: blue;
        background: -webkit-linear-gradient(to left top , blue, rgb(134, 200, 255));  /* 그라데이션 효과를 준다 */
        background: -moz-linear-gradient(to left top , blue, rgb(134, 200, 255));
        background: -o-linear-gradient(to left top , blue, rgb(134, 200, 255));
        background: linear-gradient(to left top , blue, rgb(134, 200, 255));

	}

	.first_area_01{
		text-align: center;
		height: 500px;
		font-size: 30px;
		font-weight: 700;
		line-height: 57px;
		background: 0% 0%;
		white-space: pre-wrap;
		text-decoration: none solid rgb(0, 0, 0);
        color: white;
		display: block;
		margin: 0 129px 0 129px;
		display: block;
		font-size: 40px;
		letter-spacing: -1.5px;
		padding: 90px 0;
	}

	.br_register{
		width: 500px;
		height: 92px;
		border-radius: 20px/20px;
		margin-top: 50px;
		
	}

	.i_call_info {
		text-align: center;
		color: black;
		font-size: 20px;
		line-height: 230px;
		letter-spacing: 0.3px;
		margin-top: -20px;
	}
	
	

/* ---------------- 2번째 구역 시작 ---------------*/
	.second_area{
		text-align: center;
		height: 900px;
		margin: 0 0px 0px 477px;
		
		
	}

/* ---------------- 2번째 구역 끝 ---------------*/


/* ---------------- 3번째 구역 시작 ---------------*/
	.bmj_ct01 {
		padding: 70px 0 60px;
		background: #fff;
	}

	.bmj .main_txt {
		display: block;
		color: #129ded;
		font-size: 40px;
		font-family: 'Noto Sans KR-bold';
		text-align: center;
		line-height: 53px;
		letter-spacing: -1.5px;
	}

	.bmj .sok {
		position: relative;
		width: 1080px;
		margin: 0 auto;
		line-height: 1;
	}
	
	.bmj_ct01 .readme {
		display: flex;
		justify-content: space-between;
		width: 720px;
		margin: 53px auto 0;
	}

	.bmj_ct01 .readme .rd {
		display: flex;
		flex-wrap: wrap;
		justify-content: center;
		padding-top: 145px;
		width: 120px;
		text-overflow: ellipsis;
		white-space: nowrap;
		text-align: center;
	}

	.bmj_ct01 .readme .rd01 {
		background-image: url("https://www.bdsplanet.com/images/joininfo/ji01_01.png");
	}

	.bmj_ct01 .readme .rd02 {
		background-image: url("https://www.bdsplanet.com/images/joininfo/ji01_02.png");
	}

	.bmj_ct01 .readme .rd03 {
		background-image: url("https://www.bdsplanet.com/images/joininfo/ji01_03.png");
	}

	.bmj_ct01 .readme .rd .txt01, .bmj_ct01 .readme .rd .txt02 {
		display: block;
		text-align: center;
		font-size: 16px;
	}
/* ---------------- 3번째 구역 끝 ---------------*/

</style>