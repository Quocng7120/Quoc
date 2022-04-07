package fis.training.filnal.Exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppException extends RuntimeException {
    private String code;
    public AppException(String code, String message){
        super(message);
        this.code = code;
    }

}
