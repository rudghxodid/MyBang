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
                <v-list-item class="mx-1">
                    <v-text-field placeholder="아이디" v-model="userId" :rules="idRules" required></v-text-field>
                    <v-btn @click="checkId">아이디 확인</v-btn>
                </v-list-item>
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
                <v-list-item class="mx-1">
                    <v-text-field placeholder="e-mail" v-model="email" :rules="emailRules" required></v-text-field>
                    <v-btn @click="checkEmail">이메일 인증</v-btn>
                </v-list-item> 
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

        <v-dialog v-model="idDialog" max-width="400">
            <v-card v-if="!canUseId" class="pa-3">
                <v-card-title>사용할 수 없는 아이디입니다.</v-card-title>
                <v-card-text>다른 아이디를 사용해주세요.</v-card-text>
                <v-text-field v-model="userId" class="mx-5" label="아이디" :rules="idRules" required></v-text-field>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn @click="checkId">아이디 확인</v-btn>
                </v-card-actions>
                
                
            </v-card>

            <v-card v-else class="pa-3">
                <v-card-title>사용 가능한 아이디입니다.</v-card-title>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn @click="closeDialog">사용하기</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>

        <v-dialog v-model="emailDialog" max-width="400">
            <v-card>
                <v-card-title>메일함을 확인해주세요.</v-card-title>
                <v-card-text>인증번호 6자리를 입력해주세요.</v-card-text>
                <v-text-field v-model="code" class="mx-5" label="인증번호"></v-text-field>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn @click="ckeckCode">확인</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-container>
</template>

<script>
import { mapState } from 'vuex'
import axios from 'axios'

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
            canUseId: false,
            idDialog: false,
            emailDialog: false,
            code: null,
            randomCode: null,
            completeId: false,
            completeEmail: false
            
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

            if (this.completeId && this.completeEmail) {
                this.$emit('submit', { userId, password, email, name, birth, sex, phone, auth })
            } else {
                alert("아이디 또는 이메일 인증을 완료해주세요.")
            }
            
        },
        checkId () {
            const userId = this.userId

            if (userId) {
                axios.post(`http://localhost:7777/member/checkId/${userId}`).then(res => {
                    this.canUseId = res.data
                    this.idDialog = true
                    this.completeId = true
                })
            } else {
                alert('아이디를 입력해주세요.')
            }
            
        },
        closeDialog () {
            this.idDialog = false
        },
        checkEmail () {
            const email = this.email

            if (email) {
                axios.post(`http://localhost:7777/member/checkEmail/${email}`).then(res => {
                    if (res.data == 'AlreadyUser') {
                        alert('이미 사용중인 회원입니다.')
                    } else {
                        this.emailDialog = true
                        this.randomCode = res.data
                    }
                })
            } else {
                alert('이메일을 입력해주세요.')
            }
            
        },
        ckeckCode () {
            if (this.code == this.randomCode) {
                alert('이메일 인증이 완료되었습니다.')

                this.emailDialog = false
                this.code = null
                this.completeEmail = true
            } else {
                alert('인증번호가 일치하지 않습니다.')
            }
        }
        
    }
}
</script>