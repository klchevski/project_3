package com.example.demo.service;

import com.example.demo.exception.PhonesNotFoundException;
import com.example.demo.model.Phones;
import com.example.demo.repository.PhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PhonesServiceImpl implements PhonesService {
    private PhonesRepository phonesRepository;

    @Autowired
    PhonesServiceImpl(PhonesRepository phonesRepository) {
        this.phonesRepository = phonesRepository;
    }


    @Override
    public Phones save(Phones phone) {
        return phonesRepository.save(phone);
    }

    @Override
    public List<Phones> findPhones() {
        return phonesRepository.findAll();
    }

    @Override
    public List<Phones> findPhonesWithTwoOne() {

        List<Phones> allPhones = phonesRepository.findAll();
        ArrayList<Phones> filteredPhones = new ArrayList<>();

        for (Phones phone : allPhones) {
            if (phone.getModelName() != null && phone.getModelName().contains("11")) {
                filteredPhones.add(phone);
            }
        }

        return filteredPhones;
    }

    /**
     * Find max Phone price
     *
     * @return The phone with max price
     */
    @Override
    public Phones getMaxPricePhone() {
        Phones max = phonesRepository.findAll().stream()
                .max(Comparator.comparing(e -> e.getPrice()))
                .orElseThrow(() -> new PhonesNotFoundException("Phone not found"));
        return max;
    }

    @Override
    public List<Phones> findUsedPhones(Boolean isUsed) {
        List<Phones> allPhones = phonesRepository.findAll();
        if (isUsed == null) {
            return allPhones;
        }
        List<Phones> filteredPhones = new ArrayList<>();
        for (Phones phone : allPhones) {

            if (phone.getIsUsed() == isUsed) {
                filteredPhones.add(phone);
            }
        }
        return filteredPhones;
    }

    /**
     * Find minus price and fix it to plus price
     * @return The Phone with plus price
     */
    @Override
    public List<Phones> getPlusPrice() {
        List<Phones> allPhones = phonesRepository.findAll();
        ArrayList<Phones> phonesArrayList = new ArrayList<>();

        for (Phones phones : allPhones) {
            if (phones.getPrice() < 0) {
                phones.setPrice(phones.getPrice() * -1 );
                phonesArrayList.add(phones);
            }
        }
        return phonesArrayList;
    }

}
