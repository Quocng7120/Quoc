package fis.training.filnal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import fis.training.filnal.entity.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    @NotEmpty(message = "001: Name should not be null.")
    @Length(max = 100, message = "002: Max length of name is 100.")
    private String name;

    @Past(message = "003: Birthdate should be in the past")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime birthday;

    @NotEmpty(message = "004: Address should not be null.")
    private String address;

    @NotEmpty(message = "005: Identity No should not be null.")
    @Length(max = 12, message = "CUS006: Identity No`s length is 12.")
    private String identityNo;

    @NotEmpty(message = "007: Mobile should not be null.")
    @Length(max = 10, message = "008: Phone`s length is 10.")
    private String mobile;

    @NotNull(message = "009: Customer Type should not be null.")
    private CustomerType customerType;
}
