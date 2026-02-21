package com.retirement.plan.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransactionParserResponse {

    @JsonProperty("date")
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private LocalDateTime date;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("ceiling")
    private double ceiling;

    @JsonProperty("remanent")
    private double remanent;
}
