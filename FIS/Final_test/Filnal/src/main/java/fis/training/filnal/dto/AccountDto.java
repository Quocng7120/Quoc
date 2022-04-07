package fis.training.filnal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    @NotEmpty(message = "ACC001: AccountNumber should not be null.")
    @Length(max = 13, message = "ACC002: Max length of name is 13.")
    private String accountNumber;

    @NotEmpty(message = "ACC003: Balance should not be null.")
    private Double balance;

    @NotEmpty(message = "ACC004: Status should not be null.")
    private Integer status;
}
