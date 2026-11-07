package com.example.demo.controller;

import com.example.demo.model.Phones;
import com.example.demo.service.PhonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/phones/withTwoOne")
    List<Phones> getPhonesTwoOne() {
        return phonesService.findPhonesWithTwoOne();
    }

    @GetMapping("/phones/maxPhonePrice")
    Phones getMaxPhonePrice() {
        return phonesService.getMaxPricePhone();
    }

    @GetMapping("/phones/isBUPhones")
    public List<Phones> getUsedPhones(@RequestParam(required = false) Boolean isUsed) {
        return phonesService.findUsedPhones(isUsed);
    }

    @GetMapping("/phones/getPlusPrice")
    public List<Phones> getPlusPrice() {
        return phonesService.getPlusPrice();
    }
}
