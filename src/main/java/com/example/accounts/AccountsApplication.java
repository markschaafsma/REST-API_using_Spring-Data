package com.example.accounts;

import com.example.accounts.domain.Currency;
import com.example.accounts.domain.TxnType;
import com.example.accounts.service.AccountService;
import com.example.accounts.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.example.accounts.domain.Currency.SGD;

@SpringBootApplication
public class AccountsApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionService transactionService;

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		loadAccounts();
		System.out.println("Total number of accounts loaded into the database:     " + accountService.totalAccounts());
		loadTransactions();
		System.out.println("Total number of transactions loaded into the database: " + transactionService.totalTransactions());
	}

	private void loadAccounts() {
		accountService.createAccount("585309209", "SGSavings726", "Savings", LocalDate.parse("2021-03-05"), Currency.SGD, BigDecimal.valueOf(84327.51));
		accountService.createAccount("791066619", "AUSavings933", "Savings", LocalDate.parse("2021-03-05"), Currency.AUD, BigDecimal.valueOf(88005.93));
	}

	private void loadTransactions() {
		transactionService.createTransaction(1,"585309209", LocalDateTime.parse("2021-03-05T10:30:00"),SGD,BigDecimal.valueOf(9540.98), TxnType.Credit,"Payment A");
		transactionService.createTransaction(1,"585309209", LocalDateTime.parse("2021-03-05T11:10:00"),SGD,BigDecimal.valueOf(7497.82), TxnType.Credit,"Payment B");
		transactionService.createTransaction(1,"585309209", LocalDateTime.parse("2021-03-06T15:20:00"),SGD,BigDecimal.valueOf(5564.79), TxnType.Credit,"Payment C");
		transactionService.createTransaction(2,"791066619", LocalDateTime.parse("2021-03-06T16:05:00"),SGD,BigDecimal.valueOf(3490.22), TxnType.Credit,"Payment D");
	}

}
