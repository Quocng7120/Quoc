package com.vti.departmentmanegement.repository;

import com.vti.departmentmanegement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Short>, JpaSpecificationExecutor<Department> {

	public Department findByName(String name);

	public boolean existsByName(String name);

	@Modifying
	@Transactional
	@Query("delete from Department where id in(:ids)")
	public void deleteByIds(@Param("ids") List<Short> ids);

}
