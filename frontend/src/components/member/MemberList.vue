<template>
	<div>
		<v-simple-table>
			<template v-slot:default>
				<thead>
					<tr>
						<th>선택</th>
						<th>번호</th>
						<th>아이디</th>
						<th>이메일</th>
						<th>이름</th>
						<th>생일</th>
						<th>성별</th>
						<th>전화번호</th>
						<th>권한</th>
						<th>정지여부</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="member of members" :key="member.userId">
						
						<v-checkbox v-model="selected" :value="member.userId"></v-checkbox>
						
						<td>{{ member.memberNo }}</td>
						<td>{{ member.userId }}</td>
						<td>{{ member.email }}</td>
						<td>{{ member.name }}</td>
						<td>{{ member.birth }}</td>
						<td>{{ member.sex }}</td>
						<td>{{ member.phone }}</td>
						<td>{{ member.authList[0].auth }}</td>
						<td v-if="member.pause == 0"></td>
						<td v-else>정지</td>
					</tr>
				</tbody>
			</template>
		</v-simple-table>

		<v-dialog v-model="dialog" max-width="400">
			<template v-slot:activator="{ on }">
				<v-btn v-on="on">삭제</v-btn>
			</template>
			<v-card class="pa-2">

				<v-card-title>정말 회원을 삭제하시겠습니까??</v-card-title>
				
				<v-card-actions>
					<v-btn @click="cancel">취소</v-btn>
					<v-spacer></v-spacer>
					<v-btn @click="deleteUser">확인</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>

		<v-dialog v-model="pausedialog" max-width="400">
			<template v-slot:activator="{ on }">
				<v-btn v-on="on">정지</v-btn>
			</template>
			<v-card class="pa-2">
				<v-card-title>정말 회원을 정지시키겠습니까??</v-card-title>
				
				<v-card-actions>
					<v-btn @click="cancel">취소</v-btn>
					<v-spacer></v-spacer>
					<v-btn @click="pauseUser">확인</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>

		<v-dialog v-model="hostDialog" max-width="400">
			<template v-slot:activator="{ on }">
				<v-btn v-on="on">관리자</v-btn>
			</template>
			<v-card class="pa-2">
				<v-card-title>관리자 권한을 주시겠습니까?</v-card-title>
				
				<v-card-actions>
					<v-btn @click="cancel">취소</v-btn>
					<v-spacer></v-spacer>
					<v-btn @click="hostUser">확인</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>
	</div>
</template>


<script>
import axios from 'axios'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'MemberList',
	data() {
		return {
			headerTitle: [
				{ text: '회원번호', value: 'memberNo', width: "100px" },
				{ text: '아이디', value: 'userId', width: "200px" },
				{ text: '이메일', value: 'email', width: "100px" },
				{ text: '이름', value: 'name', width: "100px" },
				{ text: '생일', value: 'birth', width: "100px" },
				{ text: '성별', value: 'sex', width: "100px" },
				{ text: '전화번호', value: 'phone', width: "100px" },
				{ text: '정지여부', value: 'pause', width: "100px" }
				],
			selected: [],
			userId: null,
			dialog: false,
			pausedialog: false,
			hostDialog: false
		}
	},
	computed: {
		...mapState(['members']),
	},
	mounted() {
		this.fetchMemberList()
	},
	methods: {
		...mapActions(['fetchMemberList']),
		cancel () {
			this.dialog = false
			this.pausedialog = false
			this.hostDialog = false
		},
		deleteUser () {
			if(this.selected.length == 1){
				axios.delete(`http://localhost:7777/member/remove/${this.selected}`).then(() => {
					this.dialog = false
					this.fetchMemberList()
					alert('탈퇴가 완료되었습니다.')
				})
			}
			if(this.selected.length > 1){
				for(let i = 0; i < this.selected.length; i++){
					axios.delete(`http://localhost:7777/member/remove/${this.selected[i]}`).then(() => {
						this.dialog = false
						this.fetchMemberList()
						alert('탈퇴가 완료되었습니다.')
					})
				}
			}
		},
		pauseUser() {
			axios.post(`http://localhost:7777/member/pause/${this.selected}`)
			.then(() =>{
				this.pausedialog = false
				this.fetchMemberList()
				alert("해당아이디는 정지 하였습니다.")
			})
		},
		hostUser () {
			axios.post(`http://localhost:7777/member/host/${this.selected}`).then(()=> {
				this.hostDialog = false
				this.fetchMemberList()
				alert('해당 아이디에 관리자 권한을 부여하였습니다.')
			})
		}
			
	},

    
    
}
</script>
