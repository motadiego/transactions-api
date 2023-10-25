package com.transactions.mapper;

import com.transactions.domain.Account;
import com.transactions.dto.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 
 * @author Diego Mota
 *
 */
@Mapper
public interface AccountMapper {

	AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
	
	AccountDTO accountToAccountDTO(Account account);
	
	Account accountDTOToAccount(AccountDTO accountDTO);
	
}