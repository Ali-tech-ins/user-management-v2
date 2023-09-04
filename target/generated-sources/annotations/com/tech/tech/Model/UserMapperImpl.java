package com.tech.tech.Model;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-01T15:35:06+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (GraalVM Community)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(UserModel entity) {
        if ( entity == null ) {
            return null;
        }

        Long addressId = null;
        String name = null;
        String email = null;

        addressId = entityAdressId( entity );
        name = entity.getName();
        email = entity.getEmail();

        UserDTO userDTO = new UserDTO( name, email, addressId );

        return userDTO;
    }

    @Override
    public UserModel toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setAdress( userDTOToAdress( dto ) );
        userModel.setName( dto.getName() );
        userModel.setEmail( dto.getEmail() );

        return userModel;
    }

    private Long entityAdressId(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }
        Adress adress = userModel.getAdress();
        if ( adress == null ) {
            return null;
        }
        Long id = adress.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Adress userDTOToAdress(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        Adress adress = new Adress();

        adress.setId( userDTO.getAddressId() );

        return adress;
    }
}
