package com.board.backend.service;

import com.board.backend.model.FileDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NotDirectoryException;
import java.util.List;

public interface FileService {

    public List<FileDto> getFileList(int boardId);

    public void insertFile(FileDto fileDto, List<MultipartFile> files);

    public void deleteSelectedFile(int fileId);

    public File downloadFile(int boardId, int fileId) throws NotDirectoryException, FileNotFoundException;
}
