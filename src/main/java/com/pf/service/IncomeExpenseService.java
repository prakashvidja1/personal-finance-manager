package com.pf.service;

import com.pf.bean.IncomeExpenseRequestBean;
import com.pf.bean.IncomeExpenseResponseBean;
import com.pf.bean.IncomeExpenseSearchRequest;
import com.pf.bean.IncomeExpenseSearchResponse;
import com.pf.entity.IncomeExpenseEntity;

import java.util.List;

public interface IncomeExpenseService {

    IncomeExpenseResponseBean getById(long incomeExpenseId);

    IncomeExpenseResponseBean save(IncomeExpenseRequestBean incomeExpenseRequestBean);

    IncomeExpenseEntity findById(Long incomeExpenseId);

    IncomeExpenseSearchResponse searchQueryByExample(IncomeExpenseSearchRequest searchRequest);

    List<IncomeExpenseResponseBean> findAll();

    List<Object> findAllByProcedure();

}
