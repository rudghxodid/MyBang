<template>
  <v-sheet class="fill-height" max-height="700">
    <Search @selectStation="selectStation" style="position: fixed; z-index: 1;"></Search>

    <naver-map
      ref="maps"
      :center="center"
      :zoom="zoomLevel"
      style="width: 70%; height: 100%; float: left;"
      @idle="idle">

      <div>
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

    <v-card v-if="selectLength" width="400" style="float:right;" class="overflow-y-auto"
      id="scrolling-techniques-7" max-height="700"> 
      <v-card-title>{{selectLength}}개의 매물</v-card-title>
      <v-divider></v-divider>
      <v-list v-for="list in selectVillaList" :key="list.index">
        
        <v-list-item-group>
          <v-list-item three-line @click="viewInfo(list)">
            <img :src="imageList(list.image)" class="mr-3" width="40%">
            <v-list-item-content>
              <v-list-item-subtitle class="caption">{{list.roomType}} · {{list.sizeM2}}㎡</v-list-item-subtitle>
              <v-list-item-title class="title my-2">{{list.salesType}} {{list.deposit}}</v-list-item-title>
              <v-list-item-subtitle>{{list.title}}</v-list-item-subtitle>
            </v-list-item-content> 
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card>
    
    <v-dialog v-model="dialog" max-width="400">
      <InfoDetail :info="houseInfo"></InfoDetail>
    </v-dialog>
  </v-sheet>
</template>

<script>
import seoulGu from '@/assets/data/seoul_gu'
import InfoDetail from '@/components/house/InfoDetail'
import Search from '@/components/house/Search'
import axios from 'axios'

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
      infoWindow: null,
      dialog: false,
      selectVillaList: [],
      selectLength: null
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
    })

    axios.get('http://localhost:7777/station/lists').then(res => {
      this.stationList = res.data
    })
  },
  methods: {
    idle () {
      this.zoomLevel = this.$refs.maps.map.getZoom()

      let bounds = { max: { x: this.$refs.maps.map.getBounds()._max.x, y: this.$refs.maps.map.getBounds()._max.y},
                     min: { x: this.$refs.maps.map.getBounds()._min.x, y: this.$refs.maps.map.getBounds()._min.y}}

      this.selectVillaList = []

      for (let i = 0; i < this.villaList.length; i++) {
        if (bounds.min.y < this.villaList[i].lat && this.villaList[i].lat < bounds.max.y && 
            bounds.min.x < this.villaList[i].lng && this.villaList[i].lng < bounds.max.x) {
          this.selectVillaList.push(this.villaList[i])
        }
      }
      this.selectLength = this.selectVillaList.length
      console.log(this.selectLength)
      console.log(this.selectVillaList)
    },
    viewInfo(info) {
      this.houseInfo = info
      console.log(this.houseInfo)
      this.dialog = true
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
    imageList (imageList) {
      return imageList.split(',')[0]
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