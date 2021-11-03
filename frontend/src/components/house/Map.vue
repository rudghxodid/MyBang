<template>
  <v-sheet class="fill-height" max-height="700">

    <naver-map
      ref="maps"
      :center="{ lat: center.lat, lng: center.lng }"
      :zoom="12"
      style="width: 70%; height: 100%; float: left;"
      @idle="idle">

      <naver-map-marker-cluster :options="cluster.options">
        <naver-map-marker v-for="list in villaList" :key="list.index"
          :options="{ position: {lat: list.lat, lng: list.lng }}"
          @click="viewInfo(list)"/>
      </naver-map-marker-cluster>


      <div v-if="zoomLevel >= 15">
        <naver-map-marker
          v-for="list in stationList" :key="list.index"
          :options="{
              position: { lat: list.lat, lng: list.lng },
              icon: {
                url: require('@/assets/img/metro-station.png')
              }
            }"
          @click="showCircle(list.lat, list.lng)">
        </naver-map-marker>  
      </div>
      

    </naver-map>
    
    <Info :info="houseInfo"></Info>
  </v-sheet>
</template>

<script>
import Info from '@/components/house/Info'
import seoul_station from '@/assets/data/seoul_station'
import axios from 'axios'

export default {
  components: {
    Info
  },
  data() {
    return {
      villaList: [],
      stationList: seoul_station.items,
      center: { lat: 37.5285549, lng: 127.0370612 },
      cluster: {
        options: {
          maxZoom: 17,
          averageCenter: true,
          icons: [
            {content: `<div class="cluster lv1"></div>`},
            {content: `<div class="cluster lv2"></div>`},
            {content: `<div class="cluster lv3"></div>`},
            {content: `<div class="cluster lv4"></div>`},
            {content: `<div class="cluster lv5"></div>`}
          ],
        }
      },
      houseInfo: null,
      zoomLevel: null
    }
  },
  mounted () {
    axios.get('http://localhost:7777/villa/lists').then(res => {
      this.villaList = res.data
      console.log(this.villaList)
      this.houseInfo = this.villaList[0]
    })
  },
  methods: {
    viewInfo(info) {
      this.houseInfo = info
      console.log(this.houseInfo)
    },
    showCircle (lat, lng) {
      const coords = new window.naver.maps.LatLng(lat, lng)
      this.$refs.maps.map.setCenter(coords)

      const mapCircle = new window.naver.maps.Circle({
        map: this.$refs.maps.map,
        center: new window.naver.maps.LatLng(lat, lng),
        radius: 400,
        fillColor: 'gray',
        fillOpacity: 0.2,
        visible: this.circle
      })
      
      setTimeout(() => {
        mapCircle.setMap(null)
      }, 2000)
    },
    idle () {
      this.zoomLevel = this.$refs.maps.map.getZoom()
      // console.log(this.zoomLevel)
      // console.log(this.$refs.maps.map.getCenter())
    }
  }
}
</script>


<style lang="scss">
  .cluster {
    cursor:pointer;
    width:40px;
    height:40px;
    line-height:42px;
    font-size:12px;
    color:white;
    text-align:center;
    font-weight:bold;
    border-radius:20px;
    opacity:0.8;
    border:2px solid;
  }
  .lv1 {
    border-color:#3EDBF0;
    background-color:#3EDBF0;
  }
  .lv2 {
    border-color:#77ACF1;
    background-color:#77ACF1;
  }
  .lv3 {
    border-color:#185ADB;
    background-color:#185ADB;
  }
  .lv4 {
    border-color:#04009A;
    background-color:#04009A;
  }
  .lv5 {
    border-color:#04009A;
    background-color:#04009A;
  }
</style>