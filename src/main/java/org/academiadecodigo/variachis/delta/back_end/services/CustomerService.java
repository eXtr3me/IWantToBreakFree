package org.academiadecodigo.variachis.delta.back_end.services;

import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.DiaryEntry;

import java.util.List;

public interface CustomerService {


    Customer get(Integer id);

    Customer save(Customer customer);

    void delete (Integer id);

    List<DiaryEntry> getDiary(Customer customer);
}
