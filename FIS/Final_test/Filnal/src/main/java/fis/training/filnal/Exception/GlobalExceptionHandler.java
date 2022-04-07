package fis.training.filnal.Exception;

import fis.training.filnal.entity.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handleBindException(BindException e){
        List<ErrorMessage> errors = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach((error) ->{
            String str = error.getDefaultMessage();
            ErrorMessage errorMessage = new ErrorMessage(str.substring(0, str.indexOf(":")), str.substring(str.indexOf(":") + 2));
            errors.add(errorMessage);
            log.error("Error Message: {}", str);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<?> handleNotValidCustomerException(ValidateException e) {
        ErrorMessage em = new ErrorMessage(e.getCode(), e.getMessage());
        log.error("Error Message: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(em);
    }
}
