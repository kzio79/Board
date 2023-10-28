package com.board.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    @NonNull
    int boardId;
    @NonNull
    int categoryId;
    @NonNull
    int adminNum;
    @NonNull
    int userNum;
    @NonNull
    String menuType;
    @NonNull
    String title;
    @NonNull
    String writer;
    @NonNull
    String content;
    @NonNull
    Timestamp writeDate;
    @NonNull
    Timestamp answerDate;
    @NonNull
    int hit;
    @NonNull
    int secretCheck;
    @NonNull
    int noticeCheck;

    String searchId;
    Timestamp startDate;
    Timestamp endDate;

    int pageNum = 1;
    int pageSize = 10;
    int startPage;
}
