package com.retirement.plan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retirement.plan.dto.request.TransactionParserRequest;
import com.retirement.plan.dto.response.TransactionParserResponse;
import com.retirement.plan.services.TransactionCalculationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/blackrock/challenge/v1")
public class ApiController {

    @Autowired
    TransactionCalculationService calculationService;

    @PostMapping("/transactions:parse")
    public ResponseEntity<List<TransactionParserResponse>> parseTransaction(
            @RequestBody List<TransactionParserRequest> requests) {
        List<TransactionParserResponse> responses = calculationService.calculate(requests);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
