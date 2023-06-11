package com.turhan.housemates.service.impl;

import com.turhan.housemates.model.entity.Adress;
import com.turhan.housemates.repository.AdressRepository;
import com.turhan.housemates.service.AdressService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class AdressServiceImpl implements AdressService {

    @Autowired
    private AdressRepository adressRepository;
    @Override
    public void saveAdress(Adress adress) {
        adressRepository.save(adress);
    }
}
