package org.academiadecodigo.variachis.delta.back_end.persistence.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static java.lang.Integer.parseInt;


@Entity
@Table(name = "diary")
public class DiaryEntry extends AbstractModel {

    private static final double PRICE_PER_CIGARETTE = 0.20;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    //private Date date;
    //@Generated(GenerationTime.ALWAYS)
    private String date;
    private Integer numberOfSmokedCigarrettes;
    private double moneySpent;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNumberOfSmokedCigarrettes() {
        return numberOfSmokedCigarrettes;
    }

    public void setNumberOfSmokedCigarrettes(Integer numberOfSmokedCigarrettes) {
        this.numberOfSmokedCigarrettes = numberOfSmokedCigarrettes;

        setMoneySpent(numberOfSmokedCigarrettes * PRICE_PER_CIGARETTE);
    }

   public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    private void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }

    @Override
    public String toString() {
        return "DiaryEntry{" +
                ", date='" + date + '\'' +
                ", numberOfSmokedCigarrettes=" + numberOfSmokedCigarrettes +
                ", moneySpent=" + moneySpent +
                '}';
    }
}
