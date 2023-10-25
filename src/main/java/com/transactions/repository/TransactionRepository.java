package com.transactions.repository;

import com.transactions.domain.Account;
import com.transactions.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Diego Mota
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}