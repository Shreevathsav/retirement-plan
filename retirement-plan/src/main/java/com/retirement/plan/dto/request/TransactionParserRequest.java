package com.retirement.plan.dto.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransactionParserRequest {

    @JsonProperty("date")
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private LocalDateTime date;

    @JsonProperty("amount")
    private double amount;
}
