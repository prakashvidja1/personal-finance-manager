package com.pf.bean;

import java.util.List;

public class IncomeExpenseSearchResponse {

    private List<IncomeExpenseResponseBean> incomeExpenseResponseBeanList;
    private int currentPage;
    private int totalPages;
    private long totalElements;


    public List<IncomeExpenseResponseBean> getIncomeExpenseResponseBeanList() {
        return incomeExpenseResponseBeanList;
    }

    public void setIncomeExpenseResponseBeanList(List<IncomeExpenseResponseBean> incomeExpenseResponseBeanList) {
        this.incomeExpenseResponseBeanList = incomeExpenseResponseBeanList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}
