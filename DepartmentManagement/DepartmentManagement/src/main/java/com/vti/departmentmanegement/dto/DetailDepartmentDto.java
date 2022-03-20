package com.vti.departmentmanegement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DetailDepartmentDto {
    private short id;
    private String name;
    private AccountDto author;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    public DetailDepartmentDto(short id, String name, AccountDto author, Date createDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.createDate = createDate;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountDto getAuthor() {
        return author;
    }

    public void setAuthor(AccountDto autor) {
        this.author = autor;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
