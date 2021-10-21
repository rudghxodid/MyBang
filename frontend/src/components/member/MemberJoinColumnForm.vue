<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <h3>회원 가입</h3>
            <div class="row">
                <v-radio-group v-model="radioGroup" row>
                    <v-radio v-for="kinds in kindsOfMember" :key="kinds" :label="`${kinds}`"> 
                    </v-radio>
                </v-radio-group>
            </div>

            <div class="mx-3">
                <v-icon color="black" size="30px">person</v-icon>
                    ID
                <div class="mx-1">
                    <v-text-field placeholder="아이디" v-model="userId" :rules="idRules" required >
                    </v-text-field>
                </div>
            </div> 


            <div class="mx-3"> 
                <v-icon color="black" size="30px">lock</v-icon>
                    Password
                <div class="mx-1">
                    <v-text-field placeholder="비밀번호" type="password" v-model="password" 
                        :rules="pwRules" required ></v-text-field>
                    <v-text-field placeholder="비밀번호 확인" type="password" v-model="checkPassword"
                        :rules="matchPwRules" required ></v-text-field>
                </div> 
            </div>

            <div class="mx-3"> 
                <v-icon color="black" size="30px">mail</v-icon>
                 E-mail
                <div class="mx-1">
                    <v-text-field placeholder="e-mail" v-model="email" :rules="emailRules" required></v-text-field>
                </div> 
            </div> 



            <div class="mx-3"> 
                <v-icon color="black" size="30px">label</v-icon>
                 Name
                <div class="mx-1">
                    <v-text-field placeholder="name" v-model="name" :rules="nameRules" required></v-text-field>
                </div> 
            </div> 


            

            <div class="mx-3"> 
                <v-icon color="black" size="30px">hourglass_empty</v-icon>
                 Birth
                <div class="mx-1">
                    <v-menu ref="menu" v-model="menu" :close-on-content-click="false"
                        :return-value.sync="date" transition="scale-transition" offset-y min-width="auto">
                        <template v-slot:activator="{ on }">
                        <v-text-field placeholder="birth" v-model="birth" :rules="birthRules"
                            v-on="on" append-icon="mdi-calendar" required></v-text-field>
                        </template>
                        <v-date-picker color="secondary" v-model="birth" no-title scrollable>
                        
                        <v-btn text @click="menu = false">
                            Cancel
                        </v-btn>
                        <v-spacer></v-spacer>
                        <v-btn text @click="$refs.menu.save(date)">
                            OK
                        </v-btn>
                        </v-date-picker>
                    </v-menu>
                 
                </div> 
            </div>

            <div class="row"> 
                <v-radio-group v-model="radioGroup2" row>
                    <v-radio v-for="gender in kindsOfGender" :key="gender" :label="`${gender}`"></v-radio>
                </v-radio-group>
            </div>  

            <div class="mx-3"> 
                <v-icon color="black" size="30px">phone</v-icon>
                 Phone
                <div class="mx-1">
                    <v-text-field placeholder="phone" v-model="phone" :rules="phoneRules" required></v-text-field>
                </div> 
            </div>   

            <div>
                <button type="submit" @keydown.enter="onSubmit">등록</button>
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
        </form>
    </v-container>
</template>

<script>
import { mapState } from 'vuex'

export default {
    name: 'MemberJoinColumnForm',
    data () {
        return {
            radioGroup: null,
            radioGroup2: null,
            kindsOfMember: [
                '개인',
                '사업자'
            ],
            kindsOfGender: [
                '남자',
                '여자'
            ],
            userId: '',
            password: '',
            email: '',
            name: '',
            birth: '',
            sex: '',
            phone: '',
            menu: false,
            date: null,
            checkPassword: null,
            matchPwRules: [
                pw => !!pw || '비밀번호를 입력해주세요!',
                pw => pw === this.password || '비밀번호가 일치하지 않습니다!'
            ],
            
        }
    },
    computed: {
        ...mapState(['idRules', 'pwRules', 'emailRules', 'nameRules', 'birthRules', 'phoneRules'])
    },
    methods: {
        onSubmit () {
            const { userId, password, email, name, birth, radioGroup2, phone, radioGroup } = this
            const auth = radioGroup == 0 ? '개인' : '사업자'
            const sex = radioGroup2 == 0 ? '남자' : '여자'
            this.$emit('submit', { userId, password, email, name, birth, sex, phone, auth })
        },
        
    }
}
</script>