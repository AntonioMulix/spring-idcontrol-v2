package com.id.control.exception;

import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author marco-romero
 * @param <T>
 */
@Data
public class ApiResponse<T> {

    private int status;
    private String message;
    private boolean success;
    private T data;
    private LocalDateTime timestamp;

    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse<T> res = new ApiResponse<>();
        res.status = 200;
        res.message = "OK";
        res.success = true;
        res.data = data;
        res.timestamp = LocalDateTime.now();
        return res;
    }

    public static <T> ApiResponse<T> ok(String message, T data) {
        ApiResponse<T> res = new ApiResponse<>();
        res.status = 200;
        res.message = message;
        res.success = true;
        res.data = data;
        res.timestamp = LocalDateTime.now();
        return res;
    }

    public static <T> ApiResponse<T> error(int status, String message) {
        ApiResponse<T> res = new ApiResponse<>();
        res.status = status;
        res.message = message;
        res.success = false;
        res.data = null;
        res.timestamp = LocalDateTime.now();
        return res;
    }
}
