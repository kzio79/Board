package com.board.backend.mapper;

import com.board.backend.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    public int totalCount(BoardDto boardDto);

    public List<BoardDto> getBoardList(BoardDto boardDto);

    public BoardDto viewContent(@Param("boardId") int boardId);

    public int modifyContent(BoardDto boardDto);

    public int writeContent(BoardDto boardDto);

    public int deleteContent(@Param("boardId") int boardId);

    public void updateHit(@Param("boardId") int boardId);
}
