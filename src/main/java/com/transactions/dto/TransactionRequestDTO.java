package com.transactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Diego Mota
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDTO {

    private String id;

    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("operation_type_id")
    private String operationType;

    private String amount;

    private LocalDateTime eventDate;

}