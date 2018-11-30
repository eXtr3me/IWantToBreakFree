package org.academiadecodigo.variachis.delta.back_end.persistence.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

import static java.lang.Integer.parseInt;


@Entity
@Table(name = "diary")
public class DiaryEntry extends AbstractModel {

    private static final double PRICE_PER_CIGARRETTE = 0.20;

    @ManyToOne
    private Customer customer;

    private Date date;
    private String numberOfSmokedCigarretes;
    private double moneySpent;


    public DiaryEntry(Date date, String numberOfSmokedCigarretes) {
        this.date = date;
        this.numberOfSmokedCigarretes = numberOfSmokedCigarretes;
        this.moneySpent = parseInt(numberOfSmokedCigarretes) * PRICE_PER_CIGARRETTE;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumberOfSmokedCigarretes() {
        return numberOfSmokedCigarretes;
    }

    public void setNumberOfSmokedCigarretes(String numberOfSmokedCigarretes) {
        this.numberOfSmokedCigarretes = numberOfSmokedCigarretes;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }
}
