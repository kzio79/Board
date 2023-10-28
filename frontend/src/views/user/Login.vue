<script setup>

import {useRouter} from "vue-router";

const router = useRouter();

/*
todo : 비밀번호 확인
 */

const signup = () => {
  router.push({ name: 'signup'});
};

const login = () => {
  router.push({ name: 'home'});
};
</script>

<template>
  <b-container style="margin-top: 3%; text-align: center">
    <h1>로그인</h1>
    <b-card-body>
      <b-row style="margin-top: 15%; margin-bottom: 1%; display: flex; justify-content: center;">
        <b-col cols="5">
          <b-form-input type="text" v-model="id" placeholder="아이디" />
        </b-col>
      </b-row>
      <b-row style="margin-bottom: 1%; display: flex; justify-content: center;">
        <b-col cols="5">
          <b-form-input type="text" v-model="pw" placeholder="비밀번호" />
        </b-col>
      </b-row>
      <b-row style="margin-bottom: 1%; display: flex; justify-content: center;">
        <b-col cols="5">
          <b-button variant="primary" style="width: 100%" @click="login">로그인</b-button>
        </b-col>
      </b-row>
      <b-row style="margin-bottom: 1%; display: flex; justify-content: center;">
        <b-col cols="5">
          <b-button variant="primary" style="width: 100%" @click="signup">회원가입</b-button>
        </b-col>
      </b-row>
    </b-card-body>
  </b-container>
</template>
