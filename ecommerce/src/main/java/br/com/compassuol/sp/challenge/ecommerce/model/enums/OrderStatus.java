package br.com.compassuol.sp.challenge.ecommerce.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OrderStatus {
    CREATED("created"),
    CONFIRMED("confirmed");

    private String status;


    private OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

}
