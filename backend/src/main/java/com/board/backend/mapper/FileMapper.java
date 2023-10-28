package com.board.backend.mapper;

import com.board.backend.model.FileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileMapper {

    /**
     * 파일 등록
     *
     * @param fileDto 파일 등록 parameter
     */
    public void insertFile(FileDto fileDto);

    /**
     * 전체 파일 보기
     *
     * @param boardId 파일 보기 parameter
     */
    public List<FileDto> getFileList(@Param("boardId") int boardId);

    /**
     * 파일 선택 삭제
     *
     * @param fileId 파일 삭제 paremeter
     */
    public void deleteSelectedFile(@Param("fileId") int fileId);

    public FileDto downloadFile(@Param("boardId") int boardId, @Param("fileId") int fileId);
}
