
<template>
    <div>
       <v-simple-table>
                <template v-slot:default>
                    <thead>
                        <tr>
                            
                            
                            <th class="text-left" style="width:30px;">체크</th>
                            <th class="text-center">회원번호</th>
                            <th class="text-center">아이디</th>
                            <th class="text-center">이메일</th>
                            <th class="text-center">이름</th>
                            <th class="text-center">생일</th>
                            <th class="text-center">성별</th>
                            <th class="text-center">전화번호</th>
                            <th class="text-center">정지여부</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="member of members" :key="member.userId">
                            
                            <v-checkbox
                            v-model="selected"
                            label=""
                            :value="member.userId" 

                            ></v-checkbox>
                            <td style="color: gray">{{ member.memberNo }}</td>
                            <!-- <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td> -->
                            <td>{{ member.userId }}</td>
                            <td>{{ member.email }}</td>
                            <td>{{ member.name }}</td>
                            <td>{{ member.birth }}</td>
                            <td>{{ member.sex }}</td>
                            <td>{{ member.phone }}</td>
                            <td>{{ member.pause }}</td>

                        </tr>
                    </tbody>
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
                        <v-btn @click="paseUser">확인</v-btn>
                    </v-card-actions>
                    </v-card>
                </v-dialog>

                
            
                </template>
            </v-simple-table>
            
            


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
            
            
        }
    },
    props: {
        members: {
            type: Array,
            require: true
        }
    },
 
 
    methods: {
        ...mapActions(['fetchMember']),
        ...mapActions(['fetchSession']),
    cancel () {
      this.dialog = false
    },
      deleteUser () {
      if(this.selected.length == 1){
      axios.delete(`http://localhost:7777/member/remove/${this.selected}`).then(() => {
        this.dialog = false
        this.$store.commit('USER_LOGIN', false)
        
        this.fetchSession(this.$cookies.remove('session'))
        this.$store.commit('FETCH_USER_INFO', [])
        alert('탈퇴가 완료되었습니다.')
        this.$router.go();
      })
      }
      if(this.selected.length > 1){
        for(let i = 0; i < this.selected.length; i++){
      axios.delete(`http://localhost:7777/member/remove/${this.selected[i]}`).then(() => {
        this.dialog = false
        
        this.$store.commit('USER_LOGIN', false)
        
        this.fetchSession(this.$cookies.remove('session'))
        this.$store.commit('FETCH_USER_INFO', [])
        
        this.$router.go();
      })
      }
      alert('탈퇴가 완료되었습니다.')
      }
    },
    pauseUser() {
          axios.post(`http://localhost:7777/member/pause/${this.selected}`)
          .then( () =>{
              alert("해당아이디는 정지 하였습니다.")
              this.$router.go()
          })
      },
       
    },
    computed: {
         ...mapState(['member']),
         ...mapState(['userInfo'])
    },
    mounted() {
    this.userId = this.userInfo.userId
    },
    
    
}
</script>
