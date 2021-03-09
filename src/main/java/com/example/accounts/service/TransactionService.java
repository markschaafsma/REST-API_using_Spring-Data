package com.example.accounts.service;

import com.example.accounts.domain.Account;
import com.example.accounts.domain.Currency;
import com.example.accounts.domain.Transaction;
import com.example.accounts.domain.TxnType;
import com.example.accounts.repo.AccountRepository;
import com.example.accounts.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository){
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    /*
     * Create a transaction
     *
     * @ param acctNo
     * @ param acctNo
     * @ param txnDate
     * @ param currency
     * @ param amount
     * @ param txnType
     * @ param narrative
     * @ param account
     *
     * @ return new transaction
     */
    public Transaction createTransaction(Integer acctId
                                       , String acctNo
                                       , LocalDateTime txnDateTime
                                       , Currency currency
                                       , BigDecimal amount
                                       , TxnType txnType
                                       , String narrative) {

        Account account = accountRepository.findByAcctNo(acctNo)
            .orElseThrow(() -> new RuntimeException("Account does not exist - Id: " + acctId + "; AcctNo: " + acctNo));

        return transactionRepository.save(new Transaction(account.getAcctNo()
                                                        , txnDateTime
                                                        , currency
                                                        , amount
                                                        , txnType
                                                        , narrative
                                                        , account));
    }

    /**
     * Get the total number of Transactions in the Database.
     *
     * @return the total number of Transactions.
     */
    public long totalTransactions() {
        return transactionRepository.count();
    }

    /*
     * Lookup all transactions
     *
     * @return all transactions
     */
    public Iterable<Transaction> lookup() {
        return transactionRepository.findAll();
    }

}
