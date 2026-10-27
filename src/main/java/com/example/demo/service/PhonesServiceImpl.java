package com.example.demo.service;

import com.example.demo.model.Phones;
import com.example.demo.repository.PhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhonesServiceImpl implements PhonesService {
    private PhonesRepository phonesRepository;

    @Autowired
    PhonesServiceImpl(PhonesRepository phonesRepository) {
        this.phonesRepository = phonesRepository;
    }

    @Override
    public List<Phones> findPhones() {
        return phonesRepository.findAll();
    }
}
