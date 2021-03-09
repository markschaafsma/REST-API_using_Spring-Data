package com.example.accounts.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Integer id;

    @Column (length = 12)
    private String acctNo;

    @Column
    private LocalDateTime txnDateTime;

    @Column
    @Enumerated
    private Currency currency;

    @Column
    private BigDecimal amount;

    @Column
    private TxnType txnType;

    @Column (length = 200)
    private String narrative;

    @ManyToOne
    private Account account;

    public Transaction(String acctNo, LocalDateTime txnDateTime, Currency currency, BigDecimal amount, TxnType txnType, String narrative, Account account) {
        this.acctNo = acctNo;
        this.txnDateTime = txnDateTime;
        this.currency = currency;
        this.amount = amount;
        this.txnType = txnType;
        this.narrative = narrative;
        this.account = account;
    }

    // Default constructor protected so consumers must create a fully initialised object.
    protected Transaction() {
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

    public LocalDateTime getTxnDateTime() {
        return txnDateTime;
    }

    public void setTxnDate(LocalDateTime txnDateTime) {
        this.txnDateTime = txnDateTime;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TxnType getTxnType() {
        return txnType;
    }

    public void setTxnType(TxnType txnType) {
        this.txnType = txnType;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", acctNo='" + acctNo + '\'' +
                ", txnDateTime=" + txnDateTime +
                ", currency=" + currency +
                ", amount=" + amount +
                ", txnType=" + txnType +
                ", narrative='" + narrative + '\'' +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(acctNo, that.acctNo) &&
                Objects.equals(txnDateTime, that.txnDateTime) &&
                currency == that.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(acctNo, txnDateTime, currency);
    }
}


