package com.example.item;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 여러 컨트롤러에서 발생한 예회를 처리함.
public class GlobalExceptionHandler
{
    @ExceptionHandler(IllegalArgumentException.class) // 예외 발생 시 아래 실행
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex)
    {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // NOT_FOUND, CONFLICT
                .body(ex.getMessage());
    }
}
