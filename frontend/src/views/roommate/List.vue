<template>

	<div class="list_wrap">
		<a href="/">간다 홈으로</a>
		<h1>구한다 룸메</h1>

		<table class="table table-hover">

			<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회</th>
			</tr>
			</thead>

			<tbody>
			<tr v-for="(b, index) in boardList" :key="index">
				<td>{{b[0].id}}</td>
				<td>
					<router-link :to="`/community/detail/${b[0].id}`">{{b[0].title}}</router-link>
				</td>
				<td>{{b[0].writerName}}</td>
				<td>{{b[0].createdAt}}</td>
				<td>{{b[0].count}}</td>
			</tr>
			</tbody>

		</table>

		<div class="btn_wrap">
			<b-button @click="onClickWriteBtn">글쓰기</b-button>
		</div>
		<b-pagination aria-controls="my-table" align="center" first-class="first" prev-class="prev" next-class="next"
          last-class="last"
          v-model="currentPage" :total-rows="totalItems" :per-page="perPage"
          @change="handlerPagenation">
		</b-pagination>

	</div>

</template>

<script>
  export default {
    name: "RoomMateList",
    methods: {
      onClickWriteBtn() {
        this.$router.push({name: 'RoomMateCreate'});
      },
    },
    data() {
      return {
        currentPage: 1, // 현재 페이지
        perPage: 10, // 페이지당 보여줄 갯수
        totalPage: '',
        totalItems: '',
        // bootstrap 'b-table' 필드 설정
        boardList: [],
        // items: items
      };
    },
    // methods : {
    //   async fetchRoomMateList() {
    //     return await axios.get('http://localhost:7777/roommate/list/')
    //       .then((res) => {
    //         this
    //         }
    //
    //       )
    //   }
    // },
  }
  // import api from "../../api/api";
  // import dayjs from "dayjs";
  //
  // export default {
  //   name: "RoomMateList",
  //   async mounted() {
  //     await this.fetchBoardList();
  //   },
  //   data() {
  //     return {
  //       currentPage: 1, // 현재 페이지
  //       perPage: 10, // 페이지당 보여줄 갯수
  //       totalPage: '',
  //       totalItems: '',
  //       // bootstrap 'b-table' 필드 설정
  //       boardList: [],
  //       // items: items
  //     };
  //   },
  //   methods: {
  //     async fetchBoardList() {
  //       return await api.get(`/list/${this.currentPage}/${this.perPage}`)
  //         .then((res) => {
  //           this.boardList = res.data.data.content;
  //           this.boardList.map((v) => {
  //             v[0].createdAt = dayjs(v[0].createdAt).format("YYYY-MM-DD HH:mm");
  //           })
  //           this.totalPage = res.data.data.totalPages;
  //           this.totalItems = res.data.data.totalElements;
  //           console.log(this.boardList);
  //         }).catch((err) => {
  //           console.log(err);
  //           alert("게시글 목록 조회 오류");
  //         });
  //     },
  //     rowClick(item) {
  //       this.$router.push({
  //         path: `/community/detail/${item.id}`
  //       });
  //     },
  //     onClickWriteBtn() {
  //       this.$router.push({name: 'BoardCreate'});
  //     },
  //     async handlerPagenation(v) {
  //       this.currentPage = v;
  //       await this.fetchBoardList();
  //     }
  //   },
  //   computed: {
  //     rows() {
  //       return this.items.length;
  //     }
  //   },
  // }
</script>

<style scoped>
	.list_wrap {
		width: 1200px;
		/*height: 100vh;*/
		display: flex;
		flex-direction: column;
		/*justify-content: space-evenly;*/
		align-items: center;
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
		color: red;
	}

	/*테이블*/
	table {
		margin-top: 50px;
		width: 100%;
		/*table-layout: fixed;*/
		text-align: center;
	}

	table th, td {
		padding: 10px;
	}

	table thead tr th:nth-child(1) {
		width: 7%;
	}

	table thead tr th:nth-child(2) {
		width: 63%;
	}

	table thead tr th:nth-child(3) {
		width: 10%;
	}

	table thead tr th:nth-child(4) {
		width: 13%;
	}

	table thead tr th:nth-child(5) {
		width: 7%;
	}

	table tbody tr td:nth-child(2) {
		text-align: justify;

	}

	table tbody tr td:nth-child(2) a {
		color: #212529;
		display: block;
		padding: 0px 35px;
	}


	.btn_wrap {
		width: 100%;
	}

	b-button {
		width: 90px;
		height: 35px;
		color: #555;
		background-color: rgb(222, 221, 221);
		border: none;
		border-radius: 5px;
		font-size: 18px;
		line-height: 35px;
		text-align: center;
		float: right;
		font-family: 'Gowun Dodum', sans-serif;
	}

	.pagination {
		margin-top: 50px;
	}

	.page-item .page-link {
		color: red;
	}


</style>
