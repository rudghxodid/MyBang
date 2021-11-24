<template>
	<v-container>
		<table border="1">
			<tr>
				<th align="center" width="100">건물 유형</th>
				<th align="center" width="350">매물 이름</th>
				<th align="center" width="650">매물 주소</th>
				<th align="center" width="240">작성자</th>
			</tr>

			<tr v-for="villa in agentVilla" :key="villa.villaNo">
				<td align="center">{{ villa.serviceType }}</td>
				<td align="center">{{ villa.title }}</td>
				<a @click="villaDetailPage(villa.villaNo)">
					<td align="center">{{ villa.address }}</td>
				</a>
				<td align="center">{{ villa.agentId }}</td>
			</tr>
			<tr v-for="oneroom in agentOneroom" :key="oneroom.oneroomNo">
				<td align="center">{{ oneroom.serviceType }}</td>
				<td align="center">{{ oneroom.title }}</td>
				<a @click="oneroomDetailPage(oneroom.oneroomNo)">
					<td align="center">{{ oneroom.address }}</td>
				</a>
				<td align="center">{{ oneroom.agentId }}</td>
			</tr>
			<tr v-for="officetel in agentOfficetel" :key="officetel.officetelNo">
				<td align="center">{{ officetel.serviceType }}</td>
				<td align="center">{{ officetel.title }}</td>
				<a @click="officetelDetailPage(officetel.officetelNo)">
					<td align="center">{{ officetel.address }}</td>
				</a>
				<td align="center">{{ officetel.agentId }}</td>
			</tr>
		</table>
	</v-container>
</template>

<script>


  export default {
    name: 'BrokerHouseListForm',
    data() {
      return {
        // 페이지 구분
        //pageNum: 0,

      }
    },
    props: {
      agentVilla: {
        type: Array,
        required: true
      },
      agentOneroom: {
        type: Array,
        required: true
      },
      agentOfficetel: {
        type: Array,
        required: true
      },
      pageSize: {
        type: Number,
        required: false,
        default: 8
      },
    },
    computed: {},
    mounted() {

    },
    methods: {
      villaDetailPage(villaNo) {
        this.$router.push({
          name: 'VillaReadPage',
          params: {"villaNo": villaNo}
        })
      },
      oneroomDetailPage(oneroomNo) {
        this.$router.push({
          name: 'OneroomReadPage',
          params: {"oneroomNo": oneroomNo}
        })
      },
      officetelDetailPage(officetelNo) {
        this.$router.push({
          name: 'OfficetelReadPage',
          params: {"officetelNo": officetelNo}
        })
      },
    },
  }
</script>

<style lang="scss" scoped>
	.search-btn {
		position: absolute;
		top: 11em;
		right: 10em;
	}

	table {
		width: 100%;
		border-collapse: collapse;
	}

	table th {
		font-size: 1.2rem;
	}

	table tr {
		height: 2rem;
		text-align: center;
		border-bottom: 1px solid #505050;
	}

	table tr:first-of-type {
		border-top: 2px solid #404040;
	}

	table tr td {
		padding: 1rem 0;
		font-size: 1.1rem;
	}

	.btn-cover {
		margin-top: 2rem;
		margin-bottom: 5rem;
		text-align: center;
	}

	.btn-cover .page-btn {
		width: 5rem;
		height: 2rem;
		letter-spacing: 0.5px;
	}

	.btn-cover .page-count {
		padding: 0 1rem;
	}

</style>

