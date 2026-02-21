package com.retirement.plan.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.retirement.plan.dto.base.TransactionBaseDTO;
import com.retirement.plan.dto.request.ValidatorRequest;
import com.retirement.plan.dto.response.InvalidResponse;
import com.retirement.plan.dto.response.ValidatorResponse;

@Service
public class ValidateService {

    public ValidatorResponse validateTransaction(ValidatorRequest validatorRequest) {

        List<TransactionBaseDTO> valid = new ArrayList<>();
        List<InvalidResponse> invalid = new ArrayList<>();

        Set<String> seen = new HashSet<>();

        for (TransactionBaseDTO tx : validatorRequest.getTransactions()) {

            String uniqueKey = tx.getDate() + "_" + tx.getAmount();

            if (!seen.add(uniqueKey)) {
                invalid.add(buildInvalid(tx, "Duplicate transaction"));
                continue;
            }

            if (tx.getAmount() < 0) {
                invalid.add(buildInvalid(tx, "negative amounts are not allowed"));
                continue;
            }

            if (tx.getAmount() > validatorRequest.getWage()) {
                invalid.add(buildInvalid(tx, "Amount exceeds wage"));
                continue;
            }

            double expectedCeiling = Math.ceil(tx.getAmount() / 100.0) * 100;
            if (Double.compare(expectedCeiling, tx.getCeiling()) != 0) {
                invalid.add(buildInvalid(tx, "Incorrect ceiling value"));
                continue;
            }

            double expectedRemanent = expectedCeiling - tx.getAmount();
            if (Double.compare(expectedRemanent, tx.getRemanent()) != 0) {
                invalid.add(buildInvalid(tx, "Incorrect remanent value"));
                continue;
            }
            valid.add(tx);
        }

        ValidatorResponse response = new ValidatorResponse();
        response.setValidTransactionList(valid);
        response.setInvalidResponses(invalid);

        return response;

    }

    private InvalidResponse buildInvalid(TransactionBaseDTO tx, String message) {

        InvalidResponse invalidTx = new InvalidResponse(tx.getDate(), tx.getAmount(), tx.getCeiling(), tx.getCeiling(),
                message);

        return invalidTx;
    }
}
