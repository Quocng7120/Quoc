package com.vti.departmentmanegement.controller;

import com.vti.departmentmanegement.dto.AccountDto;
import com.vti.departmentmanegement.dto.DepartmentDto;
import com.vti.departmentmanegement.dto.DetailDepartmentDto;
import com.vti.departmentmanegement.entity.Department;
import com.vti.departmentmanegement.form.DepartmentFilterForm;
import com.vti.departmentmanegement.form.DepartmentFormForCreating;
import com.vti.departmentmanegement.form.DepartmentFormForUpdating;
import com.vti.departmentmanegement.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@GetMapping()
	public ResponseEntity<?> getAllDepartments(Pageable pageable, @RequestParam(required = false) String search, DepartmentFilterForm filter) {
		Page<Department> entities = service.getAllDepartments(pageable, search, filter);

		Page<DepartmentDto> dtos = entities.map(new Function<Department, DepartmentDto>() {
			@Override
			public DepartmentDto apply(Department department) {
				DepartmentDto dto = new DepartmentDto(department.getId(), department.getName(),
						new AccountDto(department.getAuthor().getId(), department.getAuthor().getFullName()),
						department.getCreateDate());
				return dto;
			}
		});
		return new ResponseEntity<>(dtos, HttpStatus.OK);
//		List<DepartmentDto> dtos = new ArrayList<>();
//		for(Department entity : entities){
//
//			AccountDto accountDto = new AccountDto(entity.getAuthor().getId(), entity.getAuthor().getFullName());
//			DepartmentDto dto = new DepartmentDto(entity.getId(), entity.getName(), accountDto, entity.getCreateDate());
//			dtos.add(dto);
//		}
//		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") short id) {

		Department entity = service.getDepartmentByID(id);
		AccountDto accountDto = new AccountDto(entity.getAuthor().getId(), entity.getAuthor().getFullName());
		DetailDepartmentDto dto = new DetailDepartmentDto(entity.getId(), entity.getName(), accountDto, entity.getCreateDate());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	@GetMapping(value = "/name/{name}/exists")
	public ResponseEntity<?> existsByName(@PathVariable(name = "name") String name) {

		return new ResponseEntity<>(service.isDepartmentExistsByName(name), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentFormForCreating form) {
		service.createDepartment(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id, @RequestBody DepartmentFormForUpdating form) {
		service.updateDepartment(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteDepartments(@RequestParam(name = "ids") List<Short> ids) {
		service.deleteDepartments(ids);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
