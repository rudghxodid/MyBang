<template>
	<div class="detail_wrap">
		<div class="detail_inner">
			<h1>커뮤니티</h1>
			<div class="detail_title">
				<h1>{{ this.board.title }}</h1>
				<div class="detail_subtitle">
					<span>{{ this.board.writerName }}</span>
					<strong>{{ this.board.createdAt }}</strong>
					<em>조회수 <b>{{ this.board.count }}</b></em>
				</div>
			</div>

			<div class="detail_body" v-html="content">
				<p>{{ this.board.content }}</p>
			</div>


			<div class="detail-button">
<!--				<b-button @click="onClickModifyBtn" v-if="userId === board.writerName" class="btn_modify">수정</b-button>-->
<!--				<b-button @click="onClickDeleteBtn" v-if="userId === board.writerName" class="btn_delete">삭제</b-button>-->
				<b-button @click="onClickModifyBtn" class="btn_modify">수정</b-button>
				<b-button @click="onClickDeleteBtn" class="btn_delete">삭제</b-button>
				<b-button @click="onClickListBtn" class="btn_list">목록</b-button>
			</div>

<!--			<div class="int-area">-->
<!--				<input-->
<!--								type="text"-->
<!--								placeholder="댓글을 입력해주세요."-->
<!--								autocomplete="off"-->
<!--								required-->
<!--								v-model="commentInput"-->
<!--								@keyup="onKeyUpCommentBtn"-->
<!--				>-->
<!--				<button @click="onClickCommentBtn">등록</button>-->
<!--			</div>-->

<!--			<div v-for="(cl, index) in commentList" class="content-detail-comment" :key="index">-->
<!--				<div>-->
<!--					&lt;!&ndash; 닉네임 &ndash;&gt;-->
<!--					<span class="commentNick">{{ cl[1].nickname }}</span>-->

<!--					&lt;!&ndash; 댓글 내용 &ndash;&gt;-->
<!--					<div v-if="cl[0].edit === true" style="display: inline-block">-->
<!--						<input v-model="cl[0].editContent" style="border: 1px solid black" @keyup="onKeyupEditInput($event, cl[0].id, index)">-->
<!--					</div>-->
<!--					<div v-else>-->
<!--						<p class="commentContent">{{ cl[0].content }}</p>-->
<!--					</div>-->

<!--					&lt;!&ndash; 댓글 작성일 &ndash;&gt;-->
<!--					<span class="commentTime">{{ cl[0].createdAt }}</span>-->

<!--					&lt;!&ndash; 저장 및 수정 삭제 버튼 &ndash;&gt;-->
<!--					<div v-if="cl[0].edit === true" style="display: inline-block">-->
<!--						<span @click="onClickCommentSave(cl[0].id, index)">저장</span>-->
<!--						<span @click="onClickCancleBtn(cl[0].id, index)">취소</span>-->
<!--					</div>-->
<!--					<div v-else-if="!cl[0].edit && cl[1].id === userId">-->
<!--						<span @click="onClickCommentModify(cl[0].id, index)">수정</span>-->
<!--						<span @click="onClickCommentDelete(cl[0].id)">삭제</span>-->
<!--					</div>-->

<!--				</div>-->
<!--			</div>-->
		</div>
	</div>
</template>

