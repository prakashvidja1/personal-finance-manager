package com.pf.repo;

import com.pf.entity.IncomeExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface IncomeExpenseRepository extends JpaRepository<IncomeExpenseEntity, Long> {
    @Procedure (procedureName = "get_all_income_expense")
    List<Object> findAllByProcedure();
}
