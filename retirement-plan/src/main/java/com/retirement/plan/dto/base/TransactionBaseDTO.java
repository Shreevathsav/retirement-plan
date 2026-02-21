package com.retirement.plan.dto.base;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransactionBaseDTO {
    @JsonProperty("date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("ceiling")
    private double ceiling;

    @JsonProperty("remanent")
    private double remanent;
}
