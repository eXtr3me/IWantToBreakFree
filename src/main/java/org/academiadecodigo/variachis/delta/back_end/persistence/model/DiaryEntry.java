package org.academiadecodigo.variachis.delta.back_end.persistence.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.util.Date;

import static java.lang.Integer.parseInt;


@Entity
@Table(name = "diary")
public class DiaryEntry extends AbstractModel {

    private static final double PRICE_PER_CIGARRETTE = 0.20;

    @ManyToOne
    private Customer customer;

    //private Date date;
    @Generated(GenerationTime.ALWAYS)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private String numberOfSmokedCigarretes;
    private double moneySpent;

    public Date getDate() {
        return date;
    }

    @Autowired
    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumberOfSmokedCigarretes() {
        return numberOfSmokedCigarretes;
    }

    @Autowired
    public void setNumberOfSmokedCigarretes(String numberOfSmokedCigarretes) {
        this.numberOfSmokedCigarretes = numberOfSmokedCigarretes;

        setMoneySpent(parseInt(numberOfSmokedCigarretes) * PRICE_PER_CIGARRETTE);
    }

   public Customer getCustomer() {
        return customer;
    }

    @Autowired
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    private void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }
}
