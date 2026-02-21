package com.retirement.plan.dto.response;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.retirement.plan.dto.base.TransactionBaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvalidResponse extends TransactionBaseDTO {

    @JsonProperty("message")
    private String message;

    public InvalidResponse(LocalDateTime date, double amount, double ceiling, double remanent, String message) {
        super.setAmount(amount);
        super.setCeiling(ceiling);
        super.setDate(date);
        super.setRemanent(remanent);
        this.message = message;
    }
}
