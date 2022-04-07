package fis.training.final_test_mrphuoc.service;

import fis.training.final_test_mrphuoc.entity.Detective;
import fis.training.final_test_mrphuoc.form.DetectiveFormForUpdate;

import java.util.List;

public interface DetectiveService {
    Detective addDetective(Detective detective);
    void updateDetective(Long id, DetectiveFormForUpdate form);
    void deleteDetective(Long id);
    Detective findDetectiveById(Long id);
    List<Detective> getAllDetective();
}
