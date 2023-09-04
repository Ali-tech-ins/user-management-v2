package com.tech.tech.Model;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdressMapper {

    AdressDTO toDTO (Adress adress);
    Adress toEntity (AdressDTO adressDTO);

}
