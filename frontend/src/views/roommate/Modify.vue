<template>
	<div class="modify_wrap">
		<a href="/">간다 홈으로</a>
		<div class="form_wrap">
			<h2>쓴다 글</h2>
			<b-input v-model="detail.title" placeholder="제목을 입력해주세요."></b-input>
			<b-form-textarea
							v-model="detail.content"
							placeholder="내용을 입력해 주세요"
							rows="13"
							max-rows="6"

			></b-form-textarea>

		</div>

		<br>
		<b-button @click="onClickSaveBtn">저장</b-button>&nbsp;
		<b-button @click="onClickCancleBtn">취소</b-button>
	</div>
</template>

<script>
  import api from "../../api";
  export default {
    name: "RoomMateModify",
    data() {
      return {
        // userId: this.$store.state.userInfo.id,
        // id: this.$route.params.id,
        detail: {
          title: '',
          content: '',
          writer: '',
          createdAt: '',
        },
      }
    },
    methods: {
      onClickSaveBtn() {

          // 글작성
          api.post(`/roomMate/create`, {
            title: this.detail.title,
            content: this.detail.content,
            writer: this.userId,
          })
            .then((res) => {
              this.$router.push({name: "RoomMateList", params: {id: res.data.id }});
              alert("등록 성공");
            }).catch((err) => {
            console.log(err);
            alert("등록 실패");
          });

      },
      onClickCancleBtn() {
        this.$router.push({name: "RoomMateList"});
      }
    }
  }
</script>

<style scoped>
	.modify_wrap {
		width: 1200px;
		padding-top: 100px;
		margin: 0 auto;
		font-family: 'Gowun Dodum', sans-serif;
	}

	.v-application a {
		text-decoration: none;
		background-color: #000;
		color: yellow;
		padding: 5px;
	}

	h1 {
		font-size: 33px;
		font-weight: bold;
		width: 100%;
		color: rgb(229, 119, 175);
	}

	.form_wrap {
		border: 1px solid rgba(0, 0, 0, 0.125);
		border-radius: 5px;
		padding: 30px 50px;
		background: linear-gradient(to right, #0088ff, mediumpurple, pink 80%);
		margin-top: 45px;
	}

	h2 {
		font-size: 25px;
		color: #e74141;
		font-weight: bold;
	}

	input {
		width: 40%;
		margin-top: 30px;
	}

	textarea {
		margin-top: 10px;
	}




	.btn_wrap {
		width: 100%;
	}

	.btn {
		width: 90px;
		height: 35px;
		color: #fff;
		background-color: rgb(184, 213, 172);
		border: none;
		border-radius: 5px;
		font-size: 18px;
		line-height: 18px;
		float: right;
		font-family: 'Gowun Dodum', sans-serif;
	}

	.btn:nth-of-type(2) {
		background-color: #fff;
		color: #000;
		font-weight: bold;
	}
</style>
