package com.transactions.mapper;

import com.transactions.domain.OperationType;
import com.transactions.domain.Transaction;
import com.transactions.dto.TransactionRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Diego Mota
 */
@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);


    TransactionRequestDTO transactionToTransactionRequestDTO(Transaction transaction);

    Transaction transactionRequestDTOToTransaction(TransactionRequestDTO transactionRequestDTO);

    default OperationType mapOperationType(String operationTypeCode) {
        for (OperationType enumValue : OperationType.values()) {
            if (enumValue.getCode() == Integer.parseInt(operationTypeCode)) {
                return enumValue;
            }
        }
        throw new IllegalArgumentException(
            "OperationType not found for code: " + operationTypeCode);
    }
}