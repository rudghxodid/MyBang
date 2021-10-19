import {
  // Login
  FETCH_USER_INFO,
  FETCH_SESSION,



} 

from './mutation-types'


import axios from 'axios'
import cookies from 'vue-cookies'

export default {
  fetchUserInfo ({ commit }, userId) {
    return axios.get(`http://localhost:7777/member/mypage/${userId}`).then(res => {
      console.log(res.data)
      cookies.set('session', res.data.userId)
      commit(FETCH_USER_INFO, res.data)
    })
  },
  fetchSession ({ commit }, session) {
    commit(FETCH_SESSION, session)
  },
}