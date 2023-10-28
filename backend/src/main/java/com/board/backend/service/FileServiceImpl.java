package com.board.backend.service;

import com.board.backend.mapper.FileMapper;
import com.board.backend.model.FileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${spring.servlet.multipart.location}")
    private String saveFileUrl;

    private final FileMapper fileMapper;

    @Override
    public List<FileDto> getFileList(int boardId) {
        return fileMapper.getFileList(boardId);
    }

    @Override
    public void insertFile(FileDto fileDto, List<MultipartFile> files) {

        for (MultipartFile file : files) {
            if (file != null && !file.isEmpty()) {

                fileDto.setSaveFileName(file.getOriginalFilename());
                fileDto.setOriginalFileName(file.getOriginalFilename());
                fileDto.setFilePath(saveFileUrl + File.separator + fileDto.getOriginalFileName());

                System.out.println("fileName :" + file.getOriginalFilename());
                System.out.println("filePathSaveFileUrl fileService: " + saveFileUrl);

                Path path = Paths.get(saveFileUrl + File.separator + fileDto.getOriginalFileName());
                System.out.println("filePath fileService: " + path);
                try (InputStream inputStream = file.getInputStream()) {

                    Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);

                    File fileSaveDir = new File(saveFileUrl);

                    if (!fileSaveDir.exists()) {
                        fileSaveDir.mkdirs();
                    }

                    System.out.println("fileDto : " + fileDto);
                    fileMapper.insertFile(fileDto);

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteSelectedFile(int fileId) {
        fileMapper.deleteSelectedFile(fileId);
    }

    @Override
    public File downloadFile(int boardId, int fileId) throws NotDirectoryException, FileNotFoundException {

        FileDto fileDto = fileMapper.downloadFile(boardId, fileId);
        String filePath = fileDto.getFilePath();

        if (!filePath.startsWith(saveFileUrl)) {
            throw new NotDirectoryException("저장된 위치가 아닙니다.");
        }

        File downloadFiles = new File(filePath);

        if (!downloadFiles.exists()) {
            throw new FileNotFoundException("파일이 존재하지 않습니다." + filePath);
        }
        return downloadFiles;
    }
}
