package fis.training.minitest_with_datajpa.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private Date transactionDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fromAccount", referencedColumnName = "Account_id")
    private Account fromAccount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "toAccount", referencedColumnName = "Account_id")
    private Account toAccount;
    private Double amount;
    private Integer status;
    private String content;
    private String errorReason;

    public Transaction( Date transactionDate, Account fromAccount, Account toAccount, Double amount,
                        Integer status, String content, String errorReason) {
        super();
        this.transactionDate = transactionDate;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.status = status;
        this.content = content;
        this.errorReason = errorReason;
    }
}
