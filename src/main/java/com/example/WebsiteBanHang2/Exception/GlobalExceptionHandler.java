package com.example.WebsiteBanHang2.Exception;
import com.example.WebsiteBanHang2.Model.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler( value = Exception.class)
//    public ResponseEntity<ApiResponse> handleOtherExceptions(Exception Exception) {
//        ApiResponse<Object> response = new ApiResponse<>();
//        response.setCode(ErrorCode.OTHEREXCEPTION.getCode());
//        response.setMessage(ErrorCode.OTHEREXCEPTION.getMessage());
//        return ResponseEntity.badRequest().body(response);
//    }
    @ExceptionHandler( value = AppException.class)
    public ResponseEntity<ApiResponse> handleAllExceptions(AppException appException) {
        ErrorCode errorCode = appException.getErrorCode();
        ApiResponse<Object> response = new ApiResponse<>();
        response.setCode(errorCode.getCode());
        response.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler( value = IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleAllExceptions(IllegalArgumentException Exception) {
        ApiResponse<Object> response = new ApiResponse<>();
        response.setMessage(Exception.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        String message = "Validation failed: ";
        ErrorCode errorCode = ErrorCode.INVALID_INPUT;
        String specificMessage = null;

        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            specificMessage = violation.getMessage();
            message += specificMessage + " (field: " + violation.getPropertyPath() + ")" +"/n";

            if ("INVALID_PASSWORD".equals(specificMessage)) {
                errorCode = ErrorCode.INVALID_PASSWORD;
            }
        }
        ApiResponse<Object> response = new ApiResponse<>();
        response.setCode(errorCode.getCode());
        response.setMessage(errorCode.getMessage()+message);
        return ResponseEntity.badRequest().body(response);
    }

}