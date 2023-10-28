package com.board.backend.service;

import com.board.backend.model.ReplyDto;

import java.util.List;

public interface ReplyService {

    /**
     * 댓글 불러 오기
     *
     * @param boardId 게시판 id
     */
    public List<ReplyDto> getReplyList(int boardId);

    /**
     * 댓글 작성
     *
     * @param boardId 게시판 id
     * @param content 댓글 내용
     */
    public int writeReply(int boardId, String content);

    /**
     * 댓글 개별 삭제
     *
     * @param replyId 댓글 id
     */
    public void deleteReply(int replyId);
}
