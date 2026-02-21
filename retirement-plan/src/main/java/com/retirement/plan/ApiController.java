package com.retirement.plan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retirement.plan.dto.base.TransactionBaseDTO;
import com.retirement.plan.dto.request.TransactionParserRequest;
import com.retirement.plan.dto.request.ValidatorRequest;
import com.retirement.plan.dto.response.ValidatorResponse;
import com.retirement.plan.services.TransactionCalculationService;
import com.retirement.plan.services.ValidateService;

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

    @Autowired
    ValidateService validateService;

    @PostMapping("/transactions:parse")
    public ResponseEntity<List<TransactionBaseDTO>> parseTransaction(
            @RequestBody List<TransactionParserRequest> requests) {

        return new ResponseEntity<>(calculationService.calculate(requests), HttpStatus.OK);
    }

    @PostMapping("/transactions:validator")
    public ResponseEntity<ValidatorResponse> validate(
            @RequestBody ValidatorRequest request) {

        return new ResponseEntity<>(validateService.validateTransaction(request), HttpStatus.OK);
    }
}
