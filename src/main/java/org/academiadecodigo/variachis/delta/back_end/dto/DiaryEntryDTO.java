package org.academiadecodigo.variachis.delta.back_end.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DiaryEntryDTO {

    private Integer id;

    private String date;

    @NotNull
    private Integer numberOfSmokedCigarrettes;

    private double moneySpent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNumberOfSmokedCigarretes() {
        return numberOfSmokedCigarrettes;
    }

    public void setNumberOfSmokedCigarretes(Integer numberOfSmokedCigarretes) {
        this.numberOfSmokedCigarrettes = numberOfSmokedCigarretes;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }

    @Override
    public String toString() {
        return "DiaryEntryDTO{" +
                "id=" + id +
                ", date='" + date.toString() + '\'' +
                ", numberOfSmokedCigarrettes=" + numberOfSmokedCigarrettes +
                ", moneySpent=" + moneySpent +
                '}';
    }
}
