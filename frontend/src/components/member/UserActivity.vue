<template>
  <v-container>
    <v-card class="grey lighten-4">
      <v-expansion-panels v-model="panel" multiple>
        <v-expansion-panel>
          <v-expansion-panel-header>
            내가 쓴 게시글
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <user-activity-compo :lists="roomMateList"></user-activity-compo>
          </v-expansion-panel-content>
        </v-expansion-panel>
        <v-expansion-panel>
          <v-expansion-panel-header>
            내가 쓴 댓글
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <user-activity-compo :lists="roomMateCommentList"></user-activity-compo>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </v-card>
  </v-container>
  
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
      panel: [0],
    }
  },
  computed: {
    ...mapState(['userInfo']),
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

}
</script>