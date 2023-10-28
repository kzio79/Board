package com.board.backend.utils;

import com.board.backend.model.BoardDto;
import com.board.backend.model.FileDto;
import com.board.backend.model.ReplyDto;
import lombok.Data;
import org.springframework.core.io.Resource;

import java.util.List;

@Data
public class BoardResponse {

    private List<BoardDto> boardList;
    private int totalCount;
    private int boardId;

    private List<ReplyDto> replyList;
    private BoardDto boardDto;
    private int replyContent;
    private int replyId;

    private List<FileDto> fileList;
    private int fileId;
    private Resource resource;
}
