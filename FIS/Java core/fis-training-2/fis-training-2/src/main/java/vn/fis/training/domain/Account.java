package vn.fis.training.domain;
//POJO

import java.util.Objects;

public class Account {
    private Long id;
    private String accountNumber;
    private String accountName;
    private Double balance;
    private Integer status;

    public Account(Long id, String accountNumber, String accountName, Double balance, Integer status) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.status = status;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(accountName, account.accountName) && Objects.equals(balance, account.balance) && Objects.equals(status, account.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, accountName, balance, status);
    }
}
