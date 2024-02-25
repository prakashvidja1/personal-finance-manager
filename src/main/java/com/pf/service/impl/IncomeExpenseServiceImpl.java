package com.pf.service.impl;

import com.pf.bean.IncomeExpenseRequestBean;
import com.pf.bean.IncomeExpenseResponseBean;
import com.pf.entity.IncomeExpenseEntity;
import com.pf.helper.IncomeExpenseHelper;
import com.pf.repo.IncomeExpenseRepository;
import com.pf.service.IncomeExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
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
            else
                throw new RuntimeException("IncomeExpense not found for id " + incomeExpenseId);
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
        incomeExpenseEntity.setType(incomeExpenseRequestBean.getType());
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
