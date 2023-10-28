package com.board.backend.controller.board;

import com.board.backend.model.BoardDto;
import com.board.backend.model.FileDto;
import com.board.backend.model.ReplyDto;
import com.board.backend.service.BoardService;
import com.board.backend.service.FileService;
import com.board.backend.service.ReplyService;
import com.board.backend.utils.ApiResult;
import com.board.backend.utils.BoardResponse;
import com.board.backend.utils.ResultCode;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NotDirectoryException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/free")
@RequiredArgsConstructor
public class FreeBoardController {

    private final BoardService boardService;
    private final ReplyService replyService;
    private final FileService fileService;

    /**
     * 게시글 리스트
     *
     * @param boardDto 게시글 리스트 parameter
     */
    @GetMapping("/boards")
    public ResponseEntity<?> getBoardList(BoardDto boardDto) {

        boardDto.setMenuType("free");

        List<BoardDto> getBoardList = boardService.getBoardList(boardDto);
        int totalCount = boardService.totalCount(boardDto);

        BoardResponse responseData = new BoardResponse();
        responseData.setBoardList(getBoardList);
        responseData.setTotalCount(totalCount);

        ApiResult response = new ApiResult(ResultCode.SUCCESS, responseData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 게시글 보기
     *
     * @param boardDto 게시글 보기 위한 parameter(boardId)
     */
    @GetMapping("/content")
    public ResponseEntity<?> viewContent(@RequestBody @Valid BoardDto boardDto) {

        BoardDto viewContent = boardService.viewContent(boardDto.getBoardId());

        List<ReplyDto> getReplyList = replyService.getReplyList(boardDto.getBoardId());

        List<FileDto> getFileList = fileService.getFileList(boardDto.getBoardId());

        boardService.updateHit(boardDto.getBoardId());

        BoardResponse responseDate = new BoardResponse();
        responseDate.setBoardDto(viewContent);
        responseDate.setReplyList(getReplyList);
        responseDate.setFileList(getFileList);

        ApiResult response = new ApiResult(ResultCode.SUCCESS, responseDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * 게시글 수정
     *
     * @param boardDto 게시글 수정 parameter
     * @param files    파일 업로드 parameter
     */
    @PostMapping("/modify")
    public ResponseEntity<?> modifyContent(@RequestPart @Valid BoardDto boardDto,
                                           @RequestPart(required = false) List<MultipartFile> files) {

        boardDto.setMenuType("free");
        boardService.modifyContent(boardDto, files);

        BoardResponse responseDate = new BoardResponse();
        responseDate.setBoardId(boardDto.getBoardId());

        ApiResult response = new ApiResult(ResultCode.SUCCESS, responseDate);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /**
     * 글 작성
     *
     * @param boardDto 글 작성 parameter
     * @param files    파일 업로드 parameter
     */
    @PostMapping("/write")
    public ResponseEntity<?> writeContent(@RequestPart @Valid BoardDto boardDto,
                                          @RequestPart(required = false) List<MultipartFile> files) {

        boardDto.setMenuType("free");
        boardService.writeContent(boardDto, files);

        BoardResponse responseDate = new BoardResponse();
        responseDate.setBoardId(boardDto.getBoardId());

        ApiResult response = new ApiResult(ResultCode.SUCCESS, responseDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteContent(@RequestBody @Valid BoardDto boardDto) {

        boardService.deleteContent(boardDto.getBoardId());
        return ResponseEntity.ok().build();

    }

    /**
     * 댓글 작성
     *
     * @param replyDto 댓글 작성 parameter
     */
    @PostMapping("/writeReply")
    public ResponseEntity<?> replyContent(@RequestBody @Valid ReplyDto replyDto) {

        int replyContent = replyService.writeReply(replyDto.getBoardId(), replyDto.getReplyContent());

        BoardResponse responseDate = new BoardResponse();
        responseDate.setReplyContent(replyContent);

        ApiResult response = new ApiResult(ResultCode.SUCCESS, responseDate);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /**
     * 댓글 선택 삭제
     *
     * @param replyDto 댓글 삭제 parameter
     */
    @PostMapping("/deleteReply")
    public ResponseEntity<?> deleteReply(@RequestBody @Valid ReplyDto replyDto) {

        replyService.deleteReply(replyDto.getReplyId());

        BoardResponse responseDate = new BoardResponse();
        responseDate.setReplyId(replyDto.getReplyId());

        ApiResult response = new ApiResult(ResultCode.SUCCESS, responseDate);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /**
     * 파일 삭제
     *
     * @param fileDto 파일 삭제 parameter
     * @return fileDto 가 null 이 아닐 경우 삭제 null 일경우 badRequest 발생
     */
    @PostMapping("/deleteFile")
    public ResponseEntity<?> deleteFile(@RequestBody FileDto fileDto) {

        if (fileDto != null) {
            fileService.deleteSelectedFile(fileDto.getFileId());

            BoardResponse responseDate = new BoardResponse();
            responseDate.setFileId(fileDto.getFileId());

            ApiResult response = new ApiResult(ResultCode.SUCCESS, responseDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * 파일 다운 로드
     *
     * @param fileDto 파일 다운 로드 parameter
     * @throws NotDirectoryException 저장된 폴더가 없을떄
     * @throws FileNotFoundException 저장된 파일이 없을때
     */
    @GetMapping("/downloadFile")
    public ResponseEntity<?> downloadFile(@RequestBody FileDto fileDto) throws NotDirectoryException, FileNotFoundException {

        File file = fileService.downloadFile(fileDto.getBoardId(), fileDto.getFileId());

        System.out.println("file : " + file);

        Resource resource = new FileSystemResource(file);

        BoardResponse responseDate = new BoardResponse();
        responseDate.setResource(resource);

        ApiResult response = new ApiResult(ResultCode.SUCCESS, responseDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
//        try {
//            File file = fileService.downloadFile(fileDto.getBoardId(), fileDto.getFileId());
//
//            Resource resource = new FileSystemResource(file);
//
//            BoardResponse responseDate = new BoardResponse();
//            responseDate.setResource(resource);
//
//            ApiResult response = new ApiResult(ResultCode.SUCCESS, responseDate);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (NotDirectoryException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        } catch (FileNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
    }

//    @GetMapping("/downloadFile")
//    public void downloadFile(@RequestBody FileDto fileDto, HttpServletResponse response) throws IOException {
//
//        File file = fileService.downloadFile(fileDto.getBoardId(), fileDto.getFileId());
//
//        String fileName = file.getName();
//
//        response.setContentType("application/octet-stream");
//        response.setHeader("Content-Disposition",
//                "attachment;fileName=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
//
//        Files.copy(file.toPath(), response.getOutputStream());
//    }
}
