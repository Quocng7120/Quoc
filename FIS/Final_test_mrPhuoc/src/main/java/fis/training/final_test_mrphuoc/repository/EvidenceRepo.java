package fis.training.final_test_mrphuoc.repository;

import fis.training.final_test_mrphuoc.entity.CriminalCase;
import fis.training.final_test_mrphuoc.entity.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvidenceRepo extends JpaRepository<Evidence, Long> {
    Evidence findByNumber(String number);
    boolean existsByNumber(String number);
    List<Evidence> findByCriminalCase(CriminalCase criminalCase);
}
