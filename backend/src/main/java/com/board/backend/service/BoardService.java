package com.board.backend.service;

import com.board.backend.model.BoardDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {


    public int totalCount(BoardDto boardDto);

    public List<BoardDto> getBoardList(BoardDto boardDto);

    public BoardDto viewContent(int boardId);

    public void modifyContent(BoardDto boardDto, List<MultipartFile> files);

    public void writeContent(BoardDto boardDto, List<MultipartFile> files);

    public void deleteContent(int boardId);

    public void updateHit(int boardId);
}
