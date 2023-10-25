package com.transactions.domain;

/**
 * @author Diego Mota
 */
public enum OperationType {

    COMPRA_A_VISTA(1, "COMPRA A VISTA"),
    COMPRA_PARCELADA(2, "COMPRA PARCELADA"),
    SAQUE(3, "SAQUE"),
    PAGAMENTO(4, "PAGAMENTO");

    private int code;
    private String description;

    private OperationType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

}