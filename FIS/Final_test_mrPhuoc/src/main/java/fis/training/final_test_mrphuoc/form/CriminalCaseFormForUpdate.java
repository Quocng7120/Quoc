package fis.training.final_test_mrphuoc.form;

import fis.training.final_test_mrphuoc.entity.CaseStatus;
import fis.training.final_test_mrphuoc.entity.CaseType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CriminalCaseFormForUpdate {

    private int version;
    private String number;
    private CaseType type;
    private CaseStatus status;
    private String shortDescription;
    private String detailDescription;
    private String notes;
}
