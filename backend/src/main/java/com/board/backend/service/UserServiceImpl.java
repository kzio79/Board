package com.board.backend.service;

import com.board.backend.mapper.UserMapper;
import com.board.backend.model.UserDto;
import com.board.backend.utils.ValidService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ValidService validService;


    /**
     * 로그인
     *
     * @param userDto 사용자 정보
     * @return 사용자 id를 통하여 암호화 pw를 확인
     */

    /*
    todo : System.out.println("storedUserId : " + storedUser);의 값이 null 이 나오는 이유
     */
    @Override
    public String userLogin(@Valid UserDto userDto) {

        String storedUserId = userMapper.idChecked(userDto.getUserId());
        String storedUserPw = userMapper.pwChecked(userDto.getUserId());

        log.debug("동작 확인 userLogin service");

        boolean idChecked = storedUserId != null && storedUserId.equals(userDto.getUserId());
        boolean pwChecked = storedUserPw != null && passwordEncoder.matches(userDto.getUserPw(), storedUserPw);

        if (idChecked) {
            if (pwChecked) {
                return "user login success";
            } else {
                return "user login fail";
            }
        } else {
            return "user id not equals";
        }
    }

    /**
     * 회원 가입
     *
     * @param userDto 사용자 정보
     * @return id, pw 유효성 검사와 중복검사
     */
    @Override
    public String userSignup(@Valid UserDto userDto) {

        if (!validService.isValidUserId(userDto.getUserId())) {
            System.out.println("invalid id");
            return "Invalid id";
        }

        if (!validService.isValidPassword(userDto.getUserId(), userDto.getUserPw())) {
            System.out.println("invalid pw");
            return "Invalid password";
        }

//        String idCheck = idCheck(userDto);
//        if ("id exist".equals(idCheck)) {
//            System.out.println("id exist signup");
//            return "Id already in use";
//        }
        log.debug("동작 확인 userSignup service");
        String encodedPw = passwordEncoder.encode(userDto.getUserPw());

        userDto.setUserPw(encodedPw);

        int result = userMapper.userSignup(userDto);
        return result > 0 ? "signup success" : "signup fail";
    }

    /**
     * id 중복 검사
     *
     * @param userDto 사용자 id
     * @return 사용자 id를 통한 중복 검사
     */
    @Override
    public String idChecked(@Valid UserDto userDto) {

        String idChecked = userMapper.idChecked(userDto.getUserId());
        log.debug("동작 확인 idChecked service");

        if (idChecked != null) {
            System.out.println("id exist");
            return "id exist";
        } else {
            System.out.println("id not exist");
            return "id not exist";
        }
    }

    /**
     * 관리자 로그인
     *
     * @param userDto 관리자 id
     * @return 관리자 id를 통하여 암호화 pw를 확인
     */
    @Override
    public String adminLogin(@Valid UserDto userDto) {

        String storedAdminId = userMapper.adminIdChecked(userDto.getAdminId());
        String storedAdminPw = userMapper.adminPwChecked(userDto.getAdminId());

        boolean idChecked = storedAdminId != null && storedAdminId.equals(userDto.getAdminId());
        boolean pwChecked = storedAdminPw != null && passwordEncoder.matches(userDto.getAdminPw(), storedAdminPw);

        log.debug("동작 확인 adminLogin service");

        if (idChecked) {
            if (pwChecked) {
                return "admin login success";
            } else {
                return "admin login fail";
            }
        } else {
            System.out.println("admin id not equals");
            return "admin id not equals";
        }
    }
}
