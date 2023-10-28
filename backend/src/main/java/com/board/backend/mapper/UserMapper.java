package com.board.backend.mapper;

import com.board.backend.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    /**
     * 회원 가입
     *
     * @param userDto 회원 가입 정보
     */
    public int userSignup(UserDto userDto);

    /**
     * Id 중복 체크
     *
     * @param id user id
     */
    public String idChecked(@Param("userId") String id);

    /**
     * pw 확인
     *
     * @param id user pw
     */
    public String pwChecked(@Param("userId") String id);

    /**
     * 관리자 로그인 id 확인
     *
     * @param id 관리자 id
     */

    public String adminIdChecked(@Param("adminId") String id);

    /**
     * 관리자 로그인 pw 확인
     *
     * @param id 관리자 id
     */
    public String adminPwChecked(@Param("adminId") String id);
}
