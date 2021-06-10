package com.datwhite.repository;

import com.datwhite.entity.Record;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordRepo extends CrudRepository<Record, String> {
    List<Record> findAll();

    Record findByCardNumber(String cardNumber);
}
