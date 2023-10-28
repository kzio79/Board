package com.board.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDto {

    @NonNull
    int replyId;
    @NonNull
    int boardId;
    @NonNull
    String replyContent;
    @NonNull
    Timestamp replyDate;
}
