package com.transactions.repository;

import com.transactions.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Diego Mota
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}