package com.board.backend.service;

import com.board.backend.model.UserDto;

public interface UserService {

    public String userLogin(UserDto userDto);

    public String userSignup(UserDto userDto);

    public String idChecked(UserDto userDto);

    public String adminLogin(UserDto userDto);
}
