package com.pf.helper;

import com.pf.bean.IncomeExpenseResponseBean;
import com.pf.bean.IncomeExpenseSearchResponse;
import com.pf.entity.IncomeExpenseEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public class IncomeExpenseHelper {

    public static IncomeExpenseResponseBean getExpenseResponseBean(IncomeExpenseEntity incomeExpenseEntity) {
        IncomeExpenseResponseBean incomeExpenseResponseBean = new IncomeExpenseResponseBean();
        incomeExpenseResponseBean.setIncomeExpenseId(incomeExpenseEntity.getIncomeExpenseId());
        incomeExpenseResponseBean.setAmount(incomeExpenseEntity.getAmount());
        incomeExpenseResponseBean.setCategory(incomeExpenseEntity.getCategory());
        incomeExpenseResponseBean.setSubCategory(incomeExpenseEntity.getSubCategory());
        incomeExpenseResponseBean.setSummary(incomeExpenseEntity.getSummary());
        incomeExpenseResponseBean.setType(incomeExpenseEntity.getType());
        incomeExpenseResponseBean.setDateTime(incomeExpenseEntity.getDateTime().toString());
        return incomeExpenseResponseBean;
    }

    public static List<IncomeExpenseResponseBean> getExpenseResponseBeanList(List<IncomeExpenseEntity> incomeExpenseEntityList) {
        return incomeExpenseEntityList.stream().map(IncomeExpenseHelper::getExpenseResponseBean).toList();
    }

    public static IncomeExpenseSearchResponse getIncomeExpenseSearchResponse(Page<IncomeExpenseEntity> incomeExpenseEntityPage) {
        IncomeExpenseSearchResponse paginatedIncomeExpenseResponse = new IncomeExpenseSearchResponse();
        paginatedIncomeExpenseResponse.setCurrentPage(incomeExpenseEntityPage.getNumber());
        paginatedIncomeExpenseResponse.setTotalPages(incomeExpenseEntityPage.getTotalPages());
        paginatedIncomeExpenseResponse.setTotalElements(incomeExpenseEntityPage.getTotalElements());
        paginatedIncomeExpenseResponse.setIncomeExpenseResponseBeanList(getExpenseResponseBeanList(incomeExpenseEntityPage.getContent()));
        return paginatedIncomeExpenseResponse;
    }
}