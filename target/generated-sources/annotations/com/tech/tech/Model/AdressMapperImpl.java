package com.tech.tech.Model;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-01T15:35:06+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (GraalVM Community)"
)
@Component
public class AdressMapperImpl implements AdressMapper {

    @Override
    public AdressDTO toDTO(Adress adress) {
        if ( adress == null ) {
            return null;
        }

        AdressDTO adressDTO = new AdressDTO();

        adressDTO.setStreetName( adress.getStreetName() );
        adressDTO.setHouseNumber( adress.getHouseNumber() );

        return adressDTO;
    }

    @Override
    public Adress toEntity(AdressDTO adressDTO) {
        if ( adressDTO == null ) {
            return null;
        }

        Adress adress = new Adress();

        adress.setStreetName( adressDTO.getStreetName() );
        adress.setHouseNumber( adressDTO.getHouseNumber() );

        return adress;
    }
}
