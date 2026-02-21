package com.retirement.plan.services;

import java.util.ArrayList;
import java.util.List;

import com.retirement.plan.dto.request.TransactionParserRequest;
import com.retirement.plan.dto.response.TransactionParserResponse;

public class TransactionCalculationService {

    public List<TransactionParserResponse> calculate(List<TransactionParserRequest> requests) {
        List<TransactionParserResponse> responseList = new ArrayList<>();
        for (TransactionParserRequest request : requests) {
            TransactionParserResponse response = new TransactionParserResponse();
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
        return ((amount + 99) / 100) * 100;
    }

    public double diference(double ceiling, double amount) {
        return ceiling - amount;
    }
}
