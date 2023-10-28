<script setup>
</script>

<template>
  <b-container style="margin-top: 1%">
    <b-card>
      <b-row>
        <b-col cols="2" >
          <label>분류*</label>
        </b-col>
        <b-col cols="2">
          <b-form-select v-model="category" required="true">
            <option value="0">분류</option>
            <option value="1">JAVA</option>
            <option value="2">JS</option>
            <option value="3">SpringBoot</option>
            <option value="4">Android</option>
            <!--              <option v-for="category in props" :value="category" :key="categoryNum">{{category.name}}</option>-->
          </b-form-select>
        </b-col>
      </b-row>
      <hr>
      <b-row>
        <b-col cols="2">
          <label>제목*</label>
        </b-col>
        <b-col cols="8">
          <b-form-input v-model="title" type="text" placeholder="제목을 입력해 주세요" required/>
        </b-col>
      </b-row>
      <hr>
      <b-row>
        <b-col cols="2">
          <label>내용*</label>
        </b-col>
        <b-col cols="8">
          <b-form-textarea v-model="content" rows="12" required></b-form-textarea>
        </b-col>
      </b-row>
      <hr>
      <b-row>
        <b-col cols="2">
          <label>첨부</label>
        </b-col>
        <b-col cols="8">
          <input type="file">
        </b-col>
      </b-row>
      <b-row style="margin-top: 1%;">
        <b-col cols="2">
        </b-col>
        <b-col cols="8">
          <b-button v-model="files" variant="outline-danger">추가</b-button>
        </b-col>
      </b-row>
    </b-card>
    <b-form style="margin-top: 2%;">
      <b-row>
        <b-col style="justify-content: center">
          <b-button variant="primary" style="margin-right: 1%; justify-content: center">등록</b-button>
          <b-button variant="primary" style="margin-right: 1%;">수정</b-button>
        </b-col>
      </b-row>
    </b-form>
  </b-container>
</template>