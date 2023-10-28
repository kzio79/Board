package com.board.backend.controller.user;

import com.board.backend.model.UserDto;
import com.board.backend.service.UserService;
import com.board.backend.utils.ApiResult;
import com.board.backend.utils.ResultCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /*
   todo : frontend 와 연동후 if문 재 설정
    */


    /**
     * 회원 로그인
     *
     * @param userDto 회원 정보
     * @return 401(UNAUTHORIZED), 400(BAD_REQUEST), 200(SUCCESS)
     */
    @GetMapping("/api/v1/user/login")
    public ResponseEntity<?> userLogin(@RequestBody @Valid UserDto userDto) {

        String login = userService.userLogin(userDto);

        if ("user login fail".equals(login)) {

            ApiResult response = new ApiResult(ResultCode.UNAUTHORIZED, login);
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);

        } else if ("user id not equals".equals(login)) {

            ApiResult response = new ApiResult(ResultCode.BAD_REQUEST, login);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } else {

            ApiResult response = new ApiResult(ResultCode.SUCCESS, login);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    /**
     * 회원 가입
     *
     * @param userDto 회원 정보
     * @return 200(SUCCESS)
     */
    @PostMapping("/api/v1/user/signup")
    public ResponseEntity<?> userSignup(@RequestBody @Valid UserDto userDto) {

        String signUp = userService.userSignup(userDto);

        if ("signup fail".equals(signUp)) {
            return userSignup(userDto);
        } else {
            ApiResult response = new ApiResult(ResultCode.SUCCESS, signUp);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    /**
     * id 중복 체크
     *
     * @param userDto 회원 정보
     * @return 200(SUCCESS)
     */
    @PostMapping("/api/v1/user/idChecked")
    public ResponseEntity<?> idChecked(@RequestBody @Valid UserDto userDto) {

        String idChecked = userService.idChecked(userDto);
        if ("id exist".equals(idChecked)) {
            return idChecked(userDto);

        } else {
            ApiResult response = new ApiResult(ResultCode.SUCCESS, idChecked);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    /**
     * 관리자 로그인
     *
     * @param userDto 관리자 정보
     * @return 401(UNAUTHORIZED), 400(BAD_REQUEST), 200(SUCCESS)
     */
    @GetMapping("/api/v1/adminLogin")
    public ResponseEntity<?> adminLogin(@RequestBody @Valid UserDto userDto) {

        String adminLogin = userService.adminLogin(userDto);

        if ("admin login fail".equals(adminLogin)) {

            ApiResult response = new ApiResult(ResultCode.UNAUTHORIZED, adminLogin);
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);

        } else if ("admin id not equals".equals(adminLogin)) {

            ApiResult response = new ApiResult(ResultCode.BAD_REQUEST, adminLogin);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } else {

            ApiResult response = new ApiResult(ResultCode.SUCCESS, adminLogin);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }
}
