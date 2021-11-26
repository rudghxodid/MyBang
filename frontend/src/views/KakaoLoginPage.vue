<template>
 <v-container>
     <ul>
         <li v-on:click="kakaoLogin()">
             <a href="javascript:void(0)">
             <span>카카오 로그인</span>

             </a>
         </li>
         <li v-on:click="kakaoLogout()">
             <a href="javascript:void(0)">
             <span>로그아웃</span>
             
             </a>
         </li>
     </ul>
     
    </v-container>
</template>

<script>
import axios from 'axios'
// import '@/kakao/kakao.js'


export default {
    name: 'KakaoLoginPage',
    data () {
        return {
            id: '',
            pw: ''
        }
    },
    
    methods: {
        onSubmit () {
        
            const { id, pw } = this
            axios.post('http://localhost:5000/login', { userId: id, password: pw })
                    .then(res => {
                        if (res.data != "") {
                            alert('로그인 성공! - ' + JSON.stringify(res.data))
                                
                        } else {
                            alert('로그인 실패! - ' + res.data)
                       
                        }
                     
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        
     },
    kakaoLogin () {
         
         window.Kakao.Auth.login({
             
             success: (res) => { 
                 window.Kakao.API.request({
                     url: '/v2/user/me',
                     success: (res) => {
                         const kakao_account = res.kakao_account
                         console.log(kakao_account)
                         console.log(res)
                         
                     },
                     fail: (err) => {
                         console.log(err)
                     }
                 })
                console.log(res)  
             },
             fail: (err) => {
                 console.log(err)
             }
         })
      },
    kakaoLogout () {
        window.Kakao.Auth.logout({
            
        })
      }
      
    },
    mounted() {
        window.Kakao.init("a6e2bc18b777344f6efd78ddbadfe7d8")
        alert('Kakao 초기화 여부 : ' + window.Kakao.isInitialized())
    }
   
}
</script>