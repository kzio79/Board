package com.board.backend.mapper;

import com.board.backend.model.ReplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    /**
     * 댓글 불러 오기
     *
     * @param boardId 게시판 id
     */
    public List<ReplyDto> getReplyList(@Param("boardId") int boardId);

    /**
     * 댓글 작성
     *
     * @param boardId 게시판 id
     * @param content 댓글 내용
     */
    public int writeReply(@Param("boardId") int boardId, @Param("replyContent") String content);

    /**
     * 댓글 개별 삭제
     *
     * @param replyId 댓글 id
     */
    public int deleteReply(@Param("replyId") int replyId);

}
