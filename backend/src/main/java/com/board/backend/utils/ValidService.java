package com.board.backend.utils;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class ValidService {


    /**
     * 금지된 사용자 이름 목록(관리 데이터)
     */
    private static final Set<String> FORBIDDEN_USERID = new HashSet<>(Arrays.asList("admin", "root", "master", "manager"));

    /**
     * Id 유효성 검사
     *
     * @param id 사용자 id
     * @return 4자리 이상 12자리 미만, 영문 숫자 -_ 만 포함, 사용불가 아이디 필터링
     */
    public boolean isValidUserId(String id) {
        String insertId = "^[a-zA-Z0-9_-]{4,12}$";

        if (!id.matches(insertId)) {
            return false;
        }

        if (FORBIDDEN_USERID.contains(id)) {
            System.out.println("사용할 수 없는 id 입니다.");
            return false;
        }
        return true;
    }

    /**
     * pw 유효성 검증
     *
     * @param id 사용자 id
     * @param pw 사용자 pw
     * @return pw에 id와 동일한 문자 불가 연속된 문자 3번이상 불가
     */
    public boolean isValidPassword(String id, String pw) {

        String insertPw = "^(?=.*[0-9])(?=.*[a-z])(?=.*[~!@#$%^&*]).{4,12}";

        if (!pw.matches(insertPw)) {
            return false;
        }

        if (pw.contains(id)) {
            return false;
        }

        for (int i = 0; i < pw.length() - 2; i++) {
            char c1 = pw.charAt(i);
            char c2 = pw.charAt(i + 1);
            char c3 = pw.charAt(i + 2);

            if (c1 == c2 && c2 == c3) {
                return false;
            }
        }
        return true;
    }
}
