package com.vti.departmentmanegement.service;

import com.vti.departmentmanegement.entity.Department;
import com.vti.departmentmanegement.form.DepartmentFilterForm;
import com.vti.departmentmanegement.form.DepartmentFormForCreating;
import com.vti.departmentmanegement.form.DepartmentFormForUpdating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IDepartmentService {

	public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm filter);

	public Department getDepartmentByID(short id);

	public Department getDepartmentByName(String name);

	public void createDepartment(DepartmentFormForCreating form);

	public void updateDepartment(short id, DepartmentFormForUpdating form);

	public void deleteDepartment(short id);

	public boolean isDepartmentExistsByID(short id);

	public boolean isDepartmentExistsByName(String name);
	public void deleteDepartments(List<Short> ids);
}
