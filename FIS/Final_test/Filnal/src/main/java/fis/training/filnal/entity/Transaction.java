package fis.training.filnal.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Builder
@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Transaction_Id")
    private Long transactionId;

    @Column(name = "Transaction_Date", nullable = false)
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "from_account")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account")
    private Account toAccount;

    @Column(name = "Amount")
    private Double amount;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Content")
    private String content;

    @Column(name = "Error_Reason")
    private String errorReason;
}
