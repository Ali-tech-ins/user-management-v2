package com.tech.tech.Model;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {



    @Mapping(target = "addressId" , source = "adress.id" )
    UserDTO toDTO (UserModel entity);

    @InheritInverseConfiguration
    UserModel toEntity(UserDTO dto);




}
