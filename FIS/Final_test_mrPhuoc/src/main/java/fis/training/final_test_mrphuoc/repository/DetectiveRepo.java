package fis.training.final_test_mrphuoc.repository;

import fis.training.final_test_mrphuoc.entity.Detective;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetectiveRepo extends JpaRepository<Detective, Long> {
    Detective findByBadgeNumber(String badgeNumber);
}
