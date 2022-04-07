package fis.training.final_test_mrphuoc.repository;

import fis.training.final_test_mrphuoc.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
	boolean existsByUsername(String username);

	Person findByUsername(String username);

}
