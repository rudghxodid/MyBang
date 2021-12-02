<template>
	<div class="modify_wrap">
		<div class="form_wrap">
			<h2>룸메 구하기</h2>
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
    mounted() {
      if (this.id) {
        console.log("==> this.id : ", this.id);

        api.get(`/roomMate/${this.id}`)
          .then((res) => {
            this.detail.title = res.data.title;
            this.detail.content = res.data.content;
            this.detail.writer = res.data.writer;
            this.detail.writerName = res.data.writerName;
            this.detail.createdAt = res.data.createdAt;
            console.log(res.data.board);
          })
          .catch((err) => {
            console.log(err);
            alert("게시글 조회 오류");
          })
      }
    },
    data() {
      return {
        userId: this.$store.state.userInfo.memberNo,
        id: this.$route.params.id,
        detail: {
          title: '',
          content: '',
          writer: '',
          createdAt: '',
          // writerName: '',
        },
      }
    },
    methods: {
      onClickSaveBtn() {
        if (this.id === undefined) {
          // console.log("==> this.id : ", this.id);
          // 글 작성
          api.post(`/roomMate/create`, {
            title: this.detail.title,
            content: this.detail.content,
            writer: this.userId,
            // writerName: this.userId,
          })
            .then((res) => {

              this.$router.push({name: "RoomMateList", params: {id: res.data.id }});
              alert("등록 성공");
            }).catch((err) => {
            console.log(err);
            alert("등록 실패");
          });
        } else {
          // 글 수정
	        api.post(`/roomMate/update/${this.id}`, {
            title: this.detail.title,
            content: this.detail.content,
            writer: this.userId,
            // writerName: this.userId,
	        })
	          .then((res) => {
              console.log("==> res : ", res);

              console.log(res);
	            this.$router.push({name: "RoomMateDetail", params: {id: this.$route.params.id}});
	            alert("수정 성공");
		          }).catch((err) => {
		            console.log("==> err : ", err);
		            alert("수정 실패");
		        })
        }
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
		background: none;
		margin-top: 45px;
	}

	h2 {
		font-size: 25px;
		color: #000;
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
