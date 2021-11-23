<template>
  <v-card width="400" flat>
   
    <!-- 사진선택 -->
    <v-file-input class="mx-10" v-model="files" @change="selectImg" label="사진 선택"
      prepend-icon="insert_photo" chips multiple ></v-file-input>

    <!-- 선택한 사진 미리보기 -->
    <v-card class="mx-10" flat>
      <v-img v-for="url in urls" :key="url.index" class="ml-10" :src="url" width="80%"/>
    </v-card>

    <!-- imgBB에 이미지 전송 -->
    <v-btn @click="sendImg">전송</v-btn>
    <!-- 전송된 사진 url 확인 -->
    <v-btn @click="checkImage">확인</v-btn>

    <!-- 저장된 첫번째 사진 미리보기 -->
    <div v-if="viewImage">
      <v-img :src="viewImage"></v-img>
    </div>
  </v-card>
</template>

<script>
import axios from 'axios'

export default {
   data () {
    return {
      files: [],
      urls: [],
      imageStr: '',
      image: null,
      viewImage: null
    }
  },
  methods: {
    selectImg () {
      try {
        this.urls = []
        this.imageStr = ''

        for (let i = 0; i < this.files.length; i++) {
          this.urls.push(URL.createObjectURL(this.files[i]))
        }
      }catch(e) {
        this.urls = []
        this.imageStr = ''
      }
    },
    sendImg() {
      const formData = new FormData()

      // 아래 빈칸에 key 입력
      formData.set('key', '')
      
      for (let i = 0; i < this.files.length; i++) {
        formData.append('image', this.files[i])

        axios.post(`https://api.imgbb.com/1/upload`, formData).then(res => {
          console.log(res.data.data.display_url)
          this.imageStr += res.data.data.display_url + ','
        })
      }
    },
    checkImage () {
      // imageStr의 마지막 ',' 제거
      this.image = this.imageStr.slice(0, -1)
      console.log(this.image)

      // 불러온 imageStr을 img로 표시하려면 ',' 기준으로 잘라서 배열로 저장 후 사용
      let imageList = this.image.split(',')
      console.log(imageList)

      // 배열에 저장된 첫번째 사진 url
      this.viewImage = imageList[0]
    }
  }
}
</script>