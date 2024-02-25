package com.pf.bean;

import java.math.BigDecimal;

public class IncomeExpenseRequestBean {

    private long incomeExpenseId;
    private double amount;
    private String category;
    private String subCategory;
    private String summary;
    private String type;
    private String dateTime;

    public long getIncomeExpenseId() {
        return incomeExpenseId;
    }

    public void setIncomeExpenseId(long incomeExpenseId) {
        this.incomeExpenseId = incomeExpenseId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
