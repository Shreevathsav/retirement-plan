package com.retirement.plan.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.retirement.plan.dto.base.TransactionBaseDTO;

import lombok.Data;

@Data
public class ValidatorRequest {

    @JsonProperty("wage")
    private double wage;

    @JsonProperty("transactions")
    private List<TransactionBaseDTO> transactions;
}
