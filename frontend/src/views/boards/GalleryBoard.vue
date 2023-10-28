<script setup>
import Header from "@/components/Header.vue";
import BoardForm from "@/components/BoardForm.vue";
</script>

<template>
  <Header />
  <b-container style="margin-top: 1%">
    <h3 style="text-align: left">Gallery</h3>
    <BoardForm />
    <b-card>
      <b-row>
        <b-col>
          Thumbnail
        </b-col>
        <b-col>
          <h4>title</h4>
          <p>content</p>
        </b-col>
      </b-row>
    </b-card>
  </b-container>
</template>