<script setup>
import Header from "@/components/Header.vue";
import BoardForm from "@/components/BoardForm.vue";
</script>

  <template>
    <Header />
    <b-container style="margin-top: 1%">
      <h3 style="text-align: left;">공지사항</h3>
      <BoardForm />
      <table style="text-align: center; width: 100%; margin-top: 1%;">
        <thead>
        <tr>
          <th>번호</th>
          <th>분류</th>
          <th>제목</th>
          <th>조회</th>
          <th>등록일시</th>
          <th>등록자</th>
        </tr>
        </thead>
      </table>
      <hr>
      <table style="text-align: center; width: 100%; margin-top: 1%;">
        <tbody>
        <tr >
          <td>번호</td>
          <td>분류</td>
          <td>제목
            <a
                @click.prevent="showContent(boardList.boardNum)"
                style=" text-decoration: none; color: black"
            >

            </a>
          </td>
          <td>조회</td>
          <td>등록일시</td>
          <td>등록자</td>
        </tr>
        </tbody>
      </table>
      <hr>
    </b-container>
  </template>
