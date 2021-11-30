import {
  // Login
  USER_LOGIN,
  FETCH_USER_INFO,
  FETCH_SESSION,
  FETCH_MEMBER_LIST,
  FETCH_MEMBER,

  
  FETCH_GONGZI,
  FETCH_GONGZI_LIST,

    // 매물게시판
  FETCH_VILLA_LIST,
  FETCH_VILLA,
  FETCH_OFFICETEL_LIST,
  FETCH_OFFICETEL,
  FETCH_ONEROOM_LIST,
  FETCH_ONEROOM,
  FETCH_AGENT_VILLA,
  FETCH_AGENT_ONEROOM,
  FETCH_AGENT_OFFICETEL,

  // 뉴스 크롤링
  CRAWL_START,
} from "./mutation-types";

export default {
  [USER_LOGIN](state, isLogin) {
    state.isLogin = isLogin;
    console.log("isLogin: " + isLogin);
  },
  [FETCH_USER_INFO](state, userInfo) {
    state.userInfo = userInfo;
    console.log(userInfo);
  },
  [FETCH_SESSION](state, session) {
    state.session = session;
  },
  [FETCH_MEMBER_LIST](state, members) {
    state.members = members;
  },
  [FETCH_MEMBER](state, member) {
    state.member = member;
  },
  [FETCH_GONGZI_LIST](state, gongzis) {
    state.gongzis = gongzis;
  },
  [FETCH_GONGZI](state, gongzi) {
    state.gongzi = gongzi;
  },

  [FETCH_VILLA_LIST](state, villas) {
    state.villas = villas;
  },
  [FETCH_VILLA](state, villa) {
    state.villa = villa;
  },
  [FETCH_ONEROOM_LIST](state, oneroomList) {
    state.oneroomList = oneroomList;
  },
  [FETCH_ONEROOM](state, oneroom) {
    state.oneroom = oneroom;
  },
  [FETCH_OFFICETEL_LIST](state, officetelList) {
    state.officetelList = officetelList;
  },
  [FETCH_OFFICETEL](state, officetel) {
    state.officetel = officetel;
  },
  [FETCH_AGENT_VILLA](state, agentVilla) {
    state.agentVilla = agentVilla;
  },
  [FETCH_AGENT_ONEROOM](state, agentOneroom) {
    state.agentOneroom = agentOneroom;
  },
  [FETCH_AGENT_OFFICETEL](state, agentOfficetel) {
    state.agentOfficetel = agentOfficetel;
  },

  [CRAWL_START](state, payload) {
    state.lists = payload;
  },
};
