package org.academiadecodigo.variachis.delta.back_end.persistence.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "diary")
public class DiaryEntry {

    @ManyToOne
    private Customer customer;
    private Date date;
    private String message;


    public DiaryEntry(Date date, String message) {
        this.date = date;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
