package com.example.accounts.repo;

import com.example.accounts.domain.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {

    /**
     * Find Account by acctNo.
     *
     * @param acctNo account number for the account
     * @return Optional of Account
     */
    Optional<Account> findByAcctNo(String acctNo);

    @Override
    @RestResource(exported=false)
    <S extends Account> S save(S s);

    @Override
    @RestResource(exported=false)
    <S extends Account> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    @RestResource(exported=false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported=false)
    void delete(Account account);

    @Override
    @RestResource(exported=false)
    void deleteAll(Iterable<? extends Account> iterable);

    @Override
    @RestResource(exported=false)
    void deleteAll();
}
