import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import cooikes from 'vue-cookies'
import VueNaverMap from 'vue-naver-map'

import 'material-design-icons/iconfont/material-icons.css'

Vue.config.productionTip = false

Vue.use(cooikes)
Vue.$cookies.config('1h')

// key에 발급받은 clientID 넣으시면 됩니다(https://www.ncloud.com/)
Vue.use(VueNaverMap, {
  key: '',
  libraries: ['geocoder']
})

new Vue({
  router,
  store,
  vuetify,
  el:"#app",
  render: h => h(App)
}).$mount('#app')
