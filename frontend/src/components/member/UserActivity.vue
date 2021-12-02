<template>
  <v-card class="grey lighten-4">
    <v-expansion-panels>
      <v-expansion-panel>
        <v-expansion-panel-header>
          내가 쓴 게시글
        </v-expansion-panel-header>
        <v-expansion-panel-content>
          <!--
          <v-card>
            <v-list v-for="list in roomMateList" :key="list.index">
              <v-list-item-group>
                <v-list-item two-line @click="roommateDetail(list.id)">
                  <v-list-item-content>
                    <v-list-item-title>
                      {{ list.title }}
                    </v-list-item-title>
                    <v-list-item-subtitle class="caption">
                      {{ list.createdDate }}
                    </v-list-item-subtitle>
                  </v-list-item-content>
                </v-list-item>
              </v-list-item-group>
            </v-list>
          </v-card>
          -->
          <user-activity-compo :lists="roomMateList"></user-activity-compo>
        </v-expansion-panel-content>
      </v-expansion-panel>
      <v-expansion-panel>
        <v-expansion-panel-header>
          내가 쓴 댓글
        </v-expansion-panel-header>
        <v-expansion-panel-content>
          <!--
          <v-card>
            <v-list v-for="list in calData" :key="list.index">
              <v-list-item-group>
                <v-list-item two-line @click="roommateDetail(list.boardNo)">
                  <v-list-item-content>
                    <v-list-item-title>
                      {{ list.content }}
                    </v-list-item-title>
                    <v-list-item-subtitle class="caption">
                      {{ list.createdDate }}
                    </v-list-item-subtitle>
                  </v-list-item-content>
                </v-list-item>
              </v-list-item-group>
            </v-list>

            <v-pagination
              v-model="curPageNum"
              :length="numOfPages"
              >
            </v-pagination>
          </v-card>
          -->
          <user-activity-compo :lists="roomMateCommentList"></user-activity-compo>
        </v-expansion-panel-content>
      </v-expansion-panel>
      <v-expansion-panel v-if="userInfo.authList[0].auth == '사업자'">
        <v-expansion-panel-header>
          내 매물 목록
        </v-expansion-panel-header>
        <v-expansion-panel-content>
          
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-expansion-panels>
  </v-card>
</template>


<script>
import UserActivityCompo from '@/components/member/UserActivityCompo'
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  components: {
    UserActivityCompo
  },
  data () {
    return {
      roomMateList: null,
      roomMateCommentList: null,
      houseList: null,
      dataPerPage: 3,
      curPageNum: 1,
      
    }
  },
  computed: {
    ...mapState(['userInfo']),
    // startOffset() {
    //   return ((this.curPageNum - 1) * this.dataPerPage)
    // },
    // endOffset() {
    //   return (this.startOffset + this.dataPerPage)
    // },
    // numOfPages() {
    //   if (this.roomMateCommentList) {
    //     return Math.ceil(this.roomMateCommentList.length / this.dataPerPage)
    //   } else {
    //     return 1
    //   }
    // },
    // calData() {
    //   if (this.roomMateCommentList) {
    //     return this.roomMateCommentList.slice(this.startOffset, this.endOffset)
    //   } else {
    //     return this.roomMateCommentList
    //   }
    // }
  },
  watch: {

  },
  created () {
    axios.get(`http://localhost:7777/roomMate/list/${this.userInfo.userId}`).then(res => {
      this.roomMateList = res.data.reverse()
      console.log(this.roomMateList)
    })

    axios.get(`http://localhost:7777/roomMateComment/list/${this.userInfo.memberNo}`).then(res => {
      this.roomMateCommentList = res.data.reverse()
      console.log(this.roomMateCommentList)
    })
    
  },
  methods: {
    // roommateDetail (id) {
    //   this.$router.push({ name: 'RoomMateDetail', params: { id: id } } )
    // },
  }
}
</script>