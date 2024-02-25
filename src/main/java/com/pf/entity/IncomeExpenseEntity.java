package com.pf.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "income_expense")
public class IncomeExpenseEntity {

    @Id
    @Column(name = "incomeExpenseId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long incomeExpenseId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "category")
    private String category;

    @Column(name = "subCategory")
    private String subCategory;

    @Column(name = "summary")
    private String summary;

    @Column(name = "type")
    private String type;

    @Column(name = "date", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
