package fis.training.final_test_mrphuoc.repository;

import fis.training.final_test_mrphuoc.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(String name);
}
