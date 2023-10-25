package com.transactions.mapper;

import com.transactions.domain.Account;
import com.transactions.dto.request.AccountRequestDTO;
import com.transactions.dto.response.AccountResponseDTO;
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

	AccountResponseDTO accountToAccountResponseDTO(Account account);
	
	Account accountRequestDTOToAccount(AccountRequestDTO accountRequestDTO);
	
}