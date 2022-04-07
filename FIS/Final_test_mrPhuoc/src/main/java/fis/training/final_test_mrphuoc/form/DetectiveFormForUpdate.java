package fis.training.final_test_mrphuoc.form;

import fis.training.final_test_mrphuoc.entity.EmploymentStatus;
import fis.training.final_test_mrphuoc.entity.Person;
import fis.training.final_test_mrphuoc.entity.Ranks;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DetectiveFormForUpdate {

    private int version;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private Person person;

    private String badgeNumber;
    private Ranks rankz;
    private Boolean armed;
    private EmploymentStatus status;
}
