package com.vti.departmentmanegement.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.departmentmanegement.dto.AccountDto;

import java.util.Date;

public class DepartmentFormForCreating {

    private String name;
    private short authorId;

    public DepartmentFormForCreating() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAuthorId() {
        return authorId;
    }

    public void setAuthorId(short authorId) {
        this.authorId = authorId;
    }
}
