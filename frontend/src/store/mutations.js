import {
  FETCH_USER_INFO
} from './mutation-types'

export default {
  [FETCH_USER_INFO] (state, userInfo) {
    state.userInfo = userInfo
  },
  
}