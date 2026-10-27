package com.example.demo.repository;

import com.example.demo.model.Phones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhonesRepository extends CrudRepository<Phones, Long>{
        List<Phones> findAll();
        }
