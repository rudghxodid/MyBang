<template>
  <div>
    <ul>
			<li v-for="list in recentGongzis" :key="list.index"
        @click="gongziRead(list.gongziNo)">{{list.title}}</li>
    </ul>
  </div>
</template>


<script>
import { mapActions, mapState } from 'vuex'

export default {
  data () {
    return {
      recentGongzis: []
    }
  },
  computed: {
    ...mapState(['gongzis'])
  },
  mounted () {
    if (this.gongzis.length > 5) {
      this.recentGongzis = this.gongzis.slice(0, 5)
    } else {
      this.recentGongzis = this.gongzis
    }
    console.log(this.recentGongzis)
  },
  methods: {
    ...mapActions(['fetchGongziList']),
    gongziRead (gongziNo) {
      this.$router.push(
				{ name: 'GongziReadPage', query: { gongziNo: gongziNo } }
			)
    }
  }
}
</script>


<style scoped>
	ul {
	  list-style: none;
	  cursor: pointer;
		padding-left: 0;
	}

	li {
	  padding: 15px 2px;
		border-bottom: 1px solid #eee;
		color: #666;
		font-size: 15px;
	}

	li:first-child {
		border-top: 2px solid #ddd;
	}

	li:last-child {
		border-bottom: 2px solid #ddd;
	}

	li:hover {
	  background:rgba(220, 220, 220, 0.671);
	  transition:all .3s ease
	}
</style>
