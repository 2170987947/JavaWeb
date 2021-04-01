package org.example.exception;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/30 12:50
 */
public class AppException extends RuntimeException{

    /**
     * 自定义异常: 业务代码跑自定义异常或其他异常
     * 自定义异常
     */
    private String code;
    public AppException(String code, String message) {
//        super(message);
//        this.code = code;
        this(code, message, null);
    }

    public AppException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
