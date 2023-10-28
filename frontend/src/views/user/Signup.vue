<script setup>

/*
todo : id : 4 ~ 8, 영문숫자포함
      pw : 4 ~ 12, 아이디와 동일한 문자 불가
 */
import {useRouter} from "vue-router";
import apiService from "@/service/apiService";

const router = useRouter();

const signup = () => {
  router.push({ name: 'home'});
};
</script>

<template>
  <b-container style="margin-top: 3%; text-align: center">
    <h1>회원가입</h1>
    <b-card-body>
      <b-row style="margin-top: 15%; display: flex; justify-content: center;">
        <b-col cols="4">
          <b-form-input type="text" v-model="id" placeholder="아이디" required/>
        </b-col>
        <b-col cols="3">
          <b-button variant="outline-danger" v-model="idChecked">중복체크</b-button>
          <p></p>
        </b-col>
      </b-row>
      <b-row style="margin-bottom: 1%; display: flex; justify-content: center;">
        <b-col cols="7">
          <b-form-input type="text" v-model="pw" placeholder="비밀번호" required/>
        </b-col>
      </b-row>
      <b-row style="margin-bottom: 1%; display: flex; justify-content: center;">
        <b-col cols="7">
          <b-form-input type="text" v-model="pwChecked" placeholder="비밀번호 확인" required/>
        </b-col>
      </b-row>
      <b-row style="margin-bottom: 1%; display: flex; justify-content: center;">
        <b-col cols="7">
          <b-form-input type="text" v-model="name" placeholder="이름" required/>
        </b-col>
      </b-row>
      <b-row style="margin-bottom: 1%; display: flex; justify-content: center;">
        <b-col cols="7">
          <b-button variant="primary" style="width: 100%" @click="signup">회원 가입 하기</b-button>
        </b-col>
      </b-row>
    </b-card-body>
  </b-container>
</template>