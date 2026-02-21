package com.retirement.plan.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.retirement.plan.dto.base.TransactionBaseDTO;
import com.retirement.plan.dto.request.TransactionParserRequest;

@Service
public class TransactionCalculationService {

    public List<TransactionBaseDTO> calculate(List<TransactionParserRequest> requests) {
        List<TransactionBaseDTO> responseList = new ArrayList<>();
        for (TransactionParserRequest request : requests) {
            TransactionBaseDTO response = new TransactionBaseDTO();
            response.setAmount(request.getAmount());
            response.setDate(request.getDate());

            response.setCeiling(roundOffToHundred(response.getAmount()));
            response.setRemanent(
                    diference(response.getCeiling(), response.getAmount()));
            responseList.add(response);
        }
        return responseList;
    }

    public double roundOffToHundred(double amount) {
        return Math.ceil(amount / 100.0) * 100;
    }

    public double diference(double ceiling, double amount) {
        return ceiling - amount;
    }
}
