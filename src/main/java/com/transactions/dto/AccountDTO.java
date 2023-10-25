package com.transactions.dto;

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
public class AccountDTO {

    private String id;

    private String documentNumber;

}