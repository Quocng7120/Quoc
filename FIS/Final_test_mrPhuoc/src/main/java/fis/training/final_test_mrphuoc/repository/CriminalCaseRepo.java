package fis.training.final_test_mrphuoc.repository;

import fis.training.final_test_mrphuoc.entity.CaseType;
import fis.training.final_test_mrphuoc.entity.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriminalCaseRepo extends JpaRepository<CriminalCase, Long> {
    CriminalCase findByNumber(String number);
    List<CriminalCase> findByType(CaseType type);
    boolean existsByNumber(String number);
}
