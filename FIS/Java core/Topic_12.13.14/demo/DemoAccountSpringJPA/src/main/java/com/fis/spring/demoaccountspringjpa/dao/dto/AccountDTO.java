package com.fis.spring.demoaccountspringjpa.dao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class AccountDTO {


    @JsonProperty("Account_id")
    private Long accountid;

    @JsonProperty("Account_No")
    private String accountNo;

    @JsonProperty("Card_No")
    private String cardNo;

    @JsonProperty("Full_Name")
    private String fullname;

    @Column(name = "Amount")
    private Long amount;

    @Column(name = "Issued_Date")
    private Date issuedDate;

    @Column(name = "Update_Date")
    private Date updateDate;
}
