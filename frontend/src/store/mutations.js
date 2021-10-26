import {
  // Login
  USER_LOGIN,
  FETCH_USER_INFO,
  FETCH_SESSION,
  FETCH_MEMBER_LIST,
  FETCH_MEMBER



} from './mutation-types'

export default {
  [USER_LOGIN] (state, isLogin) {
    state.isLogin = isLogin
    console.log('isLogin: ' + isLogin)
  },
  [FETCH_USER_INFO] (state, userInfo) {
    state.userInfo = userInfo
    console.log(userInfo)
  },
  [FETCH_SESSION] (state, session) {
    state.session = session
  },
  [FETCH_MEMBER_LIST] (state, members) {
    state.members = members;
  },
  [FETCH_MEMBER] (state, member) {
    state.member = member
  },

}