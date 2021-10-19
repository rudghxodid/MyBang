<template>
  <v-container>
    <v-card>
      <v-text-field label="id" v-model="userId"></v-text-field>
      <v-text-field label="pw" v-model="password"></v-text-field>
      <v-text-field label="email" v-model="email"></v-text-field>
      <v-text-field label="name" v-model="name"></v-text-field>
      <v-text-field label="age" v-model="age"></v-text-field>
      <v-text-field label="sex" v-model="sex"></v-text-field>
      <v-text-field label="phone" v-model="phone"></v-text-field>
      <v-btn @click="signup">
        회원가입
      </v-btn>
    </v-card>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      userId: null,
      password: null,
      email: null,
      name: null,
      age: null,
      sex: null,
      phone: null
    }
  },
  methods: {
    signup () {
      const {userId, password, email, name, age, sex, phone} = this

      axios.post('http://localhost:7777/member/signup', {userId, password, email, name, age, sex, phone})
      .then(() => {
        alert('회원가입이 완료되었습니다.')
      }).catch(res => {
        alert(res)
      })
    }
  }
}
</script>