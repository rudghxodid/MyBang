<template>
  <v-card flat>
    <v-list v-for="list in calData" :key="list.index">
      <v-list-item-group>
        <v-list-item two-line @click="roommateDetail(list.id, list.boardNo)">
          <v-list-item-content>
            
            <v-list-item-title v-if="list.title">
              {{ list.title }}
            </v-list-item-title>
            <v-list-item-title v-else>
              {{ list.content }}
            </v-list-item-title>
            <v-list-item-subtitle class="caption">
              {{ list.createdDate }}
            </v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>
    <v-pagination v-model="curPageNum" :length="numOfPages"
      color="secondary">
    </v-pagination>
  </v-card>
</template>


<script>
import { mapState } from 'vuex'

export default {
  props: {
    lists: {

    }
  },
  data () {
    return {
      dataPerPage: 3,
      curPageNum: 1,
    }
  },
  computed: {
    ...mapState(['userInfo']),
    startOffset() {
      return ((this.curPageNum - 1) * this.dataPerPage)
    },
    endOffset() {
      return (this.startOffset + this.dataPerPage)
    },
    numOfPages() {
      if (this.lists) {
        return Math.ceil(this.lists.length / this.dataPerPage)
      } else {
        return 1
      }
    },
    calData() {
      if (this.lists) {
        return this.lists.slice(this.startOffset, this.endOffset)
      } else {
        return this.lists
      }
    }
  },
  methods: {
    roommateDetail (id, boardNo) {
      if (boardNo) {
        this.$router.push({ name: 'RoomMateDetail', params: { id: boardNo } } )
      } else {
        this.$router.push({ name: 'RoomMateDetail', params: { id: id } } )
      }
      
    },
  }
}
</script>