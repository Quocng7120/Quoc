package fis.training.minitest_with_datajpa.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_id")
    private Long id;

    @Column(name = "Account_number")
    private String accountNumber;

    @Column(name = "Account_name")
    private String accountName;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "status")
    private int status;
}
