<template>
  <v-sheet class="fill-height" max-height="700">
    <Search @selectStation="selectStation" @selectGu="selectGu" @selectDong="selectDong"
      style="position: fixed; z-index: 1;"></Search>

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
                        icon: iconContent(list.salesType,list.deposit, list.rent)}"
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

    <v-card width="400" style="float:right;" max-height="700"> 
      <v-card-title>{{selectLength}}개의 매물</v-card-title>
      <v-divider></v-divider>
      <v-card-subtitle v-if="!selectLength">해당 지역에 매물이 없습니다.<br>지도를 이동&축소해 주세요.</v-card-subtitle>
      
      <v-virtual-scroll :bench="10" :items="selectVillaList" :item-height="120" height="630">
        <template v-slot:default="{ item }">
          <v-list-item three-line @click="viewInfo(item)" 
            @mouseover="openPosition(item.lat, item.lng)" @mouseout="closePosition">
            <img :src="imageList(item.image)" class="mr-3" width="40%">
            <v-list-item-content>
              <v-list-item-subtitle class="caption">{{item.roomType}} · {{item.sizeM2}}㎡</v-list-item-subtitle>
              <v-list-item-title v-if="item.salesType == '월세'" class="title my-2">{{item.salesType}} {{item.deposit}}/{{item.rent}}</v-list-item-title>
              <v-list-item-title v-else class="title my-2">{{item.salesType}} {{item.deposit}}</v-list-item-title>
              <v-list-item-subtitle>{{item.title}}</v-list-item-subtitle>
            </v-list-item-content> 
          </v-list-item>
        </template>
      </v-virtual-scroll>
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
      center: { lat: 37.49664389, lng: 127.0629852 },
      cluster: {
        options: {
          maxZoom: 18,
          icons: [
            {content: `<div class="cluster lv1"></div>`},
            {content: `<div class="cluster lv2"></div>`},
            {content: `<div class="cluster lv3"></div>`},
            {content: `<div class="cluster lv4"></div>`},
            {content: `<div class="cluster lv5"></div>`}
          ],
          gridSize: 200,
          averageCenter: true,
        }
      },
      houseInfo: null,
      zoomLevel: 13,
      infoWindow: null,
      dialog: false,
      selectVillaList: [],
      selectLength: null,
      guMarkers: [],
      guPolygons: []
    }
  },
  watch: {
    zoomLevel: function () {
      if (this.zoomLevel <= 14) {
        if (this.guMarkers.length == 0) {
          this.addGuMarkerPolygon()
          this.guMarkerEvent()
        }
      } else {
        this.removeGuMarkerPolygon()
      }
    }
  },
  mounted () {
    setTimeout(() => {
      this.villaOnMap()
      this.addGuMarkerPolygon()
      this.guMarkerEvent()
    }, 1000)

    axios.get('http://localhost:7777/villa/lists').then(res => {
      this.villaList = res.data
    })

    axios.get('http://localhost:7777/station/lists').then(res => {
      this.stationList = res.data
    }) 
  },
  methods: {
    idle () {
      this.zoomLevel = this.$refs.maps.map.getZoom()

      this.villaOnMap()
    },
    villaOnMap () {
      let map = this.$refs.maps.map

      this.selectVillaList = []

      const list = this.villaList

      for (let i = 0; i < list.length; i++) {
        let coords = new window.naver.maps.LatLng(list[i].lat, list[i].lng)

        if (map.getBounds().hasLatLng(coords)) {
          this.selectVillaList.push(list[i])
        }
      }
      this.selectLength = this.selectVillaList.length
    },
    viewInfo (info) {
      this.houseInfo = info
      console.log(this.houseInfo)
      this.dialog = true
    },
    iconContent (salesType, deposit, rent) {
      let cost = deposit / 10000
      let strCost = cost.toString() + '억'
      
      if (salesType == '전세') {
        return { content: `<div class="marker-html" style="background: #CEE5D0;">${strCost}</div>` }
      } else if (salesType == '매매') {
        return { content: `<div class="marker-html" style="background: #F3F0D7;">${strCost}</div>` }
      } else {
        return { content: `<div class="marker-html" style="background: #FED2AA;">${deposit}/${rent}</div>` }
      }
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
    imageList (imageList) {
      return imageList.split(',')[0]
    },
    selectGu (lat, lng) {
      const coords = new window.naver.maps.LatLng(lat, lng)
      this.$refs.maps.map.setCenter(coords)
      this.$refs.maps.map.setZoom(14)
    },
    selectDong (lat, lng) {
      const coords = new window.naver.maps.LatLng(lat, lng)
      this.$refs.maps.map.setCenter(coords)
      this.$refs.maps.map.setZoom(16)
    },
    addGuMarkerPolygon () {
      const list = seoulGu.features

      for (let i = 0; i < list.length; i++) {
        let position = new window.naver.maps.LatLng(list[i].properties.lat, list[i].properties.lng)

        let gu = list[i].properties.SGG_NM

        let marker = new window.naver.maps.Marker({
          map: this.$refs.maps.map,
          position: position,
          icon: { content: `<div class="marker-html">${gu}</div>` }
        })
        
        let coords = list[i].geometry.coordinates[0]
        let coordList = []

        for(let i = 0; i < coords.length; i++) {
          coordList.push(new window.naver.maps.LatLng(coords[i][1], coords[i][0]))
        }
        
        let polygon = new window.naver.maps.Polygon({
          map: this.$refs.maps.map,
          paths: [coordList],
          strokeColor: 'transparent'
        })

        this.guPolygons.push(polygon)
        this.guMarkers.push(marker)
      }
    },
    guMarkerEvent() {
      for (let i = 0; i < this.guMarkers.length; i++) {
        window.naver.maps.Event.addListener(this.guMarkers[i], 'mouseover', () => {
          let polygon = this.guPolygons[i]

          polygon.setOptions({
            strokeColor: 'blue',
            strokeWeight: 2
          })
        })

        window.naver.maps.Event.addListener(this.guMarkers[i], 'mouseout', () => {
          let polygon = this.guPolygons[i]

          polygon.setOptions({
            strokeColor: 'transparent'
          })
        })

        window.naver.maps.Event.addListener(this.guMarkers[i], 'click', (e) => {
          this.$refs.maps.map.setCenter(e.coord)
          this.$refs.maps.map.setZoom(14)
        })
      }
    },
    removeGuMarkerPolygon() {
      for (let i = 0; i < this.guMarkers.length; i++) {
        this.guMarkers[i].setMap(null)
        this.guPolygons[i].setMap(null)
      }
      this.guMarkers = []
      this.guPolygons = []
    },
    openPosition (lat, lng) {
      this.infoWindow = new window.naver.maps.InfoWindow({
        disableAnchor: true,
        backgroundColor: 'transparent',
        borderWidth: 0,
        content: `<div class="infoWindow"></div>`
      })
      const coords = new window.naver.maps.LatLng(lat, lng)
      this.infoWindow.open(this.$refs.maps.map, coords)
    },
    closePosition () {
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
  .infoWindow {
    background: #E26A2C;
    width: 30px;
    height: 30px;
    border-radius: 50%;
    opacity: 0.6;
    animation: scale 1s infinite alternate;
  }
  @keyframes scale {
    0%  { transform: scale(1); }
    100%  { transform: scale(2.5); opacity: 0.4; }
  }
</style>