import { createRouter, createWebHistory } from 'vue-router'
import MainBoard from "@/views/boards/MainBoard.vue";
import NotificationBoard from "@/views/boards/NotificationBoard.vue";
import FreeBoard from "@/views/boards/FreeBoard.vue";
import GalleryBoard from "@/views/boards/GalleryBoard.vue";
import QnABoard from "@/views/boards/QnABoard.vue";
import Content from "@/views/boards/component/Content.vue";
import Modify from "@/views/boards/component/Modify.vue";
import Delete from "@/views/boards/component/Delete.vue";
import Login from "@/views/user/Login.vue";
import Signup from "@/views/user/Signup.vue";
import Write from "@/views/boards/component/Write.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: MainBoard
    },

    /**
     * 공지사항 게시판
     */
    {
      path: '/api/v1/board/notificationBoard',
      name: 'notification',
      component: NotificationBoard
    },

    /**
     * 자유 게시판
     */
    {
      path: '/api/v1/board/freeBoard',
      name: 'freeBoard',
      component: FreeBoard
    },

    /**
     * 갤러리 게시판
     */
    {
      path: '/api/v1/board/gallery',
      name: 'galleryBoard',
      component: GalleryBoard
    },

    /**
     * 문의 게시판
     */
    {
      path: '/api/v1/board/qnaBoard',
      name: 'qnaBoard',
      component: QnABoard
    },

    /**
     * 게시판 상세보기
     */
    {
      path: '/api/v1/board/content',
      name: 'content',
      component: Content
    },

    /**
     * 게시판 수정
     */
    {
      path: '/api/v1/board/modify',
      name: 'modify',
      component: Modify
    },

    /**
     * 글작성
     */
    {
      path:'/api/v1/board/write',
      name: 'write',
      component: Write
    },

    /**
     * 게시판 삭제
     */
    {
      path: '/api/v1/board/delete',
      name: 'delete',
      component: Delete
    },

    /**
     * 로그인
     */
    {
      path: '/api/v1/user/login',
      name: 'login',
      component: Login
    },

    /**
     * 회원가입
     */
    {
      path: '/api/v1/signup',
      name: 'signup',
      component: Signup
    },

  ]
})

export default router
