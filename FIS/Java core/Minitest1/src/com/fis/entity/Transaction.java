package com.fis.entity;

import java.util.Date;

public class Transaction {
    private Long id;
    private Date transactionDate;
    private Number fromAccount;
    private Number toAccount;
    private Double amount;
    private Integer status;
    private String content;
    private String errorReason;

    public Transaction(Long id, Date transactionDate, Number fromAccount, Number toAccount, Double amount, Integer status, String content, String errorReason) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.status = status;
        this.content = content;
        this.errorReason = errorReason;
    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Number getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Number fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Number getToAccount() {
        return toAccount;
    }

    public void setToAccount(Number toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transactionDate=" + transactionDate +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", amount=" + amount +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", errorReason='" + errorReason + '\'' +
                '}';
    }
}
