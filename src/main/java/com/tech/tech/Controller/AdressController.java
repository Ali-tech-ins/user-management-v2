package com.tech.tech.Controller;

import com.tech.tech.Model.Adress;
import com.tech.tech.Model.AdressDTO;
import com.tech.tech.Model.AdressMapper;
import com.tech.tech.Repository.AdressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/adress")
public class AdressController {

    @Autowired
    private AdressMapper adressMapper;

    @Autowired
    private AdressRepo adressRepo;

   @PostMapping
    Adress createAdress (@RequestBody Adress newAdress){
       return adressRepo.save(newAdress);
   }

   @GetMapping
    List<AdressDTO> getAddresses(){
       return adressRepo.findAll()
               .stream()
               .map(
                       adress -> adressMapper.toDTO(adress))
               .collect(Collectors.toList());
   }


}
