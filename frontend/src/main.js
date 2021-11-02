import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import cooikes from 'vue-cookies'
import VueNaverMap from 'vue-naver-map'

import { library } from '@fortawesome/fontawesome-svg-core'
import { faUserSecret } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faHeart as fasHeart} from '@fortawesome/free-solid-svg-icons'
import { faHeart as farHeart} from '@fortawesome/free-regular-svg-icons'

library.add(faUserSecret)

import 'material-design-icons/iconfont/material-icons.css'
library.add(fasHeart, farHeart, faUserSecret)
Vue.component('font-awesome-icon', FontAwesomeIcon)

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