<script>
  import api from "../../api";
  import dayjs from "dayjs";

  export default {
    name: "RoomMateDetail",
    async mounted() {
      if (!this.userId) {
        alert("권한이 없습니다. 로그인 화면으로 이동합니다.");
        this.$router.push({name: "MemberLoginPage"});
      } else {
        await this.fetchRoomMateDetail();
      }
    },
    data() {
      return {
        userId: this.$store.state.userInfo.userId,
        id: this.$route.params.id,
        // commentList: [],
        board: {
          id: '',
          title: '',
          content: '',
          writer: '',
          createdAt: '',
          writerName: '',
          count: '',
        },
        // commentInput: '',
      };
    },
    computed: {
      content() {
        return this.board.content.split('\n').join('<br>');
      }
    },
    methods: {
			async fetchRoomMateDetail() {
			  await api.get(`/roomMate/${this.id}`)
          .then((res) => {
            console.log(res);
            this.board.title = res.data.title;
            this.board.content = res.data.content;
            this.board.writer = res.data.writer;
            this.board.writerName = res.data.writerName;
            this.board.count = res.data.count;
            this.board.createdAt = dayjs(res.data.createdAt).format("YYYY-MM-DD HH:mm");
          })
          .catch((err) => {
            console.log(err);
            alert("게시글 조회 오류");
          })
			},
      onClickModifyBtn() {
        this.$router.push({name: "RoomMateModify", params: {id: this.id}});
      },
      async onClickDeleteBtn() {
        if (confirm("삭제하시겠습니까?")) {
          await api.delete(`/roomMate/delete/${this.id}`)
            .then((res) => {
              if (res.data === "") {
                alert('글 삭제 성공');
                this.$router.push({name: "RoomMateList"});
              } else {
                alert('글 삭제 실패');
              }
            })
            .catch((err) => {
              console.log(err);
              alert("알 수 없는 오류 발생");
            })
        }
      },
      onClickListBtn() {
        this.$router.push({name: "RoomMateList"});
      },
    }
  }
</script>

<style scoped>


	.detail_wrap {
		width: 1200px;
		margin-top: 100px;
		margin: 0 auto;
		font-family: 'Gowun Dodum', sans-serif;
	}

	.detail_inner {
		width: 1000px;
	}

	a, em, strong, b {
		font-style: normal;
		font-weight: normal;
		text-decoration: none;
	}

	/* 컨텐츠 제목 */
	.detail_title {
		/*text-align: justify;*/

		padding: 20px 0;
	}

	.detail_title h1 {
		color: rgb(99, 99, 99);
	}

	.detail_title .detail_subtitle {
		margin-top: 25px;
	}

	.detail_title .detail_subtitle span {
		font-weight: bold;
		margin-right: 25px;
		background: linear-gradient(to top, #a3f5a8 50%, transparent 50%);
	}

	.detail_title .detail_subtitle strong {
		font-size: 15px;
	}

	.detail_title .detail_subtitle em {
		float: right;
		font-size: 14px;
	}

	.detail_title .detail_subtitle em b {
		font-weight: bold;
		font-size: 15px;
	}


	/* 컨텐츠 */
	.detail_body {
		padding: 50px 10px;
		font-size: 18px;
		border-top: 1px solid rgba(0, 0, 0, .1);
		border-bottom: 1px solid rgba(0, 0, 0, .1);
		width: 100%;
		word-wrap:break-word;
		word-break:break-all;
	}




	/* 컨텐츠 버튼 */
	.detail-button {
		/*border: 1px solid red;*/
		padding: 15px 0;
	}

	.detail-button .btn {
		background-color: #fff;
		color: #000;
		border: 1px solid #bbb;
	}

	.detail-button .btn_modify {
		margin-right: 10px;
	}

	.detail-button .btn_delete {
		background-color: #f15c5c;
		color: #fff;
		border: 1px solid #f15c5c;
	}

	.detail-button .btn_list {
		float: right;
	}

	.detail-button:after {
		display: block;
		content: '';
		clear: both;
	}


	.content-detail-comment {
		border-top: 1px solid black;
		margin-top: 1rem;
		padding: 10px;
	}


	h1 {
		font-size: 33px;
		font-weight: bold;
		width: 100%;
		color: rgb(229, 119, 175);
	}

	.detail_inner > h1 {
		font-size: 22px;
	}

	.int-area {
		margin-top: 20px;
		width: 100%;
	}

	.int-area input {
		padding: 10px;
		float: left;
		width: 95%;
	}

	.int-area > button {
		padding: 10px;
		color: #fff;
		background-color: rgb(229, 139, 185);
	}


	.commentNick {
		font-weight: bold;
		margin-right: 20px;
		margin-bottom: 5px;
		display: block;
	}

	.commentContent {
		font-size: 18px;
		width: 80%;
		float: left;
	}

	.commentTime {

	}
</style>
