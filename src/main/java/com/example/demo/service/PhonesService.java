package com.example.demo.service;

import com.example.demo.model.Phones;

import java.util.List;

public interface PhonesService {
    Phones save(Phones phone);
    List<Phones> findPhones();
}
