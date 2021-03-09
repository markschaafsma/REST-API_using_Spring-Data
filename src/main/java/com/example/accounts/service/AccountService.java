package com.example.accounts.service;

import com.example.accounts.domain.Account;
import com.example.accounts.domain.Currency;
import com.example.accounts.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    /*
     * Create an account
     *
     * @ param acctNo
     * @ param acctName
     * @ param acctType
     * @ param balanceDate
     * @ param currency
     * @ param balance
     *
     * @ return new account
     */
    public Account createAccount(String acctNo
                               , String acctName
                               , String acctType
                               , LocalDate balanceDate
                               , Currency currency
                               , BigDecimal balance) {
        return accountRepository.save(new Account(acctNo
                                                , acctName
                                                , acctType
                                                , balanceDate
                                                , currency
                                                , balance));
    }

    /**
     * Calculate the number of Accounts in the Database.
     *
     * @return the total number of Accounts.
     */
    public long totalAccounts() {
        return accountRepository.count();
    }

    /*
     * Lookup all accounts
     *
     * @return all accounts
     */
    public Iterable<Account> lookupAllAccounts() {
        return accountRepository.findAll();
    }

}
