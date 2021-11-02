<template>
  <v-card width="400" style="float:right;" v-if="info" class="grey lighten-4">
    <v-card flat>
      <v-card-title>
        {{info.local1}}
        {{info.local2}}
        {{info.local3}}
      </v-card-title>
      <v-divider></v-divider>
      <v-container>
        <swiper class="swiper" :options="swiperOption">
          <swiper-slide v-for="list in imageList" :key="list.index">
            <img :src="list">
          </swiper-slide>
          <div class="swiper-pagination" slot="pagination"></div>
          <div class="swiper-button-prev" slot="button-prev"></div>
          <div class="swiper-button-next" slot="button-next"></div>
        </swiper>
      </v-container>

      <v-card-title>
        {{info.salesType}}
        {{info.deposit}}
      </v-card-title> 
      <v-divider/>

      <div class="d-flex justify-space-between my-2 mx-10">
        <div>
          <div>면적</div>
          <div class="headline">{{info.sizeM2}}㎡</div>
        </div>
        <div>
          <div>관리비</div>
          <div class="headline">{{info.manageCost}}</div>
        </div>
        <div>
          <div>구조</div>
          <div class="headline">{{info.roomType}}</div>
        </div>
      </div>
      <v-divider/>
      <v-card-text>{{info.title}}</v-card-text>
    </v-card>

    <v-card class="mt-5">

    </v-card>
    


    
  </v-card>
</template>


<script>
import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'

export default {
  components: {
    Swiper,
    SwiperSlide
  },
  props: {
    info: {
      type: Object
    },
  },
  data() {
    return {
      swiperOption: {
        loop: true,
        slidesPerView: 1,
        spaceBetween: 30,
        pagination: {
          el: '.swiper-pagination',
          clickable: true
        },
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
        }
      },
    }
  },
  computed: {
    imageList: function () {
      return this.info.image.split(',')
    }
  }
}
</script>



<style class="scss" scoped>
.swiper-3d {
  width: 400px;
  height: 300px;
  padding-top: 50px;
  padding-bottom: 50px;
}
.swiper {
  height: 100%;
  width: 100%;
}
.swiper-slide {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 300px;
  height: 300px;
  font-weight: bold;
  color: white;
}
.swiper-pagination >>> .swiper-pagination-bullet {
  opacity: 1;
  border: white solid 1px;
  background-color: transparent;
}
.swiper-pagination >>> .swiper-pagination-bullet-active {
  background-color: white;
}
.swiper-button-next {
  color: white;
}
.swiper-button-prev {
  color: white;
}

</style>