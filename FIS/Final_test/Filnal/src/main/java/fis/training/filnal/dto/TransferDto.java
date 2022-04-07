package fis.training.filnal.dto;

import fis.training.filnal.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {

    @NotEmpty(message = "TF001: FromAccountId should not be null.")
    private Long fromAccountId;

    @NotEmpty(message = "TF002: ToAccountId should not be null.")
    private Long toAccountId;

    @NotEmpty(message = "TF003: amount should not be null.")
    private Double amount;

    @NotEmpty(message = "TF004: status should not be null.")
    private Integer status;

    @NotEmpty(message = "TF005: content should not be null.")
    private String content;

    @NotEmpty(message = "TF006: errorReason should not be null.")
    private String errorReason;
}
