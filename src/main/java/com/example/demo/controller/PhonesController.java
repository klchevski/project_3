package com.example.demo.controller;

import com.example.demo.model.Phones;
import com.example.demo.service.PhonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhonesController {
    private PhonesService phonesService;

    @Autowired
    PhonesController(PhonesService phonesService) {
        this.phonesService = phonesService;
    }

    @GetMapping("/phones")
    List<Phones> findPhones() {
        return phonesService.findPhones();
    }

    @PostMapping("/phones/save")
    public Phones savePhone(@RequestBody Phones phone) {
        return phonesService.save(phone);
    }
}
