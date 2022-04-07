package fis.training.filnal.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidateException extends AppException{
    private String code;
    private String message;

    public ValidateException(String code, String message){
        super(code, message);
    }
}
