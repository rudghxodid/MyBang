import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import cooikes from 'vue-cookies'
import Dayjs from 'dayjs';
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";


import 'material-design-icons/iconfont/material-icons.css'

Vue.config.productionTip = false

Vue.use(cooikes)
Vue.$cookies.config('1h')
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(Dayjs);

new Vue({
  router,
  store,
  vuetify,
  el:"#app",
  render: h => h(App)
}).$mount('#app')
