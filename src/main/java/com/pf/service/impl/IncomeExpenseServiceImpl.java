package com.pf.service.impl;

import com.pf.bean.IncomeExpenseRequestBean;
import com.pf.bean.IncomeExpenseResponseBean;
import com.pf.bean.IncomeExpenseSearchRequest;
import com.pf.bean.IncomeExpenseSearchResponse;
import com.pf.entity.IncomeExpenseEntity;
import com.pf.enums.AmountTypeEnum;
import com.pf.helper.IncomeExpenseHelper;
import com.pf.repo.IncomeExpenseRepository;
import com.pf.service.IncomeExpenseService;
import com.pf.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeExpenseServiceImpl implements IncomeExpenseService {

    @Autowired
    private IncomeExpenseRepository incomeExpenseRepository;

    @Override
    public IncomeExpenseResponseBean getById(long incomeExpenseId) {
        if (incomeExpenseId > 0) {
            IncomeExpenseEntity incomeExpenseEntity = findById(incomeExpenseId);
            if (null != incomeExpenseEntity && incomeExpenseEntity.getIncomeExpenseId() > 0)
                return IncomeExpenseHelper.getExpenseResponseBean(incomeExpenseEntity);
            else throw new RuntimeException("IncomeExpense not found for id " + incomeExpenseId);
        }
        return null;
    }

    @Override
    public IncomeExpenseResponseBean save(IncomeExpenseRequestBean incomeExpenseRequestBean) {
        IncomeExpenseEntity incomeExpenseEntity = null;
        if (incomeExpenseRequestBean.getIncomeExpenseId() > 0) {
            incomeExpenseEntity = findById(incomeExpenseRequestBean.getIncomeExpenseId());
        }
        if (null == incomeExpenseEntity) {
            incomeExpenseEntity = new IncomeExpenseEntity();
        }
        incomeExpenseEntity.setAmount(incomeExpenseRequestBean.getAmount());
        incomeExpenseEntity.setSummary(incomeExpenseRequestBean.getSummary());
        incomeExpenseEntity.setCategory(incomeExpenseRequestBean.getCategory());
        incomeExpenseEntity.setSubCategory(incomeExpenseRequestBean.getSubCategory());
        incomeExpenseEntity.setType(AmountTypeEnum.getName(incomeExpenseRequestBean.getType()));
        incomeExpenseEntity.setDateTime(LocalDateTime.now());
        incomeExpenseEntity = incomeExpenseRepository.save(incomeExpenseEntity);

        return IncomeExpenseHelper.getExpenseResponseBean(incomeExpenseEntity);
    }

    @Override
    public IncomeExpenseEntity findById(Long incomeExpenseId) {
        Optional<IncomeExpenseEntity> incomeExpenseEntityOptional = incomeExpenseRepository.findById(incomeExpenseId);
        return incomeExpenseEntityOptional.orElse(null);
    }

    @Override
    public IncomeExpenseSearchResponse searchQueryByExample(IncomeExpenseSearchRequest searchRequest) {
        Sort.Order sortOrder = new Sort.Order(searchRequest.isAscending() ? Sort.Direction.ASC : Sort.Direction.DESC, searchRequest.getSortBy());
        Sort sort = Sort.by(sortOrder);
        Pageable pageable = PageRequest.of(searchRequest.getPage(), searchRequest.getSize()).withSort(sort);
        IncomeExpenseEntity incomeExpenseEntity = new IncomeExpenseEntity();
        if (StringUtils.isNotEmpty(searchRequest.getSummary()))
            incomeExpenseEntity.setSummary(searchRequest.getSummary());
        if (StringUtils.isNotEmpty(searchRequest.getCategory()))
            incomeExpenseEntity.setCategory(searchRequest.getCategory());
        if (StringUtils.isNotEmpty(searchRequest.getSubCategory()))
            incomeExpenseEntity.setSubCategory(searchRequest.getSubCategory());
        if (StringUtils.isNotEmpty(searchRequest.getType()))
            incomeExpenseEntity.setType(searchRequest.getType());
        if (StringUtils.isNotEmpty(searchRequest.getFromDate()))
            incomeExpenseEntity.setDateTime(DateUtil.getLocalDateTimeFromString(searchRequest.getFromDate()));

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("summary", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("category", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase())
                .withMatcher("subCategory", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase())
                .withMatcher("dateTime", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase())
                .withIgnorePaths("incomeExpenseId", "amount");
        Example<IncomeExpenseEntity> example = Example.of(incomeExpenseEntity, exampleMatcher);

        Page<IncomeExpenseEntity> incomeExpenseEntityPage = incomeExpenseRepository.findAll(example, pageable);
        return IncomeExpenseHelper.getIncomeExpenseSearchResponse(incomeExpenseEntityPage);
    }


    @Override
    public List<IncomeExpenseResponseBean> findAll() {
        List<IncomeExpenseEntity> incomeExpenseEntityList = incomeExpenseRepository.findAll();

        if (!incomeExpenseEntityList.isEmpty()) {
            return IncomeExpenseHelper.getExpenseResponseBeanList(incomeExpenseEntityList);
        }
        return null;
    }

    @Override
    @Transactional
    public List<Object> findAllByProcedure() {
        return incomeExpenseRepository.findAllByProcedure();
    }
}
