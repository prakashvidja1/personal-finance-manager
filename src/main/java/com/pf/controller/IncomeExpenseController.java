package com.pf.controller;

import com.pf.bean.IncomeExpenseRequestBean;
import com.pf.bean.IncomeExpenseResponseBean;
import com.pf.bean.IncomeExpenseSearchRequest;
import com.pf.bean.IncomeExpenseSearchResponse;
import com.pf.service.IncomeExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomeExpense")
public class IncomeExpenseController {

    private static final Logger _log = LoggerFactory.getLogger(IncomeExpenseController.class);
    @Autowired
    private IncomeExpenseService incomeExpenseService;


    @GetMapping(value = "get/{incomeExpenseId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<IncomeExpenseResponseBean> get(@PathVariable long incomeExpenseId) {

        try {
            IncomeExpenseResponseBean incomeExpenseResponseBean = incomeExpenseService.getById(incomeExpenseId);
            return new ResponseEntity<>(incomeExpenseResponseBean, HttpStatus.OK);
        } catch (Exception e) {
            _log.error("Exception occurred at getIncomeExpenseById : {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/save")
    public ResponseEntity<IncomeExpenseResponseBean> save(@RequestBody IncomeExpenseRequestBean incomeExpenseRequestBean) {
        try {
            IncomeExpenseResponseBean incomeExpenseResponseBean = incomeExpenseService.save(incomeExpenseRequestBean);
            return new ResponseEntity<>(incomeExpenseResponseBean, HttpStatus.OK);
        } catch (Exception e) {
            _log.error("Exception occurred at saveIncomeExpense : {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/searchQueryByExample")
    public ResponseEntity<IncomeExpenseSearchResponse> searchQueryByExample(@RequestBody IncomeExpenseSearchRequest incomeExpenseSearchRequest) {
        try {
            IncomeExpenseSearchResponse incomeExpenseSearchResponse = incomeExpenseService.searchQueryByExample(incomeExpenseSearchRequest);
            return new ResponseEntity<>(incomeExpenseSearchResponse, HttpStatus.OK);
        } catch (Exception e) {
            _log.error("Exception occurred at searchIncomeExpense : {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/findAll")
    public ResponseEntity<List<IncomeExpenseResponseBean>> findAll() {
        try {
            List<IncomeExpenseResponseBean> incomeExpenseResponseBeanList = incomeExpenseService.findAll();
            return new ResponseEntity<>(incomeExpenseResponseBeanList, HttpStatus.OK);
        } catch (Exception e) {
            _log.error("Exception occurred at findAllIncomeExpense : {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/findAllByProcedure")
    public ResponseEntity<List<Object>> findAllByProcedure() {
        try {
            List<Object> incomeExpenseResponseBeanList = incomeExpenseService.findAllByProcedure();
            return new ResponseEntity<>(incomeExpenseResponseBeanList, HttpStatus.OK);
        } catch (Exception e) {
            _log.error("Exception occurred while fetching incomeExpense : {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
