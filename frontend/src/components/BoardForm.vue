<script setup>

import {ref} from "vue";

const startDate = ref(new Date(new Date().setMonth(new Date().getMonth() - 1)).toISOString().substring(0,10));
const endDate = ref(new Date().toISOString().substring(0,10));

const categoryNum = ref(0);
const pagingNum = ref(0);
const sortCondition = ref(0);
const sortOrder = ref(0);

const pagingNumOptions = [10,20,30,40,50];
const sortConditions = ["등록일시", "분류", "제목", "조회수"];
const sortOrders = ["내림차순", "오름차순"];

const props = defineProps({
  categoryNames: Array
})


</script>

<template>
  <b-container style="margin-top: 1%">
    <b-card>
        <b-row>
          <b-col>
            <b-form-input type="date" v-model="startDate" />
          </b-col>
          <b-col >
            <b-form-input type="date" v-model="endDate" />
          </b-col>
          <b-col md="2">
            <b-form-select v-model="categoryNum">
              <option value="0">분류</option>
              <option value="1">JAVA</option>
              <option value="2">JS</option>
              <option value="3">SpringBoot</option>
              <option value="4">Android</option>
<!--              <option v-for="category in props" :value="category" :key="categoryNum">{{category.name}}</option>-->
            </b-form-select>
          </b-col>
          <b-col md="3">
            <b-form-input v-model="searchId" placeholder="검색어를 입력하세요(제목 + 작성자)"></b-form-input>
          </b-col>
          <b-col md="2">
            <b-button variant="primary" type="submit">검색</b-button>
          </b-col>
        </b-row>
<!--      <b-form-checkbox v-model="scret">비밀글</b-form-checkbox>-->
<!--      <b-form-checkbox v-model="myContent">내글만 보이기</b-form-checkbox>-->
    </b-card>

    <b-row style="margin-top: 1%;">
      <b-col md="2">
        <b-form-select v-model="pagingNum">
          <option v-for="(pagingOption, index) in pagingNumOptions" :value="index" :key="index">{{pagingOption}}</option>
        </b-form-select>
      </b-col>
      <b-col md="2" style="margin-left: auto" >
        <b-form-select v-model="sortCondition">
          <option v-for="(sortConditionOption, index) in sortConditions" :value="index" :key="index">{{sortConditionOption}}</option>
        </b-form-select>
      </b-col>
      <b-col md="2">
        <b-form-select v-model="sortOrder">
          <option v-for="(sortOrderOption, index) in sortOrders" :value="index" :key="index">{{sortOrderOption}}</option>
        </b-form-select>
      </b-col>
    </b-row>
    <b-button v-model="button" variant="primary" style="margin-top: 1%; margin-left: auto">글등록</b-button>
    <hr>

  </b-container>
</template>