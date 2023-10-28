package com.board.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NonNull
    int userNum;
    @NonNull
    String userId;
    @NonNull
    String userPw;
    @NonNull
    String userName;

    @NonNull
    int adminNum;
    @NonNull
    String adminId;
    @NonNull
    String adminPw;

}
