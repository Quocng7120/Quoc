package fis.training.final_test_mrphuoc.service;

import fis.training.final_test_mrphuoc.entity.CriminalCase;
import fis.training.final_test_mrphuoc.form.CriminalCaseFormForUpdate;

import java.util.List;

public interface CriminalCaseService {
    CriminalCase addCriminalCase(CriminalCase criminalCase);
    void updateCriminalCase(Long id, CriminalCaseFormForUpdate criminalCaseFormForUpdate);
    void deleteCriminalCase(Long id);
    CriminalCase findCriminalCaseById(Long id);
    List<CriminalCase> getAllCriminalCase();
}
