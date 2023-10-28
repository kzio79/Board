package com.board.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {

    @NotNull
    int fileId;
    @NotNull
    int boardId;
    @NotNull
    String saveFileName;
    @NotNull
    String originalFileName;
    @NotNull
    String filePath;
}
