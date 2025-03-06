package com.example.WebsiteBanHang2.Exception;

public enum ErrorCode {
    OTHEREXCEPTION(1010,"Loi khong xac dinh"),
    INVALID_PASSWORD(900,"Password must be at lest 5 characters"),
    INVALID_FIRST_NAME(902,"First name must be at lest 5 characters"),
    EMAIL_IN_USE(901,"Email already used"),
    INVALID_INPUT(903,"Input is invalid"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private int code;
    private String message;
}
