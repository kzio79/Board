package com.board.backend.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResult {

    private int resultCode;
    private String resultMessage;
    private Object data;

    public ApiResult(ResultCode resultCode, Object data) {
        this.resultCode = resultCode.getCode();
        this.resultMessage = resultCode.getMessage();
        this.data = data;
    }
}
