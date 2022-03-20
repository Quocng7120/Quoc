package com.vti.departmentmanegement.dto;

public class AccountDto {
    private short id;
    private String fullname;

    public AccountDto(short id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
