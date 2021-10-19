import {
  FETCH_USER_INFO,

} from './mutation-types'

import axios from 'axios'

export default {
  fetchUserInfo ({ commit }, userId) {
    return axios.get(`http://localhost:7777/member/mypage/${userId}`).then(res => {
      console.log(res.data)
      commit(FETCH_USER_INFO, res.data)
    })
  },
}