package com.example.accounts.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Integer id;

    @Column (length = 12)
    private String acctNo;

    @Column (length = 50)
    private String acctName;

    @Column (length = 20)
    private String acctType;

    @Column
    private LocalDate balanceDate;

    @Column
    @Enumerated
    private Currency currency;

    @Column
    private BigDecimal balance;

    public Account(String acctNo, String acctName, String acctType, LocalDate balanceDate, Currency currency, BigDecimal balance) {
        this.acctNo = acctNo;
        this.acctName = acctName;
        this.acctType = acctType;
        this.balanceDate = balanceDate;
        this.currency = currency;
        this.balance = balance;
    }

    // Default constructor protected so consumers must create a fully initialised object.
    protected Account() {
    }

    public Integer getId() {
        return id;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public LocalDate getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(LocalDate balanceDate) {
        this.balanceDate = balanceDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", acctNo='" + acctNo + '\'' +
                ", acctName='" + acctName + '\'' +
                ", acctType='" + acctType + '\'' +
                ", balanceDate=" + balanceDate +
                ", currency=" + currency +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return acctNo.equals(account.acctNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acctNo);
    }

}
