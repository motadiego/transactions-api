package com.transactions.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class AccountResponseDTO {

    @JsonProperty("account_id")
    private String id;

    @JsonProperty("document_number")
    private String documentNumber;

}