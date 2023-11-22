package com.BuyMore.UserServices.Mapper;

import com.BuyMore.UserServices.DTO.ApplicationUserDTO;
import com.BuyMore.UserServices.Entity.ApplicationUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ApplicationUserMapper {
    ApplicationUser applicationUserDTOToApplicationUser(ApplicationUserDTO  entity);
    @Mapping(target="userID",ignore = true)
    @Mapping(target="uniqueID",ignore = true)
    void updateApplicationUserFromDTO(ApplicationUserDTO dto, @MappingTarget ApplicationUser entity);
    ApplicationUserDTO applicationUserToApplicationUserDTO(ApplicationUser entity);

}

