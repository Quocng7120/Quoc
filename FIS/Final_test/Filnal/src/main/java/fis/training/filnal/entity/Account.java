package fis.training.filnal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_Id")
    private Long accountId;

    @Column(name = "Account_Number", nullable = false, unique = true, length = 13)
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "Customer_Id",referencedColumnName="Customer_Id")
    private Customer customer;

    @Column(name = "Balance", nullable = false)
    private Double balance;

    @Column(name = "Status", nullable = false)
    private Integer status;

    @Column(name = "Create_Datetime", nullable = false)
    private LocalDateTime create_datetime;

    @Column(name = "Update_Datetime", nullable = false)
    private LocalDateTime update_datetime;

    @OneToMany(mappedBy = "fromAccount")
    private Set<Transaction> transactionsFrom;

    @OneToMany(mappedBy = "toAccount")
    private Set<Transaction> transactionsTo;


}
