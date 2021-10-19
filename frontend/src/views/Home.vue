<template>
  <div>

    <router-link :to="{ name: 'Mypage' }"
      class="nav-link"
      active-class="active">Mypage
    </router-link>

    <router-link :to="{ name: 'MemberRegisterPage' }"
      class="nav-link"
      active-class="active">
        회원가입 테스트
    </router-link>




























    <router-link :to="{ name: 'TestSignup' }"
      class="nav-link"
      active-class="active">회원가입
    </router-link>
    <router-link :to="{ name: 'FindUserIdPw' }"
      class="nav-link"
      active-class="active">아디비번찾기
    </router-link>
  </div>


</template>

<script>


  export default {
    name: 'Home',

  }
</script>
