package com.board.backend.service;

import com.board.backend.mapper.BoardMapper;
import com.board.backend.model.BoardDto;
import com.board.backend.model.FileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final FileService fileService;

    /**
     * 게시글 총 갯수
     *
     * @param boardDto 검색 조건에 따른 게시글 parameter
     * @return 게시글 갯수로 return
     */
    @Override
    public int totalCount(BoardDto boardDto) {

        return boardMapper.totalCount(boardDto);
    }

    /**
     * 게시글 보기
     *
     * @param boardDto 게시글 parameter
     * @return 게시글 보기로 return
     */
    @Override
    public List<BoardDto> getBoardList(BoardDto boardDto) {

        int startPage = (boardDto.getPageNum() - 1) * boardDto.getPageSize();
        boardDto.setStartPage(startPage);
        return boardMapper.getBoardList(boardDto);
    }

    @Override
    public BoardDto viewContent(int boardId) {
        return boardMapper.viewContent(boardId);
    }

    /**
     * 글 수정
     *
     * @param boardDto 글 수정 parameter
     * @param files    파일 수정 parameter
     */
    @Override
    public void modifyContent(BoardDto boardDto, List<MultipartFile> files) {

        boardMapper.modifyContent(boardDto);

        if (files != null && !files.isEmpty()) {
            FileDto fileDto = new FileDto();
            fileDto.setBoardId(boardDto.getBoardId());

            fileService.insertFile(fileDto, files);
        }
    }

    /**
     * 글 작성
     *
     * @param boardDto 글 작성 parameter
     * @param files    파일 업 로드시 parameter
     */
    @Override
    public void writeContent(BoardDto boardDto, List<MultipartFile> files) {

        boardMapper.writeContent(boardDto);

        if (files != null && !files.isEmpty()) {
            FileDto fileDto = new FileDto();
            fileDto.setBoardId(boardDto.getBoardId());

            fileService.insertFile(fileDto, files);
        }
    }

    /**
     * 글 삭제(sql 구문 으로 삭제 ON UPDATE CASCADE ON DELETE CASCADE)
     *
     * @param boardId 글 번호를 통해 댓글, 파일 한번에 삭제
     */
    @Override
    public void deleteContent(int boardId) {

        boardMapper.deleteContent(boardId);

    }

    /**
     * 조회수
     *
     * @param boardId 게시판 id
     */
    @Override
    public void updateHit(int boardId) {
        boardMapper.updateHit(boardId);
    }
}
