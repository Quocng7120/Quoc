package com.vti.departmentmanegement.controller;

import com.vti.departmentmanegement.dto.AccountDto;
import com.vti.departmentmanegement.dto.DepartmentDto;
import com.vti.departmentmanegement.dto.DetailDepartmentDto;
import com.vti.departmentmanegement.dto.LoginInfoDto;
import com.vti.departmentmanegement.entity.Account;
import com.vti.departmentmanegement.entity.Department;
import com.vti.departmentmanegement.form.DepartmentFilterForm;
import com.vti.departmentmanegement.form.DepartmentFormForCreating;
import com.vti.departmentmanegement.form.DepartmentFormForUpdating;
import com.vti.departmentmanegement.service.IAccountService;
import com.vti.departmentmanegement.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class LoginController {

	@Autowired
	private IAccountService service;

	@GetMapping()
	public ResponseEntity<?> login(Principal principal) {

		String username = principal.getName();
		Account entity = service.getAccountByUsername(username);

		LoginInfoDto dto = new LoginInfoDto(entity.getId(), entity.getFullName());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}


}
