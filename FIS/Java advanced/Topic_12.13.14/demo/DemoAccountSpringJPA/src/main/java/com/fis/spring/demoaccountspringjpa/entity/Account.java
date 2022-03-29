package com.fis.spring.demoaccountspringjpa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_id")
    @JsonProperty("Account_id")
    private Long accountid;

    @Column(name = "Account_No")
    @JsonProperty("Account_No")
    private String accountNo;

    @Column(name = "Card_No")
    @JsonProperty("Card_No")
    private String cardNo;

    @Column(name = "Full_Name" )
    @JsonProperty("Full_Name")
    private String fullname;

    @Column(name = "Amount")
    private Long amount;

    @Column(name = "Issued_Date")
    private Date issuedDate;

    @Column(name = "Update_Date")
    private Date updateDate;
}
