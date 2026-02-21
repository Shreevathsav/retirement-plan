package com.retirement.plan.dto.response;

import java.util.List;

import com.retirement.plan.dto.base.TransactionBaseDTO;

import lombok.Data;

@Data
public class ValidatorResponse {

    List<TransactionBaseDTO> validTransactionList;
    List<InvalidResponse> invalidResponses;
}
