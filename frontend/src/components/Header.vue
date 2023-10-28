<script setup>
import {useRouter} from "vue-router";

const router = useRouter();

const home = () => {
  router.push({ name: 'home'});
};
const notification = () => {
  router.push({ name: 'notification'});
};
const freeBoard = () => {
  router.push({ name: 'freeBoard'});
};
const galleryBoard = () => {
  router.push({ name: 'galleryBoard'});
};
const qnaBoard = () => {
  router.push({ name: 'qnaBoard'});
};
const signup = () => {
  router.push({ name: 'signup'});
};

const login = () => {
  router.push({ name: 'login'});
};

const logout = () => {
  router.push({ name: 'home'});
};

</script>

<template>
  <b-container style="margin-top: 2%">
    <h1 style="text-align: center" @click="home">포트폴리오 - Header</h1>
    <b-nav style="margin-top: 5%" >
      <b-nav-text @click="notification" style="font-size: 25px; ">공지사항 </b-nav-text>
      <b-nav-text style="font-size: 25px; ">&nbsp;&nbsp;|&nbsp;&nbsp;</b-nav-text>

      <b-nav-text @click="freeBoard" style="font-size: 25px; " >자유 게시판 </b-nav-text>
      <b-nav-text style="font-size: 25px; ">&nbsp;&nbsp;|&nbsp;&nbsp;</b-nav-text>

      <b-nav-text @click="galleryBoard" style="font-size: 25px; " >갤러리 </b-nav-text>
      <b-nav-text style="font-size: 25px; ">&nbsp;&nbsp;|&nbsp;&nbsp;</b-nav-text>

      <b-nav-text @click="qnaBoard" style="font-size: 25px; " >문의 게시판 </b-nav-text>

      <b-nav-text @click="login" style="margin-left: auto; margin-top: 1%;">로그인 </b-nav-text>
      <b-nav-text style="margin-top: 1%;"> &nbsp;&nbsp;&nbsp;/</b-nav-text>
      <b-nav-item @click="signup" style="margin-top: 1%;">회원가입 </b-nav-item>

      <v-if></v-if>
      <b-nav-text style="margin-top: 1%;">{{}}님 안녕하세요!!</b-nav-text>
      <b-nav-text @click="logout" style="margin-top: 1%;">&nbsp;&nbsp;로그아웃 </b-nav-text>
    </b-nav>
    <hr>
  </b-container>
</template>