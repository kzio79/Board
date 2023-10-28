<script setup>
</script>

<template>
  <b-container>
    <b-row>
      <b-col cols="1">
        분류
      </b-col>
      <b-col cols="1">
        제목
      </b-col>
      <b-col cols="1" style="margin-left: auto">
        등록일시
      </b-col>
      <b-col cols="1">
        등록자
      </b-col>
    </b-row>
    <hr>
    <b-row>
      <b-col cols="1" style="margin-left: auto">
        조회수 :
      </b-col>
    </b-row>
    <b-form-textarea style="margin-top: 2%;" rows="12">내용</b-form-textarea>
    <b-col cols="4">
      첨부파일
    </b-col>


    <b-card style="margin-top: 2%;">
      <b-row>
        <b-col cols="11">
          <b-form-textarea rows="1" placeholder="댓글을 입력해 주세요"></b-form-textarea>
        </b-col>
        <b-col >
          <b-button v-model="reply" variant="info">등록</b-button>
        </b-col>
      </b-row>
      <b-form style="margin-top: 1%;" >
        <b-row>
          <b-col cols="10">
            등록자 등록일시
          </b-col>
          <b-col style="margin-left: auto;">
            <b-form-text >삭제</b-form-text>
          </b-col>
        </b-row>
        <b-row>
          <b-col cols="10">
            댓글내용
          </b-col>
        </b-row>
        <hr>
      </b-form>
    </b-card>
    <b-form style="margin-top: 2%;">
      <b-row>
        <b-col style="justify-content: center">
          <b-button variant="primary" style="margin-right: 1%; justify-content: center">등록</b-button>
          <b-button variant="primary" style="margin-right: 1%;">수정</b-button>
          <b-button variant="primary">삭제</b-button>
        </b-col>
      </b-row>
    </b-form>

  </b-container>
</template>