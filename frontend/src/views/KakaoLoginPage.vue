<template>
 <v-container>
     <ul>
         <li v-on:click="kakaoLogin()">
             <a href="javascript:void(0)">
             <span>카카오 로그인</span>

             </a>
         </li>
         
     </ul>
     
    </v-container>
</template>

<script>


// import '@/kakao/kakao.js'


export default {
    name: 'KakaoLoginPage',
    data () {
        return {
            id: '',
            pw: '',
        }
        
    },
    props: {
        kakao_account: {
            type: Object,
            require: true
        }
    },
    

    
    methods: {
       
    kakaoLogin () {
         
         window.Kakao.Auth.login({
             
             success: (res) => { 
                 window.Kakao.API.request({
                     url: '/v2/user/me',
                     success: (res) => {
                         const kakao_account = res.kakao_account
                         console.log(kakao_account)
                         console.log(res)
                         this.$router.push({name: 'MemberRegisterPage' 
                            , params: {kakao_account: kakao_account} })
                         
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