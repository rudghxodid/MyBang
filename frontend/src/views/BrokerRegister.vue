<template>
    <div>
		<div class='grad'>
			<div id=main-text>
                <v-row dense class="main-card">
                <v-card class="mx-auto" max-width="354" outlined>
                    <span>내방 파트너 중개사가 되어 내방의 광고효과를 직접 경험해보세요!</span>
                </v-card>
                <v-card class="mx-auto" max-width="354" outlined>asdasd</v-card>
                </v-row>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'BrokerRegister',
    data() {
      return {
        item: [
           require('@/assets/img/Interior.jpg'),
        ],
      }
    },
}
</script>

<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

	* {
		font-family: 'Noto Sans KR', sans-serif;
	}



	.grad{
		/*width: 1900px;*/
		height: 300px;
        background: blue;
        

	}

    #main-text{
		text-align: justify;
		line-height: 240px;
		font-size: 12px;
		font-weight: 400;
		background: 0% 0%;
		white-space: pre-wrap;
		text-decoration: none solid rgb(0, 0, 0);
		display: block;
		margin: 0px 0px 0px 0px;
		height: 300px;
	}

    main-card{
       	margin: 0px 0px 0px 0px;
        color: white; 
    }
</style>