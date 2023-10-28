package com.board.backend.service;

import com.board.backend.mapper.ReplyMapper;
import com.board.backend.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;

    /**
     * 댓글 불러 오기
     *
     * @param boardId 게시판 id
     */
    @Override
    public List<ReplyDto> getReplyList(int boardId) {
        return replyMapper.getReplyList(boardId);
    }

    /**
     * 댓글 작성
     *
     * @param boardId      게시판 id
     * @param replyContent 댓글 내용
     */
    @Override
    public int writeReply(int boardId, String replyContent) {
        return replyMapper.writeReply(boardId, replyContent);
    }

    /**
     * 댓글 개별 삭제
     *
     * @param replyId 댓글 id
     */
    @Override
    public void deleteReply(int replyId) {
        replyMapper.deleteReply(replyId);
    }

}
