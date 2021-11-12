<template>
  <v-sheet class="fill-height" max-height="700">
    <Search @selectStation="selectStation" style="position: fixed; z-index: 1;"></Search>

    <naver-map
      ref="maps"
      :center="{ lat: center.lat, lng: center.lng }"
      :zoom="zoomLevel"
      style="width: 70%; height: 100%; float: left;"
      @idle="idle">

      <div v-if="zoomLevel >= 12">
        <naver-map-marker-cluster :options="cluster.options">
          <naver-map-marker v-for="list in villaList" :key="list.index"
            :options="{ position: { lat: list.lat, lng: list.lng },
                        icon: iconContent(list.deposit)}"
            @click="viewInfo(list)"/>
        </naver-map-marker-cluster>
      </div>
     
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
    
    <InfoDetail :info="houseInfo"></InfoDetail>
  </v-sheet>
</template>

<script>
import InfoDetail from '@/components/house/InfoDetail'
import Search from '@/components/house/Search'
import axios from 'axios'
import seoulGu from '@/assets/data/seoul_gu'

export default {
  components: {
    InfoDetail,
    Search
  },
  data() {
    return {
      villaList: [],
      stationList: null,
      center: { lat: 37.5285549, lng: 127.0370612 },
      cluster: {
        options: {
          maxZoom: 16,
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
      zoomLevel: 11,
      infoWindow: null
    }
  },
  watch: {
    zoomLevel: function () {
      if (this.zoomLevel <= 12) {
        if (this.$refs.maps.map.data._features.length == 0) {
          this.startDataLayer(seoulGu)
        }
      } else {
        this.removeDataLayer(seoulGu)
      }
    }
  },
  mounted () {
    setTimeout(() => {
      this.startDataLayer(seoulGu)
    }, 300)

    axios.get('http://localhost:7777/villa/lists').then(res => {
      this.villaList = res.data
      console.log(this.villaList)
      this.houseInfo = this.villaList[0]
    })

    axios.get('http://localhost:7777/station/lists').then(res => {
      this.stationList = res.data
      console.log(this.stationList)
    })
  },
  methods: {
    viewInfo(info) {
      this.houseInfo = info
      console.log(this.houseInfo)
    },
    iconContent (deposit) {
      let cost = deposit / 10000
      let strCost = cost.toString() + '억'
      return { content: `<div class="marker-html">${strCost}</div>` }
    },
    showCircle (lat, lng) {
      const coords = new window.naver.maps.LatLng(lat, lng)
      this.$refs.maps.map.setCenter(coords)
      this.$refs.maps.map.setZoom(17)

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
    },
    selectStation (lat, lng) {
      this.showCircle(lat,lng)
    },
    startDataLayer(geojson) {
      this.$refs.maps.map.data.addGeoJson(geojson)

      this.$refs.maps.map.data.setStyle(function() {
        return {
          fillColor: 'white',
          fillOpacity: 0.5,
          strokeColor: 'blue',
          strokeWeight: 2,
          icon: null
        }
      })

      this.$refs.maps.map.data.addListener('click', (e) => {
        const coords = new window.naver.maps.LatLng(e.feature.getProperty('lat'), e.feature.getProperty('lng'))
        this.$refs.maps.map.setCenter(coords)
        this.$refs.maps.map.setZoom(14)
      })

      this.infoWindow = new window.naver.maps.InfoWindow({
        disableAnchor: true,
        backgroundColor: 'transparent',
        borderWidth: 0
      })

      this.$refs.maps.map.data.addListener('mouseover', (e) => {
        this.$refs.maps.map.data.overrideStyle(e.feature, {
          fillColor: 'blue',
          fillOpacity: 0.5,
        })

        let infoContent = `<div class="tooltip">${e.feature.getProperty('SGG_NM')}</div>`

        this.infoWindow.setContent(infoContent)

        this.infoWindow.open(this.$refs.maps.map, e.coord)
      })
      this.$refs.maps.map.data.addListener('mouseout', () => {
        this.$refs.maps.map.data.revertStyle()
        this.infoWindow.close()
      })
    },
    removeDataLayer (geojson) {
      this.$refs.maps.map.data.removeGeoJson(geojson)
      this.infoWindow.close()
    },
    
  }
}
</script>


<style lang="scss">
  .marker-html {
    position: relative;
    background: white;
    line-height: 30px;
    text-align: center;
    font-weight: bold;
    border-radius: 15px;
    transition: 0.5s;
    padding: 0 8px;
    box-shadow: rgba(0, 0, 0, 0.08) 0px 0px 0px 1px,
      rgba(0, 0, 0, 0.18) 0px 1px 2px;
    overflow-y: auto;
    transform: translate(-40%, -60%);
    &:hover {
      background: #77ACF1;
      color: white;
      border-color: white;
      z-index: 1;
    }
  }
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
  .tooltip {
    background: white;
    line-height: 30px;
    text-align: center;
    font-weight: bold;
    border-radius: 15px;
    transition: 0.5s;
    padding: 0 8px;
    box-shadow: rgba(0, 0, 0, 0.08) 0px 0px 0px 1px,
      rgba(0, 0, 0, 0.18) 0px 1px 2px;
  }
</style>