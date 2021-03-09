package com.example.accounts.repo;

import com.example.accounts.domain.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Integer> {

    @Override
    @RestResource(exported=false)
    <S extends Transaction> S save(S s);

    @Override
    @RestResource(exported=false)
    <S extends Transaction> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    @RestResource(exported=false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported=false)
    void delete(Transaction transaction);

    @Override
    @RestResource(exported=false)
    void deleteAll(Iterable<? extends Transaction> iterable);

    @Override
    @RestResource(exported=false)
    void deleteAll();
}
